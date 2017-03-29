/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import GraficarArbol.BinaryTree;
import GraficarArbol.treeGUI;
import Modelo.Valores;
import Modelo.Evaluacion;
import Ordenamiento.Infijo;
import Ordenamiento.ExpressionTree;
import Ordenamiento.ETNode;
import Ordenamiento.Posfijo;
import comportamiento.Interfaz;
import comportamiento.Mensajes;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rms
 */
public class VtnPrincipal extends javax.swing.JFrame {

    private static int noVar = 0;
    private static Object[] vectorVariables;
    private DefaultTableModel model;

    private static final char CONJUNCION = Valores.CONJUNCION;
    private static final char DISYUNCION = Valores.DISYUNCION;
    private static final char CONDICIONAL = Valores.CONDICIONAL;
    private static final char BICONDICIONAL = Valores.BICONDICIONAL;
    private static final char NEGACION = Valores.NEGACION;
    private static final char PARENTESISABRE = Valores.PARENTESISABRE;
    private static final char PARENTESISCIERRA = Valores.PARENTESISCIERRA;

    private static final char P = 'P';
    private static final char Q = 'Q';
    private static final char R = 'R';
    private static final char S = 'S';
    private static final char T = 'T';
    private static final char U = 'U';

    private ArrayList<Character> varP = new ArrayList<>();
    private ArrayList<Character> varQ = new ArrayList<>();
    private ArrayList<Character> varR = new ArrayList<>();
    private ArrayList<Character> varS = new ArrayList<>();
    private ArrayList<Character> varT = new ArrayList<>();
    private ArrayList<Character> varU = new ArrayList<>();

    /** Creates new form VtnPrincipal */
    public VtnPrincipal() {
        initComponents();

        btnConjuncion.setText(Character.toString(CONJUNCION));
        btnDisyuncion.setText(Character.toString(DISYUNCION));
        btnCondicional.setText(Character.toString(CONDICIONAL));
        btnBicondicional.setText(Character.toString(BICONDICIONAL));
        btnNegacion.setText(Character.toString(NEGACION));
        btnParentesisAbre.setText(Character.toString(PARENTESISABRE));
        btnParentesisCierra.setText(Character.toString(PARENTESISCIERRA));
    }

    /**
    Método para contar el número de variables (PQRSTU) y crear los arreglos correspondientes, se eliminan 
    los caracteres que no sean variables (PQRSTU) y se agregan a un HashSet, como un HashSet no puede 
    contener valores repetidos, el total de elementos correponde al total de variables
    @param proposicion
    @return 
     */
    private static int contarVariables(String proposicion) {
        String prop = proposicion.replaceAll("[^A-Ua-uW-Zw-z]", "");

        HashSet<Character> hash = new HashSet<>();
        prop = prop.toUpperCase();
        for (int i = 0; i < prop.length(); i++) {
            hash.add(prop.charAt(i));
        }
        return hash.size();
    }

    /**
    Método para mostrar las tablas
    @param proposicion 
     */
    private void mostrarTablasVariables(String proposicion) {
        noVar = contarVariables(proposicion);

        vectorVariables = Valores.iniciar(noVar); 
        //es un vector de máx. longitud 6, cada índice contiene
        //un ArrayList<Character> con los valores de la tabla de verdad

        switch (noVar) {
            case 6:
                varU = (ArrayList) vectorVariables[5];
            case 5:
                varT = (ArrayList) vectorVariables[4];
            case 4:
                varS = (ArrayList) vectorVariables[3];
            case 3:
                varR = (ArrayList) vectorVariables[2];
            case 2:
                varQ = (ArrayList) vectorVariables[1];
            case 1:
                varP = (ArrayList) vectorVariables[0];
                break;
        }

        model = new DefaultTableModel();
        for (int i = 0; i < Evaluacion.arrayTabla.size(); i++) {
            Object[] obj = Evaluacion.arrayTabla.get(i).toArray();
            model.addColumn(Evaluacion.columna.get(i), obj);
        }

        tbVariables.setModel(model);
    }

    public String postfijo(String proposicion) throws IOException {
        ArrayList<String> res = new ArrayList();
        String prop[] = proposicion.split("");
        res.addAll(Arrays.asList(prop));
        Posfijo p = new Posfijo(res);
        res = p.getPosfijo();

        String temp = Arrays.toString(res.toArray());
        temp = temp.concat("").replaceAll("[ ,()]", "");
        temp = temp.substring(1, temp.length() - 1);
        System.out.println("STRING: " + temp);
        return temp;
    }

