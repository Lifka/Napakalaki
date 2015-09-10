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

// Para poder usar el array
import java.util.ArrayList;

// Mal rollo
public class BadConsequence {
    private String text; // Lo que dice el mal rollo
    private int levels; // Niveles que se pierden
    private int nVisible; // Tesoros visibles que se pierden
    private int nHiddenTreasures; // Tesoros ocultos que se pierden
    private boolean death; // Tipo muerte
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
 
    // Constructores
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisible = nVisible;
        this.nHiddenTreasures = nHidden;
        
        this.specificVisibleTreasures = null;
        this.specificHiddenTreasures = null;
        this.death = false;
    }
    
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
        this.levels = 1;
        this.nVisible = 0;
        this.nHiddenTreasures = 0;
        this.specificVisibleTreasures = null;
        this.specificHiddenTreasures = null;
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures.addAll(tVisible);
        this.specificHiddenTreasures.addAll(tHidden);
        
        this.nVisible = 0;
        this.nHiddenTreasures = 0;
        this.death = false;
    }
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures.addAll(tVisible);
        this.specificHiddenTreasures.addAll(tHidden);
        this.nVisible = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = false;
    }
    // **
    
    // Obtener atributos:
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public boolean isEmpty(){
        return (nVisible == 0 && ( specificVisibleTreasures.isEmpty() || specificVisibleTreasures == null ) && nHiddenTreasures == 0 && ( specificHiddenTreasures.isEmpty() || specificHiddenTreasures == null));
    }

    
    public int getNVisibleTreasures(){
           return nVisible;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    // Otros métodos
    
    public void substractVisibleTreasure(Treasure T){
        boolean esta = false;
        int i = 0;
        
        if (specificVisibleTreasures != null)
            while(i < specificVisibleTreasures.size() && !esta) {
                esta = (specificVisibleTreasures.get(i) == T.getType());
                i++;
            }
         
        if (esta)
            specificVisibleTreasures.remove(i - 1);
        
        if (nVisible > 0)
            nVisible--;
    }
    
    public void substractHiddenTreasure(Treasure T){
        boolean esta = false;
        int i = 0;
        
        if (specificHiddenTreasures != null)
         while(i < specificHiddenTreasures.size() && !esta){
             esta = (specificHiddenTreasures.get(i) == T.getType());
             i++;
         }
         
        if (esta)
            specificHiddenTreasures.remove(i - 1);
        
        if (nHiddenTreasures > 0)
            nHiddenTreasures--;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){

        ArrayList<TreasureKind> listaVisibles = new ArrayList();
        ArrayList<TreasureKind> listaOcultos = new ArrayList();

        // Si hay tesoros específicos que perder
        if (specificVisibleTreasures != null) {
            for(int i = 0; i < v.size(); i++){
                //Los buscamos en los visibles
                for(int j = 0; j < specificVisibleTreasures.size(); j++){
                    
                    if(specificVisibleTreasures.get(j) == v.get(i).getType())
                        listaVisibles.add(specificVisibleTreasures.get(j));
                }
            }
            
        }
        
        // Si hay tesoros v que perder vamos a descartar los primeros n
         // específicos que no hayan sido ya seleccionados
      /*  int aniade = 0; //Son los que añadimos
        for(int i = 0; aniade != nVisible && v.size() > i; i++){
            if (!listaVisibles.contains(v.get(i).getType())) { //Si ese no está ya añadido...
                   listaVisibles.add(v.get(i).getType());
                   aniade++; //Hemos añadido uno
            }
         }
            */
        // Si hay tesoros específicos que perder
        if (specificHiddenTreasures != null) {
            for(int i = 0; i < h.size(); i++){
                //Los buscamos en los ocultos
                for(int j = 0; j < specificHiddenTreasures.size(); j++){
                    
                    if(specificHiddenTreasures.get(j) == h.get(i).getType())
                        listaOcultos.add(specificHiddenTreasures.get(j));
                
                }
            }
        }
                
        // Si hay tesoros o que perder vamos a descartar los primeros n
         // específicos que no hayan sido ya seleccionados
        /*aniade = 0; //Son los que añadimos
        for(int i = 0; aniade != nHiddenTreasures && h.size() > i; i++){
            if (!listaOcultos.contains(i)) { //Si ese no está ya añadido...
                    listaOcultos.add(h.get(i).getType());
                    aniade++; //Hemos añadido uno
                
            } 
        }
     */
        
        // De este modo es el jugador el que elige qué tesoro descartarse de los n no específicos
        // Si descomentamos los dos bucles anteriores, es el juego el que le obliga
        // a descartar los n visibles u ocultos necesarios
        BadConsequence newbc = new BadConsequence("-Ajustado-",0, nVisible, nHiddenTreasures,listaVisibles,listaOcultos);
        return newbc;
    }
       
    public boolean myBadConsequencelsDeath(){
        return death;
    }
    
    public String toString(){
        String cadena = "Descripción: " + text;
        if (this.levels > 0)
            cadena += " Niveles: " + this.levels;
        if (this.nVisible > 0)
            cadena +=  " nVisible: " + this.nVisible;
        if (this.nHiddenTreasures > 0 )
            cadena +=  " nHidden: " + this.nHiddenTreasures;
        if(this.specificVisibleTreasures != null)
            cadena +=  "\n    Visibles específicos: " + specificVisibleTreasures.toString();
        if(this.specificHiddenTreasures != null)
            cadena += "\n    Ocultos específicos: " + specificHiddenTreasures.toString();
        
        return cadena;
     
    }
    
}

