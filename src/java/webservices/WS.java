/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Busqueda.model.Oferta;
import com.google.gson.Gson;

/**
 *
 * @author vivian
 */
@WebService(serviceName = "WS")
public class WS {

    /**
     * Web service operation
     * @param search : Texto a buscar
     * @param page : página
     * @param pageSize
     * @return 
     */
    @WebMethod(operationName = "getProducts")
    public String getProducts(@WebParam(name = "search") String search, @WebParam(name = "page") int page, @WebParam(name = "pageSize") int pageSize) {
        Map<String, Object> resultado = new HashMap<>();
        resultado = (new Oferta()).getProductos(search, page, pageSize);
        return new Gson().toJson(resultado);
    }
}
