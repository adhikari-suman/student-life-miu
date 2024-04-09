package standard_exam_20240406.prob2;

import java.util.List;

public class Admin {
	public static double computeUpdatedBalanceSum(List<Employee> list) {
		//implement
		double total = 0.0;

		for(var e:list){
			total+=e.computeUpdatedBalanceSum();
		}

		return total;
	}
}
