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
import java.util.ArrayList;

/**
 *
 * @author reden
 */
public class JP_Menu extends javax.swing.JPanel implements MouseListener{

    private Item_Category selectedCategory = null;
    private ArrayList<Item_Receipt> receipt;
    private ArrayList<Item_Category> category;    
    private ArrayList<JP_MenuCard> menuCard;
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
        this.receipt = new ArrayList<>();
        this.category = new ArrayList<>();
        this.menuCard = new ArrayList<>();
        this.setBackground(ColorTheme.secondaryColor);
        receipt_area.setBackground(ColorTheme.secondaryColor);
        menu_area.setBackground(ColorTheme.secondaryColor);
        c_container.setBackground(ColorTheme.secondaryColor);
        c_content.setBackground(ColorTheme.secondaryColor);
        category_sp.setBackground(ColorTheme.secondaryColor);
        receipt_sp.setBackground(ColorTheme.secondaryColor);
        r_container.setBackground(ColorTheme.secondaryColor);
        r_content.setBackground(ColorTheme.secondaryColor);
        
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
        Item_Category temp = new Item_Category(categoryName);
        temp.addMouseListener(this);
        c_content.add(temp);
        c_content.repaint();
        c_content.revalidate();
        JP_MenuCard tmc = new JP_MenuCard(this, categoryName);
        menu_area.add(tmc, categoryName);
        menuCard.add(tmc);
        if(category.size() < 1)
        {
            selectedCategory = temp;
            selectedCategory.setBackground(ColorTheme.secondaryColor);
            selectedCategory.getJLabelName().setForeground(ColorTheme.primaryColor);
            CardLayout c = (CardLayout)menu_area.getLayout();
            c.show(menu_area, categoryName);
        }
        category.add(temp);
    }
    
    public void deleteCategory(String categoryName)
    {
        for (Item_Category c : category) {
            if(c.getCategoryName().equals(categoryName))
            {
                for(JP_MenuCard m : menuCard)
                {
                    if(m.getCategoryName().equals(categoryName))
                    {
                        CardLayout lay = (CardLayout)menu_area.getLayout();
                        lay.removeLayoutComponent(m);
                        menuCard.remove(m);
                        break;
                    }
                }
                c_content.remove(c);
                c_content.repaint();
                c_content.revalidate();
                category.remove(c);
                break;
            }
        }
    }
    
    public void editCategory(String oldName, String newName)
    {
        for (Item_Category c : category) {
            if(c.getCategoryName().equals(oldName))
            {
                c.setCategory(newName);
                for(JP_MenuCard m : menuCard)
                {
                    if(m.getCategoryName().equals(oldName))
                    {
                        m.setCategoryName(newName);
                        CardLayout lay = (CardLayout)menu_area.getLayout();
                        lay.removeLayoutComponent(m);
                        lay.addLayoutComponent(m, newName);
                        lay.show(menu_area, selectedCategory.getCategoryName());
                        break;
                    }
                   
                }
  
                break;
            }
        }
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
        jp_voucher = new javax.swing.JPanel();
        jl_voucher = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jl_total1 = new javax.swing.JLabel();
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
        receipt_area.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Qty");
        receipt_area.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Description");
        receipt_area.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tax:");
        receipt_area.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 40, -1));

        jl_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_total.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jl_total.setText("0.00");
        receipt_area.add(jl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 80, -1));

        jl_tax.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_tax.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jl_tax.setText("0.00");
        receipt_area.add(jl_tax, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 80, -1));

        jp_pay.setBackground(new java.awt.Color(22, 36, 49));

        jl_pay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_pay.setForeground(new java.awt.Color(255, 255, 255));
        jl_pay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_pay.setText("PAY");

        javax.swing.GroupLayout jp_payLayout = new javax.swing.GroupLayout(jp_pay);
        jp_pay.setLayout(jp_payLayout);
        jp_payLayout.setHorizontalGroup(
            jp_payLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_pay, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jp_payLayout.setVerticalGroup(
            jp_payLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_pay, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        receipt_area.add(jp_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 590, 90, 30));

        jp_voucher.setBackground(new java.awt.Color(22, 36, 49));

        jl_voucher.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_voucher.setForeground(new java.awt.Color(255, 255, 255));
        jl_voucher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_voucher.setText("VOUCHER");

        javax.swing.GroupLayout jp_voucherLayout = new javax.swing.GroupLayout(jp_voucher);
        jp_voucher.setLayout(jp_voucherLayout);
        jp_voucherLayout.setHorizontalGroup(
            jp_voucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_voucher, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jp_voucherLayout.setVerticalGroup(
            jp_voucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_voucher, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        receipt_area.add(jp_voucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 590, 90, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Discount:");
        receipt_area.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, -1));

        jl_total1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_total1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jl_total1.setText("0.00");
        receipt_area.add(jl_total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 80, -1));

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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jl_pay;
    public javax.swing.JLabel jl_tax;
    public javax.swing.JLabel jl_total;
    public javax.swing.JLabel jl_total1;
    private javax.swing.JLabel jl_voucher;
    private javax.swing.JPanel jp_pay;
    private javax.swing.JPanel jp_voucher;
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
            selectedCategory.setBackground(ColorTheme.secondaryColor);
            selectedCategory.getJLabelName().setForeground(ColorTheme.primaryColor);
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
