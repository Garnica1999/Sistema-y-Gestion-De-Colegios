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
public class MateriaBase implements Serializable{

    private static final long serialVersionUID = 17L;
    private String nombreMateria;
    private String descripcion;
    private Area area;

    public MateriaBase(String nombreMateria, String descripcion, Area area) {
        this.nombreMateria = nombreMateria;
        this.descripcion = descripcion;
        this.area = area;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombreMateria);
        hash = 59 * hash + Objects.hashCode(this.descripcion);
        hash = 59 * hash + Objects.hashCode(this.area);
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
        final MateriaBase other = (MateriaBase) obj;
        if (!Objects.equals(this.nombreMateria, other.nombreMateria)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MateriaBase{" + "nombreMateria=" + nombreMateria + ", descripcion=" + descripcion + ", nombreArea=" + area + '}';
    }
    
}
