/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverCliente;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Byrich
 */
@WebService(serviceName = "WSClientes")
public class WSClientes {

    /**
     * Con este metodo sabemos si el usuario esta 
     * autorizado para pedir un transporte
     */
    @WebMethod(operationName = "verificacion_de_cuenta")
    public boolean UsuarioActivo(@WebParam(name = "Id") String id) {
        /*
        *
        * Buscar en base de datos estado del Usuario
        * ...
        *
        */
        int registrado = (int) (Math.random()*6);
        if (registrado <5)
            return true;
        return false;
    }
}
