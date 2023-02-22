package behavioralDP.chainOfResponsibility;

// leave this as at is , we will update this while we set s
public class Official extends Approver{
    //we need create constructor to make the manager of this class
    public Official(Approver chief) {
        super(chief);
    }

    @Override
    boolean approveLoan(int amount) {

        if(amount<100){
            System.out.println("Bank officer approved!");
            System.out.println("********************");
        } else if (chief!=null) {
            System.out.println("Amount exceeds limit that officer can approve. You are directed to manager");
            return chief.approveLoan(amount);
        }
        return false;
    }
}
