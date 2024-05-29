package lab_20240408.level3;

public class Salaried extends Employee {
    private double salary;

    public Salaried(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(DateRange range) {
        return salary / 12D;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void print() {
        String str = "******************************* Salaried Employee *******************************\n\n" +
                String.format("\tID: #%d\n", getEmpId()) +
                String.format("\tSalary: $%,.2f/yr.\n", getSalary());

        System.out.println(str);
    }
}
