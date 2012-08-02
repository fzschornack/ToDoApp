/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SubtipoTarefaDAO;
import dao.TipoTarefaDAO;
import javax.swing.JOptionPane;
import model.SubtipoTarefa;
import model.TipoTarefa;
import view.AdicionarNovoTipo;

/**
 *
 * @author Felipe Zschornack
 */
public class AdicionarNovoTipoController {
    
    AdicionarNovoTipo telaAdicionarNovoTipo;

    public AdicionarNovoTipoController(AdicionarNovoTipo telaAdicionarNovoTipo) {
        this.telaAdicionarNovoTipo = telaAdicionarNovoTipo;
    }
    
    public void adicionarNovoTipo() {
        if(telaAdicionarNovoTipo.getjRBTipo().isSelected()) {
            TipoTarefa tipo = new TipoTarefa();
            tipo.setNome(telaAdicionarNovoTipo.getTxtTipo().getText());
            TipoTarefaDAO.create(tipo);
            JOptionPane.showMessageDialog(telaAdicionarNovoTipo, "Tipo adicionado com sucesso!");
            telaAdicionarNovoTipo.dispose();
        } else if(telaAdicionarNovoTipo.getjRBSubtipo().isSelected()) {
            SubtipoTarefa  subtipo = new SubtipoTarefa(TipoTarefaDAO.read(telaAdicionarNovoTipo.getCbTiposTarefa().getSelectedItem().toString()));
            subtipo.setNome(telaAdicionarNovoTipo.getTxtSubTipo().getText());
            SubtipoTarefaDAO.create(subtipo);
            JOptionPane.showMessageDialog(telaAdicionarNovoTipo, "Subtipo adicionado com sucesso!");
            telaAdicionarNovoTipo.dispose();
        }
            
    }
    
}
