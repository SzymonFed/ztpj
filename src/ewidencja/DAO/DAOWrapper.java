/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.DAO;

import ewidencja.Model.DataBase;
import ewidencja.Model.Dyrektor;
import ewidencja.Model.Handlowiec;
import ewidencja.Model.Pracownik;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Szymon
 */
public class DAOWrapper {
    /*public static void savePracownik(Pracownik pracownik) throws SQLException
    {
        pracownikDAO.connectSend(pracownikDAO.SQLQuerySave(pracownik));
        
    }*/
    public static PracownikDAO pracownikDAO = new PracownikDAO();
    public static void savePracownik(Dyrektor pracownik) throws SQLException
    {
        //System.out.println(pracownik);
        pracownikDAO.connectSend(DyrektorDAO.SQLQuerySave(pracownik));
        
    }
    public static void savePracownik(Handlowiec pracownik) throws SQLException
    {
        pracownikDAO.connectSend(HandlowiecDAO.SQLQuerySave(pracownik));
        
    }
    public static Pracownik loadPracownik(int id) throws SQLException
    {
        Pracownik pracownik;
        ResultSet rs = pracownikDAO.connect(pracownikDAO.SQLQueryLoad(id));
        //System.out.println(id);
        if (rs.next()){
        pracownik = new Pracownik(rs.getString("pesel")
        ,rs.getString("imie")
        ,rs.getString("nazwisko")
        ,rs.getString("stanowisko")
        ,rs.getDouble("wynagrodzenie")
        ,rs.getString("telefon"));
        switch (pracownik.getStanowisko())
            {
                case ("Dyrektor"):
                    Dyrektor dyrektor = new Dyrektor(pracownik.getPesel()
                    ,pracownik.getImie()
                    ,pracownik.getNazwisko()
                    ,pracownik.getStanowisko()
                    ,pracownik.getWynagrodzenie()
                    ,pracownik.getTelefon()
                    ,rs.getDouble("dodatekSluzbowy"),rs.getString("kartaSluzbowa"),rs.getDouble("limitKosztow"));
                    pracownikDAO.closeConnection();
                    return dyrektor;
                case ("Handlowiec"):
                    Handlowiec handlowiec = new Handlowiec(pracownik.getPesel()
                    ,pracownik.getImie()
                    ,pracownik.getNazwisko()
                    ,pracownik.getStanowisko()
                    ,pracownik.getWynagrodzenie()
                    ,pracownik.getTelefon()
                    ,rs.getDouble("prowizja"),rs.getDouble("limitProwizji"));
                    pracownikDAO.closeConnection();
                    return handlowiec;
                default:
                    return pracownik;
                   
            }
        }
        return null;
    }
    public static void deletePracownik(String pesel) throws SQLException
    {
        pracownikDAO.connectSend(pracownikDAO.SQLQueryDelete(pesel));
        
    }
    public static List<Pracownik> loadAllPracownik() throws SQLException
    {
        Pracownik pracownik;
        ResultSet rs = pracownikDAO.connect(pracownikDAO.SQLQueryLoadAll());
        List<Pracownik> workersList = new ArrayList<>();
        System.out.println();
        while (rs.next())
        {
           pracownik = new Pracownik(rs.getString("pesel")
                        ,rs.getString("imie")
                        ,rs.getString("nazwisko")
                        ,rs.getString("stanowisko")
                        ,rs.getDouble("wynagrodzenie")
                        ,rs.getString("telefon"));
        switch (pracownik.getStanowisko())
            {
                case ("Dyrektor"):
                    Dyrektor dyrektor = new Dyrektor(pracownik.getPesel()
                    ,pracownik.getImie()
                    ,pracownik.getNazwisko()
                    ,pracownik.getStanowisko()
                    ,pracownik.getWynagrodzenie()
                    ,pracownik.getTelefon()
                    ,rs.getDouble("dodatekSluzbowy"),rs.getString("kartaSluzbowa"),rs.getDouble("limitKosztow"));
                    //5
                    //pracownikDAO.closeConnection();
                    workersList.add(dyrektor);
                case ("Handlowiec"):
                    Handlowiec handlowiec = new Handlowiec(pracownik.getPesel()
                    ,pracownik.getImie()
                    ,pracownik.getNazwisko()
                    ,pracownik.getStanowisko()
                    ,pracownik.getWynagrodzenie()
                    ,pracownik.getTelefon()
                    ,rs.getDouble("prowizja"),rs.getDouble("limitProwizji"));
                    //pracownikDAO.closeConnection();
                    workersList.add(handlowiec);
                default:
            }

        }
        pracownikDAO.closeConnection();
        return workersList;
    }
    public static int countPracownik() throws SQLException
    {
        String count = "";
        ResultSet rs = pracownikDAO.connect(pracownikDAO.SQLQueryCount());
        if (rs.next()){ 
         count = rs.getString(1);
        System.out.println(count);}
        pracownikDAO.closeConnection();
        return parseInt(count);
    }
}
