/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import model.Calendario;
import model.Tarefa;

/**
 *
 * @author Nilton
 */
public class CalendarioDAO {
    public static void create(Calendario calendario){
        
        ConnectorSingleton.connect();
        ConnectorSingleton.update("INSERT INTO calendario (descricao, data_prevista_inicio,"
                + "data_real_inicio,data_prevista_fim, data_real_fim, duracao_total_prevista,"
                + "duracao_total_real, duracao_maxima_execucao_dia, tarefa_urgente,"
                + "tarefa_importante, tipo,"
                + "dia_iddia)"
                + " VALUES ('"
                + calendario.getConfigCal() + "','"
                + calendario.getDias() + "','"
                + calendario.getTipos()+ "'); " );   
                
        ConnectorSingleton.close();    
    }
     public static Calendario read(long idCalendario){
        Calendario calendario = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM calendario WHERE idcalendario="
                + idCalendario + ";");
        try{
            if(resultSet.next())
            {
                calendario = new Calendario();
                calendario.setIdCalendario(idCalendario);
             //   calendario.setConfigCal(resultSet.getString("'configuracao_calendario'"));
               // calendario.setDias(resultSet.getDate("dias"));
                // calendario.setTipos(resultSet.getString("tipo"));
                
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return calendario;
    }
     
      public static void update(Calendario calendario){
        ConnectorSingleton.connect();
        ConnectorSingleton.update("UPDATE calendario SET configuracao_calendario = '" 
                + calendario.getConfigCal() + "',idcalendario ="
                + calendario.getIdCalendario() + ", dias= '"
                + calendario.getDias() + "', tipo ='" 
                + calendario.getTipos() +"'"); 
             
        ConnectorSingleton.close();
    
    } 
    
    public static void delete(long idCalendario)
    {
        ConnectorSingleton.connect();
        ConnectorSingleton.update("DELETE FROM calendario WHERE idcalendario=" +
                idCalendario + ";");
        ConnectorSingleton.close();
    }
}
