package lab_20240408.level1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Employee {
    private int empId;

    private final List<Paycheck> paychecks;

    public Employee(int empId) {
        this.empId = empId;

        this.paychecks = new ArrayList<>();
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void print() {
        System.out.println("ID: " + empId);
    }

    public List<Paycheck> getPaychecks() {
        return paychecks;
    }

    public final Paycheck calcCompensation(int month, int year) {
        Calendar startDate = Calendar.getInstance();
        startDate.set(year, month, 1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(year, month, startDate.getActualMaximum(Calendar.DAY_OF_MONTH));


        DateRange range = new DateRange(
                startDate,
                endDate

        );

        double grossPay = calcGrossPay(range);

        Paycheck p = new Paycheck(
                grossPay,
                23f,
                5f,
                1f,
                3f,
                7.5f,
                range
        );

        // Assume p is unique
        paychecks.add(p);

        return p;
    }

    public abstract double calcGrossPay(DateRange range);

}
