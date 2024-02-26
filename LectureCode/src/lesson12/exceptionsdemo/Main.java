package lesson12.exceptionsdemo;

import java.util.logging.Logger;

/**
 * Creates a few Employees, stores them in an array.
 * Then locates all Employees with first name Bill
 * 
 * @author pcorazza
 *
 */
public class Main {
	static Logger LOG = Logger.getLogger("");
	public static void main(String[] args) {
		
		Address add1A = new Address("10 Adams", "Fairfield", "IA", "52556");
		Address add1B = new Address("110 Burlington", "Fairfield", "IA", "52556");
		Address add2A = new Address("322 Harrison", "Fairfield", "IA", "52556");
		Address add2B = new Address("2210 Burlington", "Fairfield", "IA", "52556");
		Employee[] emps = new Employee[2];
		emps[0] = new Employee("Joe", "Smith");
		emps[0].setSalary(100000);
		emps[0].setHome(add1A);
		emps[0].setWork(add1B);
		emps[1] = new Employee("Bill", "Jones");
		emps[1].setSalary(120000);
		emps[1].setHome(add2A);
		emps[1].setWork(add2B);
		DataDisplayer dd = new DataDisplayer(emps);
		dd.displayData();
		LOG.warning("warning");
		LOG.info("info");
		LOG.config("config");
		
	}

}
