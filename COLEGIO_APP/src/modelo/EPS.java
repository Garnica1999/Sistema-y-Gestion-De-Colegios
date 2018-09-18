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
public class EPS implements Serializable{

    private static final long serialVersionUID = 12L;
    private String nombreEPS;
    private long telefono;
    private Direccion direccionEPS;

    public EPS(String nombreEPS, long telefono, Direccion direccionEPS) {
        this.nombreEPS = nombreEPS;
        this.telefono = telefono;
        this.direccionEPS = direccionEPS;
    }

    public String getNombreEPS() {
        return nombreEPS;
    }

    public void setNombreEPS(String nombreEPS) {
        this.nombreEPS = nombreEPS;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccionEPS() {
        return direccionEPS;
    }

    public void setDireccionEPS(Direccion direccionEPS) {
        this.direccionEPS = direccionEPS;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nombreEPS);
        hash = 67 * hash + (int) (this.telefono ^ (this.telefono >>> 32));
        hash = 67 * hash + Objects.hashCode(this.direccionEPS);
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
        final EPS other = (EPS) obj;
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombreEPS, other.nombreEPS)) {
            return false;
        }
        if (!Objects.equals(this.direccionEPS, other.direccionEPS)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EPS{" + "nombreEPS=" + nombreEPS + ", telefono=" + telefono + ", direccionEPS=" + direccionEPS + '}';
    }
    
    
}
