package lesson9_arraystack;

public class ArrayStack {
	/* Assumption: the stack will never become full */
	private static final int LEN = 500;
	private int top = -1;
	private int nextOpen = 0;
	private Integer[] arr = new Integer[LEN];
	
	public void push(Integer x) {
		if(x == null) return;
		arr[nextOpen] = x;
		top++;
		nextOpen++;
	}
	public Integer peek() {
		//returns null if stack is empty
		return (top == -1) ? null : arr[top];
	}
	public Integer pop() {
		Integer ret = peek();
		if(ret != null) {
			arr[top] = null;
			top--;
			nextOpen--;
		}
		return ret;
	}
	
	@Override
	public String toString() {
		if(top == -1) return "<empty>";
		StringBuilder sb = new StringBuilder();
		for(Integer x : arr) {
			if(x != null)
				sb.append(x.toString()).append(" ");
		}
		return sb.toString();	
	}
	public static void main(String[] args) {
		ArrayStack st = new ArrayStack();
		st.push(1);
		st.push(2);
		System.out.println(st);
		st.pop();
		System.out.println(st);
		st.pop();
		System.out.println(st);
	}
}
