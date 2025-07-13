package datastructures.avltree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import datastructures.bstree.BinarySearchTree;
import datastructures.bstree.TreeNode;

public class AVLTree<T> extends BinarySearchTree<T>{
    public AVLTree(Comparator<T> comparator) {
        super(comparator);
    }

    public int height(TreeNode<T> root) {
        if (root == null) return 0;
        if (root.left ==null && root.right==null) return 1;
        else return Math.max(height(root.left), height(root.right)) + 1;
    }
    public boolean isAVLtree(TreeNode<T> root) {
        if (root == null) return true;
        int heigth_left = height(root.left);
        int heigth_right = height(root.right);
        if (heigth_left > heigth_right+1 ||heigth_right > heigth_left+1) return false;
        else return isAVLtree(root.left) && isAVLtree(root.right);
    }

    public TreeNode<T> rotateLeft(TreeNode<T> root) {
        TreeNode<T> y = root.right;
        TreeNode<T> y_left = y.left;
        y.left = root;
        root.right = y_left;
        return y;
    }

    public TreeNode<T> rotateRight(TreeNode<T> root) {
        TreeNode<T> y = root.left;
        TreeNode<T> y_right = y.right;
        y.right = root;
        root.left = y_right;
        return y;
    }

    public TreeNode<T> balance(TreeNode<T> root) {
        if (height(root.left) > height(root.right)+1){
            int heightLL=0;
            int heightLR=0;
            if (root.left != null && root.left.left!=null) heightLL = height(root.left.left);
            if (root.left != null && root.left.right!=null) heightLR = height(root.left.right);

            if (heightLL<heightLR){
                root.left=rotateLeft(root.left);
            }
            root=rotateRight(root);

        }
        else if(height(root.right)>height(root.left)+1){
            int heightRR=0;
            int heightRL=0;
            if (root.right != null && root.right.right!=null) heightRR = height(root.right.right);
            if (root.right != null && root.right.left!=null) heightRL = height(root.right.left);

            if (heightRR<heightRL){
                root.right=rotateRight(root.right);
            }
            root=rotateLeft(root);

        }
        return root;
    }
    public TreeNode<T> insert(TreeNode<T> root, T value) {
        if (root == null) return new TreeNode<>(value);
        int cmp = super.getComparator().compare(value, root.value);
        if (cmp < 0) root.left = insert(root.left, value);
        else root.right = insert(root.right, value);
        root = balance(root);

        return root;
    }


    /**
     * The delete method checks whether a given AVL tree contains a
     * value, if so it will produce a new AVL tree without this value,
     * maintaining all properties of an AVL, in particular balancedness.
     * If value not present, it simply returns the original tree.
     *
     * @param root   the AVL Tree as input
     * @param value  the value to delete, if present. If not present, do nothing.
     * @return       the produced AVL Tree. Identical with input if value not present.
     */
    @Override
    public TreeNode<T> delete(TreeNode<T> root, T value) {

    	if(root == null){
            return root;
        }
        if(!contains(root, value)){
            return root;
        }
        
        int cmp = super.getComparator().compare(value, root.value);

        if(cmp < 0){
            root.left = delete(root.left, value);
        }
        else if(cmp > 0){
            root.right = delete(root.right, value);
        }
        else{
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            TreeNode<T> successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.value = successor.value;
            root.right = delete(root.right, successor.value);

        }
        return balance(root);
    }


