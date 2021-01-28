/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.project;

/**
 *
 * @author reden
 */
public class Item_AddMenu extends javax.swing.JPanel {

    private boolean isOpen = false;
    private String menuName;
    private double menuPrice;
    private Item_AddCategory category;
    /**
     * Creates new form Item_AddCategory
     */
    
    public Item_AddMenu() {
        initComponents();
    }
    public Item_AddMenu(Item_AddCategory c, String n, double p) {
        initComponents();
        menuName = n;
        category = c;
        menuPrice = p;
        menu.setText(n);
        price.setText(p + "");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        price = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        edit = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1200, 40));
        setPreferredSize(new java.awt.Dimension(1200, 40));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        price.setBackground(new java.awt.Color(255, 255, 255));
        price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price.setText("2000.0");
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 230, 40));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menu.setText("MenuName");
        jPanel1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 420, 40));

        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-black.png"))); // NOI18N
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteMouseReleased(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 40, 40));

        edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-black.png"))); // NOI18N
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editMouseReleased(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 40, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void deleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseReleased
        // TODO add your handling code here:
        category.removeMenu(this);
    }//GEN-LAST:event_deleteMouseReleased

    private void editMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_editMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel delete;
    private javax.swing.JLabel edit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}