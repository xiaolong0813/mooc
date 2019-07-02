package PriorityQueue.leetcode;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//示例 1:
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//示例 2:
//输入: nums = [1], k = 1
//输出: [1]
//
//说明：
//你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

// 思路：使用优先队列，优先级的定义为频率。遍历元素放入队列直到size为k，接下来放入的
// 如果某个元素的频率大于队列中的频率最小值，就将最小值出队，将该元素入队，这样这个队列
// 就一直保持k个元素并且频率为最高

import PriorityQueue.PriorityQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Q347 {

    // 创建私有类，存放元素和对应的频率，因为要对频率排序，但也要知道对应的
    // 元素是什么
    private class Freq implements Comparable<Freq> {
        int e;
        int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        // 自定义优先级
        @Override
        public int compareTo(Freq another) {
            // 注意这里的定义优先级需要考虑实际需求，这里是要优先取出频次低的元素
            // 所以频次越低，优先级越高
            if (this.freq < another.freq)
                return 1;
            else if (this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        // 先将元素和频率的对照写入树。因为写入优先队列的元素不能有重复
        // 所以不能同时写。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }
        // 将Freq类型的数据放入优先队列。这里用forEach的方式对所有key进行遍历
        PriorityQueue<Freq> queue = new PriorityQueue<Freq>();
        for (int key : map.keySet()) {
            if (queue.getSize() == k) {
                // 这里不能用compareTo，因为compareTo只在Freq类内部覆写了，而
                // 作为对比的map中的value不是Freq对象的变量，若想用，需要基于value再
                // 建一个Freq对象，比较复杂，这里直接比较即可
                // 如果该频次比queue中最低频次大，就放入
                if (map.get(key) > queue.getFront().freq){
                    queue.dequeue();
                    queue.enqueue(new Freq(key, map.get(key)));
                }
            }
            else
                queue.enqueue(new Freq(key, map.get(key)));
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.dequeue().e);
        }

        return list;
    }

    public static void main(String[] args) {

        Q347 q = new Q347();

        List<Integer> list = q.topKFrequent(new int[]{1, 1, 1, 2, 2, 3},2);

        System.out.println(list.toString());
    }
}
