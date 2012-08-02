package model;

/**
*
* @author Felipe Zschornack
*/
public class SubtipoTarefa extends TiposDeTarefaComposite {

        private long idSubtipoTarefa;
        private TipoTarefa tipoTarefa;

        public SubtipoTarefa(TipoTarefa tipoTarefa) {
            this.tipoTarefa = tipoTarefa;
        }
        
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

        public TipoTarefa getTipoTarefa() {
            return tipoTarefa;
        }

        public void setTipoTarefa(TipoTarefa tipoTarefa) {
            this.tipoTarefa = tipoTarefa;
        }

	
}
