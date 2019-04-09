/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Dao;

import java.util.Map;

/**
 *
 * @author Szymon
 */
interface Dao<K,V> {

    Map<K,V> getAll();
     
    void save(K k,V v);
     
    void update(K k, V v, String[] params);
     
    void delete(K k, V v);
    
}
