package BST;

// Binary Search Tree 二分搜索树

import Stack.LinkedListStack;
import com.sun.xml.internal.ws.wsdl.writer.document.Import;
import jdk.nashorn.internal.ir.IfNode;

import java.util.*;

// 类型必须有可比性.继承comparable
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;
        public int childrenSize;
        public int depth;

        // 这里只有一个构造函数
        public Node(E e) {
            this.e =e;
            left = null;
            right = null;
            childrenSize = 1;
            depth = 0;
        }
    }

    // 成员变量 根节点，和大小
    private Node root;
    private int size;

    // 构造函数。初始化时是空的
    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

// ****************************************************//
    // 下面是较简化的递归实现添加新元素的方法
    public void add(E e) {
        root = add(root, e, 0);
    }

    // 向以node为根的子树中插入元素e，递归
    // 返回插入新节点后，新的子树的根。这就是递归的一层。添加和查找都是以一个子树(根节点+左+右)为单位进行递归
    // 将depth作为递归的条件之一，每次递归，对于新的节点的depth就会增加一层，最后将depth赋予新增节点的depth
    private Node add(Node node, E e, int depth) {
        // 复杂的递归终止条件是如果遇到某节点左右为null的情况下，即将新节点放在此处，并停止
        // 但其实可以直接将终止条件设为，和根节点进行对比，不管节点左右是不是null，接着根据大小往下递归一层
        // 直到遇到相比较的根节点为null的时候，就放在此处，即null也当成一个节点
        // 此时条件就可以简化为，node为null，如果遇到一个null，则建立新节点并终止返回
        // 这里返回的每一层都是当前递归层的根节点。和复杂递归不同，那个只需要往里填充，不需要返回
        if (node == null) {
            size++;
            // 这里是return给了上层递归，即最后建立新节点，层层往上返回
            // 此时相当于这个new的节点也是根节点，只是没有子节点
            Node newNode = new Node(e);
            newNode.depth = depth;
            return newNode;
        }

        // 如果这个根节点node不是null的话，就需要和这个根节点相比了，如果小于这个根节点node，说明元素e在他的
        // 左子树，左子树会发生变化，就把插入新元素e后以node.left为根节点的子树的根节点(递归后就不是当前的node.left了)返回，
        // 并赋予当前的node.left。
        // 就是让node.left接住添加新元素e后的子树
        if (e.compareTo(node.e) < 0) {
            depth++;
            node.left = add(node.left, e, depth);
        }
        // 这里没有讨论相同的情况，此时就不做处理
        else if (e.compareTo(node.e) > 0){
            depth++;
            node.right = add(node.right, e, depth);
        }

        // 不管是添加到左还是右，添加完的node，也就是当前的根都会多一个子元素
        node.childrenSize++;
        // 这里需要返回每次递归当前的根节点(每次递归这个node的值是变化的，即为当前递归层的根节点)
        // 不管往左还是往右插入，插入完了后node还是当前的根节点，需要将其返回
        return node;
    }

// ****************************************************//
    // 下面是较为复杂的递归实现添加新元素方法
    public void add_complex(E e) {

        // 如果root是空，直接导入这个节点即可.别忘了size
        if (root == null) {
            root = new Node(e);
            size++;
        }
        else {
        // 这里用递归实现，使用考虑node为根的二分树中插入E
            add_complex(root, e);
        }
    }


        // 非递归实现 （待验证）
//        Node newEle = new Node(e);//
//        Node prev = root;
//        for (int i = 0; i < size; i++) {
//            if (e.compareTo(prev.e) < 0) {
//                if (prev.left == null) {
//                    prev.left = newEle;
//                    break;
//                }
//                prev = prev.left;
//            }
//            else {
//                if (prev.right == null) {
//                    prev.right = newEle;
//                    break;
//                }
//                prev = prev.right;
//            }
//        }



    // 向以node为根的二分搜索树中插入元素E，递归。
    // 这个方法只在内部用，为私有
     private void add_complex (Node node, E e) {
        // 如果这个元素等于node的e，说明已经存在该节点，直接返回。注意这里用的是equals
        if (e.equals(node.e))
             return;

        // 这里e是泛型，继承了Comparable这个类型，需要用compareTo这个方法进行比较
        // 如果小于节点的e，为左孩子。如果左边为null，那直接放在那，如果否，则需要继续
        // 在以左孩子为根节点的树中插入
        else if (e.compareTo(node.e) < 0) {
            if (node.left == null) {
                node.left = new Node(e);
                size++;
                return;
            }
            else
                add_complex (node.left, e);
        }
        // 对于右边也一样，这里没有相等的情况，因为在一开始就考虑了
        else {
            if (node.right == null) {
                node.right = new Node(e);
                size++;
                return;
            }
            else
                add_complex (node.right, e);
        }
     }

