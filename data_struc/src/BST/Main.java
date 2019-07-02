package BST;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();

//        int[] nums = {5,3,2,4,6,8};
        int[] nums = {41,22,58,15,50,33,53,42,37,13,55,63};

        for (int num: nums) {
            bst.add(num);
        }

        System.out.println(bst);

//        bst.remove(41);
//        System.out.println(bst);

//        System.out.println(bst.floor_temp(45));


//        System.out.println(bst.floor(45));
//        System.out.println(bst.ceil(40));


//        bst.remove(4);
//
//        System.out.println(bst);

//        bst.preOrder();

//        System.out.println("\n");//
//        bst.inOrder();
//
//        System.out.println("\n");//
//        bst.postOrder();

//        System.out.println("\n");//
//        bst.preOrder_non_recursion();

//        System.out.println("\n");
//        bst.levelOrder();
//
//        System.out.println("\n");
//        System.out.println(bst.findMin());
//
//        System.out.println("\n");
//        System.out.println(bst.removeMax());



//        System.out.println("\n");
//        System.out.println(bst);

//        Random random = new Random();
//
//        for (int i = 0; i < 1000; i++){
//            bst.add(random.nextInt(10000));
//        }
//
//        ArrayList<Integer> array = new ArrayList<>();
//
//        // 这里不能为for 1000次，因为有可能有重复元素，这样有可能次数小于1000
//        while (!bst.isEmpty())
//            array.add(bst.removeMin());
//
////        for (int i = 0; i < 1000; i++){
////            array.add(bst.removeMin());
////        }
//
//        System.out.println(array);

    }
}
