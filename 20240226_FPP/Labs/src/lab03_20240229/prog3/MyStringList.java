package lab03_20240229.prog3;

import java.util.Arrays;

public class MyStringList {
	private final int INITIAL_LENGTH = 2;
	private String[] strArray;
	private int size;

	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}

	public void add(String s) {
		if (size == strArray.length)
			resize();

		strArray[size++] = s;
	}

	public String get(int i) {

		if (i < 0 || i >= size)
			return null;

		return strArray[i];
	}

	public boolean find(String s) {

		for (String str : strArray) {
			if (str.equals(s))
				return true;
		}

		return false;
	}

	// consider pos starts from 0 
	public void insert(String s, int pos) {
		// validate pos value
		if(pos < 0 || pos > size ) {
			return;
		}
		
		// resize if needed
		if(size == strArray.length) {
			resize();
		}
		
		String[] temp = strArray;
		
		strArray = new String[strArray.length];
		
		// copy from 0 to pos-1 index
		 System.arraycopy(temp, 0, strArray, 0, pos);
		
		 // copy from pos index to remaining items starting from the pos+1 index
		 System.arraycopy(temp, pos, strArray, pos+1, size-pos);
		 
		 // Now add the item to be inserted
		 strArray[pos] = s;
		 size++;
	}

	public boolean remove(String s) {
		// check if string exists or not
		boolean strExists = this.find(s);

		// string not exists, return false
		if (!strExists || strArray.length == 0)
			return false;

		// string exists, find the index and remove it
		int index = -1;

		for (int i = 0; i < size; i++) {
			if (strArray[i].equals(s)) {
				index = i;
			}
		}

		// will not happen since item exists,
		// but for safety
		if (index == -1) {
			return false;
		}

		// copy the new array
		String[] temp = strArray;
		strArray = new String[strArray.length ];

		/**
		 * tmp: [1, 2, 3, 4, 5] strArray: [0,0,0,0] index to remove is 2 i.e. 3
		 * 
		 * arraycopy(temp, 0, strArray, 0, index) => copy from 0 to index 2 i.e. 2 items
		 * 
		 * arraycopy(temp, index + 1, strArray, index, size - (index + 1))
		 * 
		 * copy from index 3 to 5 i.e. 5 - (2+1) = 2
		 */
		System.arraycopy(temp, 0, strArray, 0, index);
		System.arraycopy(temp, index + 1, strArray, index, size - (index + 1));

		size--;

		// operation success
		return true;
	}

	private void resize() {
		System.out.println("Resizing...");
		String[] temp = strArray;

		// Make double the size
		strArray = new String[temp.length * 2];

		// Copy from the old array
		System.arraycopy(temp, 0, strArray, 0, temp.length);
	}

	public String toString() {
		// Create a new array of only existing parents
		String[] arr = new String[size];

		System.arraycopy(strArray, 0, arr, 0, size);

		// return String implementation
		return Arrays.toString(arr);
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		MyStringList l = new MyStringList();
		l.add("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Steve");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Susan");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Dave");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
		
		
		l.insert("Ariel", 1);
		System.out.println("The list of size " + l.size() + " is " + l);
	}

}
