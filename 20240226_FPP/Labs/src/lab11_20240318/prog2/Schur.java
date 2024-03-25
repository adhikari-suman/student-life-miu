package lab11_20240318.prog2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Schur {

	boolean checkForSum(List<Integer> list, Integer z) {
		HashMap<Integer, Integer> complimentMap = new HashMap<>();

		for (Integer n : list) {
			// find the compliment
			int compliment = z - n;

			// find if compliment exists
			if (complimentMap.containsKey(compliment)) {
				return true;
			}

			complimentMap.putIfAbsent(n, n);
		}

		return false;
	}

	public static void main(String[] args) {
		var schur = new Schur();

		List<Integer> list = new ArrayList<>(List.of(2, 4, 6, 8, 9));
		int sum = 6;

		System.out.println(String.format("Check for sum: %3d on %s: %b", sum, list, schur.checkForSum(list, sum)));
		
		
		sum = 9;
		System.out.println(String.format("Check for sum: %3d on %s: %b", sum, list, schur.checkForSum(list, sum)));
		
		sum = 12;
		System.out.println(String.format("Check for sum: %3d on %s: %b", sum, list, schur.checkForSum(list, sum)));
		
		sum = 5;
		System.out.println(String.format("Check for sum: %3d on %s: %b", sum, list, schur.checkForSum(list, sum)));

	}

}
