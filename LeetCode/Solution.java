
import Stack.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public class TestClass {
        public int testNum = 0;
    }

    public TestClass retClass() {
        TestClass ret = new TestClass();
        return ret;
    }

    public static void main(String[] args) throws IllegalAccessException {
        // 只能调用实例
        Solution solution = new Solution();
        TestClass t = solution.retClass();
        System.out.println(t.testNum);
    }
}


