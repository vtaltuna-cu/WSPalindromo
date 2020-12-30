/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda.model;

//import com.mongodb.ConnectionString;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoClient;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;


import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

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
    
    //static MongoDatabase db = mongoClient.getDatabase(databaseName);
    
     
    
    
   // MongoClient mongo = new MongoClient( "localhost:3128") ;
    
//   /* private static final String jdbcDriver = "org.postgresql.Driver";
//    
//    private static final String dbUser = "web";
//    private static final String dbPassword = "HG3yZLFHwa$.R4YN";*/
//    private static final String urlConn = "jdbc:postgresql://200.6.115.179:5432/chilterra";
//    
//    static {
//        try {
//            //Driver
//            Class.forName(jdbcDriver);
//            //connectionRW = getConnectionRW();
//            //connectionRO = getConnectionRO();
//        }
//        catch( Exception ex){
//            //System.out.println( ex.toString());
//        }
//    }
}




