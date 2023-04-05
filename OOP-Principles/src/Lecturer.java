public class Lecturer extends Academician {

    private String doorNumber;
    public Lecturer(String name, String surName, String phone, String email, String section, String title,String doorNumber) {
        super(name, surName, phone, email, section, title);
        this.doorNumber = doorNumber;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    @Override // We can use another class's method here. And we should show them.
    public void entrance(){
        System.out.println(this.getName() + " " + this.getSurName()+ " " + "Lecturer entered through Gate B");
    }

    @Override
    public void attendClass(String clock){
        System.out.println(this.getName() + " " + this.getSurName()+ " " + "Lecturer" + clock +  " attend class ");

    }
}
