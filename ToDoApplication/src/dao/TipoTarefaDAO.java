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
        
        Connector.connect();
        Connector.update("INSERT INTO tipo_tarefa ( nome)"
                + " VALUES ('" 
                + tipoTarefa.getNome()+ "'); " );   
                
        Connector.close();    
    }
    
    public static TipoTarefa read(long idTipoTarefa){
        TipoTarefa tipoTarefa = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM tipo_tarefa WHERE idtipo ="
                + idTipoTarefa + ";");
        try{
            if(resultSet.next())
            {
                tipoTarefa = new TipoTarefa();
                tipoTarefa.setIdTipoTarefa(idTipoTarefa);
                tipoTarefa.setNome(resultSet.getString("nome"));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return tipoTarefa;
    }
    
    public static TipoTarefa read(String nome){
        TipoTarefa tipoTarefa = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM tipo_tarefa WHERE nome LIKE '%"
                + nome + "%';");
        try{
            if(resultSet.next())
            {
                tipoTarefa = new TipoTarefa();
                tipoTarefa.setIdTipoTarefa(resultSet.getLong("idtipo"));
                tipoTarefa.setNome(resultSet.getString("nome"));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return tipoTarefa;
    }
    
    public static void update(TipoTarefa tipoTarefa){
        Connector.connect();
        Connector.update("UPDATE tipo_tarefa SET nome = '" 
                + tipoTarefa.getNome() + " WHERE idtipo = " 
                + tipoTarefa.getIdTipoTarefa()+";"); 
             
        Connector.close();
    
    } 
    
    public static void delete(long idTipoTarefa)
    {
        Connector.connect();
        Connector.update("DELETE FROM tarefa WHERE idtipo =" +
                idTipoTarefa + ";");
        Connector.close();
    }
    
    public static ArrayList<TipoTarefa> getAll(){
        ArrayList<TipoTarefa> lista = new ArrayList<TipoTarefa>();
        TipoTarefa tipoTarefa = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM tipo_tarefa;");
        try{
            while(resultSet.next())
            {
                tipoTarefa = new TipoTarefa();
                tipoTarefa.setIdTipoTarefa(resultSet.getLong("idtipo"));
                tipoTarefa.setNome(resultSet.getString("nome"));
                lista.add(tipoTarefa);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return lista;
    }
    
}
