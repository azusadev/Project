/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.project;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nouelle
 */
public class Item_Account extends javax.swing.JPanel {

    private String username;
    private String password;
    private String type;
    JP_Accounts parent;
    
    public void setUsername(String username) {
        this.username = username;
        username_txt.setText(username);
    }

    public void setPassword(String password) {
        this.password = password;
        password_txt.setText(password);
    }

    public void setType(String type) {
        this.type = type;
        type_txt.setText(type);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }
    
    /**
     * Creates new form Item_Account
     * @param username
     * @param password
     * @param type
     */
    public Item_Account(JP_Accounts p, String username, String password, String type) {
        initComponents();
        parent = p;
        this.username = username;
        this.password = password;
        this.type = type;
        username_txt.setText(username);
        type_txt.setText(type);
        password_txt.setText(password);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        type_txt = new javax.swing.JLabel();
        username_txt = new javax.swing.JLabel();
        edit = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        password_txt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1200, 40));
        setMinimumSize(new java.awt.Dimension(1200, 40));
        setPreferredSize(new java.awt.Dimension(1200, 40));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        type_txt.setBackground(new java.awt.Color(255, 255, 255));
        type_txt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        type_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type_txt.setText("Manager");
        add(type_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 270, 40));

        username_txt.setBackground(new java.awt.Color(255, 255, 255));
        username_txt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        username_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username_txt.setText("Username");
        add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 330, 40));

        edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-black.png"))); // NOI18N
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editMouseReleased(evt);
            }
        });
        add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 40, 40));

        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-black.png"))); // NOI18N
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteMouseReleased(evt);
            }
        });
        add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 40, 40));

        password_txt.setBackground(new java.awt.Color(255, 255, 255));
        password_txt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        password_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        password_txt.setText("Password");
        add(password_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 270, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void editMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseReleased
        JOP_Account tempAccount = new JOP_Account();
        tempAccount.password.setText(password);
        tempAccount.username.setText(username);
        int index = 0;
        switch(type)
        {
            case "Manager":
                index = 1;
                break;
            case "Cashier":
                index = 0;
                break;
        }
        tempAccount.type.setSelectedIndex(index);
                
        int value = JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor(this),
            tempAccount,
            "Edit Account",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);

        if(value == JOptionPane.OK_OPTION && !tempAccount.username.getText().isEmpty() && !tempAccount.password.getText().isEmpty())
        {
            for (int i = 0; i < Database.accounts.size(); i++) {
                if(Database.accounts.get(i).getUsername().equals(getUsername()))
                {
                    Database.accounts.get(i).setUsername(tempAccount.username.getText());
                    Database.accounts.get(i).setPassword(tempAccount.password.getText());
                    Database.accounts.get(i).setType(tempAccount.type.getSelectedItem().toString());
                    break;
                }
            }
            setUsername(tempAccount.username.getText());
            setPassword(tempAccount.password.getText());
            setType(tempAccount.type.getSelectedItem().toString());
            Database.SaveAccount("Accounts");
        }
       
    }//GEN-LAST:event_editMouseReleased

    private void deleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseReleased
        for (int i = 0; i < Database.accounts.size(); i++) {
            if(Database.accounts.get(i).getUsername().equals(getUsername()))
            {
                Database.accounts.remove(Database.accounts.get(i));
                parent.getAccounts().remove(this);
                parent.getC_content().remove(this);
                parent.getC_content().repaint();
                parent.getC_content().revalidate();
                break;
            }
        }
        Database.SaveAccount("Accounts");
    }//GEN-LAST:event_deleteMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel delete;
    private javax.swing.JLabel edit;
    private javax.swing.JLabel password_txt;
    private javax.swing.JLabel type_txt;
    private javax.swing.JLabel username_txt;
    // End of variables declaration//GEN-END:variables
}
