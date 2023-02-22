package behavioralDP.mediator;

public interface Dispatcher {
    //we may increase num of dispatacher so we are making this interface
    void dispatch(String  topic, String message);
}
