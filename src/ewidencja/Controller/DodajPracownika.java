/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Controller;

import ewidencja.Model.*;
import java.util.Scanner;
import static ewidencja.Utils.*;
import java.util.Map;

/**
 *
 * @author Szymon
 */
public class DodajPracownika 
{
    Scanner scan = new Scanner(System.in);
    
    public static Pracownik dodajPracownika()
    {
          String pesel = promptForString("PESEL: ");
          String imie = promptForString("Imię: ");
          String nazwisko = promptForString("Nazwisko: ");
          String stanowisko = promptForString("Stanowisko: ");
          double wynagrodzenie = promptForDouble("Wynagrodzenie: ");
          String telefon = promptForString("Telefon: ");
          return new Pracownik (pesel,imie,nazwisko,stanowisko,wynagrodzenie,telefon);
    }
    
    public static Dyrektor dodajDyrektora()
    {
        Pracownik pracownik = dodajPracownika();
        double dodatekSluzbowy = promptForDouble("Dodatek służbowy: ");
        String kartaSluzbowa = promptForString("Numer karty służbowej: ");
        double limitKosztow = promptForDouble("Limit kosztów: ");
        return new Dyrektor(
                pracownik.getPesel()
                ,pracownik.getImie()
                ,pracownik.getNazwisko()
                ,pracownik.getStanowisko()
                ,pracownik.getWynagrodzenie()
                ,pracownik.getTelefon()
                ,dodatekSluzbowy
                ,kartaSluzbowa
                ,limitKosztow);
    }
    public static Handlowiec dodajHandlowca()
    {
        Pracownik pracownik = dodajPracownika();
        double prowizja = promptForDouble("Prowizja: ");
        double limitProwizji = promptForDouble("limitProwizji: ");
        
        return new Handlowiec(
                pracownik.getPesel()
                ,pracownik.getImie()
                ,pracownik.getNazwisko()
                ,pracownik.getStanowisko()
                ,pracownik.getWynagrodzenie()
                ,pracownik.getTelefon()
                ,prowizja
                ,limitProwizji);
    }
    public static void addToMap(Map<String,java.lang.Object> pracownicy,Handlowiec handlowiec)
    {
         pracownicy.put(handlowiec.getPesel(),handlowiec);
    }
    public static void addToMap(Map<String,java.lang.Object> pracownicy,Dyrektor dyrektor)
    {
         pracownicy.put(dyrektor.getPesel(),dyrektor);
    }
}
