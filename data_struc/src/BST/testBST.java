package BST;

public class testBST<E extends Comparable<E>> {

    // 私有变量Node
    private class Node {
        public E e;
        public Node left, right;
        public int childrenSize;
        // public int depth;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            this.childrenSize = 1;
            // this.depth = 0;
        }
    }

    private Node root;
    private int size;

    // 构造函数
    public testBST() {
        root = null;
        size = 0;
    }

    private void add(Node node, E e) {
        if (e.equals(node.e))
            return;

        if (e.compareTo(node.e) < 0) {
            if (node.left == null) {
                node.left = new Node(e);
                return;
            }
            else
                add(node.left, e);
        }
        else {
            if (node.right == null) {
                node.right = new Node(e);
                return;
            }
            else
                add(node.right, e);
        }        
    }

    // private Node add(Node node, E e) {
    //     if (node == null) {
    //         size++;
    //         Node newRoot = new Node(e);
    //         return newRoot;
    //     }

    //     if (e.compareTo(node.e) < 0) {
            
    //     }
    // }


}