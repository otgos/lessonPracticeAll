package behavioralDP.mediator;

public class MessageTeacher implements Teacher {

    //teacher field
    String name;

    //they should know dispatcher// not other teachers
    Dispatcher dispatcher;

    //constructor

    public MessageTeacher(String name, Dispatcher dispatcher) {
        this.name = name;
        this.dispatcher = dispatcher;
    }

    //which teacher to understand message receive
    @Override
    public void receiveMessage(String message) {
        System.out.println(name+" received message "+ message);

    }

    @Override
    public void sendMessage(String topic, String message) {
        //actor will send message through dispatcher
        dispatcher.dispatch(topic, message);
    }
}
