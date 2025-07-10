package datastructures.bstree;

import java.util.*;

public class BinarySearchTree<T> {

    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public TreeNode<T> insert(TreeNode<T> root, T value) {
        if (root == null) return new TreeNode<>(value);
        int cmp = comparator.compare(value, root.value);
        if (cmp < 0) root.left = insert(root.left, value);
        else root.right = insert(root.right, value);
        return root;
    }

    public void preOrder(TreeNode<T> node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(TreeNode<T> node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(TreeNode<T> node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public int size(TreeNode<T> node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public int countLeaves(TreeNode<T> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public boolean contains(TreeNode<T> node, T value) {
        if (node == null) return false;
        int cmp = comparator.compare(value, node.value);
        if (cmp == 0) return true;
        if (cmp < 0) return contains(node.left, value);
        else return contains(node.right, value);
    }


    /**
     * The method delete searches root for the given value, and if present
     * deletes it from the tree, returning a binary search tree with all
     * the same values as the input tree, except for the input value.
     * If the tree is empty or the value is not present in the tree,
     * this method simply returns the input tree.
     *
     *
     * @param root	The three on which the delete is performed.
     * @param value The value to delete from root.
     * @return      The output tree after deletion.
     */
    public TreeNode<T> delete(TreeNode<T> root, T value) {

        // check if tree is empty or doesn't contain the value
        if (!contains(root, value) || countLeaves(root) == 0) {
            return root;
        }

        int cmp = comparator.compare(value, root.value);

        if (cmp > 0) { // searched value is right
            root.right = delete(root.right, value);
        } else if (cmp < 0) { // searched value is left
            root.left = delete(root.left, value);
        } else { // value found
            // if no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // if 1 child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // if 2 children
            // get smallest value in right subtree
            TreeNode<T> successorNode = root.right;
            while (successorNode.left != null) {
                successorNode = successorNode.left; // always on the left (In-Order)
            }
            root.value = successorNode.value; // replace value

            // delete leftovers
            root.right = delete(root.right, successorNode.value);
        }
        return root;
    }

    /**
     * searchRange gets a tree root and two values, min and max,
     * as input. It will produce a list of all values in root
     * which are in between (w.r.t. the comparator of the binary
     * search tree) of min and max. Both ends are inclusive, so
     * values that are equal to min or equal to max are to be
     * included.
     * In case of an empty tree, the empty list should be returned.
     *
     * @param node The input tree that will be searched.
     * @param min  The lower end of the range of values to be returned (inclusive).
     * @param max  The upper end of the range of values to be returned (inclusive).
     * @return A list of values in node which are in between the values of min and max
     * or equal to min or equal to max.
     */
    public List<T> searchRange(TreeNode<T> node, T min, T max) {
        List<T> result = new ArrayList<>();
        searchRange(node, min, max, result);
        return result;
    }

    private void searchRange(TreeNode<T> n, T min, T max, List<T> result) {
        if (n == null) {
            return;
        }

        if (comparator.compare(n.value, min) > 0) {
            searchRange(n.left, min, max, result);
        }

        if (comparator.compare(n.value, min) >= 0 && comparator.compare(n.value, max) <= 0) {
            result.add(n.value);
        }

        if (comparator.compare(n.value, max) < 0) {
            searchRange(n.right, min, max, result);
        }
    }


    /**
     * Max_Min will return either the minimal value among the
     * values of root, if the second argument isMin is set to true.
     * If the second argument is set to false, it will return the
     * maximal value instead.
     * In case of an empty tree, it should simply return null.
     *
     * @param root	The tree to be searched.
     * @param isMin Indicates the type of search: true means searching
     * for the smallest value in root, false means searching for the
     * highest value in root.
     * @return A value in root, either the smallest or highest value,
     * based on the value of isMin or null in case root is empty.
     */
    public T Max_Min(TreeNode<T> root, boolean isMin) {
        if (root == null) {
            return null;
        }
        
        if (isMin == true) {
            while (root.left != null) {
                root = root.left;
            }

            return root.value;
        } else {
            while (root.right != null) {
                root = root.right;
            }

            return root.value;
        }
    }

    /**
     * CombineBST takes as input two binary search trees, root1 and root2
     * and produces a new binary search tree that contains all values
     * in root1 or root2. In case both trees are empty, this must return
     * the empty tree. If only one is empty, it must return the other,
     * non-empty tree.
     *
     * @param root1  The first of the two trees to be combined.
     * @param root2  The second of the two trees to be combined.
     * @return A new tree, with all values of root1 and root2 or the empty
     * tree in case both root1 and root2 are empty.
     */
    public TreeNode<T> combineBSTs(TreeNode<T> root1, TreeNode<T> root2) {

        //TODO

        return root1;
    }







}
