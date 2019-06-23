/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Model;

import java.io.Serializable;

import javax.xml.bind.annotation.*;
/**
 *
 * @author Szymon
 */
@XmlRootElement(name="Pracownik")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ewidencja.Model.Dyrektor.class,ewidencja.Model.Handlowiec.class})
public class Pracownik implements Serializable
{
    @XmlElement
    protected String pesel;
    @XmlElement
    protected String imie;
    @XmlElement
    protected String nazwisko;
    @XmlElement
    protected String stanowisko;
    @XmlElement
    protected double wynagrodzenie;
    @XmlElement
    protected String telefon;
    
    private int id;
    
    public Pracownik ( String pesel,String imie, String nazwisko, String stanowisko,double wynagrodzenie, String telefon)
    {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.wynagrodzenie = wynagrodzenie;
        this.telefon = telefon;
        
    }
    @Override
    public String toString()
    {
        return String.format("------------------------------------%n"
                +"Identyfikator PESEL         :  %s%n"
                +"Imię                        :  %s%n"
                +"Nazwisko                    :  %s%n"
                +"Stanowisko                  :  %s%n"
                +"Wynagrodzenie (zł)          :  %s%n"
                +"Telefon służbowy            :  %s%n"
                
                
                , pesel
                , imie
                , nazwisko
                , stanowisko
                , wynagrodzenie
                , (telefon != null ? telefon : "-brak-")
        );
    }
    
    public String toString2()
    {
        return String.format("------------------------------------"

                +"Imię                        :  %s%n"
                +"Nazwisko                    :  %s%n"
                +"Stanowisko                  :  %s%n"
                +"Wynagrodzenie (zł)          :  %s%n"
                +"Telefon służbowy            :  %s%n"
                
                
                , pesel
                , imie
                , nazwisko
                , stanowisko
                , wynagrodzenie
                , (telefon != null ? telefon : "-brak-")
        );
    }
    
    /*setery i getery*/
    public void setPesel(String pesel)
    {
        this.pesel = pesel;
    }
    public String getPesel ()
    {
        return pesel;
    }
    public void setImie(String imie)
    {
        this.imie = imie;
    }
    public String getImie ()
    {
        return imie;
    }
    public void setNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }
    public String getNazwisko ()
    {
        return nazwisko;
    }
    public void setStanowisko(String stanowisko)
    {
        this.stanowisko = stanowisko;
    }
    public String getStanowisko ()
    {
        return stanowisko;
    }
    public void setWynagrodzenie(double wynagrodzenie)
    {
        this.wynagrodzenie = wynagrodzenie;
    }
    public double getWynagrodzenie ()
    {
        return wynagrodzenie;
    }
    public void setTelefon(String telefon)
    {
        this.telefon = telefon;
    }
    public String getTelefon ()
    {
        return telefon;
    }
    
}