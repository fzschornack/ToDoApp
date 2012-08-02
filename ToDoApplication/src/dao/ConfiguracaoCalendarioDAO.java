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
    private static String horarioAlocacaoTarefas;
    
    public static void create(ConfiguracaoCalendario configuracaoCalendario){
        
        Connector.connect();
        Connector.update("INSERT INTO configuracao_calendario ( slot_tempo,"
                + " horarios)"
                + " VALUES (" 
                + configuracaoCalendario.getSlotTempo() + ", '"
                + configuracaoCalendario.getHorarioAlocacaoTarefas() + "'); " );   
                
        Connector.close();    
    }
    
    public static ConfiguracaoCalendario read(long idConfiguracaoCalendario){
        ConfiguracaoCalendario configuracaoCalendario = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM configuracao_calendario WHERE idconfiguracao_calendario ="
                + idConfiguracaoCalendario + ";");
        try{
            if(resultSet.next())
            {
               
                configuracaoCalendario = ConfiguracaoCalendario.getInstancia();
                configuracaoCalendario.setIdConfiguracaoCalendario(idConfiguracaoCalendario);
                configuracaoCalendario.setSlotTempo(resultSet.getInt("slot_tempo"));
               
                configuracaoCalendario.setHorarioAlocacaoTarefas(resultSet.getString("horarios"));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return configuracaoCalendario;
    }
    
    public static void update(ConfiguracaoCalendario configuracaoCalendario){
        
        Connector.connect();
        Connector.update("UPDATE configuracao_calendario SET slot_tempo = " 
                + configuracaoCalendario.getSlotTempo() + "', horarios ='"
                + configuracaoCalendario.getHorarioAlocacaoTarefas() +"' WHERE idconfiguracao_calendario = " 
                + configuracaoCalendario.getIdConfiguracaoCalendario()+";"); 
             
        Connector.close();
    
    } 
    
    public static void delete(long idConfiguracaoCalendario)
    {
        Connector.connect();
        Connector.update("DELETE FROM configuracao_calendario WHERE idconfiguracao_calendario =" +
                idConfiguracaoCalendario + ";");
        Connector.close();
    }
    
    public static ArrayList<ConfiguracaoCalendario> getAll(){
        ArrayList<ConfiguracaoCalendario> lista = new ArrayList<ConfiguracaoCalendario>();
        ConfiguracaoCalendario configuracaoCalendario = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM configuracao_calendario;");
        try{
            while(resultSet.next())
            {
             
                configuracaoCalendario = ConfiguracaoCalendario.getInstancia();
                configuracaoCalendario.setIdConfiguracaoCalendario(resultSet.getLong("idconfiguracao_calendario"));
                configuracaoCalendario.setSlotTempo(resultSet.getInt("slot_tempo"));
              
                configuracaoCalendario.setHorarioAlocacaoTarefas(resultSet.getString("horarios"));
                lista.add(configuracaoCalendario);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return lista;
    }
    
}
