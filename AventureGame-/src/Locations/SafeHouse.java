package Locations;

import Game.Player;

public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "SafeHouse");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onLocation() {
		System.out.println();
		System.out.println("There is no enemy...");
		System.out.println("You are in the SafeHouse now, your health be refresh");
		System.out.println();
		this.getPlayer().setHealth(this.getPlayer().getOrgHealth());
		getPlayer().printInventory();
		System.out.println();
		return true;
	}
	

}
