package model;

/**
*
* @author Felipe Zschornack
*/
public class SubtipoTarefa extends TiposDeTarefaComposite {

        private long idSubtipoTarefa;

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
	
}
