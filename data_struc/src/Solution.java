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

//    class RecentCounter {
//
//        public RecentCounter() {
//
//        }
//
//        public int ping(int t) {
//
//        }
//    }


    // leetcode 203题。这里的ListNode不需要提交，为leetcode内置类

    //    删除链表中等于给定值 val 的所有节点
    //    示例:
    //    输入: 1->2->6->3->4->5->6, val = 6
    //    输出: 1->2->3->4->5

//     Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }

         // 加入转换数组为链表方法，便于测试提供链表
         public ListNode arrayToLink(int[] array) {
             if (array == null || array.length == 0) {
                 throw new IllegalArgumentException("array cannot be empty");
             }

             ListNode head = new ListNode(array[0]);
             ListNode node = head;
             for (int i = 1; i < array.length; i++) {
                 node.next = new ListNode(array[i]);
                 node = node.next;
             }

             return head;
         }

         public String toString(ListNode head) {
             StringBuilder sb = new StringBuilder();

             ListNode node = head;
             while (node.next != null) {
                 sb.append(node.val + "->");
                 node = node.next;
             }
             sb.append("NULL");

             return sb.toString();
         }
     }


    // 这个是不考虑虚拟头节点的情况
    public ListNode removeElements1(ListNode head, int val) {

        // 找到某个元素需要找到其前一个元素的next,让其指向空，所以对于头节点，需要单独考虑

        // 不加虚拟头节点。需要讨论head。这里删掉头节点后，剩下的头节点依然可能需要删除，所以需要
        // 循环一直到头节点不是需要删除的为止
        while (head != null && head.val == val ) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
            // 其实在LeetCode中，这个函数执行完后，所有运行空间都会销毁，所以只需要下面一句。不用手动释放
            head = head.next;


        }
        // 如果都是val，上面的操作已经都删完了
        if (head == null) {
            return null;
        }

        // 上面讨论了head需要删除的情况，这里是head不需要删除，而需要考虑后面的
        // 由于需要删除所有的val的节点，需要循环讨论每一个
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                // 同样不用手动释放
                prev.next = prev.next.next;
            }
            // 上面的prev.next已经改变，所以不能直接跳过，需要依然看prev.next是否需要删除
            // 只有prev.next不需删，才运行下面的往下一个
            else {
                prev = prev.next;
            }
        }

        // 注意链表需要返回头指针，以便访问其他数据
        return head;
    }

    // 这个是添加虚拟头节点的情况
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummayHead = new ListNode(0);
        dummayHead.next = head;

        ListNode prev = dummayHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }
            else {
                prev = prev.next;
            }
        }
        // 注意这里不能返回dummyHead
        return head;
    }



    public static void main(String[] args) throws IllegalAccessException {
//        String[] strings = new String[]{"5","-2","4","C","D","9","+","+"};
//
//        int test = (new Solution()).calPoints(strings);
//        System.out.println(test);

        // 测试203
        // 这里需要先建立一个链表用于实验，可以添加ListNode方法arrayToLink，使数组转换为链表
        int[] array = {1,2,3,4,5,56,66,76};

        // 只能调用实例
        Solution solution = new Solution();
        ListNode head = new ListNode(0).arrayToLink(array);

        System.out.println(head.toString());





    }
}


