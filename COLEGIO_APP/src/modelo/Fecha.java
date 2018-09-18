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
public class Fecha implements Serializable{

    private static final long serialVersionUID = 14L;
    private int dia;
    private int mes;
    private int anio;
    
    /**
     * Imprime /
     */
    public static final int FORMATO_FECHA_DIAG = 1;
    
    /**
     * Imprime -
     */
    public static final int FORMATO_FECHA_LIN = 2;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public String getString(int formato){
        if (formato == FORMATO_FECHA_DIAG){
            return this.dia + "/" + this.mes + "/" + this.anio + "";
        } else if (formato == FORMATO_FECHA_LIN){
            return this.dia + "-" + this.mes + "-" + this.anio + "";
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.dia;
        hash = 13 * hash + this.mes;
        hash = 13 * hash + this.anio;
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
        final Fecha other = (Fecha) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fecha{" + "dia=" + dia + ", mes=" + mes + ", anio=" + anio + '}';
    }
    
    
}
