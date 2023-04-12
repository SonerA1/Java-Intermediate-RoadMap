package Game;

import java.util.Iterator;
import java.util.Scanner;

import Character.Archer;
import Character.GameChar;
import Character.Knight;
import Character.Samurai;

public class Player {
	protected int damage;
	protected int health;
	private int orgHealth;
	protected int money;
	protected String name;
	protected String charName;
	protected Scanner scan = new Scanner(System.in);
	protected Inventory inventory;
	
	public Player(String name) {
		super();
		this.name = name;
		this.inventory = new Inventory();
	}
	public void selectChar() {
		GameChar[] charlist = {new Samurai(), new Archer(), new Knight()};
		System.out.println("--------------------------------------------");
        for (GameChar gameChar : charlist){
            System.out.println("ID : " + gameChar.getId()+
                    "\t Character : "+ gameChar.getName() +
                    "\t Damage : "+gameChar.getDamage()+
                    "\t Health : " + gameChar.getHealth()+
                    "\t Money : "+gameChar.getCost());
        }System.out.println("--------------------------------------------");
        System.out.println("Please select a Character ! :");
        int selectChar = scan.nextInt();        
        
        switch (selectChar) {
        case 1:
        	initPlayer(new Samurai());
        	break;
        case 2:
        	initPlayer(new Archer());
        	break;
        case 3:
        	initPlayer(new Knight());
        	break;
        	default:
        		initPlayer(new Samurai());
        		break;
        }
        
        
	}
	public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrgHealth(gameChar.getHealth());
        this.setMoney(gameChar.getCost());
        this.setCharName(gameChar.getName());
    }
    public void printInfo(){
        System.out.println("Weapon : "+ this.getInventory().getWeapon().getName() + "  |" +
                "\t Armor : " + this.getInventory().getArmor().getName() + "  |" +
                "\t Block : " + this.getInventory().getArmor().getBlock() + "  |" +
                "\t Damage : "+ this.getDamage() + "  |" +
                "\t Health : " + this.getHealth() + "  |" +
                "\t Money : "+this.getMoney());

    }
    public void printInventory(){
        System.out.println();
        System.out.println("Food : " + this.getInventory().getFood());
        System.out.println("Wood : " + this.getInventory().getWood());
        System.out.println("Water : " + this.getInventory().getWater());
        System.out.println();
    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
	

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getOrgHealth() {
		return orgHealth;
	}

	public void setOrgHealth(int orgHealth) {
		this.orgHealth = orgHealth;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	

	
}
