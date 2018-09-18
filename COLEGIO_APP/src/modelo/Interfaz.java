/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.interfaces.IInterfaz;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Carlos
 */
public class Interfaz implements IInterfaz, Serializable{

    private static final long serialVersionUID = 15L;
    private boolean modoNoche;
    private String color;

    public Interfaz(boolean modoNoche, String color) {
        this.modoNoche = modoNoche;
        this.color = color;
    }

    public boolean isModoNoche() {
        return modoNoche;
    }

    public void setModoNoche(boolean modoNoche) {
        this.modoNoche = modoNoche;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.modoNoche ? 1 : 0);
        hash = 43 * hash + Objects.hashCode(this.color);
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
        final Interfaz other = (Interfaz) obj;
        if (this.modoNoche != other.modoNoche) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Interfaz{" + "modoNoche=" + modoNoche + ", color=" + color + '}';
    }
    
    
}
