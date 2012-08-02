/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TarefaDAO;
import java.sql.Date;
import java.util.ArrayList;
import model.Tarefa;
import view.EditarTarefa;
import view.TelaTarefasConcluidas;

/**
 *
 * @author Felipe
 */
public class TelaTarefasConcluidasController {
    
    private TelaTarefasConcluidas telaTarefasConcluidas;

    public TelaTarefasConcluidasController(TelaTarefasConcluidas telaTarefasConcluidas) {
        this.telaTarefasConcluidas = telaTarefasConcluidas;
    }
    
    public void preencher() {
        
        ArrayList<Tarefa> tarefas;

        tarefas = TarefaDAO.getAll();

        telaTarefasConcluidas.getListTarefasModel().removeAllElements();
        for(Tarefa t: tarefas) {
            if(t.getDataRealFim().before(new Date(System.currentTimeMillis()))) {
                telaTarefasConcluidas.getListTarefasModel().addElement(t.getDescricao());
            }
        }
        
        telaTarefasConcluidas.pack();
    }
    
    public void visualizar() {
        EditarTarefa telaEditarTarefa = new EditarTarefa(telaTarefasConcluidas.getListTarefas().getSelectedValue().toString());
        telaEditarTarefa.setVisible(true);
    }
    
}
