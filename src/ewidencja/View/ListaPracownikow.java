/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.View;

import ewidencja.Model.Dyrektor;
import java.util.Scanner;

/**
 *
 * @author Szymon
 */
public class ListaPracownikow {

    public static void printDetails()
    {
        
        String answer = "";
        //Dyrektor dyrektor = new Dyrektor("ds","dupa","penis","costam",2.0,"1",4.0,"4",2.9);
        System.out.println("1. Lista pracowników");
        //System.out.println(dyrektor.toString());
        System.out.println("[Enter] - następny");
        System.out.println("[Q] - powrót");
        Scanner scan = new Scanner(System.in);
        answer = scan.nextLine();
        if (answer.equals("q")) MainMenu.chooseOperation();
    }
}
