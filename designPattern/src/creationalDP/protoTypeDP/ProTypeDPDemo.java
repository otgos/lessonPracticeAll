package creationalDP.protoTypeDP;

public class ProTypeDPDemo {
    public static void main(String[] args) {
        Soldier availableSoldier = new Soldier(100, 45, 20, 50,
                60, 5, "Sward", true);
        // if i want to create not available soldier, everything will the save except last parameter

        Soldier notAvailableSoldier = new Soldier(100, 45, 20, 50,
                60, 5, "Sward", false);

        //so I may have hundreds of fields

        //we may set fields while we create fields but later on we may set different values


        //use clone method
        Soldier notAvailableSoldier2 = availableSoldier.clone(); //it clones the object
        notAvailableSoldier2.setAvailableForWar(false);

        System.out.println("********************");
        notAvailableSoldier.showSoldierInfo();
        System.out.println("********************");
        notAvailableSoldier2.showSoldierInfo();
    }
}
