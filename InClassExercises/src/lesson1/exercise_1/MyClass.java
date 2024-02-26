package lesson1.exercise_1;

import java.util.Arrays;

/*
 * Use SampleClass to guide you as you try to write a program that
 * prints the following lines to the console:
 
        The product of the values in {2, 5, -3, 11, 1} is -330
        A printout of the array of integers is [2, 5, -3, 11, 1]
        Concatenating the strings in arr2 gives us: ALMOST DONE
   
   Obtain the first line by creating a method 
           static int product(int[] arr)
   which multiplies together every element of arr.
   Your printed statement should include the value returned by the method product(int[] arr)
   
   Obtain the second line by using the technique in SampleClass to
   print an array of values
   
   Obtain the third line by defining an array of strings and passing
   it to a method of the form
           static String concatenate(String[] arr2)
   which concatenates all the elements of arr and returns the resulting
   String. Then print this returned value.
 */
public class MyClass {

	public static void main(String[] args) {
		/* Task 1 - Calculate the product and print */
		// create an array of integers
		int[] numbers = new int[]{2, 5, -3, 11, 1};
		
		// calculate the product
		int product = product(numbers);
		
		// now print the result
		System.out.println("The product of the values in {2, 5, -3, 11, 1} is " + product);
		/* Task 1 Complete */
		
		/* Task 2 - Print the array */
		System.out.println("A printout of the array of integers is "+Arrays.toString(numbers));
		/* Task 2 Complete */
		
		/* Task 3 - Combine tasks */
		String[] strings = new String[]{"ALMOST"," ","DONE"};
		String combined = concatenate(strings);
		System.out.println("Concatenating the strings in arr2 gives us: "+ combined);
		/* Task 3 Complete */

	}
	
	public static int product(int[] arr) {
		int product = 1;
		for(int i = 0; i < arr.length; ++i) {
			product *= arr[i];
		}
		return product;
	}
	
	public static String concatenate(String[] arr2) {
		String concat = "";
		for(int i = 0; i < arr2.length; ++i) {
			concat += arr2[i];
		}
		return concat;
	}

}
