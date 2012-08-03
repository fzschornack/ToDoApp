/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DiaDAO;
import dao.SubtipoTarefaDAO;
import dao.TarefaDAO;
import dao.TipoTarefaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Calendario;
import model.Dia;
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
        telaEditarTarefa.getFtxtDataPrevistaFim().setText(formato.format(tarefa.getDataPrevistaFim()));
        telaEditarTarefa.getFtxtDataPrevistaInicio().setText(formato.format(tarefa.getDataPrevistaInicio()));
        telaEditarTarefa.getTxtDuracaoMaximaExecucaoPordia().setText(tarefa.getDuracaoMaximaExecucaoDia()+"");
        telaEditarTarefa.getTxtDuracaoTotalPrevista().setText(tarefa.getDuracaoTotalPrevista()+"");
        telaEditarTarefa.getCbTiposTarefa().setSelectedItem(tarefa.getTipo().getNome());
        
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
    
    
   public void salvar(String descricao) {
        Tarefa tarefa;
        tarefa = new Tarefa();
        try {
            tarefa.setIdTarefa(TarefaDAO.read(descricao).getIdTarefa());
            tarefa.setDescricao(telaEditarTarefa.getTxtDescricao().getText());
            tarefa.setDataPrevistaInicio(formatador(telaEditarTarefa.getFtxtDataPrevistaInicio().getText()));
            tarefa.setDataPrevistaFim(formatador(telaEditarTarefa.getFtxtDataPrevistaFim().getText()));
            tarefa.setDuracaoTotalPrevista(Integer.parseInt(telaEditarTarefa.getTxtDuracaoTotalPrevista().getText()));
            tarefa.setDuracaoMaximaExecucaoDia(Integer.parseInt(telaEditarTarefa.getTxtDuracaoMaximaExecucaoPordia().getText()));
            tarefa.setDataRealInicio(new Date(System.currentTimeMillis()));
            tarefa.setDataRealFim(formatador("01/01/2099"));
            if(TipoTarefaDAO.read(telaEditarTarefa.getCbTiposTarefa().getSelectedItem().toString()) != null) {
                tarefa.setTipo(TipoTarefaDAO.read(telaEditarTarefa.getCbTiposTarefa().getSelectedItem().toString()));
            }
            else {
                tarefa.setTipo(SubtipoTarefaDAO.read(telaEditarTarefa.getCbTiposTarefa().getSelectedItem().toString().substring(4)));
            }
            int prioridade = 0;
            if(telaEditarTarefa.getjCBUrgente().isSelected())
                prioridade += 70;
            if(telaEditarTarefa.getjCBImportante().isSelected())
                prioridade += 30;
            tarefa.setPrioridade(prioridade);
            
        } catch (Exception e) {
            Logger.getLogger(AdicionarTarefaController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        int existeDia = 0;
        Dia dia = null;
        
        if(Calendario.getInstancia().getDias() != null) {
            for(Dia d: Calendario.getInstancia().getDias()) {
                if(d.getData().equals(tarefa.getDataPrevistaInicio())) {
                    existeDia = 1;
                    dia = d;
                    break;
                }
            }
        }
        
        if(existeDia == 1) {
            tarefa.setDia(dia);
        } else {
            dia = new Dia();
            dia.setData(tarefa.getDataPrevistaInicio());
            DiaDAO.create(dia);
            tarefa.setDia(DiaDAO.read(new Date(dia.getData().getTime())));
            Calendario.getInstancia().getDias().add(tarefa.getDia());
        }
        
        TarefaDAO.update(tarefa);
        JOptionPane.showMessageDialog(telaEditarTarefa, "Tarefa editada com sucesso!");
        
    }
    
    public void excluir(String descricao) {
        TarefaDAO.delete(TarefaDAO.read(descricao).getIdTarefa());
        JOptionPane.showMessageDialog(telaEditarTarefa, "Tarefa excluida com sucesso!");
        telaEditarTarefa.dispose();
    }
 
    public static java.sql.Date formatador(String data) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return  new Date(format.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(AdicionarTarefaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
