/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.stub;

import java.util.List;

/**
 *
 * @author hallgato
 */
public class GuitarOwnerStub {
    
    private String name;
    private String email;
    private List<GuitarStub> guitars;

    public GuitarOwnerStub() {
    }

    public GuitarOwnerStub(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public GuitarOwnerStub(String name, String email, List<GuitarStub> guitars) {
        this.name = name;
        this.email = email;
        this.guitars = guitars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GuitarStub> getGuitars() {
        return guitars;
    }

    public void setGuitars(List<GuitarStub> guitars) {
        this.guitars = guitars;
    }

    @Override
    public String toString() {
        return "GuitarOwnerStub{" + "name=" + name + ", email=" + email + ", guitars=" + guitars + '}';
    }
    
}
