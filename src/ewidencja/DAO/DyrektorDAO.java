/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.DAO;

import ewidencja.Model.Dyrektor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Szymon
 */
public class DyrektorDAO extends PracownikDAO {
    private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/ewidencja";
    private final static String DBUSER = "root";
    private final static String DBPASS = "root";
    private final static String DBDRIVER = "com.mysql.jdbc.Driver";

    private static Connection connection;
    private static Statement statement;
    private static String query;
    private static SQLPracownikParser sqlPracownikParser;

    public static String SQLQuerySave(Dyrektor pracownik) throws SQLException {
            //System.out.println(pracownik);
            query = sqlPracownikParser.createSaveQuery(pracownik);
        return query;
    }
}
