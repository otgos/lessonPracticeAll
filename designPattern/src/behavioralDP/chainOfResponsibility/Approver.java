package behavioralDP.chainOfResponsibility;

public abstract class Approver {
    Approver chief;

    //when we create obj we need to set manager of the class
    public Approver(Approver chief) {
        this.chief = chief;
    }

    abstract boolean approveLoan(int amount);
}
