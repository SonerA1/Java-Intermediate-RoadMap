import java.util.*;

public class Store {
    private LinkedList<Brand> brandlist = new LinkedList<>();
    private ArrayList<Products> cellphones = new ArrayList<>();
    private ArrayList<Products> notebooks = new ArrayList<>();
    public  Scanner sc = new Scanner(System.in);
    public Store(){
        Brand samsung = new Brand(1,"Samsung");
        Brand lenova = new Brand(2,"Lenova");
        Brand Huawei = new Brand(3,"Huawei");
        Brand Casper = new Brand(4,"Casper");
        Brand Asus = new Brand(5,"Asus");
        Brand Hp = new Brand(6,"HP");
        Brand Xiomi = new Brand(7,"Xiomi");
        Brand Monster = new Brand(8,"Monster");
        Brand Apple = new Brand(9,"Apple");
        brandlist.addAll(List.of(new Brand[]{samsung, lenova,Huawei,Casper,Asus,Hp,Xiomi,Monster,Apple}));
        Cellphone p20 = new  Cellphone(100,15200,15,150,"Huawei P20",brandlist.get(2),128,1.6,6,"white",400);
        Cellphone iPhone11 = new Cellphone(101,32550,12,225,"iPhone 11",brandlist.get(8),64,5,4,"black",800);
        Cellphone galaxy = new Cellphone(102,3199,12,55,"Galaxy A51",brandlist.get(0),128,6.5,5,"red",220);
        Cellphone Note10 = new Cellphone(103,4012,10,440,"Redmi Note 10 Pro",brandlist.get(6),8,6.5,8,"Black",125);
        cellphones.addAll(List.of(new Cellphone[]{p20, Note10, iPhone11, galaxy}));
        Notebook Matebook = new Notebook(200,7000,5,88,"Matebook 14",brandlist.get(2),512,14,16,"White");
        Notebook V14Igl = new Notebook(201,3699,4,45,"V14 IGL",brandlist.get(1),1024,14,8,"Black");
        Notebook TufGaming = new Notebook(202,8199,3,20,"Tuf Gaming",brandlist.get(4),2048,15.6,32,"Orange");
        notebooks.addAll(List.of(new Notebook[]{Matebook,V14Igl,TufGaming}));
        this.Walkthemenu();
    }
    public  void listing(){
        brandlist.sort(new OrderBrands());
        Iterator<Brand> itr = this.brandlist.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next().getName());
        }

    }
    public void Walkthemenu(){
        System.out.println("---------- Welcome to the Patika Store ----------");
        System.out.println("1 - Notebooks \n" +
                "2 - Cellphones \n" +
                "3 - Brands \n" +
                "4 - Filters by Brand \n"+
                "0 - Exit \n " +
                "Please Choose");
        int menu = sc.nextInt();
        switch (menu){
            case 1:
                System.out.println("Welcome to Notebook Section");
                this.devicesMenu(notebooks);
                break;
            case 2:
                System.out.println("Welcome to Cellphone Section");
                this.devicesMenu(cellphones);
                break;
            case 3:
                System.out.println("Our Brands--------------");
                this.listing();
                break;
            case 4:
                System.out.println("Choose Brand for Filter");
                this.filterByBrand();
                break;
            case 0:
                System.out.println("----- See ----- You -----");
                break;
        }
    }
    public void devicesMenu(ArrayList<Products> productlist){
        System.out.println("1 - List the Products \n" +
                "2 - Add the Product \n" +
                "3 - Remove the Product \n" +
                "4 - Sort List \n" +
                "0 - Back ");
        int prodchosen = sc.nextInt();
        switch (prodchosen){
            case 1:
                this.listingProducts(productlist);
                break;
            case 2:
                this.AddProduct(productlist);
                break;
            case 3:
                this.removeProduct(productlist);
                break;
            case 4:
                this.sortingProducts(productlist);
            case 0  :
                Walkthemenu();
                break;
        }

    }
    public void listingProducts(ArrayList<Products> products){
        System.out.println("| ID |      Ürün Adı            |   Fiyat      |  Marka       |  Depolama   |  Ekran    |    Ram     |");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Products p:products) {
            System.out.println("| "+ p.getId() +"  |   "+p.getName()+"        |    "+p.getPrice()+" TL   |   "+p.getBrand().getName()+"       |   "+p.getStorage()+"      | "+p.getWindowwidth()+"      | "+p.getRam() +"    |");
        }
    }
    public void AddProduct( ArrayList<Products> prductList){
        System.out.println("Welcome to the Adding Product");
        int productid = prductList.get(prductList.size()-1).getId()+1;
        System.out.println("What is the product price ? ");
        int productprice = sc.nextInt();
        System.out.println("What is the discount rate?");
        int productDiscount = sc.nextInt();
        System.out.println("How many product is in storage?");
        int productsstorage = sc.nextInt();
        System.out.println("What is Product name?");
        Scanner ln = new Scanner(System.in);
        String productName = ln.nextLine();
        Brand probrand = choseBrand();
        System.out.println("What is product's memory ? ");
        int productMemory = sc.nextInt();
        System.out.println("What is product's windowwith ? ");
        double productWindowWidth = sc.nextDouble();
        System.out.println("What is product's Ram ? ");
        int productRAM = sc.nextInt();
        System.out.println("What is product's colour ?");
        String productColour = sc.nextLine();
        if (prductList == cellphones){
            System.out.println("What is Your power ");
            int productPower = sc.nextInt();
            prductList.add(new Cellphone(productid,productprice,productDiscount,productsstorage,productName,probrand,productMemory,productWindowWidth,productRAM,productColour,productPower));
            System.out.println("Product added");
        }else{
            prductList.add(new Products(productid, productprice, productDiscount, productsstorage, productName, probrand, productMemory, productWindowWidth, productRAM, productColour) {
            });
            System.out.println("Product added");
        }
        devicesMenu(prductList);

    }
    public void removeProduct(ArrayList<Products> products){
        listingProducts(products);
        System.out.println("Lütfen silmek istediğiniz ürünün idsini giriniz");
        int removenChoseId = sc.nextInt();
        try {
            if (products.size()<1){
                System.out.println("There isn't any product");
            }else{
                for (Products product: products) {
                    if (product.getId()==removenChoseId){
                        products.remove(product);
                        System.out.println("product is removed");
                    }
                }
            }
        }catch (Exception e){

        }
        devicesMenu(products);
    }
    public Brand choseBrand(){
        for (Brand b : this.brandlist){
            System.out.println(b.getId() + " - " + b.getName());
        }
        System.out.println("Which one is your products's brand?");
        int brandchosen = sc.nextInt();
        return this.brandlist.get(brandchosen-1);
    }
    public void filterByBrand(){
        Brand chosebrand = this.choseBrand();
        ArrayList<Products> FilterBrandProducts = new ArrayList<>() ;
        for (Products pro : cellphones){
            if (pro.getBrand()==chosebrand){
                FilterBrandProducts.add(pro);
            }
        }
        for (Products pro : notebooks){
            if (pro.getBrand()==chosebrand){
                FilterBrandProducts.add(pro);
            }
        }
        listingProducts(FilterBrandProducts);
        Walkthemenu();

    }
    public void sortingProducts(ArrayList<Products> products){
        System.out.println("Choose your sorting style \n" +
                "1 - A-Z \n" +
                "2 - Z-A \n" +
                "3 - low-High \n" +
                "4 - High-low \n");
        int choosensort = sc.nextInt();

        switch (choosensort){
            case 1:
                products.sort(new Comparator<Products>() {
                    @Override
                    public int compare(Products o1, Products o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                listingProducts(products);
                break;
            case 2:
                products.sort(new Comparator<Products>() {
                    @Override
                    public int compare(Products o1, Products o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }.reversed());
                listingProducts(products);
                break;
            case 3:
                products.sort(new Comparator<Products>() {
                    @Override
                    public int compare(Products o1, Products o2) {
                        return o1.getPrice()-o2.getPrice();
                    }
                });
                listingProducts(products);
                break;
            case 4:
                products.sort(new Comparator<Products>() {
                    @Override
                    public int compare(Products o1, Products o2) {
                        return o1.getPrice()-o2.getPrice();
                    }
                }.reversed());
                listingProducts(products);
                break;

        }
    }

}