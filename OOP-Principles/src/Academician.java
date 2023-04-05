public abstract class Academician extends Worker { //add a abstract..
    private String section;
    private String title;

    public Academician(String name, String surName, String phone, String email, String section, String title) {
        super(name, surName, phone, email);
        this.section = section;
        this.title = title;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    /*public void attendClass() { // abstract method
        System.out.println(this.getName() + " " + getSurName() + " " + "entered the class !"); //Encapsulation
    }*/
    public abstract void attendClass(String lessonClock);  // abstract method

    @Override // We can use another class's method here. And we should show them.
    public void entrance(){
        System.out.println(this.getName() + " " + this.getSurName()+ " " + "Academician entered through Gate A");
    }
}
