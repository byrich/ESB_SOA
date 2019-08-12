/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverCarros;

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
@WebService(serviceName = "WSCarros")
public class WSCarros {
// "Base de datos de pilotos"
    private final listaPilotos misPilotos = new listaPilotos();
    
    /**
     * Verifica si existen autos cercanos a la 
     * a la ubicacion del cliente
     * La ubicacion aceptada es en Grados decimales (DD): 41.40338, 2.17403
     * @return idAuto
     */
    
    @WebMethod(operationName = "Autos_cercanos")
    public int autosCercanos(@WebParam(name = "coordA") double aPos, @WebParam(name = "coordB") double bPos) {
        /*
        *
        * Buscar ubicacion de autos registrados
        * en un rango cercano a las coordenadas del cliente
        * ...
        *
        */
        Random rnd = new Random();
        int idAuto = rnd.nextInt(7);
        if (idAuto <5 ) 
            //Encuentra auto cercano
            return idAuto;
        //No encuentra resultados
        return -1;
    }
}
