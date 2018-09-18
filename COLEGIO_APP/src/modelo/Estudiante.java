/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.interfaces.IEstudiante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Carlos
 */
public class Estudiante extends Persona implements IEstudiante, Serializable{

    private static final long serialVersionUID = 13L;
    private int codigo;
    private Fecha fechaNam;
    private Direccion direccion;
    private String rh;
    private float promedio;
    private Fecha fechaInscripcion;
    private String estadoInscripcion;
    private Ruta ruta;
    private EPS eps;
    private ArrayList<Deuda> deudas;
    private Acudiente[] acudientes;
    private Curso curso;

    public Estudiante(int codigo, Fecha fechaNam, Direccion direccion, String rh, Fecha fechaInscripcion, String estadoInscripcion, EPS eps, long documento, String tipo_documento, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, int edad, char genero, long telefono, Acudiente[] acudientes, Curso curso, String usuario, String clave) {
        super(documento, tipo_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, edad, genero, telefono, usuario, clave);
        this.codigo = codigo;
        this.fechaNam = fechaNam;
        this.direccion = direccion;
        this.rh = rh;
        this.fechaInscripcion = fechaInscripcion;
        this.estadoInscripcion = estadoInscripcion;
        this.eps = eps;
        this.acudientes = acudientes;
        this.curso = curso;
        this.deudas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Fecha getFechaNam() {
        return fechaNam;
    }

    public void setFechaNam(Fecha fechaNam) {
        this.fechaNam = fechaNam;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public Fecha getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Fecha fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(String estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public EPS getEps() {
        return eps;
    }

    public void setEps(EPS eps) {
        this.eps = eps;
    }

    public ArrayList<Deuda> getDeudas() {
        return deudas;
    }

    public void setDeudas(ArrayList<Deuda> deudas) {
        this.deudas = deudas;
    }

    public Acudiente[] getAcudientes() {
        return acudientes;
    }

    public void setAcudientes(Acudiente[] acudientes) {
        this.acudientes = acudientes;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + Objects.hashCode(this.fechaNam);
        hash = 37 * hash + Objects.hashCode(this.direccion);
        hash = 37 * hash + Objects.hashCode(this.rh);
        hash = 37 * hash + Float.floatToIntBits(this.promedio);
        hash = 37 * hash + Objects.hashCode(this.fechaInscripcion);
        hash = 37 * hash + Objects.hashCode(this.estadoInscripcion);
        hash = 37 * hash + Objects.hashCode(this.ruta);
        hash = 37 * hash + Objects.hashCode(this.eps);
        hash = 37 * hash + Objects.hashCode(this.deudas);
        hash = 37 * hash + Arrays.deepHashCode(this.acudientes);
        hash = 37 * hash + Objects.hashCode(this.curso);
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
        final Estudiante other = (Estudiante) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Float.floatToIntBits(this.promedio) != Float.floatToIntBits(other.promedio)) {
            return false;
        }
        if (!Objects.equals(this.rh, other.rh)) {
            return false;
        }
        if (!Objects.equals(this.estadoInscripcion, other.estadoInscripcion)) {
            return false;
        }
        if (!Objects.equals(this.fechaNam, other.fechaNam)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.fechaInscripcion, other.fechaInscripcion)) {
            return false;
        }
        if (!Objects.equals(this.ruta, other.ruta)) {
            return false;
        }
        if (!Objects.equals(this.eps, other.eps)) {
            return false;
        }
        if (!Objects.equals(this.deudas, other.deudas)) {
            return false;
        }
        if (!Arrays.deepEquals(this.acudientes, other.acudientes)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "codigo=" + codigo + ", fechaNam=" + fechaNam + ", direccion=" + direccion + ", rh=" + rh + ", promedio=" + promedio + ", fechaInscripcion=" + fechaInscripcion + ", estadoInscripcion=" + estadoInscripcion + ", ruta=" + ruta + ", eps=" + eps + ", deudas=" + deudas + ", acudientes=" + acudientes + ", curso=" + curso + '}';
    }

    
}
