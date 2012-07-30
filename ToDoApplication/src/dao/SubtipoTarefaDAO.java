/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.SubtipoTarefa;

/**
 *
 * @author Felipe Zschornack
 */
public class SubtipoTarefaDAO {
     
    public static void create(SubtipoTarefa subtipoTarefa){
        
        ConnectorSingleton.connect();
        ConnectorSingleton.update("INSERT INTO subtipo_tarefa ( nome, tipo_tarefa_idtipo)"
                + " VALUES ('" 
                + subtipoTarefa.getNome()+ "', "
                + subtipoTarefa.getIdTipoTarefa() + "); " );   
                
        ConnectorSingleton.close();    
    }
    
    public static SubtipoTarefa read(long idSubtipoTarefa){
        SubtipoTarefa subtipoTarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM subtipo_tarefa WHERE idsubtipo ="
                + idSubtipoTarefa + ";");
        try{
            if(resultSet.next())
            {
                subtipoTarefa = new SubtipoTarefa();
                subtipoTarefa.setIdSubtipoTarefa(idSubtipoTarefa);
                subtipoTarefa.setNome(resultSet.getString("nome"));
                subtipoTarefa.setIdTipoTarefa(resultSet.getLong("tipo_tarefa_idtipo"));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return subtipoTarefa;
    }
    
    public static SubtipoTarefa read(String nome){
        SubtipoTarefa subtipoTarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM subtipo_tarefa WHERE nome LIKE '%"
                + nome + "%';");
        try{
            if(resultSet.next())
            {
                subtipoTarefa = new SubtipoTarefa();
                subtipoTarefa.setIdSubtipoTarefa(resultSet.getLong("idsubtipo"));
                subtipoTarefa.setNome(resultSet.getString("nome"));
                subtipoTarefa.setIdTipoTarefa(resultSet.getLong("tipo_tarefa_idtipo"));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return subtipoTarefa;
    }
    
    public static void update(SubtipoTarefa subtipoTarefa){
        ConnectorSingleton.connect();
        ConnectorSingleton.update("UPDATE subtipo_tarefa SET nome = '" 
                + subtipoTarefa.getNome() + "',tipo_tarefa_idtipo="
                + subtipoTarefa.getIdTipoTarefa() + " WHERE idsubtipo = " 
                + subtipoTarefa.getIdSubtipoTarefa()+";"); 
             
        ConnectorSingleton.close();
    
    } 
    
    public static void delete(long idSubtipoTarefa)
    {
        ConnectorSingleton.connect();
        ConnectorSingleton.update("DELETE FROM tarefa WHERE idsubtipo =" +
                idSubtipoTarefa + ";");
        ConnectorSingleton.close();
    }
    
    public static ArrayList<SubtipoTarefa> getAll(){
        ArrayList<SubtipoTarefa> lista = new ArrayList<SubtipoTarefa>();
        SubtipoTarefa subtipoTarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM subtipo_tarefa;");
        try{
            while(resultSet.next())
            {
                subtipoTarefa = new SubtipoTarefa();
                subtipoTarefa.setIdSubtipoTarefa(resultSet.getLong("idsubtipo"));
                subtipoTarefa.setNome(resultSet.getString("nome"));
                subtipoTarefa.setIdTipoTarefa(resultSet.getLong("tipo_tarefa_idtipo"));
                lista.add(subtipoTarefa);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return lista;
    }
    
    public static ArrayList<SubtipoTarefa> getAllIdTipo(long idTipo){
        ArrayList<SubtipoTarefa> lista = new ArrayList<SubtipoTarefa>();
        SubtipoTarefa subtipoTarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM subtipo_tarefa WHERE tipo_tarefa_idtipo = "+
                idTipo+";");
        try{
            while(resultSet.next())
            {
                subtipoTarefa = new SubtipoTarefa();
                subtipoTarefa.setIdSubtipoTarefa(resultSet.getLong("idsubtipo"));
                subtipoTarefa.setNome(resultSet.getString("nome"));
                subtipoTarefa.setIdTipoTarefa(resultSet.getLong("tipo_tarefa_idtipo"));
                lista.add(subtipoTarefa);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return lista;
    }
    
}
