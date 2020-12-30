/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Filters.regex;
import static com.mongodb.client.model.Projections.excludeId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author vivian
 */
public class Oferta {

    private Integer percent = 50;
    public Oferta() {
    }
    
    public Map<String, Object> getProductos(String cadena, Integer pagina, Integer largoPagina){
        
        Map<String, Object> resultado = new HashMap<String, Object>();
        cadena = cadena.trim();
        
        ArrayList<Producto> listado = new ArrayList<>();
        Boolean palindromo = false;
        
        try {
            Integer entero = Integer.parseInt(cadena);
            palindromo = esPalindromo(cadena);
            
            Producto producto = getProducto(entero,palindromo);
            if (producto!= null)
                listado.add(producto);
            
            resultado.put("productos", listado);
            return resultado;
        } catch( NumberFormatException ex){
            
        }
        
        if (cadena.length()>3)
            palindromo = esPalindromo(cadena);
        
        resultado = getProductos(cadena, palindromo, pagina, largoPagina);

        return resultado;
    }
    
    private Producto getProducto(Integer identificador, Boolean palindromo){
        
        MongoCollection<Document> collection = (ManagerDB.getDataBase()).getCollection("producto"); 
        
        Document doc = collection.find(eq("id", identificador)).projection(excludeId()).first();
        
        try{
            String brand = (String)doc.get("brand");
            String description = (String)doc.get("description");
            String image = (String)doc.get("image");
            Integer price = (Integer)doc.get("price");
            Integer id = (Integer)doc.get("id");
            return new Producto(id, brand, description, image, price, palindromo, percent);
        } catch (Exception ex){
            return null;
        }
    }
    
    private Map<String, Object> getProductos(String cadena, Boolean palindromo, Integer pagina, Integer largoPagina){
        
        Map<String, Object> resultado = new HashMap<>();
        
        ArrayList<Producto> productos = new ArrayList<>();
        
        MongoCollection<Document> collection = (ManagerDB.getDataBase()).getCollection("producto"); 
        
        Integer saltos = largoPagina * (pagina -1);
        
        Integer cantidad = 0;
        
        FindIterable<Document> it ;
        if (cadena.trim().length()>0){
            it = collection.find(or(regex("brand", cadena), regex("description", cadena))).skip(saltos).limit(largoPagina).projection(excludeId());
            cantidad = (int)collection.count(or(regex("brand", cadena), regex("description", cadena)));
        }
        else {
            it = collection.find().skip(saltos).limit(largoPagina).projection(excludeId());
            cantidad = (int)collection.count();
        }
        
        resultado.put("cantidad", cantidad);
        resultado.put("pagina", pagina);
        resultado.put("paginas", (int)Math.ceil((double)cantidad/largoPagina));
        
        ArrayList<Document> docs = new ArrayList<>();

        it.into(docs);

        docs.forEach((doc) -> {
            String brand = (String)doc.get("brand");
            String description = (String)doc.get("description");
            String image = (String)doc.get("image");
            Integer price = (Integer)doc.get("price");
            Integer id = (Integer)doc.get("id");
            productos.add(new Producto(id, brand, description, image, price, palindromo, percent));
        });
     
        resultado.put("productos", productos);
        return resultado;
    }
    
    private Boolean esPalindromo(String cadena){
        cadena = cadena.replaceAll("\\s+", "").toLowerCase(); //Elimino todos los caracteres en blanco
        StringBuilder inicial = new StringBuilder(cadena.trim().toLowerCase());
        StringBuilder alreves = inicial.reverse();
        return (alreves.toString()).equals(cadena);
    }
    
}
