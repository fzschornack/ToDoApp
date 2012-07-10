package model;

import java.util.ArrayList;

/**
*
* @author Felipe Zschornack
*/
public class TipoTarefa extends TiposDeTarefaComposite
{

	private ArrayList<SubtipoTarefa> subtipos;
	
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
	
	
	
}
