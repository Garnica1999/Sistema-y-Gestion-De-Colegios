/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Carlos
 */
public class ActividadExtra implements Serializable{

    private static final long serialVersionUID = 2L;
    private int numActividad;
    private int salon;
    private String horaInicio;
    private String horafin;
    private String diasActividad[];
    private int limEdad;

    public ActividadExtra(int numActividad, int salon, String horaInicio, String horafin, String[] diasActividad) {
        this.numActividad = numActividad;
        this.salon = salon;
        this.horaInicio = horaInicio;
        this.horafin = horafin;
        this.diasActividad = diasActividad;
        this.limEdad = -1;
    }

    public ActividadExtra(int numActividad, int salon, String horaInicio, String horafin, String[] diasActividad, int limEdad) {
        this.numActividad = numActividad;
        this.salon = salon;
        this.horaInicio = horaInicio;
        this.horafin = horafin;
        this.diasActividad = diasActividad;
        this.limEdad = limEdad;
    }

    public int getNumActividad() {
        return numActividad;
    }

    public void setNumActividad(int numActividad) {
        this.numActividad = numActividad;
    }

    public int getSalon() {
        return salon;
    }

    public void setSalon(int salon) {
        this.salon = salon;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public String[] getDiasActividad() {
        return diasActividad;
    }

    public void setDiasActividad(String[] diasActividad) {
        this.diasActividad = diasActividad;
    }

    public int getLimEdad() {
        return limEdad;
    }

    public void setLimEdad(int limEdad) {
        this.limEdad = limEdad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.numActividad;
        hash = 17 * hash + this.salon;
        hash = 17 * hash + Objects.hashCode(this.horaInicio);
        hash = 17 * hash + Objects.hashCode(this.horafin);
        hash = 17 * hash + Arrays.deepHashCode(this.diasActividad);
        hash = 17 * hash + this.limEdad;
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
        final ActividadExtra other = (ActividadExtra) obj;
        if (this.numActividad != other.numActividad) {
            return false;
        }
        if (this.salon != other.salon) {
            return false;
        }
        if (this.limEdad != other.limEdad) {
            return false;
        }
        if (!Objects.equals(this.horaInicio, other.horaInicio)) {
            return false;
        }
        if (!Objects.equals(this.horafin, other.horafin)) {
            return false;
        }
        if (!Arrays.deepEquals(this.diasActividad, other.diasActividad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actividad{" + "numActividad=" + numActividad + ", salon=" + salon + ", horaInicio=" + horaInicio + ", horafin=" + horafin + ", diasActividad=" + diasActividad + ", limEdad=" + limEdad + '}';
    }
    
    
    
    
}
