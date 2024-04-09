package lab_20240408.level1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SalaryMain {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Create employees
        Employee e1 = new Hourly(1, 5.25, 20);
        Employee e2 = new Hourly(2, 12.5, 40);
        Employee e3 = new Salaried(3, 140_000);
        Employee e4 = new Salaried(4, 60_000);
        Employee e5 = new Commissioned(5, 7, 10_000,
                List.of(
                        new Order(1, new Date(2000-1900, Calendar.JANUARY, 15), 250),
                        new Order(2, new Date(2000-1900, Calendar.JANUARY, 18), 500),
                        new Order(3, new Date(2000-1900, Calendar.FEBRUARY, 1), 125),
                        new Order(4, new Date(2000-1900, Calendar.MARCH, 5), 150)
                )
        );

        employees.addAll(List.of(e1,e2,e3,e4,e5));

        // Calculate gross pay
        for(Employee e:employees){
            Paycheck paycheck = e.calcCompensation(Calendar.MARCH, 2000);

            e.print();

            paycheck.print();
        }


    }
}
