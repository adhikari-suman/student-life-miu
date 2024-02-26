package lesson8.node.small;


public class Node {
	String data;
	Node node;
	
	/* Shows how to print a list with just one, two, or three nodes */
	@Override
	public String toString() {
		if(data == null) return "";
		String retval = data + " ";
		if(node != null) {
			if(node.data == null) return retval;
			else {
				retval = retval + node.data + " ";
				if(node.node != null) {
					if(node.node.data == null) return retval;
					else {
						return retval + node.node.data;
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
//		sb = toString(sb, node);
//		return sb.toString();
//	}
//	private StringBuilder toString(StringBuilder sb, Node n) {
//		if(n == null) return sb;
//		sb.append(n.data + " ");
//		return toString(sb, n.node);
//	}
}
