package creationalDP.singletonDP;

public class SingletonObject {
    String message = "HELLO";
    private static SingletonObject instance = new SingletonObject();
    //new object cannot be created 
    private SingletonObject(){};
    
    //this is the main thing singleton. 
    // Each time when i get this method i will get above method
    //it is static so it is class based
    public static  SingletonObject getInstance(){
        return instance;
    }
    
    public void changeMethod(){
        this.message = this.message+" Batch 110-111";
    }
}
