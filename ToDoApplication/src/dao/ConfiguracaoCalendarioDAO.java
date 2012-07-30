/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.ConfiguracaoCalendario;

/**
 *
 * @author Nilton
 */
public class ConfiguracaoCalendarioDAO {
     
    private static String dias;
    private static String horarios;
    private static ArrayList<Boolean> diasUteis;
    private static ArrayList<Boolean> horarioAlocacaoTarefas;
    
    public static void create(ConfiguracaoCalendario configuracaoCalendario){
        
        dias = "";
        for(int i=0; i<7; i++)
               if(configuracaoCalendario.getDiasUteis().get(i) == true)
                    dias += "1";
               else
                   dias += "0";
        
        horarios = "";
        for(int i=0; i<24; i++)
               if(configuracaoCalendario.getHorarioAlocacaoTarefas().get(i) == true)
                    horarios += "1";
               else
                   horarios += "0";
                
        
        ConnectorSingleton.connect();
        ConnectorSingleton.update("INSERT INTO configuracao_calendario ( slot_tempo,"
                + " dias, horarios)"
                + " VALUES ('" 
                + configuracaoCalendario.getSlotTempo() + "', '"
                + dias + "', '"
                + horarios + "'); " );   
                
        ConnectorSingleton.close();    
    }
    
    public static ConfiguracaoCalendario read(long idConfiguracaoCalendario){
        ConfiguracaoCalendario configuracaoCalendario = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM configuracao_calendario WHERE idconfiguracao_calendario ="
                + idConfiguracaoCalendario + ";");
        try{
            if(resultSet.next())
            {
                diasUteis = new ArrayList<Boolean>(7);
		horarioAlocacaoTarefas = new ArrayList<Boolean>(24);
                
                configuracaoCalendario = new ConfiguracaoCalendario();
                configuracaoCalendario.setIdConfiguracaoCalendario(idConfiguracaoCalendario);
                configuracaoCalendario.setSlotTempo(resultSet.getInt("slot_tempo"));
                
                dias = resultSet.getString("dias");
                horarios = resultSet.getString("horarios");
                for(int i=0; i<7; i++)
                    if(dias.charAt(i) == 1)
                            diasUteis.set(i, Boolean.TRUE);
                    else
                        diasUteis.set(i, Boolean.FALSE);
                
                for(int i=0; i<24; i++)
                    if(horarios.charAt(i) == 1)
                            horarioAlocacaoTarefas.set(i, Boolean.TRUE);
                    else
                        horarioAlocacaoTarefas.set(i, Boolean.FALSE);
                
                configuracaoCalendario.setDiasUteis(diasUteis);
                configuracaoCalendario.setHorarioAlocacaoTarefas(horarioAlocacaoTarefas);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return configuracaoCalendario;
    }
    
    public static void update(ConfiguracaoCalendario configuracaoCalendario){
        
        dias = "";
        for(int i=0; i<7; i++)
               if(configuracaoCalendario.getDiasUteis().get(i) == true)
                    dias += "1";
               else
                   dias += "0";
        
        horarios = "";
        for(int i=0; i<24; i++)
               if(configuracaoCalendario.getHorarioAlocacaoTarefas().get(i) == true)
                    horarios += "1";
               else
                   horarios += "0";
        
        ConnectorSingleton.connect();
        ConnectorSingleton.update("UPDATE configuracao_calendario SET slot_tempo = " 
                + configuracaoCalendario.getSlotTempo() + ", dias ='"
                + dias + "', horarios ='"
                + horarios +"' WHERE idconfiguracao_calendario = " 
                + configuracaoCalendario.getIdConfiguracaoCalendario()+";"); 
             
        ConnectorSingleton.close();
    
    } 
    
    public static void delete(long idConfiguracaoCalendario)
    {
        ConnectorSingleton.connect();
        ConnectorSingleton.update("DELETE FROM configuracao_calendario WHERE idconfiguracao_calendario =" +
                idConfiguracaoCalendario + ";");
        ConnectorSingleton.close();
    }
    
    public static ArrayList<ConfiguracaoCalendario> getAll(){
        ArrayList<ConfiguracaoCalendario> lista = new ArrayList<ConfiguracaoCalendario>();
        ConfiguracaoCalendario configuracaoCalendario = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM configuracao_calendario;");
        try{
            while(resultSet.next())
            {
                diasUteis = new ArrayList<Boolean>(7);
		horarioAlocacaoTarefas = new ArrayList<Boolean>(24);
                
                configuracaoCalendario = new ConfiguracaoCalendario();
                configuracaoCalendario.setIdConfiguracaoCalendario(resultSet.getLong("idconfiguracao_calendario"));
                configuracaoCalendario.setSlotTempo(resultSet.getInt("slot_tempo"));
                
                dias = resultSet.getString("dias");
                horarios = resultSet.getString("horarios");
                for(int i=0; i<7; i++)
                    if(dias.charAt(i) == 1)
                            diasUteis.set(i, Boolean.TRUE);
                    else
                        diasUteis.set(i, Boolean.FALSE);
                
                for(int i=0; i<24; i++)
                    if(horarios.charAt(i) == 1)
                            horarioAlocacaoTarefas.set(i, Boolean.TRUE);
                    else
                        horarioAlocacaoTarefas.set(i, Boolean.FALSE);
                
                configuracaoCalendario.setDiasUteis(diasUteis);
                configuracaoCalendario.setHorarioAlocacaoTarefas(horarioAlocacaoTarefas);
                lista.add(configuracaoCalendario);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return lista;
    }
    
}
