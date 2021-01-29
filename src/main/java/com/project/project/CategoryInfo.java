/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.project;

import java.util.ArrayList;

/**
 *
 * @author Nouelle
 */
public class CategoryInfo {
    
    private String name;
    private ArrayList<MenuInfo> menus = new ArrayList<>();

    public void setMenus(ArrayList<MenuInfo> menus) {
        this.menus = menus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MenuInfo> getMenus() {
        return menus;
    }
    
    public CategoryInfo(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
   
    
}