// ****************************************************//

    // 查询，看树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);

    }

    // 看以node为根的树中是否包含元素e，递归
    private boolean contains(Node node, E e) {

        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

// ****************************************************//

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }
    // 对以node为根节点的子树进行前序遍历 递归
    private void preOrder(Node node) {
        if (node == null)
            return;

        // 前序遍历先处理根节点，添加遍历的处理业务逻辑
        System.out.println(node.e);
        // 再遍历左右两个节点
        preOrder(node.left);
        preOrder(node.right);
    }

// ****************************************************//

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

// ****************************************************//

    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


// ****************************************************//
    // 前序遍历的非递归写法，用栈来实现，将要处理的元素压入栈，因为是前序遍历，先处理栈顶元素，
    // 再依次压入右，左孩子，再以此处理栈顶元素，也就是以左右孩子为根结点的子树
    public void preOrder_non_recursion() {
        LinkedListStack<Node> listStack = new LinkedListStack<Node>();

        listStack.push(root);
        while (!listStack.isEmpty()) {
            Node node = listStack.pop();

            // 业务逻辑
            System.out.println(node.e);

            if (node.right != null)
                listStack.push(node.right);
            if (node.left !=null)
                listStack.push(node.left);
        }
    }

// ****************************************************//
    // 层序遍历，即广度优先遍历，区别于前中后序的深度优先遍历。借用队列的形式实现，即先入队的先处理，
    // 层数往下的后入队，就后处理
    public void levelOrder() {

        // java.util中的队列类Queue是个接口，需要选择具体实现的底层数据结构，这里用链表实现，链表类中
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            // 将head元素出队，注意有其他比如peek方法，只能查看head，无法出队，不能使用
            Node cur = queue.remove();

            // 业务逻辑
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

// ****************************************************//

    // 搜索bst的最小值，也就是最左边的值
    public E findMin() {
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty");
        return findMin(root).e;
    }

    public Node findMin(Node node) {
        if (node.left == null)
            return node;
        else
            return findMin(node.left);
    }

// ****************************************************//

    // 搜索bst的最大值，也就是最右边的值
    public E findMax() {
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty");
        return findMax(root).e;
    }

    public Node findMax(Node node) {
        if (node.right == null)
            return node;
        else
            return findMax(node.right);
    }

// ****************************************************//
    // 删除bst最小值
    public E removeMin() {
        E ret = findMin();
        // 以root为根的树中删除最小值，然后把新的根节点赋予root
        root = removeMin(root);
        return ret;
    }

    // 删除以node为根的bst子树中最小节点
    // 返回删除节点后新的bst的根
    public Node removeMin(Node node) {
        // 判断结束的标准就是左边为空，也就是到了最小节点处，
        // 删除此节点，并把右子树设为当前子树最小节点返回。
        // 这里可以不用单独考虑右边为空的情况，因为如果右边为
        // 空，那么删除该节点后，子树也为空
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size --;
            reduDepth(right);
            return right;
        }
        // 删除掉以node.left为根的子树的最小节点后，新的子树根节点
        // 需要再赋予当前的node.left。进行下一次递归，这里逻辑和add方法中相同。
        // 最后需要返回当前新子树的根节点node
        node.left = removeMin(node.left);
        node.childrenSize--;

        return node;
    }

// ****************************************************//
    // 删除bst最大值
    public E removeMax() {
        E ret = findMax();
        // 以root为根的树中删除最小值，然后把新的根节点赋予root
        root = removeMax(root);
        return ret;
    }

    public Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size --;
            reduDepth(left);
            return left;
        }

        node.right = removeMax(node.right);
        node.childrenSize--;

        return node;
    }

