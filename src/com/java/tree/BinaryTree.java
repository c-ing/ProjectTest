package com.java.tree;

/**
 * Created by cdc on 2018/5/8.
 */
public class BinaryTree {

    public BinaryTree left;
    public BinaryTree right;
    public String data;

    public BinaryTree() {

    }

    public BinaryTree(BinaryTree left, BinaryTree right, String data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryTree(String data) {
        this(null, null, data);
    }

    public static void testCreate() {
        BinaryTree node = new BinaryTree(null, null, "a");
        System.out.println("[node data] " + node.getData());
        System.out.println("[node left date] " + (node.left == null ? "null" : node.left.getData()));
        System.out.println("[node right] " + (node.right == null ? "null" : node.right.getData()));
    }

    public static void insertLeft(BinaryTree node, String value) {
        if (node != null) {
            if (node.left == null) {
                node.setLeft(new BinaryTree(null, null, value));
            }
        } else {
            BinaryTree newNode = new BinaryTree(null,null,value);
            newNode.left = node.left;
            node.left = newNode;
        }
    }

    public static void insertTest(){
        BinaryTree node_a = new BinaryTree("a");
        node_a.insertLeft(node_a,"b");
    }

    public static void main(String[] args) {
        testCreate();
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
