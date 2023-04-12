package Locations;

import Game.Player;
import Monster.Monster;
import Monster.Vampire;

public class Forest extends BattleLoc {

	public Forest(Player player) {
		super(player, "Forest", new Vampire(),"Wood",3);
		// TODO Auto-generated constructor stub
	}

}
