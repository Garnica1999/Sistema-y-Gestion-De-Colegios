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
public class Nota implements Serializable{

    private static final long serialVersionUID = 19L;
    private long idNota;
    private Estudiante estudiante;
    private Docente docenteCalificador;
    private Materia materia;
    private Periodo periodo;
    private double nota;

    public Nota(long idNota, Estudiante estudiante, Docente docenteCalificador, Materia materia, Periodo periodo, double nota) {
        this.idNota = idNota;
        this.estudiante = estudiante;
        this.docenteCalificador = docenteCalificador;
        this.materia = materia;
        this.periodo = periodo;
        this.nota = nota;
    }

    public long getIdNota() {
        return idNota;
    }

    public void setIdNota(long idNota) {
        this.idNota = idNota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Docente getDocenteCalificador() {
        return docenteCalificador;
    }

    public void setDocenteCalificador(Docente docenteCalificador) {
        this.docenteCalificador = docenteCalificador;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.idNota ^ (this.idNota >>> 32));
        hash = 83 * hash + Objects.hashCode(this.estudiante);
        hash = 83 * hash + Objects.hashCode(this.docenteCalificador);
        hash = 83 * hash + Objects.hashCode(this.materia);
        hash = 83 * hash + Objects.hashCode(this.periodo);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.nota) ^ (Double.doubleToLongBits(this.nota) >>> 32));
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
        final Nota other = (Nota) obj;
        if (this.idNota != other.idNota) {
            return false;
        }
        if (Double.doubleToLongBits(this.nota) != Double.doubleToLongBits(other.nota)) {
            return false;
        }
        if (!Objects.equals(this.estudiante, other.estudiante)) {
            return false;
        }
        if (!Objects.equals(this.docenteCalificador, other.docenteCalificador)) {
            return false;
        }
        if (!Objects.equals(this.materia, other.materia)) {
            return false;
        }
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", estudiante=" + estudiante + ", docenteCalificador=" + docenteCalificador + ", materia=" + materia + ", periodo=" + periodo + ", nota=" + nota + '}';
    }
    
    
    
}
