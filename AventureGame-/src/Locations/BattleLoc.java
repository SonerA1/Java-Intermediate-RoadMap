package Locations;

import java.util.Random;

import Game.Player;
import Item.Armor;
import Item.Weapon;
import Monster.Monster;

public class BattleLoc extends Location {
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
		int monsterNumber = this.randomMonster();
		System.out.println("Your are right here" + this.getName());
		System.out.println("Take care! Right here " + monsterNumber + getMonster().getName() + "alive.");
		System.out.println("<F>ight or <R>un");
		String selectGame = scan.nextLine().toUpperCase();

		if (selectGame.equals("F")) {
			System.out.println("Preapare the Fight!");
			if (combat(monsterNumber)) {
				System.out.println(this.getName() + "defeat all enemy");
				return true;
			}
		}
		if (this.getPlayer().getHealth() <= 0) {
			System.out.println("You LOSE  ! ");
			return false;
		}
		return true;
	}

	public int snakeDamage() {
		Random r = new Random();
		return r.nextInt() * 100;
	}

	public void drop() {
		Random r = new Random();
		int chance = r.nextInt() * 100;

		if (chance < 55) {
			Random rr = new Random();
			int itemchance = rr.nextInt() * 100;
			if (itemchance <= 30) {
				Random rw = new Random();
				int weaponeChance = rr.nextInt() * 100;
				if (weaponeChance <= 20) {
					getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
					System.out.println(getPlayer().getInventory().getWeapon().getName() + " Kazandiniz ..");
				}
				if (20 < weaponeChance && weaponeChance <= 50) {
					getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
					System.out.println(getPlayer().getInventory().getWeapon().getName() + " Kazandiniz ..");
				}
				if (50 < weaponeChance) {
					getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
					System.out.println(getPlayer().getInventory().getWeapon().getName() + " Kazandiniz ..");
				}

			}
			if (30 < itemchance && itemchance <= 60) {
				Random ra = new Random();
				int armorChance = ra.nextInt() * 100;
				if (armorChance <= 20) {
					getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
					System.out.println(getPlayer().getInventory().getArmor().getName() + " earned");
				}
				if (20 < armorChance && armorChance <= 50) {
					getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
					System.out.println(getPlayer().getInventory().getArmor().getName() + " earned");
				}
				if (50 < armorChance) {
					getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
					System.out.println(getPlayer().getInventory().getArmor().getName() + " earned");
				}
			}
			if (60 < itemchance) {
				Random rg = new Random();
				int goldChance = rg.nextInt() * 100;
				if (goldChance <= 20) {
					getPlayer().setMoney(getPlayer().getMoney() + 10);
					System.out.println("10 Gold earned");
				}
				if (20 < goldChance && goldChance <= 50) {
					getPlayer().setMoney(getPlayer().getMoney() + 5);
					System.out.println("5 Gold earned");
				}
				if (50 < goldChance) {
					getPlayer().setMoney(getPlayer().getMoney() + 1);
					System.out.println("1 Gold earned");
				}
			}
		} else {
			System.out.println("Nothing..");
		}
	}

	public boolean combat(int maxMonster) {
		if (this.getMonster().getName().equals("Snake")) {
			this.getMonster().setDamage(snakeDamage());
		}
		for (int i = 1; i <= maxMonster; i++) {
			this.getMonster().setHealth(this.getMonster().getOrgHealth());
			playerStats();
			monsterStats(i);
			int battlechance = chance();
			while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
				System.out.print("<F>ight or <R>un : ");
				String selectCombat = scan.nextLine().toUpperCase();

				if (selectCombat.equals("F")) {
					if (battlechance < 50) {
						System.out.println("Your hit !");
						this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
						afterHit();
						if (this.getMonster().getHealth() > 0) {
							System.out.println();
							System.out.println(getMonster().getName() + "Damage !");
							int enemyDamage = this.getMonster().getDamage()
									- this.getPlayer().getInventory().getArmor().getBlock();
							if (enemyDamage < 0) {
								enemyDamage = 0;
							}
							this.getPlayer().setHealth(this.getPlayer().getHealth() - enemyDamage);
							afterHit();
						}
					} else {
						if (this.getMonster().getHealth() > 0) {
							System.out.println();
							System.out.println(getMonster().getName() + "Damage : !");
							int enemyDamage = this.getMonster().getDamage()
									- this.getPlayer().getInventory().getArmor().getBlock();
							if (enemyDamage < 0) {
								enemyDamage = 0;
							}
							this.getPlayer().setHealth(this.getPlayer().getHealth() - enemyDamage);
							afterHit();
						}
						System.out.println("Yor hit: !");
						this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
						afterHit();
					}
				} else {
					return false;
				}
			}
			if (getMonster().getHealth() < this.getPlayer().getHealth()) {
				System.out.println("Defeat Enemey !");

				if (getMonster().getName().equals("Snake")) {
					drop();
				} else {
					System.out.println(this.getMonster().getAward() + " Money earned !");
					this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
					if (this.getMonster().getName().equals("Zombie")) {
						getPlayer().getInventory().setFood(1);
						System.out.println("Food earned");
					}
					if (this.getMonster().getName().equals("Vampire")) {
						getPlayer().getInventory().setWood(1);
						System.out.println("Wood earned");
					}
					if (this.getMonster().getName().equals("Bear")) {
						getPlayer().getInventory().setWater(1);
						System.out.println("Water earned");
					}
					if (this.getMonster().getName().equals("Snake")) {
					}
				}
				System.out.println("Total Balance " + this.getPlayer().getMoney());
			}
		}
		return false;
	}

	private int chance() {
		Random r = new Random();
		return r.nextInt()*100;
	}

	public void monsterStats(int i) {
		System.out.println(i + "." + this.getMonster().getName() + " Stats :");
		System.out.println("----------------");
		System.out.println("Health : " + this.getMonster().getHealth());
		System.out.println("Damage : " + this.getMonster().getDamage());
		System.out.println("Award : " + this.getMonster().getAward());

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

	public void afterHit() {
		System.out.println("Your Health : " + this.getPlayer().getHealth());
		System.out.println(this.getMonster().getName() + "Health : " + this.getMonster().getHealth());
		System.out.println("-----------------");
	}

	public int randomMonster() {
		Random r = new Random();
		return r.nextInt(this.getMaxMonster()) + 1;
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
