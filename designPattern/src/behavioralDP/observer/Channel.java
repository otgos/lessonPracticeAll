package behavioralDP.observer;

public interface Channel {
    void update(String news); //used for adding new updates

    void printNews();
}
