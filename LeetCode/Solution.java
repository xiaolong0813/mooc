
import Stack.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void printArr(int[] arr) {
//        for (int i = 0; i< arr.length; i++){
//            System.out.println(arr[i]);
//            System.out.println(" ");
//        }
        StringBuilder str = new StringBuilder();
        Arrays.stream(arr).forEach(x -> str.append(x).append(" "));
        System.out.println(str.toString());
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

    public static void printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.append("NULL");
        System.out.println(sb.toString());
    }

    public static ListNode arrayToLinkedList(int[] nums) {
        final ListNode[] cur = {new ListNode(0)};
        ListNode head = cur[0];
        Arrays.stream(nums).forEach(x -> {
            cur[0].next = new ListNode(x);
            cur[0] = cur[0].next;
        });

        return head.next;
    }


    public static void main(String[] args) {

        int[] nums = {-1,5,3,4,0};
//        Q75_quickSort.sortColors(nums);
//        printArr(nums);

        ListNode head = arrayToLinkedList(nums);

        Solution.printLinkedList(head);

        ListNode sorted = Q147_LinkedListSort.insertionSortList(head);

        Solution.printLinkedList(sorted);

    }
}


