/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Dao;

import ewidencja.Model.Pracownik;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Szymon
 */

public class WorkersDao implements Dao<String, Pracownik>
{
    Map<String,Pracownik> pracownicy = new HashMap<>();
}
