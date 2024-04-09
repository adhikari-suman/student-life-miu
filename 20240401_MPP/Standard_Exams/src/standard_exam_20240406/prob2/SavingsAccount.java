package standard_exam_20240406.prob2;

public class SavingsAccount extends Account {


    private double balance;
    private double interestRate;
    private String acctId;

    public SavingsAccount(String acctId, double interestRate,double startBalance  ) {
        this.balance = startBalance;
        this.interestRate = interestRate;
        this.acctId = acctId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    @Override
    public String getAccountID() {
        return acctId;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double computeUpdatedBalance() {
        balance += balance * interestRate;

        return balance;
    }
}
