/*
 * http://www.geeksforgeeks.org/expression-tree/
 */
package Ordenamiento;

import GraficarArbol.BinaryTree;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author rms
 */
public class ExpressionTree {
    
    public static ArrayList<Character> prefijo = new ArrayList<>();
    public BinaryTree tree = new BinaryTree();

    // A utility function to check if 'c'
    // is an operator
    private boolean esOperador(char c) {
        return c == '^'
                || c == 'v'
                || c == '→'
                || c == '↔'
                || c == '-';
    }

    // Utility function to do inorden traversal
    public void inorden(ETNode t) {
        if (t != null) {
            inorden(t.left);
            System.out.print(t.value);
            inorden(t.right);
        }
    }

    public void preorden(ETNode t) {
        if (t != null) {
            System.out.print(t.value);
            prefijo.add(t.value);
            preorden(t.left);
            preorden(t.right);
        }
    }

    // Returns root of constructed tree for given
    // postfix expression
    public ETNode construirArbol(char postfix[]) {
        Stack<ETNode> st = new Stack();
        ETNode t, t1, t2;

        // Traverse through every character of
        // input expression
        for (int i = 0; i < postfix.length; i++) {

            // If operand, simply push into stack
            if (!esOperador(postfix[i])) {
                t = new ETNode(postfix[i]);
                st.push(t);
            } else if (postfix[i] != '-') {// operator (not negative)
                t = new ETNode(postfix[i]);

                // Pop two top nodes
                // Store top
                t1 = st.pop();      // Remove top
                t2 = st.pop();

                //  make them children
                t.right = t1;
                t.left = t2;

                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                st.push(t);
            } else { //operator (negative)
                t = new ETNode(postfix[i]);

                t1 = st.pop();

                t.right = t1;

                st.push(t);
            }
        }

        //  only element will be root of expression
        // tree
        t = st.peek();
        st.pop();

        tree.insertRoot(t.value);
        return t;
    }
    
    public static void main(String args[]) {
        ExpressionTree arbol = new ExpressionTree();
//        String postfix = "PQ^Q-P-v↔";
        String postfijo = "PQ→QP^^PQ↔↔";
        char[] charArray = postfijo.toCharArray();
        ETNode root = arbol.construirArbol(charArray);
        System.out.println("infijo: ");
        arbol.inorden(root);
        System.out.println("\nprefijo: ");
        arbol.preorden(root);
        System.out.println("\nPrefijo: " + prefijo);
    }
    
}
