/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.dialog;

import javax.swing.JDialog;
import javax.swing.JPanel;
import vista.Principal;

/**
 *
 * @author Carlos
 */
public class VentanaDialog extends JDialog{
    private Principal principal;
    private JPanel jPanel;

    public VentanaDialog(Principal principal,JPanel jPanel, String titulo, boolean modal, boolean marco, boolean visible, int opcionCerrar) {
        super(principal, titulo);
        this.principal = principal;
        this.jPanel = jPanel;
        
        this.setUndecorated(marco);
        
        this.setDefaultCloseOperation(opcionCerrar);
        this.setTitle(titulo);
        this.setModal(modal);
        
        
        this.add(this.jPanel);
        
        this.pack();
        
        this.setLocationRelativeTo(principal);
        this.setVisible(visible);
    }
    
    public VentanaDialog(Principal principal,JPanel jPanel, String titulo, ModalityType modal, boolean marco, boolean visible, int opcionCerrar) {
        super(principal, titulo);
        this.principal = principal;
        this.jPanel = jPanel;
        
        this.setUndecorated(marco);
        
        this.setDefaultCloseOperation(opcionCerrar);
        this.setTitle(titulo);
        this.setModalityType(modal);
        
        
        this.add(this.jPanel);
        
        this.pack();
        
        this.setLocationRelativeTo(principal);
        this.setVisible(visible);
    }
    
    public VentanaDialog build(){
        return this;
    }
}
