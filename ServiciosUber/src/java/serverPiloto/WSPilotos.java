/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPiloto;

import NodoPiloto.listaPilotos;
import NodoPiloto.piloto;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Byrich
 */
@WebService(serviceName = "WSPilotos")
public class WSPilotos {
    // "Base de datos de pilotos"
    private final listaPilotos misPilotos = new listaPilotos();
    
    /**
     * Almacenar el viaje a realizar segun el piloto seleccionado
     * @return infoPiloto
     */
    
    @WebMethod(operationName = "Registrar_viaje_asnc")
    public Boolean regisViajeAsnc(@WebParam(name = "idPiloto")int id, @WebParam(name = "coordA") double aPos, @WebParam(name = "coordB") double bPos) {
        
        piloto datosPiloto = this.misPilotos.pilotos.get(id);
        /*
        *
        * Almacenar viaje a realizar
        * ...
        *
        */
        return true;
    }
    
    @WebMethod(operationName = "Registrar_viaje")
    public piloto registrarViaje(@WebParam(name = "idPiloto")int id, @WebParam(name = "coordA") double aPos, @WebParam(name = "coordB") double bPos) {
        
        piloto datosPiloto = this.misPilotos.pilotos.get(id);
        /*
        *
        * Almacenar viaje a realizar
        * ...
        *
        */
        return datosPiloto;
    }
}
