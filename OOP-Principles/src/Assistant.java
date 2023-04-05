public abstract class Assistant extends Academician {
    private String oficeClock;
    public Assistant(String name, String surName, String phone, String email, String section, String title,String oficeClock) {
        super(name, surName, phone, email, section, title);
        this.oficeClock = oficeClock;
    }
    public void makeQuiz(){
        System.out.println(this.getName() + " " + this.getSurName() + " did a quiz");
    }
}
