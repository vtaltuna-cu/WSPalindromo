/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda.model;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author vivian
 */
public class ManagerDB {
    
    private static String mongoServer = "localhost";
    private static Integer portServer = 3128;
    private static String databaseName = "palindromo";
    
    static MongoClient mongoClient = new MongoClient(mongoServer, portServer);
    
    public static MongoDatabase getDataBase(){
        return  mongoClient.getDatabase(databaseName);
    }
   
}




