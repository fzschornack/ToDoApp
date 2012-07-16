package model;

import java.sql.Time;
import java.util.ArrayList;

/**
*
* @author Felipe Zschornack
*/
public class ConfiguracaoCalendario {

        private long idConfiguracaoCalendario;
	private ArrayList<Boolean> diasUteis;
	private ArrayList<Boolean> horarioAlocacaoTarefas;
	private int slotTempo;
        private Calendario calendario;

        public ConfiguracaoCalendario(Calendario calendario, ArrayList<Boolean> diasUteis, ArrayList<Boolean> horarioAlocacaoTarefas, int slotTempo) {
            this.diasUteis = diasUteis;
            this.horarioAlocacaoTarefas = horarioAlocacaoTarefas;
            this.slotTempo = slotTempo;
            this.calendario = calendario;
        }
               
        public ConfiguracaoCalendario() {
            this.diasUteis = new ArrayList<Boolean>(7);
            this.horarioAlocacaoTarefas = new ArrayList<Boolean>(24);
	}
        
        public long getIdConfiguracaoCalendario() {
            return idConfiguracaoCalendario;
        }

        public void setIdConfiguracaoCalendario(long idConfiguracaoCalendario) {
            this.idConfiguracaoCalendario = idConfiguracaoCalendario;
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

	public int getSlotTempo() {
		return slotTempo;
	}

	public void setSlotTempo(int slotTempo) {
		this.slotTempo = slotTempo;
	}
	
	public Integer getNumeroDiasUteis() {
            int numeroDiasUteis = 0;
            
            for(int i=0; i<7; i++)
                   if(this.diasUteis.get(i) == true)
                       numeroDiasUteis++;
            
            return numeroDiasUteis;
        }
        
        public Integer getNumeroHorasDia() {
            int numeroHorasDia = 0;
            
            for(int i=0; i<24; i++)
                   if(this.horarioAlocacaoTarefas.get(i) == true)
                       numeroHorasDia++;
            
            return numeroHorasDia;
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
