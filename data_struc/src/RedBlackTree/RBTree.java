package RedBlackTree;

//public class RBTree<K extends Comparable<K>, V> {
//
//    // 将颜色定义为final类型的变量。
//    private static final boolean RED = true;
//    private static final boolean BLACK = false;
//
//    private class Node {
//        public K key;
//        public V value;
//        public Node left, right;
//        // 定义颜色的变量，可以直接利用前面定义的final类型变量
//        public boolean color;
//
//        public Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//            left = right = null;
//            // 初始化定位为红颜色，因为初始添加的时候，先和某个节点进行融合
//            // 也就是红色，再进行其他处理
//            color = RED;
//        }
//    }
//
//    // 这里的成员变量是root，链表中是dummyHead
//    private Node root;
//    private int size;
//
//    // 构造函数，初始只有root
//    public RBTree() {
//        root = null;
//        size = 0;
//    }
//
//    // 判断一个节点到底是红还是黑，主要是处理空节点，空节点没有融合的处理，所以当作是黑节点
//    private boolean isRed(Node node) {
//        if (node == null)
//            return BLACK;
//        return node.color;
//    }
//
//    // 仿照BST中方法的写法, 向bst中添加(key, value)
//    public void add(K key, V value) {
//        root = add(root, key, value, 0);
//    }
//
//    // 向以node为根节点的子树中增加元素(key,value)，并返回增加元素后新子树的根节点
//    private Node add(Node node, K key, V value, int depth) {
//        if (node == null) {
//            size++;
//            Node newNode = new Node(key, value);
//            return newNode;
//        }
//
//        if (key.compareTo(node.key) < 0) {
//            depth++;
//            node.left = add(node.left, key, value, depth);
//        }
//        else if (key.compareTo(node.key) > 0){
//            depth++;
//            node.right = add(node.right, key, value, depth);
//        }
//        else  // key.compareTo(node.key) == 0
//            node.value = value;
//        return node;
//    }
//
//    // ****************************************************//
//    // 以下代码从BST中复制修改而来,作为remove函数的基础
//    // 搜索bst的最小值，也就是最左边的值。
//    public K findMin() {
//        if (size == 0)
//            throw new IllegalArgumentException("BST is Empty");
//        return findMin(root).key;
//    }
//
//    public Node findMin(Node node) {
//        if (node.left == null)
//            return node;
//        else
//            return findMin(node.left);
//    }
//
//    // ****************************************************//
//
//    // 删除以node为根的bst子树中最小节点
//    // 返回删除节点后新的bst的根
//    public Node removeMin(Node node) {
//        if (node.left == null) {
//            Node right = node.right;
//            node.right = null;
//            size --;
//            reduDepth(right);
//            return right;
//        }
//        node.left = removeMin(node.left);
//
//        return node;
//    }
//
//    // ****************************************************//
//    // 遍历将以node为根节点的子树所有元素的depth减去一
//    private void reduDepth(Node node) {
//        if (node == null)
//            return;
//        reduDepth(node.left);
//        reduDepth(node.right);
//    }
//
//    public V remove(K key) {
//        Node node = getNode(root, key);
//        if (node == null)
//            return null;
//        return remove(root, key).value;
//    }
//
//    public Node remove(Node node, K key) {
//        // 如果为空，找不到，返回null
//        if (node == null)
//            return null;
//
//        if (node.key.equals(key)) {
//            // 这里分为左子树为空，右子树为空及左右都不为空的情况分别讨论
//            if (node.left == null) {
//                Node right = node.right;
//                node.right = null;
//                size--;
//                reduDepth(right);
//                return right;
//            }
//
//            if (node.right == null) {
//                Node left = node.left;
//                node.left = null;
//                size--;
//                reduDepth(left);
//                return left;
//            }
//
//            Node rightMin = findMin(node.right);
//            rightMin.right = removeMin(node.right);
//            rightMin.left = node.left;
//            node.left = node.right = null;
//
//            return rightMin;
//        }
//
//        if (key.compareTo(node.key) < 0)
//            node.left = remove(node.left, key);
//        else
//            node.right = remove(node.right, key);
//
//        return node;
//    }
//
//    // 辅助函数，基于key返回对应Node
//    // 在以node为根节点的二分搜索树中，key所在的节点
//    private Node getNode(Node node, K key) {
//        if (node == null)
//            return null;
//        if (node.key.equals(key)) {
//            return node;
//        }
//        if (key.compareTo(node.key) < 0)
//            return getNode(node.left, key);
//        else
//            return getNode(node.right, key);
//    }
//
//    public boolean contains(K key) {
//        return getNode(root, key) != null;
//    }
//
//    public V get(K key) {
//        Node node = getNode(root, key);
//        return node == null ? null : node.value;
//    }
//
//    public void set(K key, V newValue) {
//        Node node = getNode(root, key);
//        if (node == null)
//            throw new IllegalArgumentException(key + " doesn't exists");
//        node.value = newValue;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//}
