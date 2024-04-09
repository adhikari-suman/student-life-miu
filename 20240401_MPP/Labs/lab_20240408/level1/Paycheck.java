package lab_20240408.level1;

public final class Paycheck {
    private final double grossPay;
    private final float fica;
    private final float state;
    private final float local;
    private final float medicare;
    private final float socialSecurity;
    private final DateRange payPeriod;

    public Paycheck(double grossPay, float fica, float state, float local, float medicare, float socialSecurity, DateRange payPeriod) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
        this.payPeriod = payPeriod;
    }


    public void print() {


        String sb = "************************** Paycheck details **************************\n\n" +
                String.format("\tGross Salary: $%,.2f\n", getGrossPay()) +
                String.format("\tFICA: %3.2f%%\n", getFica()) +
                String.format("\tState Tax: %3.2f%%\n", getState()) +
                String.format("\tLocal Tax: %3.2f%%\n", getLocal()) +
                String.format("\tMedicare: %3.2f%%\n", getMedicare()) +
                String.format("\tSocial Security: %3.2f%%\n", getSocialSecurity()) +
                String.format("\tPay period: %s\n", getPayPeriod()) +
                String.format("\tNet Pay: $%,.2f\n\n", getNetPay()) +
                "************************** Paycheck details **************************\n";

        System.out.println(sb);
    }

    public double getNetPay() {
        double taxes = getFica() + getState() + getLocal();

        return (100D - (taxes + getMedicare() + getSocialSecurity())) / 100 * getGrossPay();
    }

    public double getGrossPay() {
        return grossPay;
    }

    public float getFica() {
        return fica;
    }

    public float getState() {
        return state;
    }

    public float getLocal() {
        return local;
    }

    public float getMedicare() {
        return medicare;
    }

    public float getSocialSecurity() {
        return socialSecurity;
    }

    public DateRange getPayPeriod() {
        return payPeriod;
    }
}
