/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.project;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author reden
 */
public class JP_UpdateMenu extends javax.swing.JPanel {

    
    private ArrayList<Item_AddCategory> categoryList = new ArrayList<>();

    public ArrayList<Item_AddCategory> getCategoryList() {
        return categoryList;
    }
    
    /**
     * Creates new form JP_Logs
     */
    public JP_UpdateMenu() {
        initComponents();
        Database.dbMenu = this;
        this.setBackground(ColorTheme.secondaryColor);
        updatemenu_sp.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        updatemenu_sp.getVerticalScrollBar().setUnitIncrement(36);
        updatemenu_sp.getViewport().setBorder(null);
        updatemenu_sp.setViewportBorder(null);
        updatemenu_sp.setBorder(null);
        Database.LoadToFile("Categories");
        for (int i = 0; i < Database.loadCategories.size(); i++) {
            addCategory(Database.loadCategories.get(i).getName());
            for (int j = 0; j < Database.loadCategories.get(i).getMenus().size(); j++) {
                for (int k = 0; k < categoryList.size(); k++) {
                    if(categoryList.get(k).getCategoryName().equals(Database.loadCategories.get(i).getName()))
                    {
                        categoryList.get(k).addMenu(Database.loadCategories.get(i).getMenus().get(j).getName(), Database.loadCategories.get(i).getMenus().get(j).getPrice());
                        break;
                    }
                }
            }
        }
        
    }

    public void addCategory(String categoryName)
    {
        boolean found = false;
        for (int i = 0; i < categoryList.size(); i++) {
            if(categoryList.get(i).getCategoryName().equals(categoryName))
            {
                found = true;
                break;
            }
        }
        if(!found)
        {
            Database.categories.add(new CategoryInfo(categoryName));
            Item_AddCategory temp = new Item_AddCategory(this, categoryName);
            categoryList.add(temp);
            Database.mainMenu.addCategory(categoryName);
            c_content.add(temp);
            c_content.repaint();
            c_content.revalidate();
            Database.SaveToFile("Categories");
        }
     
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updatemenu_sp = new javax.swing.JScrollPane();
        c_container = new javax.swing.JPanel();
        c_content = new javax.swing.JPanel();
        jp_addcategory = new javax.swing.JPanel();
        jl_addcategory = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));
        setPreferredSize(new java.awt.Dimension(1200, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updatemenu_sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        updatemenu_sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        updatemenu_sp.setMaximumSize(new java.awt.Dimension(1200, 560));
        updatemenu_sp.setMinimumSize(new java.awt.Dimension(1200, 560));
        updatemenu_sp.setPreferredSize(new java.awt.Dimension(1200, 560));

        c_container.setMinimumSize(new java.awt.Dimension(1200, 560));
        c_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        c_content.setMaximumSize(new java.awt.Dimension(300000, 300000));
        c_content.setMinimumSize(new java.awt.Dimension(0, 0));
        c_content.setOpaque(false);
        c_content.setLayout(new javax.swing.BoxLayout(c_content, javax.swing.BoxLayout.PAGE_AXIS));
        c_container.add(c_content);

        updatemenu_sp.setViewportView(c_container);

        add(updatemenu_sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 530));

        jp_addcategory.setBackground(new java.awt.Color(22, 36, 49));
        jp_addcategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp_addcategoryMouseReleased(evt);
            }
        });

        jl_addcategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_addcategory.setForeground(new java.awt.Color(255, 255, 255));
        jl_addcategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_addcategory.setText("ADD CATEGORY");

        javax.swing.GroupLayout jp_addcategoryLayout = new javax.swing.GroupLayout(jp_addcategory);
        jp_addcategory.setLayout(jp_addcategoryLayout);
        jp_addcategoryLayout.setHorizontalGroup(
            jp_addcategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_addcategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_addcategory, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp_addcategoryLayout.setVerticalGroup(
            jp_addcategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_addcategory, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(jp_addcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 190, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Database");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jp_addcategoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_addcategoryMouseReleased
        // TODO add your handling code here:
        JOP_Category tempCategory = new JOP_Category();
        int value = JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor(this),
                        tempCategory,
                        "Add Category",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);

        if(value == JOptionPane.OK_OPTION && !tempCategory.categoryName.getText().isEmpty())
        {
            addCategory(tempCategory.categoryName.getText());
        }
    }//GEN-LAST:event_jp_addcategoryMouseReleased

    public void removeCategory(Item_AddCategory c)
    {
        if(categoryList.contains(c))
        {
            System.out.println("FOUND!");
            categoryList.remove(c);
            c_content.remove(c);
            c_content.repaint();
            c_content.revalidate();
            for (int i = 0; i < Database.categories.size(); i++) {
                if(Database.categories.get(i).getName().equals(c.getCategoryName()))
                {
                    Database.categories.remove(Database.categories.get(i));
                    break;
                }
            }
            Database.mainMenu.deleteCategory(c.getCategoryName());
            Database.SaveToFile("Categories");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel c_container;
    private javax.swing.JPanel c_content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jl_addcategory;
    private javax.swing.JPanel jp_addcategory;
    private javax.swing.JScrollPane updatemenu_sp;
    // End of variables declaration//GEN-END:variables
}
