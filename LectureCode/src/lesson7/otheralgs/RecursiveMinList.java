package lesson7.otheralgs;
import java.util.*;
/**
 * Locates min in a List of Integers -- modifies input list
 *
 */
public class RecursiveMinList {
	public Integer findMin(List<Integer> list) {
		if(list == null || list.isEmpty()) return null;
		return recurFindMin(list);
	}
	private Integer recurFindMin(List<Integer> list) {
		Integer first = list.remove(0);
		if(list.isEmpty()) return first;
		Integer recFind = recurFindMin(list);
		return recFind.compareTo(first) < 0 ? recFind : first;
	}
	
	public static void main(String[] args) {
		RecursiveMinList rml = new RecursiveMinList();
		List<Integer> list = new LinkedList<>();
		list.add(4); list.add(8); list.add(2); list.add(9);
		System.out.println(rml.findMin(list));
	}
}
