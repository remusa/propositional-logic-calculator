/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GraficarArbol;

/**
 * 
 * @author rms
 */
public class BinaryTree {
    
    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insertLeft(char parent, char leftvalue) {
        Node n = find(root, parent);
        Node leftchild = new Node(leftvalue, null, null);
        n.left = leftchild;
    }

    public void insertRight(char parent, char rightvalue) {
        Node n = find(root, parent);
        Node rightchild = new Node(rightvalue, null, null);
        n.right = rightchild;
    }

    public void insertRoot(char data) {
        root = new Node(data, null, null);
    }

    public Node getRoot() {
        return root;
    }

    public Node find(Node n, char key) {
        Node result = null;
        if (n == null)
            return null;
        if (n.data == key)
            return n;
        if (n.left != null)
            result = find(n.left, key);
        if (result == null)
            result = find(n.right, key);
        return result;
    }

    public int getHeight(Node root) {
        if (root == null)
            return 0;
        return (Math.max(getHeight(root.left), getHeight(root.right)) + 1);
    }

    public void printTree(Node n) {
        if (n == null)
            return;
        printTree(n.left);
        n.displayNode(n);
        printTree(n.right);
    }

    public void PreOrder(Node n ){
        if (n == null)
            return;
        n.displayNode(n);
        PreOrder(n.left);
        PreOrder(n.right);
    }

    public void InOrder(Node n ){
        if (n == null)
            return;
        InOrder(n.left);
        n.displayNode(n);
        InOrder(n.right);
    }

    public void PostOrder(Node n ){
        if (n == null)
            return;
        PostOrder(n.left);
        PostOrder(n.right);
        n.displayNode(n);
    }

    public void Breadth(Node n ){
        if (n == null)
            return;
        n.displayNode(n);
        PreOrder(n.left);
        PreOrder(n.right);
    }

}
