/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Backup;

import ewidencja.Model.Pracownik;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 *
 * @author Szymon
 */
public class Open {
    public static void Open(String filename)
    {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
        
            ewidencja.Model.DataBase.pracownicy = (Map<String,Pracownik>) inputStream.readObject();
        }
        catch(Exception e)
        {
            System.out.println("Cannot load database");
        }
        
    }
}
