import java.util.Stack;

public class Problem01Solution {


    static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(var c: s.toCharArray()) {
            if(c == ' ') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                sb.append(c);
            } else {
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(reverseWords("we test coders"));
    }
}
