package Map;

// 基于二分搜索树实现的map
// key 必须有可比性
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int childrenSize;
        public int depth;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
            childrenSize = 1;
            depth = 0;
        }

//        public Node(K key) {
//            this(key, null);
//        }
    }

    // 这里的成员变量是root，链表中是dummyHead
    private Node root;
    int size;

    // 构造函数，初始只有root
    public BSTMap() {
        root = null;
        size = 0;
    }



    // 仿照BST中方法的写法, 向bst中添加(key, value)
    @Override
    public void add(K key, V value) {
        root = add(root, key, value, 0);
    }

    // 向以node为根节点的子树中增加元素(key,value)，并返回增加元素后新子树的根节点
    private Node add(Node node, K key, V value, int depth) {
        if (node == null) {
            size++;
            Node newNode = new Node(key, value);
            newNode.depth = depth;
            return newNode;
        }

        if (key.compareTo(node.key) < 0) {
            depth++;
            node.left = add(node.left, key, value, depth);
            // 之前的childrenSize++需要挪到这里，因为如果key和node的key相同的话，
            // 不会增加节点，需要在大于和小于情况时单独讨论
            node.childrenSize++;
        }
        // 这里没有讨论相同的情况，此时就不做处理
        else if (key.compareTo(node.key) > 0){
            depth++;
            node.right = add(node.right, key, value, depth);
            node.childrenSize++;
        }
        else  // key.compareTo(node.key) == 0
            node.value = value;
        return node;
    }

    // ****************************************************//
    // 以下代码从BST中复制修改而来,作为remove函数的基础
    // 搜索bst的最小值，也就是最左边的值。
    public K findMin() {
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty");
        return findMin(root).key;
    }

    public Node findMin(Node node) {
        if (node.left == null)
            return node;
        else
            return findMin(node.left);
    }

    // ****************************************************//

    // 删除以node为根的bst子树中最小节点
    // 返回删除节点后新的bst的根
    public Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size --;
            reduDepth(right);
            return right;
        }
        node.left = removeMin(node.left);
        node.childrenSize--;

        return node;
    }

    // ****************************************************//
    // 遍历将以node为根节点的子树所有元素的depth减去一
    private void reduDepth(Node node) {
        if (node == null)
            return;
        node.depth--;
        reduDepth(node.left);
        reduDepth(node.right);
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null)
            return null;
        return remove(root, key).value;
    }

    public Node remove(Node node, K key) {
        // 如果为空，找不到，返回null
        if (node == null)
            return null;

        if (node.key.equals(key)) {
            // 这里分为左子树为空，右子树为空及左右都不为空的情况分别讨论
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                reduDepth(right);
                return right;
            }

            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                reduDepth(left);
                return left;
            }

            Node rightMin = findMin(node.right);
            rightMin.right = removeMin(node.right);
            rightMin.left = node.left;
            rightMin.childrenSize = --node.childrenSize;
            rightMin.depth = node.depth;
            node.left = node.right = null;

            return rightMin;
        }

        if (key.compareTo(node.key) < 0)
            node.left = remove(node.left, key);
        else
            node.right = remove(node.right, key);

        node.childrenSize--;
        return node;
    }

    // 辅助函数，基于key返回对应Node
    // 在以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (node.key.equals(key)) {
            return node;
        }
        if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exists");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }

        sb.append(generateDepthString(depth) + node.key.toString() + " : " +
                node.value.toString() + "(children: " + node.childrenSize + ", depth: " + node.depth + ")" + '\n');
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    // 表达深度，也就是几个横杠
    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
