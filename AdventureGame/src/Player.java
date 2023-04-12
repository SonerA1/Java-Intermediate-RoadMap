import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orgHealth;
    private int money;
    private String name;
    private String charName;
    Scanner scan = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Character[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Characters");
        System.out.println("------------------------------------------------------------------------------------");
        for (Character character : charList) {
            System.out.println();
            System.out.println("ID : " + character.getId() +
                    "\tCharacter :" + character.getName() +
                    "\t Damage :" + character.getDamage() + "" +
                    "\t Health :" + character.getHealth() + "" +
                    "\t Money : " + character.getMoney());
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("Choose a Character : ");
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
        }


    }

    public void initPlayer(Character character) {
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setOrgHealth(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharName(character.getName());
    }

    public void printInfo() {
        System.out.println(
                "Weapon : " + this.getInventory().getWeapon().getName() +
                        ", Armor : " + this.getInventory().getArmor().getName() +
                        ", Block : " + this.getInventory().getArmor().getBlock() +
                        ", Damage : " + this.getTotalDamage() +
                        ", Health:" + this.getHealth() +
                        ", Money : " + this.getMoney());
    }

    public int getTotalDamage() {
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrgHealth() {
        return orgHealth;
    }

    public void setOrgHealth(int orgHealth) {
        this.orgHealth = orgHealth;
    }
}
