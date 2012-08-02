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
import java.util.ArrayList;
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
        if(ConfiguracaoCalendarioDAO.read(1) == null)
            //JOptionPane.showMessageDialog(telaPrincipal, "Calendário ainda não foi configurado.\n Por favor, preencha a aba \"Configurar Calendário.\" ");
        try {
            this.configCalendario = ConfiguracaoCalendarioDAO.read(1);
            this.calendario = Calendario.getInstancia();
            this.calendario.setConfigCal(configCalendario);
            this.calendario.setDias(DiaDAO.getAll());
            
            
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
        
        ArrayList<Tarefa> tarefas;

        tarefas = TarefaDAO.getAll();

        telaPrincipal.getListTarefasModel().removeAllElements();
        for(Tarefa t: tarefas) {
            if(t.getDia().getData().equals(data)) {
                if(t.getDataRealFim().after(new Date(System.currentTimeMillis()))) {
                    telaPrincipal.getListTarefasModel().addElement(t.getDescricao());
                }
            }
        }
        
        telaPrincipal.pack();
    }
    
    public void concluirTarefa() {
        if(JOptionPane.showConfirmDialog(telaPrincipal, "Deseja concluir a tarefa?") == 0) {
            Tarefa tarefa = new Tarefa();
            tarefa = TarefaDAO.read(telaPrincipal.getListTarefas().getSelectedValue().toString());
            tarefa.setDataRealFim(new Date(System.currentTimeMillis()));
            TarefaDAO.update(tarefa);
        }
    }
    
    public void editarTarefa() {
        EditarTarefa telaEditarTarefa = new EditarTarefa(telaPrincipal.getListTarefas().getSelectedValue().toString());
        telaEditarTarefa.setVisible(true);
    }
    
}
