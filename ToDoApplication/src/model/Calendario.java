/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Felipe Zschornack
 * 
 *  Nessa classe é utilizado o padrão de projeto Singleton, já que deve existir somente uma instacia de Calendario no programa.
 * 
 */
public class Calendario {
    
    private ConfiguracaoCalendario configCal;
    private ArrayList<Dia> dias;
    private static Calendario instancia = new Calendario();
    private int tipoEscalonamento;

    private Calendario() {
        this.dias = new ArrayList<Dia>();
        this.tipoEscalonamento = 1;
    }
    
    public static Calendario getInstancia() {
        return instancia;
    }

    public int getTipoEscalonamento() {
        return tipoEscalonamento;
    }

    public void setTipoEscalonamento(int tipoEscalonamento) {
        this.tipoEscalonamento = tipoEscalonamento;
    }
    
    /**
     * @return the dias
     */
    public ArrayList<Dia> getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(ArrayList<Dia> dias) {
        this.dias = dias;
    }

    /**
     * @return the configCal
     */
    public ConfiguracaoCalendario getConfigCal() {
        return configCal;
    }

    /**
     * @param configCal the configCal to set
     */
    public void setConfigCal(ConfiguracaoCalendario configCal) {
        this.configCal = configCal;
    } 
    
}
