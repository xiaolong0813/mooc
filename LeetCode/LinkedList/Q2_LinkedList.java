package LinkedList;//给出两个 非空 的链表用来表示两个非负的整数。其中，
// 它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//示例：
//
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807


public class Q2_LinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode cur = newNode;
        int extra = 0, add = 0;
        int l1Value, l2Value;
        while (l1 != null || l2 != null) {
            l1Value = l1 == null ? 0 : l1.val;
            l2Value = l2 == null ? 0 : l2.val;

            add = l1Value + l2Value + extra;
            cur.next = new ListNode(add % 10);

            if (l1 == null) {
                l2 = l2.next;
            }
            else if (l2 == null) {
                l1 = l1.next;
            }
            else {
                l1 = l1.next;
                l2 = l2.next;
            }

            extra = add >= 10 ? 1 : 0;
            cur = cur.next;
        }
        cur.next = add >= 10 ? new ListNode(1) : null;

        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(7);

        Q2_LinkedList q = new Q2_LinkedList();
        ListNode node = q.addTwoNumbers(node1, node2);
//        System.out.println(node.val);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
}
