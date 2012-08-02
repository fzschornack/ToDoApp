/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DiaDAO;
import dao.SubtipoTarefaDAO;
import dao.TarefaDAO;
import dao.TipoTarefaDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Calendario;
import model.Dia;
import model.Tarefa;
import view.TelaPrincipal;

/**
 *
 * @author Felipe Zschornack
 */
public class AdicionarTarefaController {
    
    Tarefa tarefa;
    
    public void adicionarTarefa(TelaPrincipal telaPrincipal) {
        try {
            tarefa = new Tarefa();
            tarefa.setDescricao(telaPrincipal.getTxtDescricao().getText());
            tarefa.setDataPrevistaInicio(formatador(telaPrincipal.getFtxfDataPrevistaInicio().getText()));
            tarefa.setDataPrevistaFim(formatador(telaPrincipal.getFtxfDataPrevistaFim().getText()));
            tarefa.setDuracaoTotalPrevista(Integer.parseInt(telaPrincipal.getTxtDuracaoTotalPrevista().getText()));
            tarefa.setDuracaoMaximaExecucaoDia(Integer.parseInt(telaPrincipal.getTxtDuracaoMaximaExecucaoPorDia().getText()));
            tarefa.setDataRealInicio(new Date(System.currentTimeMillis()));
            tarefa.setDataRealFim(formatador("01/01/2099"));
            if(TipoTarefaDAO.read(telaPrincipal.getCbTiposTarefa().getSelectedItem().toString()) != null) {
                tarefa.setTipo(TipoTarefaDAO.read(telaPrincipal.getCbTiposTarefa().getSelectedItem().toString()));
            }
            else {
                tarefa.setTipo(SubtipoTarefaDAO.read(telaPrincipal.getCbTiposTarefa().getSelectedItem().toString().substring(4)));
            }
            int prioridade = 0;
            if(telaPrincipal.getjCBUrgente().isSelected())
                prioridade += 70;
            if(telaPrincipal.getjCBImportante().isSelected())
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
        
        TarefaDAO.create(tarefa);
        JOptionPane.showMessageDialog(telaPrincipal, "Tarefa adicionada com sucesso!");
        
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
