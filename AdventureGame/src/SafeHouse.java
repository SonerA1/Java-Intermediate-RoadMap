public class SafeHouse extends  NormalLoc {
    public SafeHouse(Player player) {
        super(player,"Safe Haouse" );
    }
    @Override
    public boolean onLocation(){
        System.out.println("You are in Safe House");
        System.out.println("Your health refresh");
        this.getPlayer().setHealth(this.getPlayer().getOrgHealth());
        return true;
    }
}
