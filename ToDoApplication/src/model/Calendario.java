/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Felipe Zschornack
 */
public class Calendario {
    
    private long idCalendario;
    private ConfiguracaoCalendario configCal;
    private ArrayList<Dia> dias;
    private ArrayList<TipoTarefa> tipos;

    public Calendario() {
        this.dias = new ArrayList<Dia>();
        this.tipos = new ArrayList<TipoTarefa>();
    }
    
    
    
    /**
     * @return the idCalendario
     */
    public long getIdCalendario() {
        return idCalendario;
    }

    /**
     * @param idCalendario the idCalendario to set
     */
    public void setIdCalendario(long idCalendario) {
        this.idCalendario = idCalendario;
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

    /**
     * @return the tipos
     */
    public ArrayList<TipoTarefa> getTipos() {
        return tipos;
    }

    /**
     * @param tipos the tipos to set
     */
    public void setTipos(ArrayList<TipoTarefa> tipos) {
        this.tipos = tipos;
    }
    
    
    
}
