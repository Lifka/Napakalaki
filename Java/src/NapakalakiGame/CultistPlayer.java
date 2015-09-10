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

import java.util.ArrayList;

public class CultistPlayer extends Player{
    static int totalCultistPlayer = 0;
    private Cultist myCultistCard = null;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
        totalCultistPlayer++;
    }
    
    //**
    public Cultist getCultistCard(){
        return myCultistCard;
    }
    //**
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getSpecialValue();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected int getCombatLevel(){
        return super.getCombatLevel() + myCultistCard.getSpecialValue();
    }
    
    @Override
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        return 2*super.computeGoldCoinsValue(t);
    }
    
    public static int getTotalCultistPlayer(){
        return totalCultistPlayer;
    }

    
}
