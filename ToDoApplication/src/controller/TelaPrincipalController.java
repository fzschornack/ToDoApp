/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConfiguracaoCalendarioDAO;
import dao.DiaDAO;
import dao.TarefaDAO;
import dao.TipoTarefaDAO;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Calendario;
import model.ConfiguracaoCalendario;
import model.Dia;
import model.Tarefa;
import view.EditarTarefa;
import view.TelaPrincipal;
import view.listTarefasModel;

/**
 *
 * @author Felipe ZSchornack
 */
public class TelaPrincipalController {
    
    private TelaPrincipal telaPrincipal;
    private ConfiguracaoCalendario configCalendario;
    private Dia diaSelecionado;
    private Calendario calendario;

    public TelaPrincipalController(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        
    }
    
    public void inicializarCalendario() {
       
        try {
            this.configCalendario = ConfiguracaoCalendarioDAO.read(1);
            this.calendario = new Calendario();
            this.calendario.setConfigCal(configCalendario);
            this.calendario.setDias(DiaDAO.getAll());
            this.calendario.setTipos(TipoTarefaDAO.getAll());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Novo Calendario.");
        }
        
    }
    
    public static void fifoPopularTarefas() {
        
    }
    
    public static void sjfPopularTarefas() {
        
    }
    
    public void exibirTarefas() {
             
        Date data = new Date(telaPrincipal.getDpCalendario().getDate().getTime());
        
        telaPrincipal.getListTarefas().setModel(new listTarefasModel(data));
        telaPrincipal.pack();
    }
    
    public void concluirTarefa() {
        if(JOptionPane.showConfirmDialog(telaPrincipal, "Deseja concluir a tarefa?") == 0) {
            telaPrincipal.getListTarefas().getSelectedValue();
        }
    }
    
    public void editarTarefa() {
        EditarTarefa telaEditarTarefa = new EditarTarefa(telaPrincipal.getListTarefas().getSelectedValue().toString());
        telaEditarTarefa.setVisible(true);
    }
    
}
