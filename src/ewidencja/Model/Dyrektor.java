/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Model;

/**
 *
 * @author Szymon
 */
public class Dyrektor extends Pracownik 
{
    private double dodatekSluzbowy;
    private String kartaSluzbowa;
    private double limitKosztow;
    private Pracownik pracownik;
    
    public Dyrektor (String pesel,String imie, String nazwisko, String stanowisko,double wynagrodzenie, String telefon,  double dodatekSluzbowy, String kartaSluzbowa, double limitKosztow)
    {
        super(pesel, imie, nazwisko, stanowisko, wynagrodzenie, telefon);
        this.dodatekSluzbowy = dodatekSluzbowy;
        this.kartaSluzbowa = kartaSluzbowa;
        this.limitKosztow = limitKosztow;
    }
    /*public Dyrektor (Pracownik pracownik,  double dodatekSluzbowy, String kartaSluzbowa, double limitKosztow)
    {
        //super(pesel, imie, nazwisko, stanowisko, wynagrodzenie, telefon);
        this.pracownik = pracownik;
        this.dodatekSluzbowy = dodatekSluzbowy;
        this.kartaSluzbowa = kartaSluzbowa;
        this.limitKosztow = limitKosztow;
    }*/
    @Override
    public String toString()
    {
        return super.toString()+ String.format(
                 "Dodatek służbowy (zł)       :  %s%n"
                +"Karta służbowa numer        :  %s%n"
                +"Limit kosztów/miesiąc       :  %s%n"
                
                ,dodatekSluzbowy
                ,kartaSluzbowa
                ,limitKosztow
        );
    }
    /*settery i gettery*/
    public void setDodatekSluzbowy(double dodatekSluzbowy)
    {
        this.dodatekSluzbowy = dodatekSluzbowy;
    }
    public double getDodatekSluzbowy ()
    {
        return dodatekSluzbowy;
    }
    public void setKartaSluzbowa(String kartaSluzbowa)
    {
        this.kartaSluzbowa = kartaSluzbowa;
    }
    public String getKartaSluzbowa ()
    {
        return kartaSluzbowa;
    }
    public void setLimitKosztow(double limitKosztow)
    {
        this.limitKosztow = limitKosztow;
    }
    public double getLimitKosztow ()
    {
        return limitKosztow;
    }
}
