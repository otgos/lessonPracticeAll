package behavioralDP.chainOfResponsibility;

public class Manager extends Approver{
    public Manager(Approver chief) {
        super(chief);
    }

    @Override
    boolean approveLoan(int amount) {
        //**copy this from Officer class
        if(amount<500){
            System.out.println("Bank manager approved!");
            System.out.println("********************");
        } else if (chief!=null) {
            System.out.println("Amount is exceeds limit that officer can approve. You are directed to general Manager");
            return chief.approveLoan(amount);
        }
        return false;
    }
}
