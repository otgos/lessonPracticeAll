package behavioralDP.mediator;

public class MediatorRunner {
    public static void main(String[] args) {

        MediatorRunner mediator = new MediatorRunner();
        mediator.mediator();


        //try this code not using mediator
        //if we add more experts

    }
    //
    void mediator(){
        //dispatcher obj
        MessageDispatcher dispatcher = new MessageDispatcher();
        //created 3 teachers
        Teacher chemistryTeacher = new MessageTeacher("ChemistryTeacher", dispatcher);
        Teacher mathTeacher = new MessageTeacher("MatchTeacher", dispatcher);
        Teacher biologyTeacher = new MessageTeacher("BiologyTeacher", dispatcher);
        Teacher englishTeacher = new MessageTeacher("EnglishTeacher", dispatcher);

        //registered my teachers for dispatcher

        dispatcher.register("chemistry", chemistryTeacher);
        dispatcher.register("mathematics", mathTeacher);
        dispatcher.register("biology", biologyTeacher);
        dispatcher.register("english", englishTeacher);

        //one actor can ask questions from others
        chemistryTeacher.sendMessage("mathematics", "Message about Maths");
        chemistryTeacher.sendMessage("biology", "Message about Biology");
        chemistryTeacher.sendMessage("english", "Message about English");

    }
}
