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
public class Node {

    char data;
    Node left, right;

    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void displayNode(Node n) {
        System.out.println(n.data + " ");
    }
    
}
