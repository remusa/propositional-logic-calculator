/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

import Modelo.Valores;
import Vista.VtnPrincipal;
import java.util.Stack;

/**
 * 
 * @author rms
 */
public class Infijo {
    
    private static final char CONJUNCION = Valores.CONJUNCION;
    private static final char DISYUNCION = Valores.DISYUNCION;
    private static final char CONDICIONAL = Valores.CONDICIONAL;
    private static final char BICONDICIONAL = Valores.BICONDICIONAL;
    private static final char NEGACION = Valores.NEGACION;
    private static final char PARENTESISABRE = Valores.PARENTESISABRE;
    private static final char PARENTESISCIERRA = Valores.PARENTESISCIERRA;

    public static void main(String[] args) {
//        test("((P→Q)^(P→R))→(P→R)", "P→Q^P→R→P→R");
//        test("(P^Q)↔(-Qv-P)", "P^Q↔-Qv-P");
//        test("((P→Q)^(Q^P))↔(P↔Q)", "P→Q^Q^P↔P↔Q");

        test("PQRv^PQ^↔PR^v", "");
    }

    /**
    Método para evaluar si un caracter recibido es un operador o no
    @param c
    @return 
     */
    private static boolean esOperador(char c) {
        return c == CONJUNCION
                || c == DISYUNCION
                || c == CONDICIONAL
                || c == BICONDICIONAL
                || c == NEGACION
                || c == PARENTESISABRE
                || c == PARENTESISCIERRA;
    }

    /**
    Método para convertir a infijo desde el postfijo
    http://javaingrab.blogspot.com/2014/07/postfix-to-infix-conversion-using-stack.html
    @param proposicion
    @return 
     */
    public static String convertiraInfijoDesdePostfijo(String proposicion) {
        Stack<String> pila = new Stack<>();
        char c;

        for (int i = 0; i < proposicion.length(); i++) {
            c = proposicion.charAt(i);

            if (esOperador(c)) {
                String b = pila.pop();
                String a = pila.pop();
                pila.push("(" + a + c + b + ")");
            } else {
                pila.push("" + c);
            }
        }

        String infijo = pila.toString();
//        infijo = infijo.substring(1, infijo.length() - 1);  //quita corchetes y paréntesis que envuelven toda la exp.
        return infijo;
    }

    public static void test(String prueba, String esperado) {
        String res = convertiraInfijoDesdePostfijo(prueba);
        String evaluacion;

        if (res.equals(esperado)) {
            evaluacion = "true";
        } else {
            evaluacion = "false";
        }

        System.out.println("--------------------------------"
                + "\nPrueba: \t" + prueba
                + "\nResultado: \t" + res
                + "\nEsperado: \t" + esperado
                + "\nEvaluación: \t" + evaluacion
                + "\n--------------------------------\n");

    }
    
    public static String convertiraInfijo(String proposicion) {
        return proposicion.replaceAll("[( )]", "");
    }
}
