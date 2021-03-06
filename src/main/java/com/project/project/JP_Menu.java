/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.project;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nouelle
 */
public class JP_Menu extends javax.swing.JPanel implements MouseListener{

    private Item_Category selectedCategory = null;
    private ArrayList<Item_Receipt> receipt = new ArrayList<>();
    private ArrayList<Item_Category> category = new ArrayList<>(); 
    private ArrayList<JP_MenuCard> menuCard = new ArrayList<>();
    private double totalAmount = 0.00;
    private double taxAmount = 0.00;

    public ArrayList<JP_MenuCard> getMenuCard() {
        return menuCard;
    }

    public ArrayList<Item_Receipt> getReceipt() {
        return receipt;
    }

    public void setReceipt(ArrayList<Item_Receipt> receipt) {
        this.receipt = receipt;
    }

    /**
     * Creates new form JP_Menu
     */
    public JP_Menu() {
        initComponents();
        Database.mainMenu = this;
        this.setBackground(ColorTheme.secondaryColor);
        receipt_area.setBackground(ColorTheme.secondaryColor);
        menu_area.setBackground(ColorTheme.secondaryColor);
        c_container.setBackground(ColorTheme.secondaryColor);
        c_content.setBackground(ColorTheme.secondaryColor);
        category_sp.setBackground(ColorTheme.secondaryColor);
        receipt_sp.setBackground(ColorTheme.secondaryColor);
        r_container.setBackground(ColorTheme.secondaryColor);
        r_content.setBackground(ColorTheme.secondaryColor);
        jp_pay.setBackground(ColorTheme.primaryColor);
        receipt_sp.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        receipt_sp.getVerticalScrollBar().setUnitIncrement(36);
        receipt_sp.getViewport().setBorder(null);
        receipt_sp.setViewportBorder(null);
        receipt_sp.setBorder(null);
        
                                
        //setting category scroll pane
        category_sp.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));
        category_sp.getHorizontalScrollBar().setUnitIncrement(36);
        category_sp.getViewport().setBorder(null);
        category_sp.setViewportBorder(null);
        category_sp.setBorder(null);
        
        
