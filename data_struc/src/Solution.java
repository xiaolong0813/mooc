import Stack.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public boolean isValid(String s) throws IllegalAccessException {

//        Stack<Character> stack = new Stack<>();
        ArrayStack<Character> stack = new ArrayStack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty(); // 如果还有元素不为空，则匹配错误
    }

    public int calPoints(String[] ops) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            String c = ops[i];

            Pattern pat = Pattern.compile("\\d");
            Matcher mat = pat.matcher(c);

            if (mat.find()) {
                stack.push(c);
            }
            else if (c.equals("D")){
                stack.push((Integer.toString(Integer.parseInt(stack.peek()) * 2)));
            }
            else if (c.equals("C")){
                stack.pop();
            }
            else if (c.equals("+")) {
                int first = stack.isEmpty()? 0: Integer.parseInt(stack.pop());
                int second = stack.isEmpty()? 0: Integer.parseInt(stack.peek());
                stack.push(Integer.toString(first));
                stack.push(Integer.toString((first + second)));
            }
            System.out.println(stack);
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum = sum + Integer.parseInt(stack.pop());
        }

        return sum;
    }



    public static void main(String[] args) throws IllegalAccessException {
        String[] strings = new String[]{"5","-2","4","C","D","9","+","+"};

        int test = (new Solution()).calPoints(strings);
        System.out.println(test);
    }
}


