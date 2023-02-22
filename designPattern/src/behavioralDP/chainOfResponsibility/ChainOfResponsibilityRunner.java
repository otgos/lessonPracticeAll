package behavioralDP.chainOfResponsibility;

public class ChainOfResponsibilityRunner {
    public static void main(String[] args) {

        ChainOfResponsibilityRunner resp = new ChainOfResponsibilityRunner();
        resp.chainOfResponsibility();

    }
    void chainOfResponsibility(){
        Approver generalManager  = new GeneralManager();
        //we need to set the general Manager to manger
        Approver manager = new Manager(generalManager);

        Approver official = new Official(manager);

        System.out.println("Limits for loan: ");
        System.out.println("For official, max limit is: <100 ");
        System.out.println("For manager, max limit is: <500 ");
        System.out.println("For general manager, no limit ");
        System.out.println("********************");
        System.out.println("requested amount is: 50");
        official.approveLoan(50);
        System.out.println("requested amount is: 450");
        official.approveLoan(450);
        System.out.println("requested amount is: 750");
        official.approveLoan(750);

    }
}
