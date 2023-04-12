package Character;

public abstract class GameChar {
	private int id;
	private String name;
	private int damage;
	private int health;
	private int cost;

	public GameChar(int id, String name, int damage, int health, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
