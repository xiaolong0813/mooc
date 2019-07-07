public class Q203 {
    // leetcode 203题。这里的ListNode不需要提交，为leetcode内置类

    //    删除链表中等于给定值 val 的所有节点
    //    示例:
    //    输入: 1->2->6->3->4->5->6, val = 6
    //    输出: 1->2->3->4->5

//     Definition for singly-linked list.



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
        // 注意这里不能返回dummyHead,也不能返回head，因为如果只有一个元素且删除，dummyHead.next指向的是null
        // 而这时head不为空
        return dummayHead.next;
    }

    public static void main(String[] args) {
        // 测试203
        // 这里需要先建立一个链表用于实验，可以添加ListNode方法arrayToLink，使数组转换为链表
        int[] array = {1,2,6,4,5,6,66,76};

        ListNode head = new ListNode(array);
        System.out.println(head);

        // 只能调用实例
        Q203 q203 = new Q203();
        ListNode res = q203.removeElements1(head, 6);
        System.out.println(res);
    }
}
