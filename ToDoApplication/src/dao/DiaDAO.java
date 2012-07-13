/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import model.Dia;



/**
 *
 * @author Nilton
 */
public class DiaDAO {
    public static void create(Dia dia){
        
        ConnectorSingleton.connect();
        ConnectorSingleton.update("INSERT INTO dia (data, calendario_idcalendario,"
                + " VALUES (" 
                + new java.sql.Date(dia.getData().getTime()) + ", "
                + dia.getCalendario().getIdCalendario() + "); " );   
                
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
                dia.getCalendario().setIdCalendario(resultSet.getLong("calendario_idcalendario"));
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
                + dia.getIdDia() + ", calendari_idcalendario ='"
                + dia.getCalendario().getIdCalendario() + "', data =" 
                + dia.getData() + ";");
             
        ConnectorSingleton.close();
    
    } 
    
    public static void delete(long idDia)
    {
        ConnectorSingleton.connect();
        ConnectorSingleton.update("DELETE FROM dia WHERE iddia=" +
                idDia + ";");
        ConnectorSingleton.close();
    }
    
    
}