    /**
     * Search all values in the AVL Tree and compute the Median value
     * of type Double of all those values. This requires that the values
     * in the AVL Tree extend the Number class.
     * In case of an empty tree, return 0.0.
     *
     *
     * @param <T>  The type of the values in the AVL Tree
     * @param node The root node of the AVL Tree
     * @return     The Median value of all values in the AVL Tree, in Double
     */
    public <T extends Number>Double findMedian(TreeNode<T> node) {
        List<T> values = new ArrayList<>();
        inOrderTraversal(node, values);
        if (values.isEmpty()) {
            return 0.0;
        }
        int size = values.size();
        if (size % 2 == 1) {
            return values.get(size / 2 ).doubleValue();
        }
        else{
            return (values.get(size / 2-1).doubleValue() + values.get(size / 2).doubleValue()) / 2.0;
        }
    }
    private <T extends Number> void inOrderTraversal(TreeNode<T> node, List<T> values){
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, values);
        values.add(node.value);
        inOrderTraversal(node.right, values);
    }

    /**
     * Search all values in the AVL Tree and compute the average value
     * of type Double of all those values. This requires that the values
     * in the AVL Tree extend the Number class.
     * In case of an empty tree, return 0.0.
     *
     * @param <T>  The type of the values in the AVL Tree
     * @param node The root node of the AVL Tree
     * @return     The average value of all values in the AVL Tree, in Double
     */
    public <T extends Number>Double findAVG(TreeNode<T> node) {
        SumCount sc = new SumCount();
        sumAndCount(node, sc);
        return sc.count == 0 ? 0.0 : sc.sum / sc.count;
    }
    private class SumCount {
        double sum = 0.0;
        int count = 0;
    }
    private <T extends Number> void sumAndCount(TreeNode<T> node, SumCount sc){
        if (node == null) {
            return;
        }
        sumAndCount(node.left, sc);
        sc.sum += node.value.doubleValue();
        sc.count++;
        sumAndCount(node.right, sc);
    }


    /**
     * Merges two AVL trees into a single AVL tree.
     * Precondition: All elements in tree1 must be less than all elements in tree2.
     * This method is crucial for the split operation.
     * If both trees are empty, return the empty tree. In case only one is empty,
     * this returns the other non-empty tree.
     *
     *
     * @param tree1 The root of the first AVL tree.
     * @param tree2 The root of the second AVL tree.
     * @return The root of the merged AVL tree.
     */
    public TreeNode<T> merge(TreeNode<T> tree1, TreeNode<T> tree2) {
      if (tree1 == null) {
        return tree2;
      }
      if (tree2 == null) {
        return tree1;
      }

      TreeNode<T> minNode = tree2;
      while (minNode.left != null) {
        minNode = minNode.left;
      }
      tree2 = delete(tree2, minNode.value);
      TreeNode<T> newRoot = new TreeNode<>(minNode.value);
      newRoot.left = tree1;
      newRoot.right = tree2;

      return balance(newRoot);
    }

    /**
     * Splits an AVL tree into two subtrees based on a given value.
     * If the input tree is empty, return a list containing two empty trees.
     * If value is higher than all values in root, then the first tree in the output
     * will be identical to root and the second tree must be empty.
     * Vice-versa, if value is lower than all values, then the first
     * tree in the output must be empty, and the second must be identical to the input.
     *
     * @param root The root of the current AVL tree.
     * @param value The value to split the tree by.
     * @return An array of two TreeNodes: result[0] is the root of the tree with elements less than 'value',
     * and result[1] is the root of the tree with elements greater than 'value'.
     * If 'value' exists in the tree, it is NOT included in either subtree.
     */
    public TreeNode<T>[] split(TreeNode<T> root, T value) {
        if (root == null) {
            return new TreeNode[]{null, null};    
        }
        int cmp = super.getComparator().compare(value, root.value);
        
        if (cmp < 0) {
            TreeNode<T>[] leftSplit = split(root.left, value);
            root.left = leftSplit[1];
            TreeNode<T> balancedRigth = balance(root);
            return new TreeNode[]{leftSplit[0], balancedRigth};
        }
        else if (cmp > 0) {
            TreeNode<T>[] rightSplit = split(root.right, value);
            root.right = rightSplit[0];
            TreeNode<T> balancedLeft = balance(root);
            return new TreeNode[]{balancedLeft, rightSplit[0]}; 
        }
        else{
            return new TreeNode[]{root.left, root.right};
        }
    }



}
