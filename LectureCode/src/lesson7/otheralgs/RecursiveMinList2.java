package lesson7.otheralgs;
import java.util.*;
/**
 * Locates min in a List of Integers -- does not modify input list
 *
 */
public class RecursiveMinList2 {
	public Integer findMin(List<Integer> list) {
		if(list == null || list.isEmpty()) return null;
		return recurFindMin(list, 0);
	}
	private Integer recurFindMin(List<Integer> list, int index) {
		Integer first = list.get(index);
		if(index==(list.size() - 1)) return first;
		Integer recFind = recurFindMin(list, index + 1);
		if(first.compareTo(recFind) < 0) return first;
		else return recFind;
	}
	
	public static void main(String[] args) {
		RecursiveMinList2 rml = new RecursiveMinList2();
		List<Integer> list = new LinkedList<>();
		list.add(4); list.add(8); list.add(2); list.add(9);
		System.out.println(rml.findMin(list));
	}
}
