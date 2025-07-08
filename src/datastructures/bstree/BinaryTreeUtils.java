package datastructures.bstree;


import java.util.*;
import datastructures.bstree.*;


public class BinaryTreeUtils<T> {


    public int height(TreeNode<T> node) {
        if (node == null) return -1;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode<T> node) {
        if (node == null) return true;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        return isBalanced(node.left) && isBalanced(node.right);
    }

    public List<T> toSortedList(TreeNode<T> node) {
        List<T> result = new ArrayList<>();
        SortedHelper(node, result);
        return result;


    }

    public void SortedHelper(TreeNode<T> node, List<T> result) {
        if (node == null) return;
        SortedHelper(node.right, result);
        result.add(node.value);
        SortedHelper(node.left, result);
    }




}
