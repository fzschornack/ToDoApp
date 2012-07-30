/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Dia;



/**
 *
 * @author Nilton
 */
public class DiaDAO {
    public static void create(Dia dia){
        
        ConnectorSingleton.connect();
        ConnectorSingleton.update("INSERT INTO dia (data)"
                + " VALUES ('" 
                + new java.sql.Date(dia.getData().getTime()) + "'); " );   
                
        ConnectorSingleton.close();    
    }
    
    public static Dia read(long idDia){
        Dia dia = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM dia WHERE iddia ="
                + idDia + ";");
        try{
            if(resultSet.next())
            {
                dia = new Dia();
                dia.setIdDia(resultSet.getLong("iddia"));
                dia.setData(resultSet.getDate("data"));
                dia.setTarefas(TarefaDAO.getAllIdDia(resultSet.getLong("iddia")));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return dia;
    }
    
    public static Dia read(Date data){
        Dia dia = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM dia WHERE data ='"
                + new java.sql.Date(data.getTime())+ "';");
        try{
            if(resultSet.next())
            {
                dia = new Dia();
                dia.setIdDia(resultSet.getLong("iddia"));
                dia.setData(resultSet.getDate("data"));
                dia.setTarefas(TarefaDAO.getAllIdDia(resultSet.getLong("iddia")));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return dia;
    }
    
    public static void update(Dia dia){
        ConnectorSingleton.connect();
        ConnectorSingleton.update("UPDATE dia SET iddia = " 
                + dia.getIdDia() + ", data ='" 
                + dia.getData() + "';");
             
        ConnectorSingleton.close();
    
    } 
    
    public static void delete(long idDia)
    {
        ConnectorSingleton.connect();
        ConnectorSingleton.update("DELETE FROM dia WHERE iddia=" +
                idDia + ";");
        ConnectorSingleton.close();
    }
    
    public static ArrayList<Dia> getAll(){
        ArrayList<Dia> lista = new ArrayList<Dia>();
        Dia dia = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM dia;");
        try{
            while(resultSet.next())
            {
                dia = new Dia();
                dia.setIdDia(resultSet.getLong("iddia"));
                dia.setData(resultSet.getDate("data"));
                dia.setTarefas(TarefaDAO.getAllIdDia(resultSet.getLong("iddia")));
                lista.add(dia);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return lista;
    }
    
    
}
