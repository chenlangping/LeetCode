package com.medium.populatingNextRightPointersInEachNode;

import com.util.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
public class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        recursive(root.left, root.right);
        recursive(root.right, null);
        return root;
    }

    private void recursive(Node root, Node rightNext) {
        if (root == null) {
            return;
        }
        root.next = rightNext;
        recursive(root.left, root.right);
        recursive(root.right, rightNext == null ? null : rightNext.left);
    }
}

