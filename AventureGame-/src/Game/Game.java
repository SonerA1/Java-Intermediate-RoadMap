package Game;

import java.util.Scanner;

import Locations.Cave;
import Locations.Forest;
import Locations.Location;
import Locations.Mine;
import Locations.River;
import Locations.SafeHouse;
import Locations.ToolStore;

public class Game {
	Scanner scan = new Scanner(System.in);

	public void start() {
		System.out.println("Welcome the Adventure Game!");
		System.out.print("Please choose a Name : ");
		boolean win = false;

		String playerName = scan.nextLine();

		Player player = new Player(playerName);
		System.out.println("Welcome this Adventure...!");
		System.out.println("Please choose a character.");
		System.out.println("Characters");
		System.out.println();
		player.selectChar();

		Location location = null;

		while (true) {
			player.printInfo();
			printMenu();
			int selectLoc = scan.nextInt();
			if (selectLoc == 3 && player.getInventory().getFood() == 1) {
				selectLoc = 0;
				System.out.println("Mission Completed!");
				System.out.println();
				System.out.println("You are going to SafeHouse now");
			}
			if (selectLoc == 4 && player.getInventory().getWood() == 1) {
				selectLoc = 0;
				System.out.println("Mission Completed!");
				System.out.println();
				System.out.println("You are going to SafeHouse now");
			}
			if (selectLoc == 5 && player.getInventory().getWater() == 1) {
				selectLoc = 0;
				System.out.println("Mission Completed!");
				System.out.println();
				System.out.println("You are going to SafeHouse now");
			}
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
			if (location == null) {
				System.out.println("YOU ARE GİVE UP!");
				break;
			}
			if (!location.onLocation()) {
				System.out.println("GAME OVER!!!");
				break;
			}
		}
	}

	public void printMenu() {
		System.out.println();

		System.out.println(" ######## Locations ########");
		System.out.println();

		System.out.println(" 1 - SafeHouse -->  There is SafeHouse. There is no enemy...");
		System.out.println(" 2 - ToolStore     -->  Armors and Weapons");
		System.out.println(" 3 - Cave    -->  Awards <Food> Preaper the zombies!!!");
		System.out.println(" 4 - Forest     -->  Awards <Wood> ake care the Vampires!!!");
		System.out.println(" 5 - River     -->  Awards <Water>  Silence!.Dont wake up the Bear!!!");
		System.out.println(" 6 - Mine     -->  Awards <Treasure> Snakes!!!");

		System.out.println(" 0 - Quit --> Quit Game");
		System.out.println(" Please select Locations : ");
	}

}
