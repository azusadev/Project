/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author reden
 */
public class Database {
    public static JP_Menu mainMenu = null;
    public static JP_UpdateMenu dbMenu = null;
    public static ArrayList<CategoryInfo> categories = new ArrayList<>();
    public static ArrayList<CategoryInfo> loadCategories = new ArrayList<>();
    public static ArrayList<AccountInfo> accounts = new ArrayList<>();
    public static ArrayList<AccountInfo> loadAccounts = new ArrayList<>();
    
    public static void SaveAccount(String fileName)
    {
        System.out.println("SAVING!");
        if(!fileName.isEmpty())
        {
            try {
                File file = new File(fileName + ".txt");
                if(!file.exists()){
                    if(file.createNewFile())
                    {
                        System.out.println(fileName + " created!");
                    }
                }
                else
                {
                    //Saving to category file
                    FileWriter fw = new FileWriter(file);
                    for (int i = 0; i < accounts.size(); i++) {
                        fw.write(accounts.get(i).getUsername() + "," + accounts.get(i).getPassword() + "," + accounts.get(i).getType() + "\n");
                    }
                    fw.close();
                }
                
               
            } catch (IOException e) {
                
            }
        }
    }
   
    public static void LoadAccount(String fileName)
    {
        ArrayList<AccountInfo> a = new ArrayList<>();
        System.out.println("SAVING!");
        if(!fileName.isEmpty())
        {
            try {
                File file = new File(fileName + ".txt");
                if(!file.exists()){
                    if(file.createNewFile())
                    {
                        System.out.println(fileName + " created!");
                    }
                }
               
                Scanner sc = new Scanner(file);
                while(sc.hasNextLine())
                {
                    String[] s = sc.nextLine().split(",");
                    a.add(new AccountInfo(s[0],s[1],s[2]));
                }
            } catch (IOException e) {
                
            }
        }
        loadAccounts = a;
    }
   
    
    public static void SaveToFile(String fileName)
    {
        System.out.println("SAVING!");
        if(!fileName.isEmpty())
        {
            try {
                File file = new File(fileName + ".txt");
                if(!file.exists()){
                    if(file.createNewFile())
                    {
                        System.out.println(fileName + " created!");
                    }
                }
                else
                {
                    //Saving to category file
                    FileWriter fw = new FileWriter(file);
                    for (int i = 0; i < categories.size(); i++) {
                        fw.write(categories.get(i).getName() + "\n");
                        SaveToCategory(categories.get(i).getName());
                    }
                    fw.close();
                }
                
               
            } catch (IOException e) {
                
            }
        }
    }
    
    public static void DeleteFile(String fileName)
    {
        if(!fileName.isEmpty())
        {
            try {
                File file = new File(fileName + ".txt");
                if(file.exists()){
                    if( file.delete())
                    {
                        System.out.println(fileName + " DELETE SUCCESS!");                  
                    }
                }
                else
                {

                }
            } catch (Exception e) {
            }
        }
    }
    
    public static void SaveToCategory(String fileName)
    {
        if(!fileName.isEmpty())
        {
            try {
                File file = new File(fileName + ".txt");
                if(!file.exists()){
                    if(file.createNewFile())
                    {
                        System.out.println(fileName + " created!");
                    }
                }else
                {
                    
                }
                FileWriter fw = new FileWriter(file);
                for (int i = 0; i < categories.size(); i++) {
                    if(categories.get(i).getName().equals(fileName))
                    {
                        for (int j = 0; j < categories.get(i).getMenus().size(); j++) {
                            fw.write( categories.get(i).getMenus().get(j).getName() +"," + categories.get(i).getMenus().get(j).getPrice()+ "\n");
                        }
                        break;
                    }
                }
                fw.close();
            } catch (IOException e) {
                
            }
        }
    }
    
    public static void SaveToFile(String fileName, String categoryName)
    {
        if(!fileName.isEmpty())
        {
            try {
                File file = new File(fileName + ".txt");
                if(!file.exists()){
                    if(file.createNewFile())
                    {
                        System.out.println(fileName + " created!");
                    }
                }else
                {
                   
                }
                File f = new File(fileName + ".txt");
                Scanner sc = new Scanner(f);
                FileWriter fw = new FileWriter(file);
            } catch (IOException e) {
                
            }
        }
    }
    
    public static void LoadToFile(String fileName)
    {
        ArrayList<CategoryInfo> c = new ArrayList<>();
        if(!fileName.isEmpty())
        {
            try {
                File file = new File(fileName + ".txt");
                if(!file.exists())
                {
                    file.createNewFile();
                }

               
                Scanner sc = new Scanner(file);
                while(sc.hasNextLine())
                {
                    String s = sc.nextLine();
                    c.add(new CategoryInfo(s));
                }
                
                for (int i = 0; i < c.size(); i++) {
                    c.get(i).setMenus(LoadToMenu(c.get(i).getName()));
                }
            } catch (IOException e) {
                
            }
        }
        loadCategories = c;
    }
    
    public static ArrayList<MenuInfo> LoadToMenu(String categoryName)
    {
        ArrayList<MenuInfo> mi = new ArrayList<>();
        if(!categoryName.isEmpty())
        {
            try {
                File file = new File(categoryName + ".txt");
                if(!file.exists())
                {
                    file.createNewFile();
                }

               
                Scanner sc = new Scanner(file);
                while(sc.hasNextLine())
                {
                    String[] s = sc.nextLine().split(",");
                    MenuInfo m = new MenuInfo(s[0],Double.parseDouble(s[1]));
                    mi.add(m);
                }
            } catch (IOException e) {
                
            }
        }
        return mi;
    }
}
