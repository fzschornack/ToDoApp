/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Felipe Zschornack
 */
public class ArquivoToDoApplication {
    
    private long idArquivoToDoApplication;
    private ConfiguracaoCalendario configuracaoCalendario;
    private ArrayList<TipoTarefa> tiposTarefa;
    private ArrayList<SubtipoTarefa> subtiposTarefa;
    private ArrayList<Tarefa> tarefas;

    /**
     * @return the idArquivoToDoApplication
     */
    public long getIdArquivoToDoApplication() {
        return idArquivoToDoApplication;
    }

    /**
     * @param idArquivoToDoApplication the idArquivoToDoApplication to set
     */
    public void setIdArquivoToDoApplication(long idArquivoToDoApplication) {
        this.idArquivoToDoApplication = idArquivoToDoApplication;
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

    /**
     * @return the tiposTarefa
     */
    public ArrayList<TipoTarefa> getTiposTarefa() {
        return tiposTarefa;
    }

    /**
     * @param tiposTarefa the tiposTarefa to set
     */
    public void setTiposTarefa(ArrayList<TipoTarefa> tiposTarefa) {
        this.tiposTarefa = tiposTarefa;
    }

    /**
     * @return the subtiposTarefa
     */
    public ArrayList<SubtipoTarefa> getSubtiposTarefa() {
        return subtiposTarefa;
    }

    /**
     * @param subtiposTarefa the subtiposTarefa to set
     */
    public void setSubtiposTarefa(ArrayList<SubtipoTarefa> subtiposTarefa) {
        this.subtiposTarefa = subtiposTarefa;
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
    
    
    
}
