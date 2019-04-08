import javax.swing.text.StyledEditorKit;

public class Array {

    // 私有成员变量，禁止从外部直接获取数据
    private int[] data;
    private int size;


    // 构造函数，传入数组含量构造array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // this 指构造函数。无参数构造函数，默认容量为10
    public Array() {
        this(10);
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

    // 向所有元素后添加新元素
    public void addLast(int e) throws IllegalAccessException {
//        if (size == data.length) {
//            throw new IllegalAccessException("Array is full, addLast failed");
//        }
//        data[size] = e;
//        size++;
        add(size, e);
    }

    public void addFirst(int e) throws IllegalAccessException {
        add(0, e);
    }

    // 向数组指定位置index添加新元素
    public void add(int index, int e) throws IllegalAccessException {

        if (size == data.length) {
            throw new IllegalAccessException("Array is full, addLast failed");
        }
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Array is full, require index < size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取index索引位置元素
    int get(int index) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Get failed, index is illegal");
        }
        return data[index];
    }


    // 修改index位置元素为e
    void set(int index, int e) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Get failed, index is illegal");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在位置，如果不存在e，返回-1
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
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
