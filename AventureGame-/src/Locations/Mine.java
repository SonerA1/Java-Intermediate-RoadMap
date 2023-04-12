package Locations;

import Game.Player;
import Monster.Monster;
import Monster.Snake;

public class Mine extends BattleLoc{

	public Mine(Player player) {
		super(player,"Mine", new Snake(),"Treasure",5);
		// TODO Auto-generated constructor stub
	}

}
