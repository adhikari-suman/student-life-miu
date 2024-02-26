package lesson8.exercise_2;


public class Node {
	String data;
	Node next;
	
	/* Shows how to print a list with just one, two, or three nodes */
	@Override
	public String toString() {
		if(data == null) return "";
		String retval = data + " ";
		if(next != null) {
			if(next.data == null) return retval;
			else {
				retval = retval + next.data + " ";
				if(next.next != null) {
					if(next.next.data == null) return retval;
					else {
						return retval + next.next.data;
					}
				}
				
			}
		}
		return retval;
	}
	
//	@Override
//	public String toString() {
//	    if(data == null) return "";
//		StringBuilder sb = new StringBuilder(data + " ");
//		sb = toString(sb, next);
//		return sb.toString();
//	}
//	private StringBuilder toString(StringBuilder sb, Node n) {
//		if(n == null) return sb;
//		sb.append(n.data + " ");
//		return toString(sb, n.next);
//	}
}
