/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EditarTarefaController;
import dao.SubtipoTarefaDAO;
import dao.TipoTarefaDAO;
import java.util.ArrayList;
import javax.swing.*;
import model.SubtipoTarefa;
import model.TipoTarefa;

/**
 *
 * @author Nilton
 */
public class EditarTarefa extends javax.swing.JFrame {

    String descricaoTarefa;
    EditarTarefaController editarTarefaController;
    /**
     * Creates new form EditarTarefa
     */
    public EditarTarefa(String descricaoTarefa) {
        this.editarTarefaController = new EditarTarefaController(this);
        this.descricaoTarefa = descricaoTarefa;
        initComponents();
        this.editarTarefaController.preencher(descricaoTarefa);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDadosDaTarefa = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblDataPrevistaInicio = new javax.swing.JLabel();
        lblDataPrevistaFim = new javax.swing.JLabel();
        lblDuracaoTotalPrevista = new javax.swing.JLabel();
        txtDuracaoTotalPrevista = new javax.swing.JTextField();
        lblDuracaoMaximaExecucaoPorDia = new javax.swing.JLabel();
        txtDuracaoMaximaExecucaoPordia = new javax.swing.JTextField();
        jCBUrgente = new javax.swing.JCheckBox();
        jCBImportante = new javax.swing.JCheckBox();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblTipoDaTarefa = new javax.swing.JLabel();
        cbTiposTarefa = new javax.swing.JComboBox();
        btnAdicionarTipo = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        ftxtDataPrevistaFim = new javax.swing.JFormattedTextField();
        ftxtDataPrevistaInicio = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDadosDaTarefa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDadosDaTarefa.setText("Dados da Tarefa");

        lblDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescricao.setText("Descriçao");

        lblDataPrevistaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDataPrevistaInicio.setText("Data prevista inicio");

        lblDataPrevistaFim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDataPrevistaFim.setText("Data prevista fim");

        lblDuracaoTotalPrevista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDuracaoTotalPrevista.setText("Duraçao total prevista");

        lblDuracaoMaximaExecucaoPorDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDuracaoMaximaExecucaoPorDia.setText("Duraçao maxima execuçao por dia");

        jCBUrgente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBUrgente.setText("Urgente");

        jCBImportante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBImportante.setText("Importante");

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblTipoDaTarefa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTipoDaTarefa.setText("Tipo da Tarefa");

        cbTiposTarefa.setModel(new comboBoxTipoTarefaModel());
        cbTiposTarefa.removeAllItems();
        ArrayList<TipoTarefa> tipos;
        tipos = TipoTarefaDAO.getAll();
        int cont = 0;
        for(TipoTarefa t: tipos) {
            cbTiposTarefa.insertItemAt(t.getNome(),cont);
            t.setSubtipos(SubtipoTarefaDAO.getAllIdTipo(t.getIdTipoTarefa()));
            cont++;
            for(SubtipoTarefa s: t.getSubtipos()) {
                cbTiposTarefa.insertItemAt("    "+s.getNome(),cont);
                cont++;
            }
        }

        btnAdicionarTipo.setText("Adicionar Tipo");

        btnAtualizar.setText("Atualizar");

        try {
            ftxtDataPrevistaFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftxtDataPrevistaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lblDadosDaTarefa)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescricao)
                                    .addComponent(lblDataPrevistaInicio)
                                    .addComponent(lblDataPrevistaFim)
                                    .addComponent(lblDuracaoTotalPrevista)
                                    .addComponent(lblDuracaoMaximaExecucaoPorDia)
                                    .addComponent(jCBUrgente)
                                    .addComponent(jCBImportante))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDuracaoTotalPrevista)
                                    .addComponent(txtDescricao)
                                    .addComponent(txtDuracaoMaximaExecucaoPordia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(ftxtDataPrevistaFim, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftxtDataPrevistaInicio, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTiposTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTipoDaTarefa)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdicionarTipo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAtualizar)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblDadosDaTarefa)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtDataPrevistaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataPrevistaInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataPrevistaFim)
                    .addComponent(ftxtDataPrevistaFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracaoTotalPrevista)
                    .addComponent(txtDuracaoTotalPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracaoMaximaExecucaoPorDia)
                    .addComponent(txtDuracaoMaximaExecucaoPordia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBUrgente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBImportante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipoDaTarefa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTiposTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarTipo)
                    .addComponent(btnAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        editarTarefaController.salvar(descricaoTarefa);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        editarTarefaController.excluir(descricaoTarefa);
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(EditarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new EditarTarefa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarTipo;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbTiposTarefa;
    private javax.swing.JFormattedTextField ftxtDataPrevistaFim;
    private javax.swing.JFormattedTextField ftxtDataPrevistaInicio;
    private javax.swing.JCheckBox jCBImportante;
    private javax.swing.JCheckBox jCBUrgente;
    private javax.swing.JLabel lblDadosDaTarefa;
    private javax.swing.JLabel lblDataPrevistaFim;
    private javax.swing.JLabel lblDataPrevistaInicio;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDuracaoMaximaExecucaoPorDia;
    private javax.swing.JLabel lblDuracaoTotalPrevista;
    private javax.swing.JLabel lblTipoDaTarefa;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDuracaoMaximaExecucaoPordia;
    private javax.swing.JTextField txtDuracaoTotalPrevista;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAdicionarTipo() {
        return btnAdicionarTipo;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JComboBox getCbTiposTarefa() {
        return cbTiposTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public EditarTarefaController getEditarTarefaController() {
        return editarTarefaController;
    }

    public JFormattedTextField getFtxtDataPrevistaFim() {
        return ftxtDataPrevistaFim;
    }

    public JFormattedTextField getFtxtDataPrevistaInicio() {
        return ftxtDataPrevistaInicio;
    }

    public JCheckBox getjCBImportante() {
        return jCBImportante;
    }

    public JCheckBox getjCBUrgente() {
        return jCBUrgente;
    }

    public JLabel getLblDadosDaTarefa() {
        return lblDadosDaTarefa;
    }

    public JLabel getLblDataPrevistaFim() {
        return lblDataPrevistaFim;
    }

    public JLabel getLblDataPrevistaInicio() {
        return lblDataPrevistaInicio;
    }

    public JLabel getLblDescricao() {
        return lblDescricao;
    }

    public JLabel getLblDuracaoMaximaExecucaoPorDia() {
        return lblDuracaoMaximaExecucaoPorDia;
    }

    public JLabel getLblDuracaoTotalPrevista() {
        return lblDuracaoTotalPrevista;
    }

    public JLabel getLblTipoDaTarefa() {
        return lblTipoDaTarefa;
    }

    public JTextField getTxtDescricao() {
        return txtDescricao;
    }

    public JTextField getTxtDuracaoMaximaExecucaoPordia() {
        return txtDuracaoMaximaExecucaoPordia;
    }

    public JTextField getTxtDuracaoTotalPrevista() {
        return txtDuracaoTotalPrevista;
    }

   

  
   

}
