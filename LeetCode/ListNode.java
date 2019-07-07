
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }

    // 链表节点的构造函数，使用array为参数，创建一个链表，便于测试提供链表
    // 当前的ListNode为链表头节点
    public ListNode (int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array cannot be empty");
        }

        // 这里是当前这个ListNode的值，也就是第一个值array[0]
        // 当遍历结束后，this就是创建出来的链表的head，由此可以找到整个链表
        this.val = array[0];
        ListNode cur = this;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
    }

    // 这里就是以当前节点，也就是this为头节点的链表
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode node = this;
        while (node.next != null) {
            sb.append(node.val + "->");
            node = node.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
