package behavioralDP.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {

    //
    private String news;


    //list of registered channels
    private List<Channel> channelList = new ArrayList<>();

    //method to add registered channels
    public void addObserver(Channel channel){
        this.channelList.add(channel);
    }
    //remove observer
    public void removeObserver(Channel channel){
        this.channelList.remove(channel);
    }

    //send new updates to channels
    public void sendNews(String news){
        this.news = news;
        for (Channel channel: channelList) {

            channel.update(this.news);

        }
    }


}
