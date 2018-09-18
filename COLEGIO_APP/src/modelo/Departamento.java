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
public class Departamento implements Serializable{

    private static final long serialVersionUID = 7L;
    private String nombreDpto;
    private String descripcion;
    private Persona encargado;

    public Departamento(String nombreDpto, String descripcion, Persona encargado) {
        this.nombreDpto = nombreDpto;
        this.descripcion = descripcion;
        this.encargado = encargado;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getEncargado() {
        return encargado;
    }

    public void setEncargado(Persona encargado) {
        this.encargado = encargado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombreDpto);
        hash = 59 * hash + Objects.hashCode(this.descripcion);
        hash = 59 * hash + Objects.hashCode(this.encargado);
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
        final Departamento other = (Departamento) obj;
        if (!Objects.equals(this.nombreDpto, other.nombreDpto)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.encargado, other.encargado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamento{" + "nombreDpto=" + nombreDpto + ", descripcion=" + descripcion + ", encargado=" + encargado + '}';
    }
    
    
}
