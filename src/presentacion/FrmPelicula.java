package presentacion;

import negocio.PeliculaNegocio;
import entidad.Pelicula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmPelicula extends javax.swing.JFrame {
    private String valorBuscado, tituloId, titulo, categoria, nacionalidad;
    private short duracion;
    
    PeliculaNegocio peliculaNegocio;
    
    private int fila;
    private boolean nuevo;
    DefaultTableModel modelo = new DefaultTableModel();
    Object[] datos = new Object[4];
    
    public FrmPelicula() {
        initComponents();
        peliculaNegocio = new PeliculaNegocio();
        habilitarTexto(false);
        habilitarBotones(false);
    }
    
    private void limpiarInput(){
        txtTitulo.setText("");
        cbCategoria.setSelectedIndex(0);
        txtNacionalidad.setText("");
        txtDuracion.setText("");
        bgOption.clearSelection();
        txtTitulo.requestFocus();
    }
    
    private void habilitarTexto(boolean sw){
        txtTitulo.setEnabled(sw);
        cbCategoria.setEnabled(sw);
        txtNacionalidad.setEnabled(sw);
        txtDuracion.setEnabled(sw);
    }
    
    private void habilitarBotones(boolean sw){
        btnNuevo.setEnabled(!sw);
        btnAgregar.setEnabled(sw);
        btnActualizar.setEnabled(sw); 
        btnEliminar.setEnabled(sw);
        btnListar.setEnabled(sw);
    }
    
    private void habilitarFiltro(boolean sw){
        rdbCategoria.setEnabled(sw);
        cbCategoria.setEnabled(sw);
        rdbNacionalidad.setEnabled(sw);
        txtNacionalidad.setEnabled(sw);
        btnListar.setEnabled(sw);
    }
    
    private void limpiarTabla(){
        modelo = (DefaultTableModel) (tblPelicula.getModel());
        modelo.getDataVector().removeAllElements();
        tblPelicula.clearSelection();
    }
    
    private void listarPeliculas(){
        if(peliculaNegocio.listar()!=null){
            limpiarTabla();
            for (Pelicula p : peliculaNegocio.listar()) {
                if( p != null){
                    datos[0] = p.getTitulo();
                    datos[1] = p.getCategoria();
                    datos[2] = p.getNacionalidad();
                    datos[3] = p.getDuracion();
                    modelo.addRow(datos);
                }
            }
            tblPelicula.setModel(modelo);
            if (peliculaNegocio.totalPeliculas() > 0){
                txtTotal.setText(""+peliculaNegocio.totalPeliculas());                
            } else {
                limpiarTabla();
                txtTotal.setText("");
                habilitarFiltro(false);
            }
        }
    }
    
    private void buscarPeliculas(Boolean sw, String buscarPelicula){
        int countFiltro = 0;
        peliculaNegocio.filtrarPeliculas(buscarPelicula);
        limpiarTabla();
        if (peliculaNegocio.totalPeliculasFiltro() > 0 ){
            for (Pelicula p : peliculaNegocio.listarPeliculasFiltro()) {
                if( p != null){
                    datos[0] = p.getTitulo();
                    datos[1] = p.getCategoria();
                    datos[2] = p.getNacionalidad();
                    datos[3] = p.getDuracion();
                    modelo.addRow(datos);
                }
            }
            tblPelicula.setModel(modelo);
            lblMensaje.setText("Se listo los registros correctamente.");
            txtTotal.setText(""+peliculaNegocio.totalPeliculasFiltro());
        }  else {
            lblMensaje.setText("No se encontro ningun registro.");
            txtTotal.setText("");
        }
        limpiarInput();
    }
/***********************************************************************************/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgOption = new javax.swing.ButtonGroup();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNacionalidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rdbCategoria = new javax.swing.JRadioButton();
        rdbNacionalidad = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelicula = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTA DE PELICULAS");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Acción", "Comedia", "Ciencia Ficción", "Drama", "Suspenso", "Romance", "Terror", "Animada" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Categoria");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Titulo");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel1.setText("PELICULAS");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nacionalidad");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Duración (min)");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        bgOption.add(rdbCategoria);
        rdbCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdbCategoria.setText("Categoria");

        bgOption.add(rdbNacionalidad);
        rdbNacionalidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdbNacionalidad.setText("Nacionalidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbNacionalidad)
                    .addComponent(rdbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(rdbCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbNacionalidad)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Filtrar");

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnListar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        tblPelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Categoria", "Nacionalidad", "Duración (min)"
            }
        ));
        tblPelicula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPelicula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPeliculaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPelicula);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Total de Peliculas");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNacionalidad)
                                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo = true;
        habilitarFiltro(false);
        lblMensaje.setText("");
        limpiarInput();
        btnAgregar.setEnabled(true);
        btnNuevo.setEnabled(false);
        habilitarTexto(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        tblPelicula.clearSelection();
        if(JOptionPane.showConfirmDialog(
                null,
                "Esta seguro de Eliminar?",
                "Eliminar",
                JOptionPane.YES_NO_OPTION,
                3) == 0){
            if(peliculaNegocio.eliminar(tituloId)){
                lblMensaje.setText("El registro se elimino exitosamente.");
            } else {
                lblMensaje.setText("El registro no se pudo eliminar.");
            }            
            listarPeliculas();
            habilitarBotones(false);
            limpiarInput();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        lblMensaje.setText("");
        if(!(txtTitulo.getText().trim().isEmpty() || cbCategoria.getSelectedItem().toString().equalsIgnoreCase("Seleccionar") || txtNacionalidad.getText().trim().isEmpty() || txtDuracion.getText().trim().isEmpty())){
            short duracionPelicula = 0;
            titulo = txtTitulo.getText().trim();
            try {
                duracionPelicula = Short.parseShort(txtDuracion.getText());                
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                    "Error, la duración debe ser numeros enteros.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
                    txtDuracion.requestFocus();
                return;
            }
            if (duracionPelicula <= 0){
                JOptionPane.showMessageDialog(null,
                    "La duración debe ser mayor a 0",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
                txtDuracion.requestFocus();
                return;
            }
            if(nuevo){
                nuevo = false;
                if (peliculaNegocio.agregar(
                        titulo, 
                        cbCategoria.getSelectedItem().toString(),
                        txtNacionalidad.getText().trim(),
                        duracionPelicula)){
                    lblMensaje.setText("El registro se agrego de manera exitosa.");
                } else {
                    lblMensaje.setText("El registro no se pudo agregar.");
                }
            } else {
                nuevo = true;
                if (peliculaNegocio.actualizar(                        
                    tituloId,
                    titulo, 
                    cbCategoria.getSelectedItem().toString(),
                    txtNacionalidad.getText().trim(),
                    duracionPelicula)){
                lblMensaje.setText("El registro se actualizo correctamente.");
                } else {
                    lblMensaje.setText("El registro no se pudo actualizar.");
                }
            }
            listarPeliculas();
            habilitarBotones(false);
            habilitarTexto(false);
            habilitarFiltro(true);
            limpiarInput();           
        } else {
            lblMensaje.setText("Faltan agregar campos.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        nuevo = false;
        habilitarBotones(false);
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(true);
        habilitarTexto(true);
        lblMensaje.setText(""+fila);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        if(rdbCategoria.isSelected()){
            lblMensaje.setText(""); 
            listarPeliculas();            
            txtNacionalidad.setText("");
            String buscarValor = cbCategoria.getSelectedItem().toString();
            if(buscarValor.equalsIgnoreCase("Seleccionar")){
                JOptionPane.showMessageDialog(null,
                                "Alerta, debe seleccionar una categoria.",
                                "Alerta",
                                JOptionPane.WARNING_MESSAGE);
                listarPeliculas();
                return;
            }
            buscarPeliculas(true, buscarValor);
            cbCategoria.setSelectedIndex(0);
        } else if (rdbNacionalidad.isSelected()){
            lblMensaje.setText("");
            listarPeliculas();
            cbCategoria.setSelectedIndex(0);
            String buscarValor = txtNacionalidad.getText().trim();
            if (buscarValor.isEmpty()){
                JOptionPane.showMessageDialog(null,
                                "Alerta, debe ingresar una nacionalidad.",
                                "Alerta",
                                JOptionPane.WARNING_MESSAGE);
                listarPeliculas();
                return;                
            }
            buscarPeliculas(false, buscarValor);            
            txtNacionalidad.setText("");
        } else {
            lblMensaje.setText("");
            JOptionPane.showMessageDialog(null,
                                "Alerta, debe ingresar y/o selecionar un filtro.",
                                "Alerta",
                                JOptionPane.WARNING_MESSAGE);
            listarPeliculas();
        }
        habilitarFiltro(true);
    }//GEN-LAST:event_btnListarActionPerformed

    private void tblPeliculaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeliculaMousePressed
        try {
            fila = tblPelicula.getSelectedRow();
            tituloId = tblPelicula.getValueAt(fila, 0).toString();
            txtTitulo.setText(tblPelicula.getValueAt(fila, 0).toString());
            cbCategoria.setSelectedItem(tblPelicula.getValueAt(fila, 1));
            txtNacionalidad.setText(tblPelicula.getValueAt(fila,  2).toString());
            txtDuracion.setText(tblPelicula.getValueAt(fila, 3).toString());;
            habilitarBotones(true);
            habilitarFiltro(false);
            habilitarTexto(false);
            btnAgregar.setEnabled(false);
            lblMensaje.setText("");
        } catch (ArrayIndexOutOfBoundsException e) {
            lblMensaje.setText("");
        }
    }//GEN-LAST:event_tblPeliculaMousePressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPelicula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgOption;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JRadioButton rdbCategoria;
    private javax.swing.JRadioButton rdbNacionalidad;
    private javax.swing.JTable tblPelicula;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
