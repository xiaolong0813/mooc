package Tree;

import java.util.List;

//给定一个二叉树，返回它的中序 遍历。
//示例:
//输入: [1,null,2,3]
//1
//\
//2
///
//3
//
//输出: [1,3,2]
//进阶: 递归算法很简单，你可以通过迭代算法完成吗

public class Q94_traverse {


//     Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     // 迭代完成
//    public List<Integer> inorderTraversal(TreeNode root) {
//
//    }

    public void inOrder(TreeNode node) {
         if (node == null)
             return;
         inOrder(node.left);
         System.out.println(node.val);
         inOrder(node.right);
    }

    public static void main(String[] args) {

    }

}
