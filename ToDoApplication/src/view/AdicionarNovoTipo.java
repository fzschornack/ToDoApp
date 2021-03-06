/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AdicionarNovoTipoController;
import dao.TipoTarefaDAO;
import java.util.ArrayList;
import javax.swing.*;
import model.TipoTarefa;

/**
 *
 * @author Nilton
 */
public class AdicionarNovoTipo extends javax.swing.JFrame {

    /**
     * Creates new form AdicionarNovoTipo
     */
    public AdicionarNovoTipo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblAdicionarTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtSubTipo = new javax.swing.JTextField();
        jRBSubtipo = new javax.swing.JRadioButton();
        btnAdicionarTipo = new javax.swing.JButton();
        jRBTipo = new javax.swing.JRadioButton();
        cbTiposTarefa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAdicionarTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAdicionarTipo.setText("Adicionar Novo Tipo");

        buttonGroup1.add(jRBSubtipo);
        jRBSubtipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRBSubtipo.setText("Subtipo");

        btnAdicionarTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionarTipo.setText("Adicionar Tipo");
        btnAdicionarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTipoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipo);
        jRBTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRBTipo.setText("Tipo");

        cbTiposTarefa.setModel(new comboBoxTipoTarefaModel());
        ArrayList<TipoTarefa> tipos;
        tipos = TipoTarefaDAO.getAll();
        int cont = 0;
        for(TipoTarefa t: tipos) {
            cbTiposTarefa.insertItemAt(t.getNome(),cont);
            cont++;
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdicionarTipo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRBSubtipo)
                                    .addComponent(jRBTipo))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTipo)
                                    .addComponent(txtSubTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTiposTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(450, Short.MAX_VALUE)
                        .addComponent(btnAdicionarTipo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdicionarTipo)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBTipo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBSubtipo)
                    .addComponent(cbTiposTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(btnAdicionarTipo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarTipoActionPerformed
        AdicionarNovoTipoController adicionarNovoTipoController = new AdicionarNovoTipoController(this);
        adicionarNovoTipoController.adicionarNovoTipo();
    }//GEN-LAST:event_btnAdicionarTipoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdicionarNovoTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarNovoTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarNovoTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarNovoTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdicionarNovoTipo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarTipo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbTiposTarefa;
    private javax.swing.JRadioButton jRBSubtipo;
    private javax.swing.JRadioButton jRBTipo;
    private javax.swing.JLabel lblAdicionarTipo;
    private javax.swing.JTextField txtSubTipo;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAdicionarTipo() {
        return btnAdicionarTipo;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public JRadioButton getjRBSubtipo() {
        return jRBSubtipo;
    }

    public JRadioButton getjRBTipo() {
        return jRBTipo;
    }

    public JLabel getLblAdicionarTipo() {
        return lblAdicionarTipo;
    }

    public JTextField getTxtSubTipo() {
        return txtSubTipo;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public JComboBox getCbTiposTarefa() {
        return cbTiposTarefa;
    }

    
}
