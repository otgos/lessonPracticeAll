package creationalDP.protoTypeDP;

public class Soldier implements Cloneable{
    private int health; //out of 100
    private int speed;
    private int maxLifeTime; //
    private int agility; //depending on weapon
    private int power;  //how much power it will remove from opponent
    private int rank;  // soldiers will have different rank //
    private String weapon; //which gun carry
    private boolean isAvailableForWar;
//instead of set one by one constructor with all args
    public Soldier(int health, int speed, int maxLifeTime, int agility, int power, int rank, String weapon, boolean isAvailableForWar) {
        this.health = health;
        this.speed = speed;
        this.maxLifeTime = maxLifeTime;
        this.agility = agility;
        this.power = power;
        this.rank = rank;
        this.weapon = weapon;
        this.isAvailableForWar = isAvailableForWar;
    }

    //some methods which will give some information about soldier

    public void showSoldierInfo(){
        System.out.println("Health: "+health);
        System.out.println("Speed: "+speed);
        System.out.println("Agility: "+agility);
        System.out.println("Power: "+power);
        System.out.println("Rank: "+rank);
        System.out.println("Maximum Life Time: "+maxLifeTime);
        System.out.println("Weapon: "+weapon);

        if(isAvailableForWar){
            System.out.println("Ready to fight!");
        }else {
            System.out.println("Unavailable to fight");
        }
    }

    // Getter - Setter // do this later on

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxLifeTime() {
        return maxLifeTime;
    }

    public void setMaxLifeTime(int maxLifeTime) {
        this.maxLifeTime = maxLifeTime;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public boolean isAvailableForWar() {
        return isAvailableForWar;
    }

    public void setAvailableForWar(boolean availableForWar) {
        isAvailableForWar = availableForWar;
    }

    @Override
    public Soldier clone() {
        Soldier soldier = null;

        try {
            // set above class name here
            soldier = (Soldier) super.clone();
            //remove to do

        } catch (CloneNotSupportedException e) {
            //change the exception message
            System.out.println("Error occurred while cloning the Soldier class");
            e.printStackTrace();
        }
        //return soldier here
        return soldier;
    }
}
