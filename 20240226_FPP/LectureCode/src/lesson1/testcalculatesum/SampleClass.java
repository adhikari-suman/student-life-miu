//All Java programs take place within a "class"
//and every class is located inside a "package" which
//is like a folder in Windows
package lesson1.testcalculatesum;

import java.util.Arrays;

//All Java programs begin inside a "class" like this one
//and all classes belong to a package
//Try running the code by right clicking on SampleClass1 in the left panel and selecting "Run As.." > "Java application"
public class SampleClass {
	//Most java programs are launched by a call to "main", just as is done here.
	//"public" means that this call to main can be done from outside the program -- it is "publicly available"
	//"static" is a more advanced concept that will be explained later -- for now, we label all our methods with the 
	//   static keyword
	public static void main(String[] args) {
		//create an array of integers
		//int[] declares the "type" of variable -- an array of ints
		//arr is the variable -- we think of arr as "storing" the array of elements
		//"=" is a way of assigning the collection {2,5,-3, 11, 1} to the variable arr
		//{..} indicates a collection; this syntax is a way of specifying an array containing 2, 5, -3, 11, 1
		//each statement in a Java program ends with a semicolon  ( ; ).
		int[] arr = {2, 5, -3, 11, 1};
		
		//calculate the sum of the elements in arr by passing the array to another "method" that does the work
		//The "int sum" at the left indicates that the result of calculating the sum will be stored in the integer sum.
		//The method "calculateSum" is being given a task to do; how it performs this tasks is shown 
		//farther down in the file
		int sum = calculateSum(arr);
		
		//This is how you print values to the console (shown in the bottom panel below)
		System.out.println("The sum of the values in {2, 5, -3, 11, 1} is " + sum);
		
		//A "String" is a sequence of characters -- you can think of a string as a kind of "word"
		String str1 = "Bob";
		String str2 = " ";  //just a blank space
		String str3 = "Tom";
		
		//We can put Strings together by "concatenating" using the '+' symbol
		//The result in this case is the new string "Bob Tom"
		String str = str1 + str2 + str3;
		
		//We print the result of this concatenation
		System.out.println("Concatenating the strings 'Bob', ' ', and 'Tom' gives us: " + str);
		
		//We can accomplish the same output by putting these strings into an array
		//and then reading off the elements from the array
		//Initialize an array of Strings
		String[] strArr = {"Bob", "Tom"};
		
		//Now concatenate by reading elements of the array and joining with a '+'
		String strng = strArr[0] + " " + strArr[1];
		
		//We print the result of this concatenation
		System.out.println("Concatenating the strings 'Bob', ' ', and 'Tom' in a slightly different way still gives us: " + strng);
		
		//Here is how to print an array of strings:
		//First turn the array into a string like this:
		String combined = Arrays.toString(strArr);
		//Then print this string
		System.out.println("A printout of an array of strings: " + combined);
		
		//You can multiply two numbers using '*' as the multiplication symbol
		int prod = 3 * 15;
		System.out.println("The product of 3 and 15 is " + prod);
		
	}
	//calculateSum is a "method" -- also known as a function call. It accepts some input to 
	//work on (an array of integers, denoted here as "int[] arr") and its declaration indicates 
	//that at the end of its processing it will return a value of type int (an integer)
	//calculateSum adds up the elements in the array arr and returns the sum.
	public static int calculateSum(int[] arr) {
		//the value sum starts out at 0; we will add each number in arr one at a time to sum
		//and when we are done, we will return the number stored in sum
		int sum = 0;
		
		//arr.length tells me the number of elements in the array arr; in this example, len is 5
		int len = arr.length;
		
		
		//The elements of the array arr have "indices", one for each element
		//In this example, the relationship to values and corresponding index is shown here:
		//  2 | 5 | -3 | 11 | 1
		//  --------------------
		//  0 | 1 | 2  |  3 | 4
		//Therefore, the value at index 1 is 5 and the value at index 3 is 11
		//Elements of arr at accessed by using the index of each element. To
		//access the element at index 3, we write arr[3].
		//To repeat a step of processing over and over -- which we need to do here since
		//we need to repeatedly do the addition operation -- we can use a "for loop"
		//In this for loop, the first part of "for" initializes a variable i so that it stores
		//the integer 0; it then says that it will continue to do steps between the braces { ... }
		//as long as this integer i remains less than len (the length of the array)
		//After each step of processing inside { .. }, the "++i" indicates that the value in i will
		//be increased by 1.
		for(int i = 0; i < len; ++i) {
			//When i is 0, sum starts out as 0, and then arr[0] is added to it, so sum becomes 2
			//When i is 1, sum is currently 2, and then arr[1] is added to it so sum becomes 2 +5 = 7
			//This continues until finally i is 4 (remember that len = 5), the number arr[4], which is 1, is added
			// to sum
			sum = sum + arr[i];
		}
		//After all the additions have been performed, the final total is now in sum and so sum is returned.
		return sum;		
	}
	
	
}
