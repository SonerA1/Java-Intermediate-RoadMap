import java.util.Random;

public abstract class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsNumber = this.randomMonsterNumber();
        System.out.println("You are here now!" + this.getName());
        System.out.println("Warning. Preaper the fight" + "," + monsNumber  + " " + this.getMonster().getName() + " " + "alive!!");
        System.out.print("<F>ight or <R>un :");
        String selectCase = scan.nextLine().toUpperCase();

        if (selectCase.equals("F") && combat(maxMonster)) {
            System.out.println("Battle Begin!");
            System.out.println(this.getName() + " elemenited all enemy !");
            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("YOU ARE DEAD!");
            return false;
        }
        return true;
    }

    public boolean combat(int maxMonster) {
        for (int i = 1; i < maxMonster; i++) {
            this.getMonster().setHealth(this.getMonster().getOrgHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<F>ight or <R>un");
                String selectCombat = scan.nextLine().toUpperCase();
                if (selectCombat.equals("F")) {
                    System.out.println("Your Attack: ");
                    this.getMonster().setHealth((this.monster.getHealth() - this.getPlayer().getTotalDamage()));
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println("Monster Atackt !");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth((this.getPlayer().getHealth() - monsterDamage));
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You win!");
                System.out.println(this.getMonster().getAward() + " Money earned");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Total Money : " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + ", Health : " + this.getMonster().getHealth());
        System.out.println("-----------------");
    }

    public void playerStats() {
        System.out.println("Player Stats");
        System.out.println("----------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Block : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money : " + this.getPlayer().getMoney());
        System.out.println("");


    }

    public void monsterStats(int i) {
        System.out.println(i + "." + this.getMonster().getName() + " Stats :");
        System.out.println("----------------");
        System.out.println("Health : " + this.getMonster().getHealth());
        System.out.println("Damage : " + this.getMonster().getDamage());
        System.out.println("Award : " + this.getMonster().getAward());

    }

    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) ;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
