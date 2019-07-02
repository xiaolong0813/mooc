package Map.leetcode;

import java.util.ArrayList;
import java.util.TreeMap;

public class Q350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        // 基于平衡搜索树实现的Map
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums1) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                // 添加和更新，都是用put
                map.put(num, map.get(num) + 1);
        }
        // 存储结果
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                // 如果该元素频率为0，就删除他
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);

        return res;
    }
}
