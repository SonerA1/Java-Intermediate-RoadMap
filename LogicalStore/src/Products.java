public  class  Products {
    private int id;
    private int price;
    private int discountRate;
    private int storage;
    private String name;
    private Brand brand;
    private int Memory;
    private double windowwidth;
    private int Ram;
    private String colour;

    public Products(int id, int price, int discountRate, int storage, String name, Brand brand, int memory, double windowwidth, int ram, String colour) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.storage = storage;
        this.name = name;
        this.brand = brand;
        this.Memory = memory;
        this.windowwidth = windowwidth;
        this.Ram = ram;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getMemory() {
        return Memory;
    }

    public void setMemory(int memory) {
        Memory = memory;
    }

    public double getWindowwidth() {
        return windowwidth;
    }

    public void setWindowwidth(double windowwidth) {
        this.windowwidth = windowwidth;
    }

    public int getRam() {
        return Ram;
    }

    public void setRam(int ram) {
        Ram = ram;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}