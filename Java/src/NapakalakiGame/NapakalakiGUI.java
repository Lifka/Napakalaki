/************************************
|                                   | 
|   Javier Izquierdo Vera           |
|   Juan Carlos Gallardo Morales    |
|   2ºBII                           |
|                                   |
|   NapakalakiGame - PDOO           |
|                                   |
************************************/

package NapakalakiGame;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;

import java.util.ArrayList;

public class NapakalakiGUI {
   
    public static void main(String[] args) {
       
        // Obtenemos la instancia de napakalaki
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        
        // creamos NapakalakiView
        NapakalakiView napakalakiView = new NapakalakiView();
        
        //Creamos el dado
        Dice.createInstance (napakalakiView);
        
        // Vector de nombres
        ArrayList<String> names = new ArrayList();
        
        // Ventana para elegir nombre
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true); //true detine la app hasta que se cierra el dialogo
        // Leer nombre de los jugadores
        names = namesCapture.getNames(); // La hace visible
        
        // Iniciar el juego
        napakalakiModel.initGame(names);
        
        // Iniciamos los gráficos
        napakalakiView.setNapakalaki(napakalakiModel);
        
        //Mostramos la ventana
        napakalakiView.showView();
                
        
    }
}

