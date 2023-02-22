package behavioralDP.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsChannel implements  Channel{

    //it should have list of news
    private List<String> newsList= new ArrayList<>();


    @Override
    public void update(String news) {
        //new news will be added to List
        newsList.add(news);
    }

    @Override
    public void printNews() {
        //all list of news will be printed
        for (String news:newsList){
            System.out.println(news);
        }
    }
}