//        for (int i = 0; i < 30; i++) {
//            System.out.println(i);
//            String name = "Category " + (i+1); 
//            addCategory(name);
//        }
    }

    public void addCategory(String categoryName)
    {
        
        try {
            Item_Category temp = new Item_Category(categoryName);
            temp.addMouseListener(this);
            category.add(temp);
            c_content.add(temp);
            c_content.repaint();
            c_content.revalidate();
            JP_MenuCard tmc = new JP_MenuCard(this, categoryName);
            menuCard.add(tmc);
            menu_area.add(tmc, categoryName);
            menu_area.repaint();
            menu_area.revalidate();
            if(category.size() <= 1)
            {
                selectedCategory = temp;
                selectedCategory.setBackground(ColorTheme.highlightColor);
                selectedCategory.getJLabelName().setForeground(ColorTheme.secondaryColor);
                CardLayout c = (CardLayout)menu_area.getLayout();
                c.show(menu_area, categoryName);
            }
        } catch (Exception e) {
        }
    }
    
    public void deleteCategory(String categoryName)
    {
        try {
            for (int i = 0; i<category.size();i++) {
                if(category.get(i).getCategoryName().equals(categoryName))
                {
                    c_content.remove(category.get(i));
                    c_content.repaint();
                    c_content.revalidate();
                    for (int j = 0; j < menuCard.size(); j++) {
                        if(menuCard.get(j).getCategoryName().equals(categoryName))
                        {
//                            CardLayout lay = (CardLayout)menu_area.getLayout();
//                            lay.removeLayoutComponent(menuCard.get(j));
                            menu_area.remove(menuCard.get(j));
                            menuCard.remove(menuCard.get(j));
                            menu_area.repaint();
                            menu_area.revalidate();
                            break;
                        }
                    }
                    category.remove(category.get(i));
                    if(category.size()<= 1) 
                    {
                        selectedCategory = category.get(0);
                        selectedCategory.setBackground(ColorTheme.highlightColor);
                        selectedCategory.getJLabelName().setForeground(ColorTheme.secondaryColor);
                        CardLayout lay = (CardLayout)menu_area.getLayout();
                        lay.show(menu_area, selectedCategory.getCategoryName());
               
                    }
                    else
                    {
                        selectedCategory = null;
                    }
              
                    break;
                }
            }
        } catch (Exception e) {
        }
    }
    
    public void editCategory(String oldName, String newName)
    {
        for (int i = 0; i<category.size();i++) {
            if(category.get(i).getCategoryName().equals(oldName))
            {
                category.get(i).setCategory(newName);
                for(JP_MenuCard m : menuCard)
                {
                    if(m.getCategoryName().equals(oldName))
                    {
                        m.setCategoryName(newName);
                        CardLayout lay = (CardLayout)menu_area.getLayout();
                        lay.removeLayoutComponent(m);
                        lay.addLayoutComponent(m, newName);
                        lay.show(menu_area, selectedCategory.getCategoryName());
                        selectedCategory.setBackground(ColorTheme.secondaryColor);
                        selectedCategory.getJLabelName().setForeground(ColorTheme.primaryColor);
                        break;
                    }
                }
                break;
            }
        }
    }
    
    
    public void removeReceipt()
    {
        r_content.removeAll();
        recalculateTotal();
        r_content.repaint();
        r_content.revalidate();
    }
    
    public void recalculateTotal()
    {
        double t = 0.0;
        for(Item_Receipt r : receipt)
        {
            t += r.getCurrentPrice();
            System.out.println(r.getCurrentPrice() + "");
        }
        setTaxAmount(t * POS_Constants.taxRate);
        setTotalAmount(t + getTaxAmount());
        System.out.println(getTaxAmount() + "---" + getTotalAmount());
        DecimalFormat df = new DecimalFormat("#.##");
        jl_tax.setText(df.format(getTaxAmount()));
        jl_total.setText(df.format(getTotalAmount()));
        jl_tax.repaint();        
        jl_tax.revalidate();
        jl_total.repaint();        
        jl_total.revalidate();
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        receipt_area = new javax.swing.JPanel();
        receipt_sp = new javax.swing.JScrollPane();
        r_container = new javax.swing.JPanel();
        r_content = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jl_total = new javax.swing.JLabel();
        jl_tax = new javax.swing.JLabel();
        jp_pay = new javax.swing.JPanel();
        jl_pay = new javax.swing.JLabel();
        menu_area = new javax.swing.JPanel();
        category_sp = new javax.swing.JScrollPane();
        c_container = new javax.swing.JPanel();
        c_content = new javax.swing.JPanel();

        setBackground(new java.awt.Color(197, 214, 222));
        setMaximumSize(new java.awt.Dimension(1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));
        setPreferredSize(new java.awt.Dimension(1200, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receipt_area.setBackground(new java.awt.Color(204, 204, 204));
        receipt_area.setMaximumSize(new java.awt.Dimension(510, 600));
        receipt_area.setMinimumSize(new java.awt.Dimension(510, 600));
        receipt_area.setPreferredSize(new java.awt.Dimension(510, 600));
        receipt_area.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receipt_sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        receipt_sp.setToolTipText("");
        receipt_sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        receipt_sp.setMaximumSize(new java.awt.Dimension(510, 400));
        receipt_sp.setMinimumSize(new java.awt.Dimension(510, 400));
        receipt_sp.setPreferredSize(new java.awt.Dimension(510, 400));
        receipt_sp.setViewportView(c_content);

        r_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        r_content.setOpaque(false);
        r_content.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        r_container.add(r_content);

        receipt_sp.setViewportView(r_container);

        receipt_area.add(receipt_sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Summary");
        receipt_area.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 510, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Price");
        receipt_area.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Total:");
        receipt_area.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Qty");
        receipt_area.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Description");
        receipt_area.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tax:");
        receipt_area.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 40, -1));

        jl_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_total.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jl_total.setText("0.0");
        receipt_area.add(jl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 240, -1));

        jl_tax.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_tax.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jl_tax.setText("0.0");
        receipt_area.add(jl_tax, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 240, -1));

        jp_pay.setBackground(new java.awt.Color(22, 36, 49));

        jl_pay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_pay.setForeground(new java.awt.Color(255, 255, 255));
        jl_pay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_pay.setText("PAY");
        jl_pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jl_payMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jp_payLayout = new javax.swing.GroupLayout(jp_pay);
        jp_pay.setLayout(jp_payLayout);
        jp_payLayout.setHorizontalGroup(
            jp_payLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_pay, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jp_payLayout.setVerticalGroup(
            jp_payLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_pay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        receipt_area.add(jp_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 590, 90, 30));

        add(receipt_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 510, 630));

        menu_area.setBackground(new java.awt.Color(197, 214, 222));
        menu_area.setPreferredSize(new java.awt.Dimension(660, 550));
        menu_area.setLayout(new java.awt.CardLayout());
        add(menu_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        category_sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        category_sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        category_sp.setPreferredSize(new java.awt.Dimension(660, 30));
        category_sp.setViewportView(c_content);

        c_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        c_content.setOpaque(false);
        c_content.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        c_container.add(c_content);

        category_sp.setViewportView(c_container);

        add(category_sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jl_payMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_payMouseReleased
        // TODO add your handling code here:
        try {
            if(receipt.size()> 0)
            {
                JOP_Pay pay = new JOP_Pay();
                int value = JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor(this),
                                pay,
                                "Pay",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE);

                if(value == JOptionPane.OK_OPTION && !pay.cash.getText().isEmpty())
                {
                    double amount = Double.parseDouble(pay.cash.getText());
                    double change = amount - Double.parseDouble(jl_total.getText());
                    if(amount > Double.parseDouble(jl_total.getText()))
                    {
                        JOP_Receipt rec = new JOP_Receipt(Database.currentUser,Double.parseDouble(jl_total.getText()),change,Double.parseDouble(jl_tax.getText()),amount,receipt);
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                                        rec,
                                        "Receipt", JOptionPane.DEFAULT_OPTION);
                    }
                    
                    receipt.clear();
                    removeReceipt();
                }
                }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jl_payMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel c_container;
    private javax.swing.JPanel c_content;
    private javax.swing.JScrollPane category_sp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jl_pay;
    public javax.swing.JLabel jl_tax;
    public javax.swing.JLabel jl_total;
    private javax.swing.JPanel jp_pay;
    private javax.swing.JPanel menu_area;
    private javax.swing.JPanel r_container;
    public javax.swing.JPanel r_content;
    private javax.swing.JPanel receipt_area;
    private javax.swing.JScrollPane receipt_sp;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getComponent() instanceof Item_Category)
        {
            Item_Category t = (Item_Category) e.getComponent();
            if(selectedCategory != null)
            {
                selectedCategory.setBackground(ColorTheme.primaryColor);
                selectedCategory.getJLabelName().setForeground(ColorTheme.secondaryColor);
            }
            selectedCategory = t;
            selectedCategory.setBackground(ColorTheme.highlightColor);
            selectedCategory.getJLabelName().setForeground(ColorTheme.secondaryColor);
            CardLayout c = (CardLayout)menu_area.getLayout();
            c.show(menu_area, t.getCategoryName());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
