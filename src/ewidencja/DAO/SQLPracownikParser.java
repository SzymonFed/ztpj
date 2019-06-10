/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.DAO;

import ewidencja.Model.Dyrektor;
import ewidencja.Model.Handlowiec;
import ewidencja.Model.Pracownik;

/**
 *
 * @author Szymon
 */
public class SQLPracownikParser {

    public static String createSaveQuery(Pracownik pracownik) {		
        System.out.println(pracownik);
        String query = "INSERT INTO pracownicy(pesel,imie,nazwisko,stanowisko,wynagrodzenie,telefon,dodatekSluzbowy,kartaSluzbowa,limitKosztow,prowizja,limitprowizji)  VALUES ('"
                
                + pracownik.getPesel() + "', '"
                + pracownik.getImie() +"', '"
                + pracownik.getNazwisko() +"', '"
                 + pracownik.getStanowisko() +"', '"
                 + pracownik.getWynagrodzenie() +"', '"
                 + pracownik.getTelefon() +"',NULL,NULL,NULL,NULL,NULL);";
        return query;
   }
   public static String createSaveQuery(Dyrektor pracownik) {
		String query = "INSERT INTO pracownicy(pesel,imie,nazwisko,stanowisko,wynagrodzenie,telefon,dodatekSluzbowy,kartaSluzbowa,limitKosztow,prowizja,limitprowizji)  VALUES ('"
                        
                        + pracownik.getPesel() + "', '"
                        + pracownik.getImie() +"', '"
                        + pracownik.getNazwisko() +"', '"
                         + pracownik.getStanowisko() +"', '"
                         + Double.toString(pracownik.getWynagrodzenie()) +"', '"
                         + pracownik.getTelefon() +"', '"
                        +Double.toString(pracownik.getDodatekSluzbowy())+"','"
                        +pracownik.getKartaSluzbowa()+"', '"
                        +Double.toString(pracownik.getLimitKosztow())+"',NULL,NULL);";
  
		return query;
	}
   public static String createSaveQuery(Handlowiec pracownik) {
		
		String query = "INSERT INTO pracownicy(pesel,imie,nazwisko,stanowisko,wynagrodzenie,telefon,dodatekSluzbowy,kartaSluzbowa,limitKosztow,prowizja,limitprowizji)  VALUES ('"                        
                        + pracownik.getPesel() + "', '"
                        + pracownik.getImie() +"', '"
                        + pracownik.getNazwisko() +"', '"
                         + pracownik.getStanowisko() +"', '"
                         + pracownik.getWynagrodzenie() +"', '"
                         + pracownik.getTelefon() +"',NULL,NULL,NULL, '"
                        +pracownik.getProwizja()+"','"
                        +pracownik.getLimitProwizji()+"');";
                    
		return query;
	}
    public static String createLoadQuery(int id) {
		String query = "";
		query = "SELECT * FROM pracownicy WHERE id ='"+id+"';";
		return query;
	}
    public static String createLoadAllQuery() {
		String query = "";
		query = "SELECT * FROM pracownicy";
		return query;
	}
    public static String deleteQuery(String pesel) {
		String query = "";
		query = "DELETE FROM pracownicy WHERE PESEL='"+pesel+"'";
		return query;
	}
    public static String countQuery()
    {
        return "SELECT COUNT (*) AS rowcount FROM pracownicy;";
    }
}
