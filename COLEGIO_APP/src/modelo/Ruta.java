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
public class Ruta implements Serializable{

    private static final long serialVersionUID = 24L;
    private int idRuta;
    private String placa;
    private String localidad;
    private int capacidad;
    private Fecha fecha_ultimo_mantenimiento;

    public Ruta(int idRuta, String placa, String localidad, int capacidad) {
        this.idRuta = idRuta;
        this.placa = placa;
        this.localidad = localidad;
        this.capacidad = capacidad;
    }

    public Ruta(int idRuta, String placa, String localidad, int capacidad, Fecha fecha_ultimo_mantenimiento) {
        this.idRuta = idRuta;
        this.placa = placa;
        this.localidad = localidad;
        this.capacidad = capacidad;
        this.fecha_ultimo_mantenimiento = fecha_ultimo_mantenimiento;
    }

    
    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Fecha getFecha_ultimo_mantenimiento() {
        return fecha_ultimo_mantenimiento;
    }

    public void setFecha_ultimo_mantenimiento(Fecha fecha_ultimo_mantenimiento) {
        this.fecha_ultimo_mantenimiento = fecha_ultimo_mantenimiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idRuta;
        hash = 41 * hash + Objects.hashCode(this.placa);
        hash = 41 * hash + Objects.hashCode(this.localidad);
        hash = 41 * hash + this.capacidad;
        hash = 41 * hash + Objects.hashCode(this.fecha_ultimo_mantenimiento);
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
        final Ruta other = (Ruta) obj;
        if (this.idRuta != other.idRuta) {
            return false;
        }
        if (this.capacidad != other.capacidad) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.localidad, other.localidad)) {
            return false;
        }
        if (!Objects.equals(this.fecha_ultimo_mantenimiento, other.fecha_ultimo_mantenimiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ruta{" + "idRuta=" + idRuta + ", placa=" + placa + ", localidad=" + localidad + ", capacidad=" + capacidad + ", fecha_ultimo_mantenimiento=" + fecha_ultimo_mantenimiento + '}';
    }
    
    
    
    
    
    
}
