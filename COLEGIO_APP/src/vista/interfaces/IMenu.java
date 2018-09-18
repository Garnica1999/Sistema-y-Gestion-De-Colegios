/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import javax.swing.JPanel;

/**
 *
 * @author Carlos
 */
public interface IMenu extends ConstantesMenu{
        
    public abstract void iniciarMenu(int menu, String usuario);
    public abstract void cargarComponentes(JPanel menu, int width, int height);
}
