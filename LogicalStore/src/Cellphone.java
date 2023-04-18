public class Cellphone extends Products{
    private int power;
    public Cellphone(int id, int price, int discountRate, int storage, String name, Brand brand, int memory, double windowwidth, int ram, String colour,int power) {
        super(id, price, discountRate, storage, name, brand, memory, windowwidth, ram, colour);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}