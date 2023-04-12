package Item;

public class Weapon {
	private String name;
	private int id;
	private int damage;
	private int price;

	public Weapon(String name, int id, int damage, int price) {
		this.name = name;
		this.id = id;
		this.damage = damage;
		this.price = price;
	}

	public static Weapon[] weapons() {
		Weapon[] weaponsList = new Weapon[3];
		weaponsList[0] = new Weapon("Katana", 1, 2, 25);
		weaponsList[1] = new Weapon("Crosbow", 2, 3, 35);
		weaponsList[2] = new Weapon("Heavy", 3, 5, 45);
		return weaponsList;
	}

	public static Weapon getWeaponObjByID(int id) {

		for (Weapon w : Weapon.weapons()) {
			if (w.getId() == id) {
				return w;
			}
		}

		return null;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
