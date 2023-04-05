public abstract class Worker {
    private String name;
    private String surName;
    private String phone;
    private String email;

    public Worker(String name, String surName, String phone, String email) {
        this.name = name;
        this.surName = surName;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void entrance(){
        System.out.println(this.getName() + " " + this.getSurName() + " " + " worker entered the university!!");
    }
    public void entrance(String entranceClock, String exitClock){ // Overloading => Giving a parameter.
        System.out.println(this.getName() + " " + this.getSurName() + " " + entranceClock + "oclok" + "entered the university and" + exitClock +" it will be out 18oclock.");
    }
    public void exit(){
        System.out.println(this.getName() + " " + this.getSurName() + " " +  "left the university!!");
    }
    public void diningHall(){
        System.out.println(this.getName() + " " + this.getSurName() + " " + "entered the dinning hall");
    }
    public static void entrants(Worker[] loginUsers){
        for (Worker w : loginUsers){
            w.entrance();
        }
    }

}
