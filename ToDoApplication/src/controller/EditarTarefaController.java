/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TarefaDAO;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Tarefa;
import view.EditarTarefa;

/**
 *
 * @author Felipe Zschornack
 */
public class EditarTarefaController {

    private EditarTarefa telaEditarTarefa;
    
    public EditarTarefaController(EditarTarefa telaEditarTarefa) {
        this.telaEditarTarefa = telaEditarTarefa;
    }
    
    public void preencher(String descricao) {
        Tarefa tarefa = new Tarefa();
        tarefa = TarefaDAO.read(descricao);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        telaEditarTarefa.getTxtDescricao().setText(tarefa.getDescricao());
        telaEditarTarefa.getTxtDataPrevistaFim().setText(formato.format(tarefa.getDataPrevistaFim()));
        telaEditarTarefa.getTxtDataPrevistaInicio().setText(formato.format(tarefa.getDataPrevistaInicio()));
        telaEditarTarefa.getTxtDuracaoMaximaExecucaoPordia().setText(tarefa.getDuracaoMaximaExecucaoDia()+"");
        telaEditarTarefa.getTxtDuracaoTotalPrevista().setText(tarefa.getDuracaoTotalPrevista()+"");
        telaEditarTarefa.getTxfTipoTarefa().setText(tarefa.getTipo().getNome());
        
        if(tarefa.getPrioridade() == 100) {
            telaEditarTarefa.getjCBImportante().setSelected(true);
            telaEditarTarefa.getjCBUrgente().setSelected(true);
        } else if(tarefa.getPrioridade() == 70) {
            telaEditarTarefa.getjCBImportante().setSelected(false);
            telaEditarTarefa.getjCBUrgente().setSelected(true);
        } else if(tarefa.getPrioridade() == 30) {
            telaEditarTarefa.getjCBImportante().setSelected(true);
            telaEditarTarefa.getjCBUrgente().setSelected(false);
        } else {
            telaEditarTarefa.getjCBImportante().setSelected(false);
            telaEditarTarefa.getjCBUrgente().setSelected(false);
        }
            
       
        
    }
    
    
    public void salvar() {
        
    }
    
    public void excluir(String descricao) {
        TarefaDAO.delete(TarefaDAO.read(descricao).getIdTarefa());
        JOptionPane.showMessageDialog(telaEditarTarefa, "Tarefa excluida com sucesso!");
        telaEditarTarefa.dispose();
    }
    
}
