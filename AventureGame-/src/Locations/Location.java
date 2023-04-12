package Locations;

import java.util.Scanner;

import Game.Player;

public abstract class Location {
	private Player player;
	private String name;
	public static Scanner scan = new Scanner(System.in); 			
	
	public Location(Player player, String name) {
		super();
		this.player = player;
		this.name = name;
	}
	
	public abstract boolean onLocation();
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
