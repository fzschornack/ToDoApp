/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.TipoTarefa;

/**
 *
 * @author Felipe Zschornack
 */
public class TipoTarefaDAO {
     
    public static void create(TipoTarefa tipoTarefa){
        
        ConnectorSingleton.connect();
        ConnectorSingleton.update("INSERT INTO tipo_tarefa ( nome, calendario_idcalendario)"
                + " VALUES ('" 
                + tipoTarefa.getNome()+ "', "
                + tipoTarefa.getCalendario().getIdCalendario() + "); " );   
                
        ConnectorSingleton.close();    
    }
    
    public static TipoTarefa read(long idTipoTarefa){
        TipoTarefa tipoTarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM tipo_tarefa WHERE idtipo ="
                + idTipoTarefa + ";");
        try{
            if(resultSet.next())
            {
                tipoTarefa = new TipoTarefa();
                tipoTarefa.setIdTipoTarefa(idTipoTarefa);
                tipoTarefa.setNome(resultSet.getString("nome"));
                tipoTarefa.setCalendario(CalendarioDAO.read(resultSet.getLong("calendario_idcalendario")));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return tipoTarefa;
    }
    
    public static void update(TipoTarefa tipoTarefa){
        ConnectorSingleton.connect();
        ConnectorSingleton.update("UPDATE tipo_tarefa SET nome = '" 
                + tipoTarefa.getNome() + "',calendario_idcalendario="
                + tipoTarefa.getCalendario().getIdCalendario() + " WHERE idtipo = " 
                + tipoTarefa.getIdTipoTarefa()+";"); 
             
        ConnectorSingleton.close();
    
    } 
    
    public static void delete(long idTipoTarefa)
    {
        ConnectorSingleton.connect();
        ConnectorSingleton.update("DELETE FROM tarefa WHERE idtipo =" +
                idTipoTarefa + ";");
        ConnectorSingleton.close();
    }
    
    public static ArrayList<TipoTarefa> getAll(){
        ArrayList<TipoTarefa> lista = new ArrayList<TipoTarefa>();
        TipoTarefa tipoTarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM tipo_tarefa;");
        try{
            while(resultSet.next())
            {
                tipoTarefa = new TipoTarefa();
                tipoTarefa.setIdTipoTarefa(resultSet.getLong("idtipo"));
                tipoTarefa.setNome(resultSet.getString("nome"));
                tipoTarefa.setCalendario(CalendarioDAO.read(resultSet.getLong("calendario_idcalendario")));
                lista.add(tipoTarefa);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return lista;
    }
    
}
