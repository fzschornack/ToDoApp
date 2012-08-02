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
        
        Connector.connect();
        Connector.update("INSERT INTO dia (data)"
                + " VALUES ('" 
                + dia.getData() + "'); " );   
                
        Connector.close();    
    }
    
    public static Dia read(long idDia){
        Dia dia = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM dia WHERE iddia ="
                + idDia + ";");
        try{
            if(resultSet.next())
            {
                dia = new Dia();
                dia.setIdDia(resultSet.getLong("iddia"));
                dia.setData(resultSet.getDate("data"));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return dia;
    }
    
    public static Dia read(Date data){
        Dia dia = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM dia WHERE data ='"
                + data+ "';");
        try{
            if(resultSet.next())
            {
                dia = new Dia();
                dia.setIdDia(resultSet.getLong("iddia"));
                dia.setData(resultSet.getDate("data"));
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return dia;
    }
    
    public static void update(Dia dia){
        Connector.connect();
        Connector.update("UPDATE dia SET iddia = " 
                + dia.getIdDia() + ", data ='" 
                + dia.getData() + "';");
             
        Connector.close();
    
    } 
    
    public static void delete(long idDia)
    {
        Connector.connect();
        Connector.update("DELETE FROM dia WHERE iddia=" +
                idDia + ";");
        Connector.close();
    }
    
    public static ArrayList<Dia> getAll(){
        ArrayList<Dia> lista = new ArrayList<Dia>();
        Dia dia = null;
        Connector.connect();
        ResultSet resultSet = Connector.query("SELECT * FROM dia;");
        try{
            while(resultSet.next())
            {
                dia = new Dia();
                dia.setIdDia(resultSet.getLong("iddia"));
                dia.setData(resultSet.getDate("data"));
                lista.add(dia);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Connector.close();
        return lista;
    }
    
    
}
