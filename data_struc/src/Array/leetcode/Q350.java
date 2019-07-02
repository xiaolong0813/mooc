package Array.leetcode;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class Q350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> array = new ArrayList<>();
        for (int num : nums1) {
            array.add(num);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int num : nums2) {
            if (array.contains(num)){
                int index = array.indexOf(num);
                res.add(num);
                array.remove(index);
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i< res.size(); i++)
            ret[i] = res.get(i);

        return ret;
    }

    public static void main(String[] args) {

//        Q350 q = new Q350();
//        for (int ele : q.intersect(new int[]{1, 2, 2, 1}, new int[]{1,2}))
//            System.out.println(ele);



        ArrayList<Integer> arr = new ArrayList<>();

        boolean success = Collections.addAll(arr, 3,4,3,6,7);
        arr.remove((Integer)3);  // 4,3,6,7
        arr.remove((Integer)3);  // 4,6,7
        for (int i = 0; i < arr.size(); i++)
            System.out.println(arr.get(i));
    }
}
