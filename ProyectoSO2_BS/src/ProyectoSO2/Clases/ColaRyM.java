/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoSO2.Clases;

/**
 *
 * @author Gab
 */
public class ColaRyM {
    private NodoRyM inicioCola, finalCola; 
    String Cola = ""; 
    
    public ColaRyM(){
        this.inicioCola = null; 
        this.finalCola = null;
    }
    
    //Insertar en la cola
    
    public void insertar(RyM datos){
        
        NodoRyM nuevoNodo = new NodoRyM();
        nuevoNodo.datos = datos;
        nuevoNodo.sig = null;
        
        if(colaVacia()){
            
            inicioCola = nuevoNodo;
            finalCola = nuevoNodo;
            
        } else {
            inicioCola.sig = nuevoNodo;
            finalCola = nuevoNodo;
        }
        
    }
    
    //Retirar de la cola
    
    public RyM retirar(){
        if (!colaVacia()) {           
            RyM datos = inicioCola.datos; 
            
            if (inicioCola == finalCola) {               
                inicioCola = null;
                finalCola = null;
                
            } else {
                inicioCola = inicioCola.sig;               
            }           
            return datos;         
        } else {           
            return null;
        }
    }
    
    //Tamaño de la cola
    
    public int tam(ColaRyM x) {

        NodoRyM temp = x.inicioCola;                  
        int size = 0;                      
        while (temp != null) {               
            size = size + 1;
            temp = temp.sig;
        }
        return size;
    }
    
    
    //Chequear si la cola está vacía
    
    public boolean colaVacia(){
        if(inicioCola == null) {
            return true;
        } else {
            return false;
        }
    }
    
    //Pasa de cola a String
    public String texto(ColaRyM x) {
        NodoRyM temp = x.inicioCola;             
        String escrib = "";              

        while (temp != null) {          
            RyM z = temp.datos;     
            escrib = escrib + "ID:" + z.id + " Prioridad:" + z.prioridad + " Index:" + z.cont + "\n"; 
            temp = temp.sig;                 
        }
        return escrib;
    } 
    
}
