/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodoPiloto;

import java.util.ArrayList;

/**
 *
 * @author Byrich
 */
public class listaPilotos {
    
    public ArrayList<piloto> pilotos;
    
    public listaPilotos(){
        pilotos = new ArrayList();
        piloto uno = new piloto("Alejandro", "P230byf", "hoda Civic", "rojo");
        piloto dos = new piloto("Raul", "P561sde", "toyota corola", "plata");
        piloto tres = new piloto("Andrea", "P231gfd", "zusuki x", "negro");
        piloto cuatro = new piloto("Lucia", "P945qwe", "hoda Civic", "azul");
        piloto cinco = new piloto("Jairo", "P657fed", "kia picanto", "verde");
        this.pilotos.add(uno);
        this.pilotos.add(dos);
        this.pilotos.add(tres);
        this.pilotos.add(cuatro);
        this.pilotos.add(cinco);
        
    }
    
    
    
}
