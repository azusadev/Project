/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.project;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author reden
 */
public class JP_MenuCard extends javax.swing.JPanel implements MouseListener{

    private JP_Menu parentMenu = null;
    private String categoryName;
    /**
     * Creates new form JP_MenuCard
     */
    public JP_MenuCard() {
        initComponents();
        this.setBackground(ColorTheme.secondaryColor);
        m_container.setBackground(ColorTheme.secondaryColor);
        m_content.setBackground(ColorTheme.secondaryColor);

    }
    
    public JP_MenuCard(JP_Menu panel, String name) {
        initComponents();
                //setting category scroll pane
        this.setBackground(ColorTheme.secondaryColor);
        m_container.setBackground(ColorTheme.secondaryColor);
        m_content.setBackground(ColorTheme.secondaryColor);
        menu_sp.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        menu_sp.getVerticalScrollBar().setUnitIncrement(36);
        menu_sp.getViewport().setBorder(null);
        menu_sp.setViewportBorder(null);
        menu_sp.setBorder(null);
        categoryName = name;
        parentMenu = panel;
        for (int i = 0; i < 30; i++) {
            Item_Menu temp = new Item_Menu(categoryName + " Menu no." + (i+1), 200.00*(i+1));
            temp.addMouseListener(this);
            m_content.add(temp);
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

        menu_sp = new javax.swing.JScrollPane();
        m_container = new javax.swing.JPanel();
        m_content = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(660, 550));
        setMinimumSize(new java.awt.Dimension(660, 550));
        setPreferredSize(new java.awt.Dimension(660, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu_sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        menu_sp.setMaximumSize(new java.awt.Dimension(660, 550));
        menu_sp.setMinimumSize(new java.awt.Dimension(660, 550));
        menu_sp.setPreferredSize(new java.awt.Dimension(660, 550));

        m_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        m_content.setLayout(new java.awt.GridLayout(0, 3, 10, 10));
        m_container.add(m_content);

        menu_sp.setViewportView(m_container);

        add(menu_sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel m_container;
    private javax.swing.JPanel m_content;
    private javax.swing.JScrollPane menu_sp;
    // End of variables declaration//GEN-END:variables

    
    public void removeReceipt(String name)
    {
        for (int i = 0; i < parentMenu.getReceipt().size(); i++) {
            if(parentMenu.getReceipt().get(i).getMenuName().equals(name))
            {
                System.out.println( parentMenu.getReceipt().get(i).getMenuName() + " FOUND AND DELETED!");
                parentMenu.r_content.remove(parentMenu.getReceipt().get(i));
                parentMenu.getReceipt().remove(i);
                break;
            }
        }
        recalculateTotal();
        parentMenu.r_content.repaint();
        parentMenu.r_content.revalidate();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getComponent() instanceof Item_Menu)
        {
            Item_Menu temp = (Item_Menu) e.getComponent();
            Item_Receipt t = new Item_Receipt(this, temp.getMenuName(), temp.getMenuPrice());
            System.out.println(temp.getMenuName() + " -- " + temp.getMenuPrice());
            boolean got = false;
            for (int i = 0; i < parentMenu.getReceipt().size(); i++) {
                if(parentMenu.getReceipt().get(i).getMenuName().equals(t.getMenuName()))
                {
                    parentMenu.getReceipt().get(i).addQuantity();
                    got = true;
                    break;
                }
            }
            if(!got) 
            {
                parentMenu.getReceipt().add(t);
                parentMenu.r_content.add(t);
            }
            recalculateTotal();
            parentMenu.r_content.repaint();
            parentMenu.r_content.revalidate();
        }
    }

    public void recalculateTotal()
    {
        double t = 0.0;
        for(Item_Receipt r : parentMenu.getReceipt())
        {
            t += r.getCurrentPrice();
            System.out.println(r.getCurrentPrice() + "");
        }
        parentMenu.setTaxAmount(t * POS_Constants.taxRate);
        parentMenu.setTotalAmount(t - parentMenu.getTaxAmount());
        System.out.println(parentMenu.getTaxAmount() + "---" + parentMenu.getTotalAmount());
        parentMenu.jl_tax.setText(parentMenu.getTaxAmount() + "");
        parentMenu.jl_total.setText(parentMenu.getTotalAmount() + "");
        parentMenu.jl_tax.repaint();        
        parentMenu.jl_tax.revalidate();
        parentMenu.jl_total.repaint();        
        parentMenu.jl_total.revalidate();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
