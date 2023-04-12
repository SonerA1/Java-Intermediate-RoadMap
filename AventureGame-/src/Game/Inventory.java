package Game;

import Item.Armor;
import Item.Weapon;

public class Inventory {
	private Weapon weapon;
	private Armor armor;
	private int food = 0;
	private int wood = 0;
	private int water = 0;
	
	public Inventory() {
		this.weapon = new Weapon("Punch",-1,0,0);
		this.armor = new Armor(-1,"Clothes",0,0);
		this.food = food;
		this.water = water;
		this.wood = wood;
	
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}
	

}
