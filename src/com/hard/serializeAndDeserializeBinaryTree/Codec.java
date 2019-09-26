package com.hard.serializeAndDeserializeBinaryTree;

import com.structure.TreeNode.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Codec {

    private static final String spliter = ",";
    private static final String NULL = "null";

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTestData("[1,2,3,null,null,4,5]");
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        TreeNode.print(codec.deserialize(codec.serialize(root)));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NULL)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
