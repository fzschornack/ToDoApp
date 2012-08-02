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
        
        Connector.connect();
        Connector.update("INSERT INTO subtipo_tarefa ( nome, tipo_tarefa_idtipo)"
                + " VALUES ('" 
                + subtipoTarefa.getNome()+ "', "
                + subtipoTarefa.getTipoTarefa().getIdTipoTarefa() + "); " );   
                
        Connector.close();    
    }
    
    public static SubtipoTarefa read(long idSubtipoTarefa){
        SubtipoTarefa subtipoTarefa = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM subtipo_tarefa WHERE idsubtipo ="
                + idSubtipoTarefa + ";");
        try{
            if(resultSet.next())
            {
                subtipoTarefa = new SubtipoTarefa(TipoTarefaDAO.read(resultSet.getLong("tipo_tarefa_idtipo")));
                subtipoTarefa.setIdSubtipoTarefa(idSubtipoTarefa);
                subtipoTarefa.setNome(resultSet.getString("nome"));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return subtipoTarefa;
    }
    
    public static SubtipoTarefa read(String nome){
        SubtipoTarefa subtipoTarefa = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM subtipo_tarefa WHERE nome LIKE '%"
                + nome + "%';");
        try{
            if(resultSet.next())
            {
                subtipoTarefa = new SubtipoTarefa(TipoTarefaDAO.read(resultSet.getLong("tipo_tarefa_idtipo")));
                subtipoTarefa.setIdSubtipoTarefa(resultSet.getLong("idsubtipo"));
                subtipoTarefa.setNome(resultSet.getString("nome"));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return subtipoTarefa;
    }
    
    public static void update(SubtipoTarefa subtipoTarefa){
        Connector.connect();
        Connector.update("UPDATE subtipo_tarefa SET nome = '" 
                + subtipoTarefa.getNome() + "',tipo_tarefa_idtipo="
                + subtipoTarefa.getTipoTarefa().getIdTipoTarefa() + " WHERE idsubtipo = " 
                + subtipoTarefa.getIdSubtipoTarefa()+";"); 
             
        Connector.close();
    
    } 
    
    public static void delete(long idSubtipoTarefa)
    {
        Connector.connect();
        Connector.update("DELETE FROM tarefa WHERE idsubtipo =" +
                idSubtipoTarefa + ";");
        Connector.close();
    }
    
    public static ArrayList<SubtipoTarefa> getAll(){
        ArrayList<SubtipoTarefa> lista = new ArrayList<SubtipoTarefa>();
        SubtipoTarefa subtipoTarefa = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM subtipo_tarefa;");
        try{
            while(resultSet.next())
            {
                subtipoTarefa = new SubtipoTarefa(TipoTarefaDAO.read(resultSet.getLong("tipo_tarefa_idtipo")));
                subtipoTarefa.setIdSubtipoTarefa(resultSet.getLong("idsubtipo"));
                subtipoTarefa.setNome(resultSet.getString("nome"));
                lista.add(subtipoTarefa);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return lista;
    }
    
    public static ArrayList<SubtipoTarefa> getAllIdTipo(long idTipo){
        ArrayList<SubtipoTarefa> lista = new ArrayList<SubtipoTarefa>();
        SubtipoTarefa subtipoTarefa = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM subtipo_tarefa WHERE tipo_tarefa_idtipo = "+
                idTipo+";");
        try{
            while(resultSet.next())
            {
                subtipoTarefa = new SubtipoTarefa(TipoTarefaDAO.read(resultSet.getLong("tipo_tarefa_idtipo")));
                subtipoTarefa.setIdSubtipoTarefa(resultSet.getLong("idsubtipo"));
                subtipoTarefa.setNome(resultSet.getString("nome"));
                lista.add(subtipoTarefa);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return lista;
    }
    
}
