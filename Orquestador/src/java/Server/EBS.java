/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;
import nodo.pilotoRetorno;

/**
 *
 * @author Byrich
 */
@WebService(serviceName = "EBS")
public class EBS {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServiciosUber/WSClientes.wsdl")
    private serviceCliente.WSClientes_Service service;

    /**
     * Servicio principal de orquestacion de servicios
     * Verificando en el siguiente orden:
     *    1)verificacion de estado de cuenta
     *    2)Solicitud de auto segun posicion 
     *    3)registro de vuelta 
     *    4)Avisar al piloto la vuelta solicitada 
     * Cada servicio cuenta con distinto proveedor
     * @return datos del piloto
     */
    @WebMethod(operationName = "Solicitud_de_transporte")
    public pilotoRetorno solicitudCliente(@WebParam(name = "idCliente")String id, @WebParam(name = "coordA") double aPos, @WebParam(name = "coordB") double bPos) {
        //proveedor 1: servicios del cliente
        WSClientes_Service clienteWs = new WSClientes_Service();
        WSClientes clienteS = clienteWs.getWSClientesPort();
        //proveedor 2: servicios del auto
        WSCarros_Service carroWs = new WSCarros_Service();
        WSCarros carroS = carroWs.getWSCarrosPort();
        //proveedor 3: servicios del piloto
        WSPilotos_Service pilotoWs = new WSPilotos_Service();
        WSPilotos pilotoS = pilotoWs.getWSPilotosPort();
        
        //paso 1: verificacion de estado de cuenta
        boolean cuentaCorrecta = clienteS.verificacionDeCuenta(id);
        if (cuentaCorrecta){
            // paso 2:
            // Si la cuenta esta correcta se procede
            // a verificar si existe autos cercanos
            int idPiloto = carroS.autosCercanos(aPos, bPos);
            if (idPiloto != -1){
                // paso 3:
                // Si la se encontro un auto disponible
                // registramos el viaje segun el piloto
                Piloto temp = pilotoS.registrarViaje(idPiloto, aPos, bPos);
                pilotoRetorno salida = new pilotoRetorno(temp.getNombre(),temp.getPlaca(),temp.getAuto(),temp.getColor());
                // paso 4:
                // Enviar notiviacion al piloto
                // "Notificar(); ..."
                return salida;
            }
            else {
                // No se encontro auto disponible para le viaje
                // codigo de error: 2
                pilotoRetorno salida = new pilotoRetorno(2);
                return salida;
            }
        }
        // No se cuenta con cuenta autorizada
        // codigo de error: 3
        pilotoRetorno salida = new pilotoRetorno(3);
        return salida;
    }
    
    
    @WebMethod(operationName = "paso_1")
    public boolean VerificarCuenta(@WebParam(name = "idCliente")String id) {
        //proveedor 1: servicios del cliente
        WSClientes_Service clienteWs = new WSClientes_Service();
        WSClientes clienteS = clienteWs.getWSClientesPort();
        //paso 1: verificacion de estado de cuenta
        return clienteS.verificacionDeCuenta(id);
    }
    
    @WebMethod(operationName = "paso_2")
    public int autosCercanos(@WebParam(name = "coordA") double aPos, @WebParam(name = "coordB") double bPos) {
        //proveedor 2: servicios del auto
        WSCarros_Service carroWs = new WSCarros_Service();
        WSCarros carroS = carroWs.getWSCarrosPort();
        // verificar si existe autos cercanos
        return carroS.autosCercanos(aPos, bPos);
    }
    
    @WebMethod(operationName = "paso_3")
    public pilotoRetorno datosPiloto(@WebParam(name = "idPiloto")int id, @WebParam(name = "coordA") double aPos, @WebParam(name = "coordB") double bPos) {
        //proveedor 3: servicios del piloto
        WSPilotos_Service pilotoWs = new WSPilotos_Service();
        WSPilotos pilotoS = pilotoWs.getWSPilotosPort();
        // registramos el viaje segun el piloto
        Piloto temp = pilotoS.registrarViaje(id, aPos, bPos);
        pilotoRetorno salida = new pilotoRetorno(temp.getNombre(),temp.getPlaca(),temp.getAuto(),temp.getColor());
        // paso 4:
        // Enviar notiviacion al piloto
        // "Notificar(); ..."
        return salida;
    }

    private boolean verificacionDeCuenta(java.lang.String id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        serviceCliente.WSClientes port = service.getWSClientesPort();
        return port.verificacionDeCuenta(id);
    }

    private boolean verificacionDeCuenta_1(java.lang.String id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        serviceCliente.WSClientes port = service.getWSClientesPort();
        return port.verificacionDeCuenta(id);
    }
}
