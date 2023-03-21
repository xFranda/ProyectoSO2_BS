/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

// Clase de la serie de The Last Of Us

/**
 *
 * @author frand
 */
public class TLOU {
    int id;
    int prioridad;
    int contador;
    String personaje;
    int poder;
    String image;
    //El atributo de poder se usara para la pelea entre las 2 series.
    public TLOU (int id, int prioridad, String personaje, String image, int poder){
    this.id = id;
    this.prioridad = prioridad;
    this.personaje = personaje;
    this.image = image;
    this.poder = poder;
    
    }
    
}
