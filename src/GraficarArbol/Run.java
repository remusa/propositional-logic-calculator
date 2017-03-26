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
public class Run {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insertRoot('4');
        tree.insertLeft('4', '5');
        tree.insertRight('4', '6');
        tree.insertLeft('5', '4');
        tree.insertRight('5', '6');
        tree.insertLeft('6', '7');
        tree.insertRight('6', '8');

//        tree.PostOrder(tree.root);

        tree.Breadth(tree.root);

        treeGUI treeGUI = new treeGUI(tree);
    }
    
}
