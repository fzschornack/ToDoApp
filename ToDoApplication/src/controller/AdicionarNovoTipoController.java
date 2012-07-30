/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SubtipoTarefaDAO;
import dao.TipoTarefaDAO;
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
        } else if(telaAdicionarNovoTipo.getjRBSubtipo().isSelected()) {
            SubtipoTarefa  subtipo = new SubtipoTarefa();
            subtipo.setNome(telaAdicionarNovoTipo.getTxtSubTipo().getText());
            SubtipoTarefaDAO.create(subtipo);
        }
            
    }
    
}
