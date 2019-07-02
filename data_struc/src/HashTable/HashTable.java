package HashTable;

// 底层是红黑树
import com.sun.org.apache.bcel.internal.generic.FNEG;

import java.util.TreeMap;

// 这里不需要K有可比性，因为要转换为hashcode存储，只需要有hashCode()方法
// Object就有这个方法。
public class HashTable<K, V> {

    // 扩容对应的M值(替代每次*2，那样不能保证一直是素数）
    private final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    // 扩容上下界，即N/M(每个地址平均元素数),大于这个值就扩容，小于就缩容
    private final static int upperTol = 10;
    private final static int lowerTol = 2;
    // 初始容量
//    private final static int initCapacity = 7;
    // 直接用表中的数据，这里是表中的索引
    private int capacityIndex = 0;

    // 其实就是TreeMap的数组，作为私有变量
    private TreeMap<K, V>[] hashtable;
    // 数组长度，也就是hashcode取模的值。是一个素数
    private int M;

    private int size;

    // 这里就不让用户设置初始值了，直接用initCapacityIndex
    public HashTable() {
        this.M = capacity[capacityIndex];
        size = 0;
        // 初始化一个数组
        hashtable = new TreeMap[M];
        // 对每个元素，进行初始化，也就是建立TreeMap
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

//    // 没有参数得话，提供默认值
//    public HashTable() {
//        this(initCapacity);
//    }

    // hash函数,将key转换为索引
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        // 先将该map取出赋予变量，防止计算多次hash(key)
        TreeMap<K, V> map = hashtable[hash(key)];
        // 检查数组是否以及存在
        if (map.containsKey(key))
            map.put(key, value);
        else {
            map.put(key, value);
            size++;
            // 避免浮点和整型转换，替换size/M>=upperTol写成这样
            // 使用capacity数组进行扩容，需要保证capacityIndex不要越界
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                // 每次扩容的量就是数组中的后一位
                capacityIndex ++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;

        if (map.containsKey(key)){
            ret = map.remove(key);
            size--;
            // 缩容的时候需要满足容量不要小于初始值
            if (size < lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }

    // 缩容，扩容
    private void resize(int newM) {
        // 用新的容量值建立新数组
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            // 每个数组位置存放一个TreeMap
            newHashTable[i] = new TreeMap<>();
        }
        // 将原来数组的每个TreeMap以此遍历，放入新的数组，注意这里的遍历次数是原来的也就是oldM，
        // 而计算新的数组的hashcode的时候用到的M应为新的newM，
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet()) {
                // 注意这里的hash()方法中取模用的是this.M，这里应该为newM，
                // 所以把newM要提前赋予当前M
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashtable = newHashTable;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }
}
