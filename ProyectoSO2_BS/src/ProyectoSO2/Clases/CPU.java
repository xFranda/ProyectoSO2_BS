/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

import ProyectoSO2.Dashboard;

/**
 *
 * @author frand
 */
public class CPU {
    
    int contador_ciclos; //Variable para contar cuando pasen cada 2 ciclos
    
    String cola1TLOU;
    String cola2TLOU;
    String cola3TLOU;
    String refuerzo;
    Administrador admin;
    IA gtp4;
    
    
    public CPU () throws InterruptedException {
        
        admin = new Administrador(); //Inicializamos al administrador
        gtp4 = new IA();            //Inicializamos la inteligencia artificial
        Dashboard dashboard = new Dashboard(); //Inicializamos la interfaz
    
        this.contador_ciclos=0;
        
        TLOU serie = new TLOU(admin.getIdTLOU(),2);
        
        boolean activo = true;
        
        while (activo) {

            admin.actColasPrioridad(admin.nivel3TLOU, admin.nivel2TLOU);//El administrador ejecuta la funcion de actualizar colas
            admin.actColasPrioridad(admin.nivel2TLOU, admin.nivel1TLOU);
            admin.actColaRefuerzo();

            cola1TLOU = admin.stringTLOU_N1();       //Obtiene la lista de prioridad 1 en un String
            cola2TLOU = admin.stringTLOU_N2();       //Obtiene la lista de prioridad 2 en un String
            cola3TLOU = admin.stringTLOU_N3();       //Obtiene la lista de prioridad 3 en un String
            refuerzo = admin.stringRefuerzo();
            
            Dashboard.Prioridad1.setText(cola1TLOU);
            Dashboard.Prioridad2.setText(cola2TLOU);
            Dashboard.Prioridad3.setText(cola3TLOU);
            Dashboard.Refuerzos.setText(refuerzo);
            

            if (serie != null) {

                System.out.println("ID:" + serie.id + " Prioridad:" + serie.prioridad + " Contador:" + serie.contador);
                gtp4.recibirSeries(serie, admin.nivel1TLOU, admin.nivel2TLOU, admin.nivel3TLOU, admin.refuerzo);        //La IA que realizara las comparaciones de series
            }

            cola1TLOU = admin.stringTLOU_N1();       //Obtiene la lista de prioridad 1 en un String
            cola2TLOU = admin.stringTLOU_N2();       //Obtiene la lista de prioridad 2 en un String
            cola3TLOU = admin.stringTLOU_N3();       //Obtiene la lista de prioridad 3 en un String
            refuerzo = admin.stringRefuerzo();           //Obtiene la lista de reparacion en un String
            
            Dashboard.Prioridad1.setText(cola1TLOU);
            Dashboard.Prioridad2.setText(cola2TLOU);
            Dashboard.Prioridad3.setText(cola3TLOU);
            Dashboard.Refuerzos.setText(refuerzo);


            if (contador_ciclos == 2) {  //Si ya se recorrieron dos ciclos entra en esta condicional

                contador_ciclos = 0;
                System.out.println("Agregando");
                admin.agregarTLOU();//Se agrega TLOU
                Thread.sleep(1000);

            }

            Thread.sleep(1000);  //Se duermo un segundo el programa para que se pueda revisar bien

            serie = admin.sigTLOU();
            contador_ciclos++;

        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}