package Locations;

import Game.Player;
import Monster.Monster;
import Monster.Zombie;

public class Cave extends BattleLoc {

	public Cave(Player player) {
		super(player,"Cave",new Zombie(),"Food", 3);
		// TODO Auto-generated constructor stub
	}

}
