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
public class Materia extends MateriaBase implements Serializable{

    private static final long serialVersionUID = 16L;
    private Docente docente;
    
    public Materia(Docente docente, String nombreMateria, String descripcion, Area nombreArea) {
        super(nombreMateria, descripcion, nombreArea);
        this.docente = docente;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.docente);
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
        final Materia other = (Materia) obj;
        if (!Objects.equals(this.docente, other.docente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Materia{" + "docente=" + docente + '}';
    }
   
    
    
    
}
