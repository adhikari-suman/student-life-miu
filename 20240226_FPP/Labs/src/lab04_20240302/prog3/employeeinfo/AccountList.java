package lab04_20240302.prog3.employeeinfo;

import java.util.Arrays;

public class AccountList {
	private final int INITIAL_LENGTH = 2;
	private Account[] accounts;
	private int size;

	public AccountList() {
		accounts = new Account[INITIAL_LENGTH];
		size = 0;
	}

	public void add(Account s) {
		if (size == accounts.length)
			resize();

		accounts[size++] = s;
	}

	public Account get(int i) {

		if (i < 0 || i >= size)
			return null;

		return accounts[i];
	}

	public boolean find(Account s) {

		for (Account a : accounts) {
			if (a.equals(s))
				return true;
		}

		return false;
	}

	// consider pos starts from 0
	public void insert(Account a, int pos) {
		// validate pos value
		if (pos < 0 || pos > size) {
			return;
		}

		// resize if needed
		if (size == accounts.length) {
			resize();
		}

		Account[] temp = accounts;

		accounts = new Account[accounts.length];

		// copy from 0 to pos-1 index
		System.arraycopy(temp, 0, accounts, 0, pos);

		// copy from pos index to remaining items starting from the pos+1 index
		System.arraycopy(temp, pos, accounts, pos + 1, size - pos);

		// Now add the item to be inserted
		accounts[pos] = a;
		size++;
	}

	public boolean remove(Account s) {
		// check if string exists or not
		boolean accExists = this.find(s);

		// string not exists, return false
		if (!accExists || accounts.length == 0)
			return false;

		// string exists, find the index and remove it
		int index = -1;

		for (int i = 0; i < size; i++) {
			if (accounts[i].equals(s)) {
				index = i;
			}
		}

		// will not happen since item exists,
		// but for safety
		if (index == -1) {
			return false;
		}

		// copy the new array
		Account[] temp = accounts;
		accounts = new Account[accounts.length];

		/**
		 * tmp: [1, 2, 3, 4, 5] strArray: [0,0,0,0] index to remove is 2 i.e. 3
		 * 
		 * arraycopy(temp, 0, strArray, 0, index) => copy from 0 to index 2 i.e. 2 items
		 * 
		 * arraycopy(temp, index + 1, strArray, index, size - (index + 1))
		 * 
		 * copy from index 3 to 5 i.e. 5 - (2+1) = 2
		 */
		System.arraycopy(temp, 0, accounts, 0, index);
		System.arraycopy(temp, index + 1, accounts, index, size - (index + 1));

		size--;

		// operation success
		return true;
	}

	private void resize() {
//		System.out.println("Resizing...");
		Account[] temp = accounts;

		// Make double the size
		accounts = new Account[temp.length * 2];

		// Copy from the old array
		System.arraycopy(temp, 0, accounts, 0, temp.length);
	}

	public String toString() {
		// Create a new array of only existing parents
		String[] arr = new String[size];

		System.arraycopy(accounts, 0, arr, 0, size);

		// return String implementation
		return Arrays.toString(arr);
	}

	public String getFormattedAccountInfo() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			Account a = accounts[i];
			sb.append(String.format("Account type: %s\n", a.getAcctType().toString().toLowerCase()));
			sb.append(String.format("Current bal: %.1f\n", a.getBalance()));
		}

		return sb.toString();
	}

	public int size() {
		return size;
	}

}
