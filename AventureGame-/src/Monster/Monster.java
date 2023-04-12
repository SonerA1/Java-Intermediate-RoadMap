package Monster;

public class Monster {
	private String name;
	private int id;
	private int damage;
	private int health;
	private int award;
	private int orgHealth;
	private String item;
	public Monster(String name, int id, int damage, int health, int award) {
		super();
		this.name = name;
		this.id = id;
		this.damage = damage;
		this.health = health;
		this.award = award;
		this.orgHealth = orgHealth;
		this.item = item;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getAward() {
		return award;
	}
	public void setAward(int award) {
		this.award = award;
	}
	public int getOrgHealth() {
		return orgHealth;
	}
	public void setOrgHealth(int orgHealth) {
		this.orgHealth = orgHealth;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	

}
