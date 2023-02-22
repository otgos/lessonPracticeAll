package behavioralDP.mediator;

public interface Teacher {
    void receiveMessage(String message);

    void sendMessage(String topic, String message);
}
