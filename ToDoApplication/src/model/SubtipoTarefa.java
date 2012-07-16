package model;

/**
*
* @author Felipe Zschornack
*/
public class SubtipoTarefa extends TiposDeTarefaComposite {

        private long idSubtipoTarefa;
        private long idTipoTarefa;

        public long getIdSubtipoTarefa() {
            return idSubtipoTarefa;
        }

        public void setIdSubtipoTarefa(long idSubtipoTarefa) {
            this.idSubtipoTarefa = idSubtipoTarefa;
        }        
        
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    /**
     * @return the idTipoTarefa
     */
    public long getIdTipoTarefa() {
        return idTipoTarefa;
    }

    /**
     * @param idTipoTarefa the idTipoTarefa to set
     */
    public void setIdTipoTarefa(long idTipoTarefa) {
        this.idTipoTarefa = idTipoTarefa;
    }
	
}
