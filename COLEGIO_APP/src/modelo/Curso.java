/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Carlos
 */
public class Curso implements Serializable{

    private static final long serialVersionUID = 6L;
    private int numCurso;
    private int capacidadMaxima;
    private int grado;
    private Docente directorCurso;
    private Materia[] materias;

    public Curso(int numCurso, int capacidadMaxima, int grado, Docente directorCurso, Materia[] materias) {
        this.numCurso = numCurso;
        this.capacidadMaxima = capacidadMaxima;
        this.grado = grado;
        this.directorCurso = directorCurso;
        this.materias = materias;
    }

    public int getNumCurso() {
        return numCurso;
    }

    public void setNumCurso(int numCurso) {
        this.numCurso = numCurso;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public Docente getDirectorCurso() {
        return directorCurso;
    }

    public void setDirectorCurso(Docente directorCurso) {
        this.directorCurso = directorCurso;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.numCurso;
        hash = 41 * hash + this.capacidadMaxima;
        hash = 41 * hash + this.grado;
        hash = 41 * hash + Objects.hashCode(this.directorCurso);
        hash = 41 * hash + Arrays.deepHashCode(this.materias);
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
        final Curso other = (Curso) obj;
        if (this.numCurso != other.numCurso) {
            return false;
        }
        if (this.capacidadMaxima != other.capacidadMaxima) {
            return false;
        }
        if (this.grado != other.grado) {
            return false;
        }
        if (!Objects.equals(this.directorCurso, other.directorCurso)) {
            return false;
        }
        if (!Arrays.deepEquals(this.materias, other.materias)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "numCurso=" + numCurso + ", capacidadMaxima=" + capacidadMaxima + ", grado=" + grado + ", directorCurso=" + directorCurso + ", materias=" + materias + '}';
    }
    
    
    
}
