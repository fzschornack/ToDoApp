/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Nilton
 */
public class EditarTarefa extends javax.swing.JFrame {

    /**
     * Creates new form EditarTarefa
     */
    public EditarTarefa() {
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

        lblDadosDaTarefa = new javax.swing.JLabel();
        lblDescriçao = new javax.swing.JLabel();
        txtDescriçao = new javax.swing.JTextField();
        lblDataPrevistaInicio = new javax.swing.JLabel();
        txtDataPrevistaInicio = new javax.swing.JTextField();
        lblDataPrevistaFim = new javax.swing.JLabel();
        txtDataPrevistaFim = new javax.swing.JTextField();
        lblDuraçaoTotalPrevista = new javax.swing.JLabel();
        txtDuraçaoTotalPrevista = new javax.swing.JTextField();
        lblDuraçaoMaximaExecuçaoPorDia = new javax.swing.JLabel();
        txtDuraçaoMaximaExecuçaoPordia = new javax.swing.JTextField();
        jCBUrgente = new javax.swing.JCheckBox();
        jCBImportante = new javax.swing.JCheckBox();
        btnTipo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDadosDaTarefa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDadosDaTarefa.setText("Dados da Tarefa");

        lblDescriçao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescriçao.setText("Descriçao");

        lblDataPrevistaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDataPrevistaInicio.setText("Data prevista inicio");

        lblDataPrevistaFim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDataPrevistaFim.setText("Data prevista fim");

        lblDuraçaoTotalPrevista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDuraçaoTotalPrevista.setText("Duraçao total prevista");

        lblDuraçaoMaximaExecuçaoPorDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDuraçaoMaximaExecuçaoPorDia.setText("Duraçao maxima execuçao por dia");

        jCBUrgente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBUrgente.setText("Urgente");

        jCBImportante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBImportante.setText("Importante");

        btnTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTipo.setText("Tipo");

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lblDadosDaTarefa)
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescriçao)
                            .addComponent(lblDataPrevistaInicio)
                            .addComponent(lblDataPrevistaFim)
                            .addComponent(lblDuraçaoTotalPrevista)
                            .addComponent(lblDuraçaoMaximaExecuçaoPorDia)
                            .addComponent(jCBUrgente)
                            .addComponent(jCBImportante)
                            .addComponent(btnTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDataPrevistaInicio)
                            .addComponent(txtDuraçaoTotalPrevista)
                            .addComponent(txtDescriçao)
                            .addComponent(txtDataPrevistaFim)
                            .addComponent(txtDuraçaoMaximaExecuçaoPordia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblDadosDaTarefa)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescriçao)
                    .addComponent(txtDescriçao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataPrevistaInicio)
                    .addComponent(txtDataPrevistaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataPrevistaFim)
                    .addComponent(txtDataPrevistaFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuraçaoTotalPrevista)
                    .addComponent(txtDuraçaoTotalPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuraçaoMaximaExecuçaoPorDia)
                    .addComponent(txtDuraçaoMaximaExecuçaoPordia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBUrgente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBImportante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                new EditarTarefa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTipo;
    private javax.swing.JCheckBox jCBImportante;
    private javax.swing.JCheckBox jCBUrgente;
    private javax.swing.JLabel lblDadosDaTarefa;
    private javax.swing.JLabel lblDataPrevistaFim;
    private javax.swing.JLabel lblDataPrevistaInicio;
    private javax.swing.JLabel lblDescriçao;
    private javax.swing.JLabel lblDuraçaoMaximaExecuçaoPorDia;
    private javax.swing.JLabel lblDuraçaoTotalPrevista;
    private javax.swing.JTextField txtDataPrevistaFim;
    private javax.swing.JTextField txtDataPrevistaInicio;
    private javax.swing.JTextField txtDescriçao;
    private javax.swing.JTextField txtDuraçaoMaximaExecuçaoPordia;
    private javax.swing.JTextField txtDuraçaoTotalPrevista;
    // End of variables declaration//GEN-END:variables
}