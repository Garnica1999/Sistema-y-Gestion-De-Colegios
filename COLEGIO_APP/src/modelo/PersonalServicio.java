/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Carlos
 */
public class PersonalServicio extends Trabajador implements Serializable{

    private static final long serialVersionUID = 22L;
    private int numeroContrato;

    public PersonalServicio(int numeroContrato, double salario, String cargo, Departamento departamento, long documento, String tipoDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int edad, char genero, long telefono, String usuario, String clave) {
        super(salario, cargo, departamento, documento, tipoDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, edad, genero, telefono, usuario, clave);
        this.numeroContrato = numeroContrato;
    }

    public PersonalServicio(int numeroContrato, double salario, Departamento departamento, long documento, String tipoDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int edad, char genero, long telefono, String usuario, String clave) {
        super(salario, departamento, documento, tipoDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, edad, genero, telefono, usuario, clave);
        this.numeroContrato = numeroContrato;
    }
    
    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.numeroContrato;
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
        final PersonalServicio other = (PersonalServicio) obj;
        if (this.numeroContrato != other.numeroContrato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonalServicio{" + "numero_cotnrato=" + numeroContrato + '}';
    }
    
    
}
