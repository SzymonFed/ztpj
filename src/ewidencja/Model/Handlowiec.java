/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Model;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Szymon
 */

public class Handlowiec extends Pracownik
{

    private double prowizja;
    private final double limitProwizji;
    
    public Handlowiec (String pesel,String imie, String nazwisko, String stanowisko,double wynagrodzenie, String telefon, double prowizja, double limitProwizji)
    {
        super(pesel, imie, nazwisko, stanowisko, wynagrodzenie, telefon);
        this.prowizja = prowizja;
        this.limitProwizji = limitProwizji;
    }
    
    @Override
    public String toString()
    {
        return super.toString()+ String.format(
                 "Prowizja (%%)                :  %s%n"
                +"Limit prowizji/miesiąc (zł) :  %s%n"
                
                
                ,prowizja
                ,limitProwizji
        );
    }
    /*settery i gettery*/
    public void setProwizja(double prowizja)
    {
        this.prowizja = prowizja;
    }
    public double getProwizja ()
    {
        return prowizja;
    }
    public void SetLimitProwizji(double limitProwizji)
    {
        this.prowizja = prowizja;
    }
    public double getLimitProwizji ()
    {
        return limitProwizji;
    }
    
}
