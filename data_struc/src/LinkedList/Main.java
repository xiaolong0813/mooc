package LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        System.out.println(linkedList);

        for (int i = 0; i < 5; i++) {
            // 链表在首部添加的复杂度是O1级别的。与数组不同，数组在最后面添加是O1级别的
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);

        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);
//
        linkedList.removeFirst();
        System.out.println(linkedList);
//
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
