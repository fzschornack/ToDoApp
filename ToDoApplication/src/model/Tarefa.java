package model;

import java.sql.Date;
import java.sql.Time;

/**
*
* @author Felipe Zschornack
*/
public class Tarefa {
	
	private long id;
	private String descricao;
	private Date dataPrevistaInicio;
	private Date dataRealInicio;
	private Date dataPrevistaFim;
	private Date dataRealFim;
	private Time duracaoTotalPrevista;
	private Time duracaoTotalReal;
	private Time duracaoMaximaExecucaoDia;
	private boolean tarefaUrgente;
	private boolean tarefaImportante;
	private TiposDeTarefaComposite tipo;
	
        public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		int altera;
		this.dataRealFim = dataRealFim;
	}
	public Time getDuracaoTotalPrevista() {
		return duracaoTotalPrevista;
	}
	public void setDuracaoTotalPrevista(Time duracaoTotalPrevista) {
		this.duracaoTotalPrevista = duracaoTotalPrevista;
	}
	public Time getDuracaoTotalReal() {
		return duracaoTotalReal;
	}
	public void setDuracaoTotalReal(Time duracaoTotalReal) {
		this.duracaoTotalReal = duracaoTotalReal;
	}
	public Time getDuracaoMaximaExecucaoDia() {
		return duracaoMaximaExecucaoDia;
	}
	public void setDuracaoMaximaExecucaoDia(Time duracaoMaximaExecucaoDia) {
		this.duracaoMaximaExecucaoDia = duracaoMaximaExecucaoDia;
	}
	public boolean isTarefaUrgente() {
		return tarefaUrgente;
	}
	public void setTarefaUrgente(boolean tarefaUrgente) {
		this.tarefaUrgente = tarefaUrgente;
	}
	public boolean isTarefaImportante() {
		return tarefaImportante;
	}
	public void setTarefaImportante(boolean tarefaImportante) {
		this.tarefaImportante = tarefaImportante;
	}
	public TiposDeTarefaComposite getTipo() {
		return tipo;
	}
	public void setTipo(TiposDeTarefaComposite tipo) {
		this.tipo = tipo;
	}
	
	
}
