/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.directivo;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import vista.Principal;
import vista.paneles.PanelComponents;
import vista.paneles.disenio.ComboBoxMaterialDesign;

/**
 *
 * @author Carlos
 */
@SuppressWarnings("serial")
public class PanelRutasEstudiantes extends PanelComponents {

    private final Principal principal;
    private final String placa;
    /**
     * Creates new form PanelRutasEstudiantes
     * @param principal
     * @param placa
     */
    public PanelRutasEstudiantes(Principal principal, String placa) {
        initComponents();
        this.principal = principal;
        this.placa = placa;
        cargarDatos();
        modificarTemaComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jListEstudiantes = new javax.swing.JList<>();
        jButtonAgregar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListEstudiantesAgregar = new javax.swing.JList<>();
        jButtonQuitar = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jComboBoxCursos = new javax.swing.JComboBox<>();
        jPanelHeader = new javax.swing.JPanel();
        jLabelHeader = new javax.swing.JLabel();
        jLabelCerrar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(null);

        jListEstudiantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jListEstudiantes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jListEstudiantes.setForeground(new java.awt.Color(110, 110, 110));
        jListEstudiantes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Seleccione un curso" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListEstudiantes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListEstudiantes.setSelectionBackground(new java.awt.Color(88, 165, 240));
        jScrollPane3.setViewportView(jListEstudiantes);

        jButtonAgregar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(88, 165, 240));
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 165, 240)));
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jScrollPane4.setBorder(null);

        jListEstudiantesAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jListEstudiantesAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jListEstudiantesAgregar.setForeground(new java.awt.Color(110, 110, 110));
        jListEstudiantesAgregar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "No hay Estudiantes cargados" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListEstudiantesAgregar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListEstudiantesAgregar.setSelectionBackground(new java.awt.Color(88, 165, 240));
        jScrollPane4.setViewportView(jListEstudiantesAgregar);

        jButtonQuitar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonQuitar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonQuitar.setForeground(new java.awt.Color(88, 165, 240));
        jButtonQuitar.setText("Quitar");
        jButtonQuitar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 165, 240)));
        jButtonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarActionPerformed(evt);
            }
        });

        jButtonRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(88, 165, 240));
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setToolTipText("");
        jButtonRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 165, 240), 2));
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonLimpiar.setForeground(new java.awt.Color(88, 165, 240));
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.setToolTipText("");
        jButtonLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 165, 240), 2));
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonCerrar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCerrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCerrar.setForeground(new java.awt.Color(88, 165, 240));
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.setToolTipText("");
        jButtonCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 165, 240), 2));
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jComboBoxCursos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxCursos.setForeground(new java.awt.Color(88, 88, 88));
        jComboBoxCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cursos" }));
        jComboBoxCursos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
        jComboBoxCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCursosActionPerformed(evt);
            }
        });

        jPanelHeader.setBackground(new java.awt.Color(88, 165, 240));

        jLabelHeader.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHeader.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabelHeader.setForeground(new java.awt.Color(240, 240, 240));
        jLabelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHeader.setText("Agregar Estuadiantes a ruta");

        jLabelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/menu/close.png"))); // NOI18N
        jLabelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCerrar)
                .addContainerGap())
            .addComponent(jLabelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHeader)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jComboBoxCursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButtonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        agregarEstudianteARuta();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarActionPerformed
        quitarEstudiante();
    }//GEN-LAST:event_jButtonQuitarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        registrar();
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        ocultarPanel();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jComboBoxCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCursosActionPerformed
        cargarEstudiantes();
    }//GEN-LAST:event_jComboBoxCursosActionPerformed

    private void jLabelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseClicked
        ocultarPanel();
    }//GEN-LAST:event_jLabelCerrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonQuitar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox<String> jComboBoxCursos;
    private javax.swing.JLabel jLabelCerrar;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JList<String> jListEstudiantes;
    private javax.swing.JList<String> jListEstudiantesAgregar;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        cargarDatosPrincipales();
    }

    private void cargarEstudiantes() {
        int curso = Integer.parseInt((String)this.jComboBoxCursos.getSelectedItem());
        String estudiantes[] = this.principal.obtenerEstudiantePorCurso(curso);
        DefaultListModel<String> modelo = new DefaultListModel<>();
        
        for(int i = 0 ; i < estudiantes.length; i++){
            modelo.addElement(estudiantes[i]);
        }
        
        this.jListEstudiantes.setModel(modelo);
        
    }

    private void agregarEstudianteARuta() {
        if (!buscar()) {
            DefaultListModel<String> modelo;
            if(this.jListEstudiantesAgregar.getModel().getElementAt(0).equals("No hay Estudiantes cargados")){
                modelo = new DefaultListModel<>();
            } else {
                modelo = (DefaultListModel<String>)this.jListEstudiantesAgregar.getModel();
            }
            String data = this.jListEstudiantes.getSelectedValue();
            modelo.addElement(data);
            
            this.jListEstudiantesAgregar.setModel(modelo);
            
        } else {
            JOptionPane.showMessageDialog(null,"El estudiante a agregar a la ruta ya existe","Agregar Estudiates a la ruta",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @Override
    public void registrar() {
        if (validar()) {
            JOptionPane.showMessageDialog(null, "Se ha agregado los estudiantes a la ruta correctamente", "Agregar estudiantes a la ruta " + placa, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar los estudiantes a la ruta correctamente", "Agregar estudiantes a la ruta " + placa, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void quitarEstudiante() {
        DefaultListModel<String> modelo = (DefaultListModel<String>)this.jListEstudiantesAgregar.getModel();
        modelo.remove(this.jListEstudiantesAgregar.getSelectedIndex());
        if(this.jListEstudiantesAgregar.getModel().getSize() == 1){
            modelo.addElement("No hay Estudiantes cargados");
        }
        
        this.jListEstudiantesAgregar.setModel(modelo);
        
    }

    @Override
    public boolean validar() {
        try {
            if (this.jListEstudiantesAgregar.getModel().getElementAt(0).equals("No hay Estudiantes cargados")) {
                return false;
            }

            ArrayList<Long> documentos = new ArrayList<>();

            for (int i = 0; i < this.jListEstudiantesAgregar.getModel().getSize(); i++) {
                long documento = Long.parseLong(this.jListEstudiantesAgregar.getModel().getElementAt(i).split("-")[0]);
                documentos.add(documento);
            }
            long doc[] = new long[documentos.size()];

            for (int i = 0; i < doc.length; i++) {
                doc[i] = documentos.get(i);
            }
            this.principal.agregarEstudiateARuta(doc, this.placa);
            return true;
        } catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException ex) {
            return false;
        }

    }

    private void ocultarPanel() {
        this.principal.ocultarDialog();
    }

    private void modificarTemaComboBox() {
        this.jComboBoxCursos.setUI(new ComboBoxMaterialDesign());
    }

    @Override
    public Object cargarDatosPrincipales() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        String cursos[] = this.principal.obtenerCursos();
        modelo.addElement("Cursos");
        for(int i = 0 ; i < cursos.length; i++){
            modelo.addElement(cursos[i]);
        }
        
        this.jComboBoxCursos.setModel(modelo);
        return modelo;
    }

    @Override
    public boolean buscar() {
        String data = this.jListEstudiantes.getSelectedValue();

        for (int i = 0; i < this.jListEstudiantesAgregar.getModel().getSize(); i++) {
            if (this.jListEstudiantesAgregar.getModel().getElementAt(i).equals(data)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void agregarItemsAMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarPlaceHolder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarTextosDefecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
