public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to Store Traveler ");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("What you need");
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Quit");
            System.out.println("Your Choose");
            int selectCase = Location.scan.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Try again. What you need");
                selectCase = scan.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you later.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("---- Weapons ----");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + " "
                    + " <Money : " + w.getPrice() + ", Damage : " + w.getDamage() + ">");
        }
        System.out.println("0 - Quit");
    }

    public void buyWeapon() {

        System.out.println("Choose a weapon : ");
        int selectWeaponID = scan.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Try again. What you need");
            selectWeaponID = scan.nextInt();
        }
        if(selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjectByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough money...");
                } else {
                    // BUY DİD HERE
                    System.out.println(selectedWeapon.getName() + " " + "Alright. You can take it.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your money balance : " + this.getPlayer().getMoney());
                    System.out.println("Your last weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("New weapon : " + this.getPlayer().getInventory().getWeapon().getName());

                }
            }

        }
    }

    public void printArmor() {

        System.out.println("---- Armors ----");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() +
                    " <Block : " + a.getBlock() + " , Price : " + a.getPrice() + ">");
        }
        System.out.println("0 - Quit");

    }

    public void buyArmor() {
        System.out.println("Choose a armor : ");
        int selectArmorID = scan.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Try again. What you need");
            selectArmorID = scan.nextInt();

        }
        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjectByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough money...");
                } else {
                    System.out.println(selectedArmor.getName() + "Alright. You can take it.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your money balance : " + this.getPlayer().getMoney());
                }
            }
        }

    }
}

