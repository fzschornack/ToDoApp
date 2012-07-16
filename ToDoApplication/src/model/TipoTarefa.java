package model;

import java.util.ArrayList;

/**
*
* @author Felipe Zschornack
*/
public class TipoTarefa extends TiposDeTarefaComposite
{
        
        private long idTipoTarefa;
        private Calendario calendario;

        public TipoTarefa(Calendario calendario) {
            this.calendario = calendario;
        }
        
	private ArrayList<SubtipoTarefa> subtipos;

        public TipoTarefa() {
        }
	
        public long getIdTipoTarefa() {
        return idTipoTarefa;
        }

        public void setIdTipoTarefa(long idTipoTarefa) {
            this.idTipoTarefa = idTipoTarefa;
        }
        
	public void adicionarSubtipo(SubtipoTarefa subtipo) {
		this.subtipos.add(subtipo);
	}
	
	public void removerSubtipo(SubtipoTarefa subtipo) {
		this.subtipos.remove(subtipo);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<SubtipoTarefa> getSubtipos() {
		return subtipos;
	}
	public void setSubtipos(ArrayList<SubtipoTarefa> subtipos) {
		this.subtipos = subtipos;
	}

    /**
     * @return the calendario
     */
    public Calendario getCalendario() {
        return calendario;
    }

    /**
     * @param calendario the calendario to set
     */
    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }
	
	
	
}
