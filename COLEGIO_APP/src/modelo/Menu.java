/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Carlos
 */
public class Menu implements Serializable{

    private static final long serialVersionUID = 18L;
    private int idMenu;
    private String jugo;
    private String postre;
    private String sopa;
    private String principal;
    private Fecha fechaMenu;

    public Menu(int idMenu, String jugo, String postre, String sopa, String principal, Fecha fechaMenu) {
        this.idMenu = idMenu;
        this.jugo = jugo;
        this.postre = postre;
        this.sopa = sopa;
        this.principal = principal;
        this.fechaMenu = fechaMenu;
    }

    public Menu(int idMenu, String jugo, String principal, Fecha fechaMenu) {
        this.idMenu = idMenu;
        this.jugo = jugo;
        this.principal = principal;
        this.fechaMenu = fechaMenu;
    }

    public Menu(int idMenu, String jugo, String postre, String principal, Fecha fechaMenu) {
        this.idMenu = idMenu;
        this.jugo = jugo;
        this.postre = postre;
        this.principal = principal;
        this.fechaMenu = fechaMenu;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getJugo() {
        return jugo;
    }

    public void setJugo(String jugo) {
        this.jugo = jugo;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }

    public String getSopa() {
        return sopa;
    }

    public void setSopa(String sopa) {
        this.sopa = sopa;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Fecha getFechaMenu() {
        return fechaMenu;
    }

    public void setFechaMenu(Fecha fechaMenu) {
        this.fechaMenu = fechaMenu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idMenu;
        hash = 29 * hash + Objects.hashCode(this.jugo);
        hash = 29 * hash + Objects.hashCode(this.postre);
        hash = 29 * hash + Objects.hashCode(this.sopa);
        hash = 29 * hash + Objects.hashCode(this.principal);
        hash = 29 * hash + Objects.hashCode(this.fechaMenu);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        if (this.idMenu != other.idMenu) {
            return false;
        }
        if (!Objects.equals(this.jugo, other.jugo)) {
            return false;
        }
        if (!Objects.equals(this.postre, other.postre)) {
            return false;
        }
        if (!Objects.equals(this.sopa, other.sopa)) {
            return false;
        }
        if (!Objects.equals(this.principal, other.principal)) {
            return false;
        }
        if (!Objects.equals(this.fechaMenu, other.fechaMenu)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "idMenu=" + idMenu + ", jugo=" + jugo + ", postre=" + postre + ", sopa=" + sopa + ", principal=" + principal + ", fechaMenu=" + fechaMenu + '}';
    }
    
    
    
}
