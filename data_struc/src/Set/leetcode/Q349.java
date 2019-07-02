package Set.leetcode;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Q349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        // 基于搜索树的集合
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        // 遍历nums2,如果有在set中包含的元素，就放入其中，并删除set中此元素
        // 这样下次再有一样的元素就识别不到了
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)){
                arrayList.add(num);
                set.remove(num);
            }
        }
        // 将结果放入int[]
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++)
            res[i] = arrayList.get(i);

        return res;
        }
    }

