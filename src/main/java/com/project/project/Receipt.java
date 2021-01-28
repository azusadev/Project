/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nouelle
 */
public class Receipt extends javax.swing.JFrame {

    /**
     * Creates new form Receipt
     */
    public Receipt() {
        initComponents();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();  
        lblTime.setText(now.toString());
        lblDate.setText(dtf.toString());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        currentuser = new javax.swing.JLabel();
        lblOrderNumber = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Description = new javax.swing.JLabel();
        Description1 = new javax.swing.JLabel();
        Description2 = new javax.swing.JLabel();
        receiptContainer = new javax.swing.JPanel();
        finalReceipt = new com.project.project.FinalReceipt();
        finalReceipt1 = new com.project.project.FinalReceipt();
        finalReceipt2 = new com.project.project.FinalReceipt();
        finalReceipt3 = new com.project.project.FinalReceipt();
        finalReceipt4 = new com.project.project.FinalReceipt();
        finalReceipt5 = new com.project.project.FinalReceipt();

        jLabel4.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 700));
        setMinimumSize(new java.awt.Dimension(400, 700));
        setPreferredSize(new java.awt.Dimension(400, 700));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(500, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 700));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("                     Jollibee STI Malolos");
        jLabel5.setMaximumSize(new java.awt.Dimension(400, 30));
        jLabel5.setMinimumSize(new java.awt.Dimension(400, 30));
        jLabel5.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText(" ---------------------Customer Receipt------------------------");
        jLabel1.setMaximumSize(new java.awt.Dimension(400, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(400, 30));
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 30));

        lblTime.setText("Time dito");
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 100, 50));

        lblDate.setText("Date dito");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 100, 50));

        jLabel2.setText("=======================================================");
        jLabel2.setMaximumSize(new java.awt.Dimension(400, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(400, 30));
        jLabel2.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 400, 30));

        currentuser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        currentuser.setText("yung may gamit ng system now.");
        jPanel1.add(currentuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 230, 40));

        lblOrderNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOrderNumber.setText("69");
        jPanel1.add(lblOrderNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 80, 40));

        jLabel6.setText("=======================================================");
        jLabel6.setMaximumSize(new java.awt.Dimension(400, 30));
        jLabel6.setMinimumSize(new java.awt.Dimension(400, 30));
        jLabel6.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 400, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Oder#");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 50, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cashier:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 60, 40));

        Description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Description.setText("Price");
        jPanel1.add(Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 80, 30));

        Description1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Description1.setText("Description");
        jPanel1.add(Description1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 220, 30));

        Description2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Description2.setText("Quantity");
        Description2.setMaximumSize(new java.awt.Dimension(80, 30));
        Description2.setMinimumSize(new java.awt.Dimension(80, 30));
        Description2.setPreferredSize(new java.awt.Dimension(80, 30));
        jPanel1.add(Description2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 80, 30));

        getContentPane().add(jPanel1);

        receiptContainer.setMaximumSize(new java.awt.Dimension(30000, 30000));
        receiptContainer.setMinimumSize(new java.awt.Dimension(0, 0));
        receiptContainer.setPreferredSize(new java.awt.Dimension(400, 250));
        receiptContainer.setLayout(new javax.swing.BoxLayout(receiptContainer, javax.swing.BoxLayout.PAGE_AXIS));
        receiptContainer.add(finalReceipt);
        receiptContainer.add(finalReceipt1);
        receiptContainer.add(finalReceipt2);
        receiptContainer.add(finalReceipt3);
        receiptContainer.add(finalReceipt4);
        receiptContainer.add(finalReceipt5);

        getContentPane().add(receiptContainer);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Description;
    private javax.swing.JLabel Description1;
    private javax.swing.JLabel Description2;
    private javax.swing.JLabel currentuser;
    private com.project.project.FinalReceipt finalReceipt;
    private com.project.project.FinalReceipt finalReceipt1;
    private com.project.project.FinalReceipt finalReceipt2;
    private com.project.project.FinalReceipt finalReceipt3;
    private com.project.project.FinalReceipt finalReceipt4;
    private com.project.project.FinalReceipt finalReceipt5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblOrderNumber;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel receiptContainer;
    // End of variables declaration//GEN-END:variables
}
