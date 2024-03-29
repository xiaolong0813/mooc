package Sort;//对链表进行插入排序。
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

//插入排序算法：
//
//插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
//每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
//重复直到所有输入数据插入完为止。
// 
//
//示例 1：
//输入: 4->2->1->3
//输出: 1->2->3->4
//
//示例 2：
//输入: -1->5->3->4->0
//输出: -1->0->3->4->5


public class Q147_LinkedListSort {


    public static Solution.ListNode insertionSortList(Solution.ListNode head) {
        if (head == null)
            return null;

        Solution.ListNode dummyHead = new Solution.ListNode(0);
        Solution.ListNode find;
        dummyHead.next = head;
        Solution.ListNode prev = dummyHead.next;
        Solution.ListNode cur;
        while (prev.next != null) {

            if (prev.val < prev.next.val) {
                prev = prev.next;
            }
            else {
                cur = prev.next;
                prev.next = cur.next;
                int val = cur.val;
                find = dummyHead;
                while (val > find.next.val) {
                    find = find.next;
                }
//                prev.next = cur.next;
                cur.next = find.next;
                find.next = cur;
            }
        }

        return dummyHead.next;
    }

}
