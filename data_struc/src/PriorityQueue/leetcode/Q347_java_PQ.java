package PriorityQueue.leetcode;

import java.util.*;

// Q347中需要自定义的PriorityQueue，MaxHeap，Array等一系列依赖类，下面用java自带的
// PriorityQueue实现，会简化很多
public class Q347_java_PQ {

// 1. java的PriorityQueue是最小堆，所以需要改变判断标准
    // （由于使用了匿名类中的变量捕获直接比较方法中的变量，这个Freq类不再需要）
    // private class Freq implements Comparable<Freq>{
    private class Freq{
        int e;
        int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        // 由于下面定义了比较器，这里不再需要。Freq类也不用再继承Comparable接口
//        // 自定义优先级
//        @Override
//        public int compareTo(Freq another) {
//            if (this.freq < another.freq)
//                return -1;
//            else if (this.freq > another.freq)
//                return 1;
//            else
//                return 0;
//        }
    }

// 2. 如果想改变java标准库中的比较方式，就不能用自定义的类比如Freq这种类型了，
// 比如按照字符串的长度为优先级。Java中的解决方案是可以往PriorityQueue中传入一个比较器，
// 该比较器可以自定义。如下列比较器。实现了该比较器，就可以不再用Freq中的CompareTo，
// Freq类也不用在继承Comparable
    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq a, Freq b) {
            // 这里简写为相减的值
            return a.freq - b.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }
// 3. 这里可以传入刚才所建立的比较器FreqComparator，这样可以定制比较器，对任意类进行比较，
// 而不用再需要类继承Comparable并实现compareTo。类可以是普通类，比如字符串的长度比较
//        PriorityQueue<Freq> queue = new PriorityQueue<>(new FreqComparator());

// 4. 上面针对Freq这个类创建了比较器，但如果仅在此类中使用，可以直接使用匿名类，而不用再创建
// FreqComparator。匿名类用于仅使用一次的情况
//        PriorityQueue<Freq> queue = new PriorityQueue<>(new Comparator<Freq>() {
//            @Override
//            public int compare(Freq a, Freq b) {
//                return a.freq - b.freq;
//            }
//        });

// 5. 再进一步，利用变量捕获，上面的匿名类其实可以获取到该方法中的所有不可变变量。则在PriorityQueue中
// 可以只保存Integer，而不再用Freq这个类。直接比较map中保存的频率
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a) - map.get(b);
//            }
//        });

// 6. 再进一步，匿名类可以写成lambda表达式
//        PriorityQueue<Integer> queue = new PriorityQueue<>(
////                (a, b) -> map.get(a) - map.get(b)
//        );
// 7. 再进一步，使用Comparator的静态方法comparing。以及::进行方法引用，也是lambda表达式的
//    一种，即对于队列中的元素，也就是这里的key，引用map的get方法，作为lambda表达式导入comparing，
//    也就是对map.get(key)进行比较
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                Comparator.comparing(map::get)
        );
        for (int key : map.keySet()) {
            if (queue.size() == k) {
                // Freq类不再需要，直接比较map中的value
//                if (map.get(key) > queue.peek().freq){
//                    queue.remove();
//                    queue.add(new Freq(key, map.get(key)));
//                }
                // 不再要求保留包含key和freq的Freq类，直接保存key，
                // 就可以通过比较器进行freq的比较。堆中的元素也只剩下了key
                if (map.get(key) > map.get(queue.peek())){
                    queue.remove();
                    queue.add(key);
                }
            }
            else
                // 同上，这里不再需要Freq类
//                queue.add(new Freq(key, map.get(key)));
                queue.add(key);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            // 不再有Freq类，直接取出就是key
//            list.add(queue.remove().e);
            list.add(queue.remove());
        }
        return list;
    }


    public static void main(String[] args) {

        Q347 q = new Q347();

        List<Integer> list = q.topKFrequent(new int[]{1, 1, 1, 2, 2, 3},2);

        list.forEach(System.out::println);
    }
}