// ****************************************************//
    // 删除bst的任意元素,为e的节点
    public void remove(E e) {
        // 将以root为根节点的树删除e, 并将删除后新子树的根节点赋予root
        root = remove(root, e);
    }

    // 删除以node为根节点的元素为e的节点，并返回删除后的新的树的根节点
    private Node remove(Node node, E e) {
        // 如果为空，找不到，返回null
        if (node == null)
            return null;

        if (node.e.equals(e)) {
            // 这里分为左子树为空，右子树为空及左右都不为空的情况分别讨论
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                // 删除的时候要注意，这里移动的是整个子树，
                // 需要将以此节点为根的所有子树遍历修改depth
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

            // 左右子树都不为空，这里选择右子树最小值为后继节点
            // 找到比待删除节点大的最小节点，并用这个节点代替原节点
            Node rightMin = findMin(node.right);
            // 删除以node.right为根的子树中最小元素，并返回这个子树的根
            // 注意这里removeMin中已经进行了size--，但我们并未弃用该元素
            // 所以相当于白减，而原始元素被替换，所以相当于进行了size--，
            // 所以不用再管理size
            rightMin.right = removeMin(node.right);
            rightMin.left = node.left;
            rightMin.childrenSize = -- node.childrenSize;
            rightMin.depth = node.depth;
            node.left = node.right = null;

            return rightMin;
        }

        if (e.compareTo(node.e) < 0)
            node.left = remove(node.left, e);
        else
            node.right = remove(node.right, e);

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


// ****************************************************//
    // 寻找某个元素的floor，即小于元素的最大值
    //
    public E floor(E e) {
        // 使用栈结构保存遍历数据
        Stack<Node> stack = new Stack<>();
        floor(root, e, stack);
        return stack.pop().e;
    }

    // 中序遍历，每次判断node元素大小，若node小于所查询的值，就将其压入栈
    // 由于是中序遍历，压入栈的元素会自动按从小到大排列。最后栈顶就是所查询元素的floor值
    private void floor(Node node, E e, Stack<Node> temp) {
        if (node == null)
            return;

        floor(node.left, e, temp);

        if (node.e.compareTo(e) <= 0)
            temp.push(node);

        floor(node.right, e, temp);
    }

    // 下面错误，无法用变量temp记录变化，temp是局部变量
//    public E floor_temp(E e) {
//        E temp = null;
//        E res = floor_temp(root, e, temp);
//        return res;
//    }
//
//    private E floor_temp(Node node, E e, E temp) {
//        if (node == null)
//            return null;
//        if (e.compareTo(node.e) < 0)
//            return temp;
//
//        E tt = temp;
//
//        floor_temp(node.left, e, tt);
//        if (node.e.compareTo(e) <= 0)
//            tt = node.e;
////            floor_temp(node.left, e, temp);
//        floor_temp(node.right, e, tt);
//
//        return temp;
//    }

// ****************************************************//
    // 寻找某个元素的ceil，即大于元素的最小值
    public E ceil(E e) {
        // 使用栈结构保存遍历数据
        Stack<Node> stack = new Stack<>();
        ceil(root, e, stack);
        return stack.pop().e;
    }
    private void ceil(Node node, E e, Stack<Node> temp) {
        if (node == null)
            return;

        // 由于和floor相反，这里可以中序遍历从大到小排列压入栈，即先处理node.right
        // 当然也可以从小到大用队列将大于所查询值的元素入队，这样队首就是ceil
        ceil(node.right, e, temp);

        if (node.e.compareTo(e) >= 0)
            temp.push(node);

        ceil(node.left, e, temp);
    }



// ****************************************************//
    // 删除bst的最大值（自定义方法，不简洁）
    public E removeMax_test() {
        Node node = findNextMax();
        Node right = node.right;
        node.right = right.left;
//        right = null;

        return right.e;
    }

    public Node findNextMax() {
        return findNextMax(root);
    }

    public Node findNextMax(Node node) {
        if (node.right.right == null)
            return node;
        else
            return findNextMax(node.right);
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

        sb.append(generateDepthString(depth) + node.e.toString() + "   (children: " + node.childrenSize + ", depth: " + node.depth + ")" + '\n');
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
