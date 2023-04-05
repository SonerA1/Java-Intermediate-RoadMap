public class Computing extends Officer {
    private String duty;
    public Computing(String name, String surName, String phone, String email, String department, String shift, String duty) {
        super(name, surName, phone, email, department, shift);
        this.duty = duty;
    }
    public void job(){
        System.out.println(this.getName() + " " + this.getSurName()+ " did a network setup");
    }
}
