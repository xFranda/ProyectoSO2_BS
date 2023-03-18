/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Nacho;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


/**
 *
 * @author frand
 */
public class Reproductor extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
    
        final String Nombre_Archivo = "C:\\Users\\frand\\Downloads\\Nacho.mp4";
        File archivo = new File(Nombre_Archivo);
        
        Media video = new Media(archivo.toURI().toString());
        MediaPlayer reproductor = new MediaPlayer(video);
        MediaView ventana = new MediaView(reproductor);
        reproductor.setAutoPlay(true);
        
        Group escenario = new Group();
        escenario.getChildren().add(ventana);
        Scene escena = new Scene(escenario, 1920, 1280);
        stage.setScene(escena);
        stage.setTitle("Reproducción Vídeo");
        stage.show();
    
    
    }
    
    public static void main (String[] args){
        launch(args);
    }
    
    
}
