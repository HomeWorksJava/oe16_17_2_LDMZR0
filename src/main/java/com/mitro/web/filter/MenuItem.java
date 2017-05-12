/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.web.filter;

import java.io.Serializable;

/**
 *
 * @author hallgato
 */
public class MenuItem implements Serializable{
    
    private String menuName;
    private String resource;

    public MenuItem() {
    }

    public MenuItem(String menuName, String resource) {
        this.menuName = menuName;
        this.resource = resource;
    }
    
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
    
}
