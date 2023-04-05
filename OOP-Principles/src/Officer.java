public abstract class Officer extends Worker {
    private String department;
    private String shift;

    public Officer(String name, String surName, String phone, String email, String department, String shift) {
        super(name, surName, phone, email);
        this.department = department;
        this.shift = shift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    public void work(){
        System.out.println(this.getName() + " " + this.getSurName() + " " + "officer on duty");
    }
    @Override // We can use another class's method here. And we should show them.
    public void entrance(){
        System.out.println(this.getName() + " " + this.getSurName()+ " " + "Officer entered through Gate C");
    }
}
