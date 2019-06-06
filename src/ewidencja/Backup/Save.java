/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Backup;

import ewidencja.Model.DataBase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;

/**
 *
 * @author Szymon
 */
public class Save 
{
    public static void Save(String path)
    {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path)))
        {
            outputStream.writeObject(DataBase.pracownicy);
        }
        catch(Exception e)
        {
            System.out.println("Cannot save database");
        }
    }
    
    
    
    
}