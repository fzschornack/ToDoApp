package model;

import java.sql.Time;
import java.util.ArrayList;

/**
*
* @author Felipe Zschornack
*/
public class ConfiguracaoCalendario {

	private ArrayList<Boolean> diasUteis;
	private ArrayList<Boolean> horarioAlocacaoTarefas;
	private Time slotTempo;
	
	public ConfiguracaoCalendario() {
		this.diasUteis = new ArrayList<Boolean>(7);
		this.horarioAlocacaoTarefas = new ArrayList<Boolean>(24);
	}

	public ArrayList<Boolean> getDiasUteis() {
		return diasUteis;
	}

	public void setDiasUteis(ArrayList<Boolean> diasUteis) {
		this.diasUteis = diasUteis;
	}

	public ArrayList<Boolean> getHorarioAlocacaoTarefas() {
		return horarioAlocacaoTarefas;
	}

	public void setHorarioAlocacaoTarefas(ArrayList<Boolean> horarioAlocacaoTarefas) {
		this.horarioAlocacaoTarefas = horarioAlocacaoTarefas;
	}

	public Time getSlotTempo() {
		return slotTempo;
	}

	public void setSlotTempo(Time slotTempo) {
		this.slotTempo = slotTempo;
	}
	
	
	
}
