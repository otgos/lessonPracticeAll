package behavioralDP.observer;

public class ObserverRunner {
    public static void main(String[] args) {

        ObserverRunner runner = new ObserverRunner();
        runner.observerDemo();


        //try to write each code...without dp

    }
    //create new channels
    void observerDemo(){

        //new channels
        Channel channel1 = new NewsChannel();
        Channel channel2 = new NewsChannel();
        Channel channel3 = new NewsChannel();

        //new agency
        NewsAgency agency = new NewsAgency();

        //register channels to agency
        agency.addObserver(channel1);
        agency.addObserver(channel2);
        agency.addObserver(channel3);

        //new posts/updates
        agency.sendNews("Learn Java at TechPro");
        agency.sendNews("Batch 110 -111 students about to finish bootcamp");

        System.out.println("News from Channel 1: ");
        channel1.printNews();

        System.out.println("News from Channel 2: ");
        channel2.printNews();

        System.out.println("News from Channel 3: ");
        channel3.printNews();

    }
}
