/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Szymon
 */
public class Driver {
    public static void Driver() throws ClassNotFoundException
    {
        Class.forName("D:\\NetBeansProjects\\Ewidencja\\commons-dbcp2-2.6.0");
        
    }
    public static void Connection(String url) throws SQLException
    {
        Connection current = DriverManager.getConnection("jdbc:db2:D:\\NetBeansProjects\\Ewidencja\\myDatabase");
        current.setAutoCommit(false);
    }
    public static void Close(Connection current) throws SQLException
    {
        current.close();
    }
}
