/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Felipe Zschornack
 */
public class Dia {
    
    private long idDia;
    private Date data;
    private ArrayList<Tarefa> tarefas;
    private ArrayList<Boolean> slots;
    private ConfiguracaoCalendario configuracaoCalendario;

    public Dia(ConfiguracaoCalendario configuracaoCalendario) {
        this.configuracaoCalendario = configuracaoCalendario;
        this.slots = new ArrayList<Boolean>(getConfiguracaoCalendario().getNumeroHorasDia()/getConfiguracaoCalendario().getSlotTempo());
        this.tarefas = new ArrayList<Tarefa>(getConfiguracaoCalendario().getNumeroHorasDia()/getConfiguracaoCalendario().getSlotTempo());
    }

    public Dia() {
    }
    
    /**
     * @return the idDia
     */
    public long getIdDia() {
        return idDia;
    }

    /**
     * @param idDia the idDia to set
     */
    public void setIdDia(long idDia) {
        this.idDia = idDia;
    }

    /**
     * @return the tarefas
     */
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    /**
     * @param tarefas the tarefas to set
     */
    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    /**
     * @return the slots
     */
    public ArrayList<Boolean> getSlots() {
        return slots;
    }

    /**
     * @param slots the slots to set
     */
    public void setSlots(ArrayList<Boolean> slots) {
        this.slots = slots;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the configuracaoCalendario
     */
    public ConfiguracaoCalendario getConfiguracaoCalendario() {
        return configuracaoCalendario;
    }

    /**
     * @param configuracaoCalendario the configuracaoCalendario to set
     */
    public void setConfiguracaoCalendario(ConfiguracaoCalendario configuracaoCalendario) {
        this.configuracaoCalendario = configuracaoCalendario;
    }
    
    
}
