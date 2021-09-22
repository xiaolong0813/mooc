package LinkedList;//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//示例：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4


public class Q21_linkedList {

//     Definition for singly-linked list.
    public static class ListNode {
         int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode newNode = new ListNode(0);
            ListNode cur = newNode;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    cur.next = l2;
                    l2 = l2.next;
                }
                else if (l2 == null) {
                    cur.next = l1;
                    l1 = l1.next;
                }
                else if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                }
                else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            return newNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(8);
        node1.next.next = new ListNode(10);

        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(10);
        node2.next.next = new ListNode(15);

        Q21_linkedList q = new Q21_linkedList();
        ListNode node = q.mergeTwoLists(node1, node2);
//        System.out.println(node.val);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
