package standard_exam_20240406.prob2;

public class CheckingAccount extends Account {
    private double balance;
    private double monthlyFee;
    private String acctId;


    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountID() {
        return acctId;
    }

    @Override
    public double computeUpdatedBalance() {
        balance -= monthlyFee;

        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }


    public CheckingAccount(String acctId, double fee, double startBalance) {
        this.balance = startBalance;
        this.monthlyFee = fee;
        this.acctId = acctId;
    }


}
