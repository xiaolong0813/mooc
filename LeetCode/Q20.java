import Stack.ArrayStack;

public class Q20 {

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
}
