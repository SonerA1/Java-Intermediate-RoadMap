public class MyList <T>{
    int capacity;
    T[] list;
    T[] listTemp;
    int listSize = 0;

    public void setList(){
        this.list = (T[]) new Object[this.capacity];
    }

    public void pCapacity(){
        this.listTemp = (T[]) new Object[this.capacity];
        for (int i = 0; i < this.list.length; i++){
            this.listTemp[i] = this.list[i];
        }
        this.list = this.listTemp;
    }
    public MyList(int capacity){
        this.capacity = capacity;
        this.setList();
    }

    public MyList(){ //Here we have indicated the capacity
        this.capacity = 10;
        this.setList();
    }
    public int getCapacity(){
        return capacity;
    }
    public int size(){
        return  this.listSize;
    }
    public void sizeCalc(){
        int c = 0;
        for (int i = 0; i < this.list.length; i++){
            if (this.list[i] != null){
                c++;
            }
        }
        this.listSize = c;
    }
   public void add(T data){
        if(this.size() < this.capacity){
            list[this.listSize] = data;
            this.sizeCalc();
        }else {
            this.capacity = this.capacity*2;
            this.pCapacity();
            this.add(data);
        }
   }
    @Override
    public String toString(){
        System.out.print("[");
        for (T x:list){
            if (x!= null){
                System.out.print(x+ ",");
            }
        }
        System.out.println("]");
        return "";
    }
    public  T get(int idx){
        T x=this.list[idx];
        return  x;
    }
    public void remove(int idx) {
        replaceForRemove(idx);
        this.listSize--;
    }
    public void replaceForRemove(int idx){
        T[] listTepm2 = this.list;
        this.list[idx] = null;
        for(int i=0;i<listTepm2.length-1;i++){
            if(idx==0){
                this.list[i]=listTepm2[i+1];
            }else if (idx!=0 && i<idx){
                this.list[i] =listTepm2[i];
            } else if (idx!=0 && i>idx ) {
                this.list[i] = listTepm2[i+1];

            }
        }
    }
    public void set(int idx, T data) {
        this.list[idx] = data;
    }
    public int indexOf(T data){
        for (int i =0 ; i<this.list.length;i++){
            if (data == this.list[i]){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data){
        int lastIdx =-1;
        for (int i = 0; i<this.list.length;i++ ){
            if (data ==this.list[i]){
                lastIdx = i;
            }
        }
        return lastIdx;
    }
    public boolean isEmpty(){
        if (this.size()==0)return true;
        else return false;
    }
    public Object[] toArray(){
        Object[] tempObject =new Object[this.list.length];
        for (int i =0;i<this.list.length;i++){
            tempObject[i] = this.list[i];
        }
        return tempObject;
    }
    public MyList<T> subList(int x, int y){
        MyList<T> sub =new MyList<>(y-x+1);
        for (int i=x;i<=y;i++){
            sub.add((T)this.list[i]);
        }
        return sub;
    }
    public boolean contains(T data){
        for (int i=0;i<this.list.length;i++){
            if (data ==this.list[i]){
                return true;
            }
        }
        return false;
    }
    public void clear(){
        for (int i=0;i<this.list.length;i++){
            this.list[i] =null;
        }
    }

}
