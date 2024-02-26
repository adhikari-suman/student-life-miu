package lesson8.exercise_4;

import java.util.*;

@SuppressWarnings("rawtypes")
public class Main {
	public static void main(String[] args) {
		List list1 = Arrays.asList("A", "B", "C");
		List list2 = Arrays.asList("W", "X", "Y");
		List[] listOfLists = {list1, list2};
		System.out.println(Arrays.toString(listOfLists));
	}
}
    //////Output
    //[[A, B, C], [W, X, Y]]



