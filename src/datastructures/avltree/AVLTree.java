package datastructures.avltree;

import java.util.Comparator;
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
    public TreeNode<T> delete(TreeNode<T> root, T value) {

    	// TODO

        return root; // dummy return, replace in your solution!
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

//    	TODO

    	return 0.0;  // dummy return, replace in your solution!
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

//    	TODO

    	return 0.0;  	  // dummy return, replace in your solution!
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


//    TODO

    	return  tree1; // dummy return, replace in your solution!
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

//    	TODO


    	return null; // dummy return, replace in your solution!
    }




}
