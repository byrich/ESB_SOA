/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodo;

/**
 *
 * @author Byrich
 */
public class pilotoRetorno {
    public String nombre;
    public String placa;
    public String auto;
    public String color;
    public int codigo;

    public pilotoRetorno(int codigo) {
        this.codigo = codigo;
    }
    
    public pilotoRetorno(String nombre, String placa, String auto, String color) {
        this.nombre = nombre;
        this.placa = placa;
        this.auto = auto;
        this.color = color;
        this.codigo = 1;
    }
    
}
