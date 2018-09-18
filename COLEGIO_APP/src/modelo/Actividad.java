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
public class Actividad implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nombreActividad;
    private String descripcion;
    private Nota nota;

    public Actividad(String nombreNota, String descripcion, Nota nota) {
        this.nombreActividad = nombreNota;
        this.descripcion = descripcion;
        this.nota = nota;
    }
    
    public static Actividad agregarActividad(String nombreNota, String descripcion, Nota nota){
        return new Actividad(nombreNota, descripcion, nota);
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.nombreActividad);
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Objects.hashCode(this.nota);
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
        final Actividad other = (Actividad) obj;
        if (!Objects.equals(this.nombreActividad, other.nombreActividad)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.nota, other.nota)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actividad{" + "nombreNota=" + nombreActividad + ", descripcion=" + descripcion + ", nota=" + nota + '}';
    }
    
    
    
}
