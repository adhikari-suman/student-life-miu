package lab_20240408.level3;

public class Hourly extends Employee {

    private double hourlyWage;
    private int hoursPerWeek;


    public Hourly(int empId, double hourlyWage, int hoursPerWeek) {
        super(empId);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }


    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calcGrossPay(DateRange range) {
        return hourlyWage * hoursPerWeek * 4;
    }

    @Override
    public void print() {
        String str = "******************************* Hourly Wage Employee *******************************\n\n" +
                String.format("\tID: #%d\n", getEmpId()) +
                String.format("\tWage: $%,.2f/hr\n", getHourlyWage()) +
                String.format("\tHours per week: %d/week\n", getHoursPerWeek());

        System.out.println(str);
    }
}
