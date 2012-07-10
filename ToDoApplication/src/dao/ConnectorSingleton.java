/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Felipe Zschornack
 * 
 *  Nessa classe é utilizado o padrão de projeto "Singleton" 
 * para apenas uma unica instancia da classe ter acesso ao 
 * banco de dados evitando assim problemas de desempenho.
 * 
 * LEMBRAR DE IMPLEMENTAR ESSE SINGLETON!!!!!!!!!!!1
 */
public class ConnectorSingleton {
    
        private static Connection connection = null;
	private static Statement statement = null;
	
        private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost/sip";
	//host defaults to localhost, pgadmin port defaults to 5432
	
        public static void connect() {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL,"root","petcomp");
			statement = connection.createStatement();
		} catch(Exception e) {
			System.out.println("Error in method connect: " + e.getMessage());
		}
	}
        
        public static Connection connect(String database) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL.substring(0, 33) + database
                                ,"root","petcomp");
			statement = connection.createStatement();
		} catch(Exception e) {
			System.out.println("Error in method connect: " + e.getMessage());
		}
                return connection;
	}
	
	public static ResultSet query(String string) {
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(string);
		} catch(Exception e) {
			System.out.println("Error in method query: " + e.getMessage());
		}
		return resultSet;
	}
	
	public static void update(String huh) {
		try {
                        System.out.println(huh);
			statement.executeUpdate(huh);
		} catch(Exception e) {
			System.out.println("Error in method update: " + e.getMessage());
		}
	}
	
	public static void close() {
		try {
			connection.close();
		} catch(Exception e) {
			System.out.println("Error in method close: " + e.getMessage());
		}
	}
    
}
