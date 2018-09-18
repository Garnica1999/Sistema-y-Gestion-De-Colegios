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
public class Area implements Serializable{

    private static final long serialVersionUID = 4L;
    private String nombreArea;
    private Docente docenteEncargado;

    public Area(String nombreArea, Docente docenteEncargado) {
        this.nombreArea = nombreArea;
        this.docenteEncargado = docenteEncargado;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public Docente getDocenteEncargado() {
        return docenteEncargado;
    }

    public void setDocenteEncargado(Docente docenteEncargado) {
        this.docenteEncargado = docenteEncargado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombreArea);
        hash = 97 * hash + Objects.hashCode(this.docenteEncargado);
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
        final Area other = (Area) obj;
        if (!Objects.equals(this.nombreArea, other.nombreArea)) {
            return false;
        }
        if (!Objects.equals(this.docenteEncargado, other.docenteEncargado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Area{" + "nombreArea=" + nombreArea + ", docenteEncargado=" + docenteEncargado + '}';
    }

    
    
    
}
