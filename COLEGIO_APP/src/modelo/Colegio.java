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
public class Colegio implements Serializable{

    private static final long serialVersionUID = 5L;
    private String nombreColegio;
    private Fecha fechaFundacion;
    private String nit;
    private Interfaz interfaz;

    public Colegio(String nombreColegio, Fecha fechaFundacion, String nit, Interfaz interfaz) {
        this.nombreColegio = nombreColegio;
        this.fechaFundacion = fechaFundacion;
        this.nit = nit;
        this.interfaz = interfaz;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public Fecha getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Fecha fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombreColegio);
        hash = 59 * hash + Objects.hashCode(this.fechaFundacion);
        hash = 59 * hash + Objects.hashCode(this.nit);
        hash = 59 * hash + Objects.hashCode(this.interfaz);
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
        final Colegio other = (Colegio) obj;
        if (!Objects.equals(this.nombreColegio, other.nombreColegio)) {
            return false;
        }
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        if (!Objects.equals(this.fechaFundacion, other.fechaFundacion)) {
            return false;
        }
        if (!Objects.equals(this.interfaz, other.interfaz)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Colegio{" + "nombreColegio=" + nombreColegio + ", fechaFundacion=" + fechaFundacion + ", nit=" + nit + ", interfaz=" + interfaz + '}';
    }
    
    
}
