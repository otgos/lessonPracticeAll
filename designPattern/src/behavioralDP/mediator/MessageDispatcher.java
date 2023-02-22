package behavioralDP.mediator;

import java.util.HashMap;
import java.util.Map;

public class MessageDispatcher implements Dispatcher{


    //dispatcher should know which teacher is expert on which topic

    //***which data structure should this class know????
    //1. actor and topic
    //Map
    Map<String, Teacher> registeredActors = new HashMap<>();
    //all actors should be registered first..
    //all dispatchers should be registered
    void register(String topic, Teacher actor){

        registeredActors.put(topic, actor);
    }



//dispatcher receives question and should send message to correct teacher
    @Override
    public void dispatch(String topic, String message) { //Physics question
        //we need to get message from Actors.
        //first we need to find topic
       Teacher teacher =  registeredActors.get(topic);
       if(teacher == null){
           System.out.println("No actor registered for this topic");
       }else{
           teacher.receiveMessage(message);
       }
    }
}
