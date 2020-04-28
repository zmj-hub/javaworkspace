package leetcode.offer;

import leetcode.TreeNode;

import java.util.HashMap;

public class question07 {


    /*
    *输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 

限制：

0 <= 节点个数 <= 5000
    *
    *
    * */

    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = new TreeNode(preorder[0]);
        HashMap hashMap = new HashMap();
        for (int i = 0; i < preorder.length; i++) {
            hashMap.put(preorder[i], i);
        }
        treeNode.left = build();
        return null;
    }

    public static TreeNode build() {

        return null;
    }
}
