/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConfiguracaoCalendarioDAO;
import java.util.ArrayList;
import model.ConfiguracaoCalendario;
import view.TelaPrincipal;

/**
 *
 * @author Nilton Gadelha
 */
public class ConfiguracaoCalendarioController {
    
    private TelaPrincipal telaPrincipal;

    public ConfiguracaoCalendarioController(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }
    
    public void salvarConfiguracoes() {
        ConfiguracaoCalendario.getInstancia().setSlotTempo(Integer.parseInt(telaPrincipal.getTxtSlotDeTempo().getText()));
        ConfiguracaoCalendarioDAO.create(ConfiguracaoCalendario.getInstancia());
    }
    
}
