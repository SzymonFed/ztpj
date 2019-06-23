/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Controller;

import ewidencja.DAO.DAOWrapper;
import ewidencja.Model.DataBase;
import ewidencja.Model.Pracownik;

import static ewidencja.Utils.promptForPesel;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Szymon
 */
public class UsunPracownika {
    static Scanner scan = new Scanner(System.in);
    public static void deleteWorker()
    {
        
        System.out.println("----------------------------");
        
        String answer = promptForPesel("Podaj identyfikator PESEL:  ");
        try{
            DAOWrapper.deletePracownik(answer);
        }
        catch(SQLException e){
            /*someday something will be there*/
        }

    }
    static boolean promptForDelete()
    {
        while(true)
        {
            String answer = scan.nextLine();
            if (answer.length()>0)
                {
                    switch(answer.charAt(0)){
                        case 'Z':
                        case 'z':
                            return true;
                        case 'Q':
                        case 'q':
                            return false;
                    }
                }
        System.out.println("Niepoprawna opcja."); 
        }
    }
    
}
