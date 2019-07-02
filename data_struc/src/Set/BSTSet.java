package Set;

import BST.BST;

// 所导入的泛型E必须是可比的，继承自Comparable。并实现接口 Set<E>
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    // 这里用BST实现集合Set，因为集合是没有重复元素，bst满足这一点
    // 私有，用户不可见。用户只关注实现结果
    private BST<E> bst;

    // 构造函数建立新的二叉树
    public BSTSet() {
        bst = new BST<E>();
    }

    // 本身bst就支持集合的操作，直接调用就好
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
