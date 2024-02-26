package lesson2.commandlineparams;

public class Example {

	public static void main(String[] args) {
		int len = args.length;  //args is never null
		for (int i = 0; i < len; ++i) {
			System.out.println("position " + i + ": " + args[i]);
		}
	}

}
