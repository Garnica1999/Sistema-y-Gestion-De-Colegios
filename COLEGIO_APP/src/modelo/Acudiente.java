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
public class Acudiente extends Persona implements Serializable{

    private static final long serialVersionUID = 3L;
    private int idAcudiente;
    private String Parentesco;

    public Acudiente(int idAcudiente, String Parentesco, long documento, String tipoDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int edad, char genero, long telefono, String usuario, String clave) {
        super(documento, tipoDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, edad, genero, telefono, usuario, clave);
        this.idAcudiente = idAcudiente;
        this.Parentesco = Parentesco;
    }

    

    public int getIdAcudiente() {
        return idAcudiente;
    }

    public void setIdAcudiente(int idAcudiente) {
        this.idAcudiente = idAcudiente;
    }

    public String getParentesco() {
        return Parentesco;
    }

    public void setParentesco(String Parentesco) {
        this.Parentesco = Parentesco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idAcudiente;
        hash = 97 * hash + Objects.hashCode(this.Parentesco);
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
        final Acudiente other = (Acudiente) obj;
        if (this.idAcudiente != other.idAcudiente) {
            return false;
        }
        if (!Objects.equals(this.Parentesco, other.Parentesco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Acudiente{" + "idAcudiente=" + idAcudiente + ", Parentesco=" + Parentesco + '}';
    }
    
    
}