    public String prefijo(String postfijo) {
        ExpressionTree.prefijo.clear();
        ExpressionTree et = new ExpressionTree();
        char[] charArray = postfijo.toCharArray();
        ETNode root = et.construirArbol(charArray);
        et.preorden(root);
//        System.out.println("Prefijo: ");
        String prefijo = ExpressionTree.prefijo.toString();
        prefijo = prefijo.replaceAll("[ ,]", "");
        prefijo = prefijo.substring(1, prefijo.length() - 1);
        return prefijo;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfProposicion = new javax.swing.JTextField();
        tfPostfijo = new javax.swing.JTextField();
        tfEvaluacion = new javax.swing.JTextField();
        btnP = new javax.swing.JButton();
        btnQ = new javax.swing.JButton();
        btnR = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnT = new javax.swing.JButton();
        btnU = new javax.swing.JButton();
        btnParentesisAbre = new javax.swing.JButton();
        btnParentesisCierra = new javax.swing.JButton();
        btnConjuncion = new javax.swing.JButton();
        btnDisyuncion = new javax.swing.JButton();
        btnCondicional = new javax.swing.JButton();
        btnBicondicional = new javax.swing.JButton();
        btnNegacion = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEvaluar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVariables = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfInfijo = new javax.swing.JTextField();
        tfPrefijo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNoVar = new javax.swing.JTextField();
        tbPegar = new javax.swing.JToggleButton();
        btnArbol = new javax.swing.JButton();
        mnuPrincipal = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuAyuda = new javax.swing.JMenu();
        mnuitemAcercaDe = new javax.swing.JMenuItem();
        mnuitemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de Lógica Proposicional");
        setResizable(false);

        tfProposicion.setEnabled(false);

        tfPostfijo.setEnabled(false);

        tfEvaluacion.setEnabled(false);

        btnP.setText("P");
        btnP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPActionPerformed(evt);
            }
        });

        btnQ.setText("Q");
        btnQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQActionPerformed(evt);
            }
        });

        btnR.setText("R");
        btnR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRActionPerformed(evt);
            }
        });

        btnS.setText("S");
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });

        btnT.setText("T");
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });

        btnU.setText("U");
        btnU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUActionPerformed(evt);
            }
        });

        btnParentesisAbre.setText("(");
        btnParentesisAbre.setToolTipText("");
        btnParentesisAbre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParentesisAbreActionPerformed(evt);
            }
        });

        btnParentesisCierra.setText(")");
        btnParentesisCierra.setToolTipText("");
        btnParentesisCierra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParentesisCierraActionPerformed(evt);
            }
        });

        btnConjuncion.setText("∧");
        btnConjuncion.setToolTipText("Conjunción");
        btnConjuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConjuncionActionPerformed(evt);
            }
        });

        btnDisyuncion.setText("∨");
        btnDisyuncion.setToolTipText("Disyunción");
        btnDisyuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisyuncionActionPerformed(evt);
            }
        });

        btnCondicional.setText("→");
        btnCondicional.setToolTipText("Condicional");
        btnCondicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCondicionalActionPerformed(evt);
            }
        });

        btnBicondicional.setText("↔");
        btnBicondicional.setToolTipText("Bicondicional");
        btnBicondicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBicondicionalActionPerformed(evt);
            }
        });

        btnNegacion.setText("¬");
        btnNegacion.setToolTipText("Negación");
        btnNegacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegacionActionPerformed(evt);
            }
        });

        btnBorrar.setText("←");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEvaluar.setText("Evaluar");
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(250, 300));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(453, 300));

        tbVariables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tbVariables.setToolTipText("");
        tbVariables.setEnabled(false);
        jScrollPane1.setViewportView(tbVariables);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Proposición:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Postfijo:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Evaluación:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Infijo:");

        tfInfijo.setEnabled(false);

        tfPrefijo.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Prefijo:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Variables:");

        tfNoVar.setEnabled(false);

        tbPegar.setText("Pegar");
        tbPegar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tbPegarItemStateChanged(evt);
            }
        });

        btnArbol.setText("Árbol");
        btnArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbolActionPerformed(evt);
            }
        });

        mnuArchivo.setText("Archivos");
        mnuPrincipal.add(mnuArchivo);

        mnuAyuda.setText("?");

        mnuitemAcercaDe.setText("Acerca de");
        mnuitemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitemAcercaDeActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuitemAcercaDe);

        mnuitemAyuda.setText("Ayuda");
        mnuitemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitemAyudaActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuitemAyuda);

        mnuPrincipal.add(mnuAyuda);

        setJMenuBar(mnuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnR))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnU)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnParentesisAbre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnParentesisCierra))
                            .addComponent(btnNegacion))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConjuncion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCondicional)
                                .addGap(18, 18, 18)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDisyuncion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBicondicional)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbPegar))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(tfProposicion, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEvaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnArbol))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfInfijo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfNoVar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPostfijo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6)
                                .addComponent(tfEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfPrefijo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnP)
                    .addComponent(btnQ)
                    .addComponent(btnR)
                    .addComponent(btnParentesisAbre)
                    .addComponent(btnParentesisCierra)
                    .addComponent(btnCondicional)
                    .addComponent(btnConjuncion)
                    .addComponent(btnBorrar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnT)
                            .addComponent(btnS)
                            .addComponent(btnU)
                            .addComponent(btnBicondicional)
                            .addComponent(btnNegacion)
                            .addComponent(btnDisyuncion)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(tbPegar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addComponent(tfProposicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEvaluar)
                        .addComponent(btnArbol)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPostfijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfInfijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(tfNoVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPrefijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnParentesisAbreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParentesisAbreActionPerformed
        String simbolo = String.valueOf(PARENTESISABRE);
        tfProposicion.setText(tfProposicion.getText() + simbolo);
    }//GEN-LAST:event_btnParentesisAbreActionPerformed

    private void btnParentesisCierraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParentesisCierraActionPerformed
        String simbolo = String.valueOf(PARENTESISCIERRA);
        tfProposicion.setText(tfProposicion.getText() + simbolo);
    }//GEN-LAST:event_btnParentesisCierraActionPerformed

    private void btnConjuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConjuncionActionPerformed
        String simbolo = String.valueOf(CONJUNCION);
        tfProposicion.setText(tfProposicion.getText() + simbolo);
    }//GEN-LAST:event_btnConjuncionActionPerformed

    private void btnDisyuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisyuncionActionPerformed
        String simbolo = String.valueOf(DISYUNCION);
        tfProposicion.setText(tfProposicion.getText() + simbolo);
    }//GEN-LAST:event_btnDisyuncionActionPerformed

    private void btnCondicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCondicionalActionPerformed
        String simbolo = String.valueOf(CONDICIONAL);
        tfProposicion.setText(tfProposicion.getText() + simbolo);
    }//GEN-LAST:event_btnCondicionalActionPerformed

    private void btnBicondicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBicondicionalActionPerformed
        String simbolo = String.valueOf(BICONDICIONAL);
        tfProposicion.setText(tfProposicion.getText() + simbolo);
    }//GEN-LAST:event_btnBicondicionalActionPerformed

    private void btnNegacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegacionActionPerformed
        String simbolo = String.valueOf(NEGACION);
        tfProposicion.setText(tfProposicion.getText() + simbolo);
    }//GEN-LAST:event_btnNegacionActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Interfaz.limpiarElementos(tfProposicion, tfEvaluacion, tfPostfijo, tfInfijo, tfPrefijo, tfNoVar, tbVariables);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPActionPerformed
        String letra = String.valueOf(P);
        tfProposicion.setText(tfProposicion.getText() + letra);
    }//GEN-LAST:event_btnPActionPerformed

    private void btnQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQActionPerformed
        String letra = String.valueOf(Q);
        tfProposicion.setText(tfProposicion.getText() + letra);
    }//GEN-LAST:event_btnQActionPerformed

    private void btnRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRActionPerformed
        String letra = String.valueOf(R);
        tfProposicion.setText(tfProposicion.getText() + letra);
    }//GEN-LAST:event_btnRActionPerformed

    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSActionPerformed
        String letra = String.valueOf(S);
        tfProposicion.setText(tfProposicion.getText() + letra);
    }//GEN-LAST:event_btnSActionPerformed

    private void btnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTActionPerformed
        String letra = String.valueOf(T);
        tfProposicion.setText(tfProposicion.getText() + letra);
    }//GEN-LAST:event_btnTActionPerformed

    private void btnUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUActionPerformed
        String letra = String.valueOf(U);
        tfProposicion.setText(tfProposicion.getText() + letra);
    }//GEN-LAST:event_btnUActionPerformed

    private void mnuitemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemAcercaDeActionPerformed
        new VtnAcercaDe().setVisible(true);
    }//GEN-LAST:event_mnuitemAcercaDeActionPerformed

    private void mnuitemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemAyudaActionPerformed
        new VtnAyuda().setVisible(true);
    }//GEN-LAST:event_mnuitemAyudaActionPerformed

    private void btnEvaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluarActionPerformed
        try {
            //Tabla
            mostrarTablasVariables(tfProposicion.getText());
            //Número de variables
            tfNoVar.setText(Integer.toString(contarVariables(tfProposicion.getText())));
            //Evaluación
            Evaluacion.evaluacionIniciar(tfProposicion.getText());
            //Tipo de evaluación
            tfEvaluacion.setText(Evaluacion.evaluacionTipo());
            //Postfijo
//            String textPostfijo = PosfijoR.convertiraPostfijo(tfProposicion.getText());
            String textPostfijo = postfijo(tfProposicion.getText());
            tfPostfijo.setText(textPostfijo);
            //Infijo
            String textInfijo = Infijo.convertiraInfijo(tfProposicion.getText());
            tfInfijo.setText(textInfijo);
            //Prefijo
            String textPrefijo = prefijo(textPostfijo);
            System.out.println("Prueba: " + textPrefijo);
            tfPrefijo.setText(textPrefijo);
        } catch (ArrayIndexOutOfBoundsException e) {
            Mensajes.falla(this, "Selecciona el número de variables correcto");
        } catch (IOException e) {
            Mensajes.falla(this, "Error I/O: " + e.getMessage());
        } catch (Exception e) {
//            Mensajes.falla(this, "Error inesperado");
        }
    }//GEN-LAST:event_btnEvaluarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        Interfaz.borrarUltimoCaracter(tfProposicion);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tbPegarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tbPegarItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            tfProposicion.setEnabled(true);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            tfProposicion.setEnabled(false);
        }
    }//GEN-LAST:event_tbPegarItemStateChanged

    private void btnArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolActionPerformed
        BinaryTree tree = new BinaryTree();
        
        String post = tfPostfijo.getText();
        
        //insertar nodos en árbol
        tree.insertRoot('4');
        tree.insertLeft('4', '5');
        tree.insertRight('4', '6');
        tree.insertLeft('5', '4');
        tree.insertRight('5', '6');
        tree.insertLeft('6', '7');
        tree.insertRight('6', '8');
        
        tree.Breadth(tree.root);
        treeGUI treeGUI = new treeGUI(tree);
    }//GEN-LAST:event_btnArbolActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        LookandFeel lf = new LookandFeel();
//        lf.darculaLF();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArbol;
    private javax.swing.JButton btnBicondicional;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCondicional;
    private javax.swing.JButton btnConjuncion;
    private javax.swing.JButton btnDisyuncion;
    private javax.swing.JButton btnEvaluar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNegacion;
    private javax.swing.JButton btnP;
    private javax.swing.JButton btnParentesisAbre;
    private javax.swing.JButton btnParentesisCierra;
    private javax.swing.JButton btnQ;
    private javax.swing.JButton btnR;
    private javax.swing.JButton btnS;
    private javax.swing.JButton btnT;
    private javax.swing.JButton btnU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuBar mnuPrincipal;
    private javax.swing.JMenuItem mnuitemAcercaDe;
    private javax.swing.JMenuItem mnuitemAyuda;
    private javax.swing.JToggleButton tbPegar;
    private javax.swing.JTable tbVariables;
    private javax.swing.JTextField tfEvaluacion;
    private javax.swing.JTextField tfInfijo;
    private javax.swing.JTextField tfNoVar;
    private javax.swing.JTextField tfPostfijo;
    private javax.swing.JTextField tfPrefijo;
    private javax.swing.JTextField tfProposicion;
    // End of variables declaration//GEN-END:variables
}
