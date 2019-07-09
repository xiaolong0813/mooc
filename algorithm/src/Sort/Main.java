package Sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        Integer[] nums = {4,7,2,9,8,1,10,0};
//        BubbleSort.sort(nums);
//        Arrays.stream(nums).forEach(System.out::println);

        //        String[] strings = {"D", "P", "A", "H"};
//        SelectionSort.sort(strings);
//        Arrays.stream(strings).forEach(System.out::println);
//
//        Student stu1 = new Student("ming", 50);
//        Student stu2 = new Student("xu", 100);
//        Student stu3 = new Student("long", 80);
//        Student stu4 = new Student("biu", 80);
//
//        Student[] students = {stu1, stu2, stu3, stu4, new Student("xiao", 70)};
//        SelectionSort.sort(students);
//
//        Arrays.stream(students).forEach(student -> System.out.println(student));

        int n = 10000;
        SortTestHelper helper = new SortTestHelper();
        Integer[] test_random1 = helper.generateRandomArray(n, 0, n);
        Integer[] test_random2 = test_random1.clone();
        Integer[] test_random3 = test_random1.clone();
        Integer[] test_random4 = test_random1.clone();
        Integer[] test_random5 = test_random1.clone();
        LinkedListMergeSort testList_random = helper.generateRandomLinkedList(n, 0, n);
        Integer[] test_random6 = test_random1.clone();
        Integer[] test_random7 = test_random1.clone();


        Integer[] test_nearlyRandom1 = helper.generateNearlyOrderedArray(n, 100);
        Integer[] test_nearlyRandom2 = test_nearlyRandom1.clone();
        Integer[] test_nearlyRandom3 = test_nearlyRandom1.clone();
        Integer[] test_nearlyRandom4 = test_nearlyRandom1.clone();
        Integer[] test_nearlyRandom5 = test_nearlyRandom1.clone();
        LinkedListMergeSort testList_nearly = helper.generateNearlyOrderedLinkedList(n, 100);
        Integer[] test_nearlyRandom6 = test_nearlyRandom1.clone();
        Integer[] test_nearlyRandom7 = test_nearlyRandom1.clone();





//         测试名称需要包含package名
//         冒泡排序需要不断交换，销毁大量资源，所以速度最慢
//         测试两个方法的性能，这里不能使用同一个数组，因为是数组本地排序，需要拷贝一份

        // n == 10000 的测试结果

        System.out.println("random list");
//        helper.testSort("Sort.SelectionSort", "sort", test_random1);   // 0.165s
//        helper.testSort("Sort.InsertionSort", "sort", test_random2);   // 0.336s 改进后-> 0.223s
//        helper.testSort("Sort.BubbleSort", "sort", test_random3);   // 0.601 改进后-> 0.554s
        helper.testSort("Sort.MergeSort", "sort", test_random4);   // 0.007s  O(nlogn)级别
        helper.testSort("Sort.MergeSort", "sortBU", test_random5);   // 0.007s
        helper.testSort("Sort.QuickSort", "sort", test_random6);   // 0.01s 改进后(随机基准) -> 0.023s 再次改进(双路) -> 0.015s
//        helper.testSort(testList_random);   // 0.617s
        helper.testSort("Sort.QuickSort3Ways", "sort", test_random7); // 0.02 但对于范围较小的随机数组，即重复元素很多
                                                                                                 // 的情况下，这种方法速度最快，因为迭代的过程中不对重复元素进行排序


        System.out.println();

        // 这里改进后插入排序仍然慢于选择排序，但应该是和java8的底层优化机制有关

        // 对于近乎sorted的数组，test3和4，插入排序速度非常快
        System.out.println("nearly random list");
//        helper.testSort("Sort.SelectionSort", "sort", test_nearlyRandom1);   // 0.163s
//        helper.testSort("Sort.InsertionSort", "sort", test_nearlyRandom2);   // 0.014s
//        helper.testSort("Sort.BubbleSort", "sort", test_nearlyRandom3);   // 0.28s 改进后-> 0.27s
        helper.testSort("Sort.MergeSort", "sort", test_nearlyRandom4);   // 0.024 对于近乎有序，反而更慢 优化后->0.006s
        helper.testSort("Sort.MergeSort", "sortBU", test_nearlyRandom5); // 0.007s
        helper.testSort("Sort.QuickSort", "sort", test_nearlyRandom6); // 0.028s 改进后(随机基准) -> 0.004s
//        helper.testSort(testList_nearly);  // 0.259s
        helper.testSort("Sort.QuickSort3Ways", "sort", test_nearlyRandom7); // 0.01


    }
}
