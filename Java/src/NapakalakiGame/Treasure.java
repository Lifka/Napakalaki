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

public class Treasure implements Card {
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    
    private TreasureKind type;
    
    // Constructor
    public Treasure(String n, int g, int min, int max, TreasureKind t){
        this.name = n;
        this.goldCoins = g;
        this.minBonus = min;
        this.maxBonus = max;
        this.type = t;
    }
    
    // Devolver
    public String getName(){
        return name;
    }
    
    public int getGoldCoins(){
        return goldCoins;
    }
    
    public int getMinBonus(){
        return minBonus;
    }
   
    public int getMaxBonus(){
        return maxBonus;
    }
    
    public TreasureKind getType(){
        return type;
    }
    
    public String toString(){
        return name + "(" + goldCoins + " oros, " + minBonus + " - " + maxBonus + ", tipo: " + type + ")"; 
    }
    
    
    @Override
    public int getBasicValue(){
        return minBonus;
    }
    
    
    @Override
    public int getSpecialValue(){
        return maxBonus;
    }
    
}
