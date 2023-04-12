import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Adventure Game!");
        System.out.print("Plase select a name : ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " " + "Welcome, Make Your Choices Carefully!!");
        System.out.println("Please select a Character.");
        System.out.println("------------------------------------------------------------------------------------");
        player.selectChar();


        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("#####Location#####");
            System.out.println();
            System.out.println("1 - Safe House --> There is no here enemy Traveler.");
            System.out.println("2 - Tool Store --> If you buy Weapon or Armor!");
            System.out.println("3 - Cave --> Award <Food>. Preaper the zombies!!!");
            System.out.println("4 - Forest --> Award <Wood>. Take care the Vampires!!!");
            System.out.println("5 - River --> Award <Water>. Silence!.Dont wake up the Bear!!!");
            System.out.println("6 - Mine --> Award <Random>. Snake!!!");
            System.out.println("0 - Quit --> Quit game.");
            System.out.println("Please choose where you want to Location");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location == null){
                System.out.println("YOU ARE GİVE UP!");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!!!");
                break;
            }
        }
    }

}

