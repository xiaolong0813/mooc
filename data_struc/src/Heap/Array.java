package Heap;

public class Array<E> {

    // 私有成员变量，禁止从外部直接获取数据
    private E[] data;
    private int size;


    // 构造函数，传入数组含量构造array
    // 泛型无法直接new创建(历史问题),需要先建立Object. java中，任意类都是Object的子类
    // 然后再强制类型转换为E
    // 注意这里的Object是哪个jar包里的，应该用java.lang里面的
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // this 指构造函数。无参数构造函数，默认容量为10
    public Array() {
        this(10);
    }

    // 传入一个数组，定义为一个Array
    public Array(E[] list) {
        data = (E[]) new Object[list.length];
        for (int i = 0; i < list.length; i++) {
            data[i] = list[i];
        }
        size = list.length;
    }

    // 获取元素数量
    public int getSize() {
        return size;
    }

    // 获取容量
    public int getCapacity() {
        return data.length;
    }

    // 数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组指定位置index添加新元素
    public void add(int index, E e) throws IllegalArgumentException {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Array is full, require index < size");
        }

        // 如果元素个数超过了capacity，进行扩容。
        if (size == data.length) {
//            throw new IllegalArgumentException("Array is full, addLast failed");
            // 这里的大小为原来两倍，对于性能比较合适。java的ArrayList为1.5
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    // 向所有元素后添加新元素
    public void addLast(E e) throws IllegalArgumentException {
//        if (size == data.length) {
//            throw new IllegalArgumentException("Array is full, addLast failed");
//        }
//        data[size] = e;
//        size++;
        add(size, e);
    }

    public void addFirst(E e) throws IllegalArgumentException {
        add(0, e);
    }

    // 获取index索引位置元素
    public E get(int index) throws IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        return data[index];
    }

    public E getLast() throws IllegalArgumentException {
        return get(size - 1);
    }

    public E getFirst() throws IllegalArgumentException {
        return get(0);
    }


    // 修改index位置元素为e
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        data[index] = e;
    }

    // 交换i和j位置的元素
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index illegal");

        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
//            if (data[i] == e) {
//                return true;
//            }
            // 这里两个类对象进行值的比较，用的是equals。
            // 而 == 是指引用比较
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在位置，如果不存在e，返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
//            if (data[i] == e) {
//                return i;
//            }
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 删除元素，并返回被删除的元素
    public E remove(int index) throws IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // 这里不手动将最后一个元素指向空的话，
                            // 这个元素会一直存在。称之为loitering object。手动指向空的话
                            // 会使其被java垃圾回收机制回收

        // 如果元素个数小到一定程度（整个容量的1/2），减容
        // 用懒算法，为1/4的时候才减容，并且需要保证不能为零
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() throws IllegalArgumentException {
        return remove(0);
    }

    public E removeLast() throws IllegalArgumentException {
        return remove(size  - 1);
    }

    public boolean removeElement(E e) throws IllegalArgumentException {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    // 覆盖父类的 obj.toString 方法. 调用System.our.println的时候，会调用此方法代替
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }

}
