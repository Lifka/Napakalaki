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

public class Cultist implements Card {
    private String name;
    private int gainedLevels;
    
    public Cultist (String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    //**
    public String getName(){
        return name;
    }
    //**
    
    @Override
    public int getBasicValue(){
        return gainedLevels;
    }
    
    @Override
    public int getSpecialValue(){
        return getBasicValue()*CultistPlayer.getTotalCultistPlayer();
    }
    
}
