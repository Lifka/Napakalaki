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

// Monstruos!
public class Monster implements Card {
    private String name; // Nombre del monstruo
    private int combatLevel; // Nivel de combate del monstruo
    private int levelChangeAgainstCultistPlayer = 0; // Level que cambia cuando combate con un  sectario
    
    private Prize prize;
    private BadConsequence bc;
    
    
    // Constructores
    Monster(String name, int level, BadConsequence bc, Prize prize, int levelChange){
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.prize = prize;
        levelChangeAgainstCultistPlayer = levelChange;
    }
    
    Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.prize = prize;
    }
    // **

    // Devolver atributos:
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return bc;
    }
     
    public int getLevelsgained(){
        return prize.getLevels();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    // Otros métodos
    public boolean kills(){
        return bc.myBadConsequencelsDeath();
    }
    
    public String toString(){
        return "Nombre: " + this.name + " - Nivel de combate: " + this.combatLevel +
                "\n-> Malrollo: " + this.bc.toString() + "\n-> Buenrollo: " + this.prize.toString();
    }
    
    @Override
    public int getBasicValue(){
        return getCombatLevel();
    }
    
    @Override
    public int getSpecialValue(){
        return levelChangeAgainstCultistPlayer + getCombatLevel();
    }
    
    
    
    
}
