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

public class Prize {
    private int treasures, levels;
    
    // Constructores
    public Prize(int level, int treasures){
        this.treasures = treasures;
        this.levels = level;
    }
    
    
    // Obtener atributos:
    public int getLevels(){
        return levels;
    }
    
    public int getTreasures(){
        return treasures;
    }
    
    public String toString(){
        return "Niveles: " + this.levels + " Tesoros: " + treasures;
    }

}
