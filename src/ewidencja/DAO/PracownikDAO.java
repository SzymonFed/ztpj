/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.DAO;

import ewidencja.Model.Dyrektor;
import ewidencja.Model.Handlowiec;
import ewidencja.Model.Pracownik;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Szymon
 */
public class PracownikDAO 
{
   
	private final static String DBURL = "jdbc:postgresql://localhost/ewidencja";
	private final static String DBUSER = "postgres";
	private final static String DBPASS = "root";
	private final static String DBDRIVER = "org.postgresql.Driver";

	private  Connection connection;
	private  Statement statement;
	private  String query;
	private  SQLPracownikParser sqlPracownikParser;
        
        PracownikDAO()
        {
            
        }
       /* public static String SQLQuerySave(Dyrektor pracownik) throws SQLException {
                //System.out.println(pracownik);
		query = sqlPracownikParser.createSaveQuery(pracownik);
            return query;
        }
        public static String SQLQuerySave(Handlowiec pracownik) throws SQLException {
		query = sqlPracownikParser.createSaveQuery(pracownik);
                //System.out.println(query);
            return query;
        }*/
        public String SQLQueryLoad(int id) throws SQLException {
		return query = sqlPracownikParser.createLoadQuery(id);
        }
        public String SQLQueryDelete(String pesel) throws SQLException {
		return query = sqlPracownikParser.deleteQuery(pesel);
        }
        public String SQLQueryLoadAll() throws SQLException {
		return query = sqlPracownikParser.createLoadAllQuery();
        }
        public String SQLQueryCount()
        {
            String supa = sqlPracownikParser.countQuery();
            System.out.println(supa);
            return supa;
        }
        public ResultSet connect(String query){
		try {
			Class.forName(DBDRIVER).newInstance();
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery(query);;
                        return rs;
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
                        ResultSet rs = null;
                        return rs;
		}
	}
        
        public void connectSend(String query){
		try {
			Class.forName(DBDRIVER).newInstance();
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			statement = connection.createStatement();
                        statement.executeUpdate(query);
                        statement.close();
                        connection.close();
                        
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
  
                }
        }
        public void closeConnection() throws SQLException
        {
            this.statement.close();
            this.connection.close();
        }
}
