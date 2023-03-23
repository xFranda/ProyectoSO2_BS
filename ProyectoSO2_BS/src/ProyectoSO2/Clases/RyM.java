/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoSO2.Clases;

/**
 *
 * @author Gab
 */
public class RyM {
    int id; 
    int prioridad; 
    int cont; 
    String nombre; 
    int poder; 
    String foto; 
    
    public RyM(int id, int prioridad, String nombre, int poder, String foto) {
        this.id = id;
        this.prioridad = prioridad;
        this.cont = 0;
        this.nombre = nombre; 
        this.poder = poder; 
        this.foto = foto; 
    }
}
