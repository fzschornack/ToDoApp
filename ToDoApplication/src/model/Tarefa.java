package model;

import java.sql.Date;

/**
*
* @author Felipe Zschornack
*/
public class Tarefa {
	
    private long idTarefa;
    private String descricao;
    private Date dataPrevistaInicio;
    private Date dataRealInicio;
    private Date dataPrevistaFim;
    private Date dataRealFim;
    private int duracaoTotalPrevista;
    private int duracaoTotalReal;
    private int duracaoMaximaExecucaoDia;
    private TiposDeTarefaComposite tipo;
    private int prioridade;
    private Dia dia;

    public Tarefa() {
    }

    public long getIdTarefa() {
            return idTarefa;
    }
    public void setIdTarefa(long id) {
            this.idTarefa = id;
    }
    public String getDescricao() {
            return descricao;
    }
    public void setDescricao(String descricao) {
            this.descricao = descricao;
    }
    public Date getDataPrevistaInicio() {
            return dataPrevistaInicio;
    }
    public void setDataPrevistaInicio(Date dataPrevistaInicio) {
            this.dataPrevistaInicio = dataPrevistaInicio;
    }
    public Date getDataRealInicio() {
            return dataRealInicio;
    }
    public void setDataRealInicio(Date dataRealInicio) {
            this.dataRealInicio = dataRealInicio;
    }
    public Date getDataPrevistaFim() {
            return dataPrevistaFim;
    }
    public void setDataPrevistaFim(Date dataPrevistaFim) {
            this.dataPrevistaFim = dataPrevistaFim;
    }
    public Date getDataRealFim() {
            return dataRealFim;
    }
    public void setDataRealFim(Date dataRealFim) {
            this.dataRealFim = dataRealFim;
    }
    public int getDuracaoTotalPrevista() {
            return duracaoTotalPrevista;
    }
    public void setDuracaoTotalPrevista(int duracaoTotalPrevista) {
            this.duracaoTotalPrevista = duracaoTotalPrevista;
    }
    public int getDuracaoTotalReal() {
            return duracaoTotalReal;
    }
    public void setDuracaoTotalReal(int duracaoTotalReal) {
            this.duracaoTotalReal = duracaoTotalReal;
    }
    public int getDuracaoMaximaExecucaoDia() {
            return duracaoMaximaExecucaoDia;
    }
    public void setDuracaoMaximaExecucaoDia(int duracaoMaximaExecucaoDia) {
            this.duracaoMaximaExecucaoDia = duracaoMaximaExecucaoDia;
    }
    public TiposDeTarefaComposite getTipo() {
            return tipo;
    }
    public void setTipo(TiposDeTarefaComposite tipo) {
            this.tipo = tipo;
    }
    
    /**
     * @return the prioridade
     */
    public int getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the dia
     */
    public Dia getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(Dia dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "idTarefa=" + idTarefa + ", descricao=" + descricao + ", dataPrevistaInicio=" + dataPrevistaInicio + ", dataRealInicio=" + dataRealInicio + ", dataPrevistaFim=" + dataPrevistaFim + ", dataRealFim=" + dataRealFim + ", duracaoTotalPrevista=" + duracaoTotalPrevista + ", duracaoTotalReal=" + duracaoTotalReal + ", duracaoMaximaExecucaoDia=" + duracaoMaximaExecucaoDia + ", tipo=" + tipo + ", prioridade=" + prioridade + ", dia=" + dia + '}';
    }
    
	
}
