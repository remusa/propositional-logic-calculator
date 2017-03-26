/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ordenamiento;

/**
 * 
 * @author rms
 */
public class ETNode {
    
    char value;
    ETNode left;
    ETNode right;

    public ETNode(char item) {
        value = item;
        left = right = null;
    }
    
    public void displayNode(ETNode n) {
        System.out.print(n.value);
    }
    
}