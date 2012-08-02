package model;

import java.sql.Time;
import java.util.ArrayList;

/**
*
* @author Felipe Zschornack
* 
*   Nessa classe é utilizado o padrão Singleton, já que deve existir somente uma Configuracao do Calendario para o pragrama todo,
* ou seja, somente uma instancia de ConfiguracaoCalendario
*/
public class ConfiguracaoCalendario {

        private long idConfiguracaoCalendario;
	private String horarioAlocacaoTarefas;
	private int slotTempo;
        
        private static ConfiguracaoCalendario instancia = new ConfiguracaoCalendario();
               
        private ConfiguracaoCalendario() {
	}
        
        public static ConfiguracaoCalendario getInstancia() {
            return instancia;
        }
        
        public long getIdConfiguracaoCalendario() {
            return idConfiguracaoCalendario;
        }

        public void setIdConfiguracaoCalendario(long idConfiguracaoCalendario) {
            this.idConfiguracaoCalendario = idConfiguracaoCalendario;
        }

	public String getHorarioAlocacaoTarefas() {
		return horarioAlocacaoTarefas;
	}

	public void setHorarioAlocacaoTarefas(String horarioAlocacaoTarefas) {
		this.horarioAlocacaoTarefas = horarioAlocacaoTarefas;
	}

	public int getSlotTempo() {
		return slotTempo;
	}

	public void setSlotTempo(int slotTempo) {
		this.slotTempo = slotTempo;
	}
        
        public Integer getNumeroHorasDia() {
            int numeroHorasDia = 0;
            
            for(int i=0; i<24; i++)
                   if(this.horarioAlocacaoTarefas.charAt(i) == '1')
                       numeroHorasDia++;
            
            return numeroHorasDia;
        }
	
}
