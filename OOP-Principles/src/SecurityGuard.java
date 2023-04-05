public class SecurityGuard extends Worker {
    private String document;
    public SecurityGuard(String name, String surName, String phone, String email,String document) {
        super(name, surName, phone, email);
        this.document = document;
    }
    public void shift(){
        System.out.println(this.getName() + " " + getSurName()+ " " + "kept watch between 24:00-08:00");
    }
}
