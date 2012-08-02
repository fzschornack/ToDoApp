/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.SubtipoTarefaDAO;
import dao.TipoTarefaDAO;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.SubtipoTarefa;
import model.TipoTarefa;

/**
 *
 * @author Felipe Zschornack
 */
public class comboBoxTipoTarefaModel extends DefaultComboBoxModel {
    
    String[] tiposSubtipos;

    public comboBoxTipoTarefaModel() {
        this.tiposSubtipos = preencher();
    } 
    

    String selection = null;
    
    public static String[] preencher() {
        
        ArrayList<TipoTarefa> tipos;
        ArrayList<SubtipoTarefa> subtipos;

        tipos = TipoTarefaDAO.getAll();
        subtipos = SubtipoTarefaDAO.getAll();
        String[] string = new String[tipos.size()+subtipos.size()]; 
        int cont = 0;
        for(TipoTarefa t: tipos) {
            string[cont] = t.getNome();
            t.setSubtipos(SubtipoTarefaDAO.getAllIdTipo(t.getIdTipoTarefa()));
            cont++;
            for(SubtipoTarefa s: t.getSubtipos()) {
                string[cont] = "    "+s.getNome();
                cont++;
            }
        }
        
        return string;
    }

    /*
    public Object getElementAt(int index) {
        return tiposSubtipos[index];
    }

    public int getSize() {
        return tiposSubtipos.length;
    }

    public void setSelectedItem(Object anItem) {
        selection = (String) anItem; // to select and register an
    } // item from the pull-down list

    // Methods implemented from the interface ComboBoxModel
    public Object getSelectedItem() {
        return selection; // to add the selection to the combo box
    }
    */
     
}

