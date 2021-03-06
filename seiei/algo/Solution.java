package algo;

import algo.utils.tree.definition.TreeNode;

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        if (A == null) return false;
        return preorder(A, B);
    }

    private boolean preorder(TreeNode A, TreeNode B) {
        if (A == null) return false;
        if (A.val == B.val && compare(A, B)) return true;
        if (preorder(A.left, B)) return true;
        return preorder(A.right, B);
    }

    private boolean compare(TreeNode A, TreeNode B) {
        if (A == null) return false;
        if (A.val != B.val) return false;
        boolean left = true, right = true;
        if (B.left != null) left = compare(A.left, B.left);
        if (B.right != null) right = compare(A.right, B.right);
        return left && right;
    }
}