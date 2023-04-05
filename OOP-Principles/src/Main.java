public class Main {
    public static void main(String[] args) {
        //Worker w1 = new Worker("Alex","Java", "05000000001","alex@java.com");
        //Academician a1 = new Academician("Eric","Python","050000022","eric@python.com","CENG","Prof");
        //Officer o1 = new Officer("Max","C#","0555333300","max@C#.com","Computing","09:00-18:00");
        //Lecturer l1 = new Lecturer("Tom","Kotlin","054444411","tom@kotlin.com","CENG","Prof","110");
        //Assistant as1 = new Assistant("Julia","React","054443321","julia@react.com","CENG","Assistant","11:00");
        //Computing c1 = new Computing("Sam","Css","05432111","sam@css.com","Computing","09:00-18:00","Newtwork");
        //SecurityGuard s1 = new SecurityGuard("David","JavaScript","054321748","david@javascript.com","Security");

        //Polymorphism
        /*Worker a2 = new Academician("Hank","Ruby","060000055","hank@ruby.com","CENG","Prof");
        a2.entrance();*/
        /*Worker[] loginUsers = {w1,a1,o1,l1};
        Worker.entrants(loginUsers);*/

        //Abstraction
        /* We changed Academician,Officer to abstract. So we can no longer create objects in abstract classes.
        * After then Lecturer Class throws error and we fixed with override.
        l1.attendClass("11:00"); */
    }
}