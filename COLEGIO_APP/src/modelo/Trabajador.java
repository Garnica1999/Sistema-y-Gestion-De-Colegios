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
public class Trabajador extends Persona implements Serializable{

    private static final long serialVersionUID = 25L;
    private double salario;
    private String cargo;
    private Departamento departamento;

    public Trabajador(double salario, String cargo, Departamento departamento, long documento, String tipoDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int edad, char genero, long telefono, String usuario, String clave) {
        super(documento, tipoDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, edad, genero, telefono, usuario, clave);
        this.salario = salario;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public Trabajador(double salario, Departamento departamento, long documento, String tipoDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int edad, char genero, long telefono, String usuario, String clave) {
        super(documento, tipoDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, edad, genero, telefono, usuario, clave);
        this.salario = salario;
        this.departamento = departamento;
    }

    


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.cargo);
        hash = 37 * hash + Objects.hashCode(this.departamento);
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
        final Trabajador other = (Trabajador) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "salario=" + salario + ", cargo=" + cargo + ", departamento=" + departamento + '}';
    }
    
    
}
