/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.TarefaDAO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import model.Tarefa;

/**
 *
 * @author Felipe Zschornack
 */
public class listTarefasModel extends DefaultListModel {
    
    static Date data;
    
    String[] descricoes;

    String selection = null;

    public listTarefasModel(Date data) {
        this.data = data;
        this.descricoes = preencher();
    }
    
    public static String[] preencher() {
        
        ArrayList<Tarefa> tarefas;

        tarefas = TarefaDAO.getAll();
        
        String[] string = new String[tarefas.size()]; 
        int cont = 0;
        for(Tarefa t: tarefas) {
            if(t.getDia().getData().equals(data)) {
                string[cont] = t.getDescricao();
                cont++;
            }
        }
        
        return string;
    }
    
}
