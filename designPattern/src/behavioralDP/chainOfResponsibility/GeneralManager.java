package behavioralDP.chainOfResponsibility;

public class GeneralManager extends Approver{
    //delete parameter and return null
    public GeneralManager() {
        super(null);
    }

    @Override
    boolean approveLoan(int amount) {
        System.out.println("General Manager approved");
        System.out.println("****************");
        return true;
    }
}
