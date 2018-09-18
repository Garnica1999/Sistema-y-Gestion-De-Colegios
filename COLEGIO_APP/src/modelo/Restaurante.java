/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Carlos
 */
public class Restaurante implements Serializable{

    private static final long serialVersionUID = 23L;
    private String nombreRestaurante;
    private ArrayList<PersonalServicio> trabajadores;
    private ArrayList<Estudiante> estudIns;
    private Menu menuDia;

    public Restaurante(String nombreRestaurante, ArrayList<PersonalServicio> trabajadores, ArrayList<Estudiante> estudIns, Menu menuDia) {
        this.nombreRestaurante = nombreRestaurante;
        this.trabajadores = trabajadores;
        this.estudIns = estudIns;
        this.menuDia = menuDia;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public ArrayList<PersonalServicio> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<PersonalServicio> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public ArrayList<Estudiante> getEstudIns() {
        return estudIns;
    }

    public void setEstudIns(ArrayList<Estudiante> estudIns) {
        this.estudIns = estudIns;
    }

    public Menu getMenuDia() {
        return menuDia;
    }

    public void setMenuDia(Menu menuDia) {
        this.menuDia = menuDia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nombreRestaurante);
        hash = 13 * hash + Objects.hashCode(this.trabajadores);
        hash = 13 * hash + Objects.hashCode(this.estudIns);
        hash = 13 * hash + Objects.hashCode(this.menuDia);
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
        final Restaurante other = (Restaurante) obj;
        if (!Objects.equals(this.nombreRestaurante, other.nombreRestaurante)) {
            return false;
        }
        if (!Objects.equals(this.trabajadores, other.trabajadores)) {
            return false;
        }
        if (!Objects.equals(this.estudIns, other.estudIns)) {
            return false;
        }
        if (!Objects.equals(this.menuDia, other.menuDia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "nombreRestaurante=" + nombreRestaurante + ", trabajadores=" + trabajadores + ", estudIns=" + estudIns + ", menuDia=" + menuDia + '}';
    }

    
    
    
}
