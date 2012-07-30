/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TarefaDAO;
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
        telaEditarTarefa.getTxtDescricao().setText(tarefa.getDescricao());
        telaEditarTarefa.getTxtDataPrevistaFim().setText(tarefa.getDataPrevistaFim().toString());
        telaEditarTarefa.getTxtDataPrevistaInicio().setText(tarefa.getDataPrevistaInicio().toString());
        telaEditarTarefa.getTxtDuracaoMaximaExecucaoPordia().setText(tarefa.getDuracaoMaximaExecucaoDia()+"");
        telaEditarTarefa.getTxtDuracaoTotalPrevista().setText(tarefa.getDuracaoTotalPrevista()+"");
        telaEditarTarefa.getTxfTipoTarefa().setText(tarefa.getTipo().getNome());
    }
    
    
    
    
    
}
