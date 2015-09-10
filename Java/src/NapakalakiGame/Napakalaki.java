/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
# 
# **********
# Javier Izquierdo Vera 2º B
# Juan Carlos Gallardo Morales 2º B
# **********
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author javieriv
 */
public class Napakalaki {
    // Singleton -> Una instancia únicamente, es lo que devolvemos
    private static final Napakalaki instance = new Napakalaki();

    private int indexCurrentPlayer = -1;
    private ArrayList<Player> players = new ArrayList();
    private Player currentPlayer;
    private Monster currentMonster;
    private CardDealer dealer;
    // Constructor privado para que no se use desde fuera
    private Napakalaki(){
        Player currentPlayer = null;
    	Monster currentMonster = null;
   	CardDealer dealer = CardDealer.getInstance();
    // Constructor privado... singleton
    }
    
    // Devolvemos la única instancia posible
    public static Napakalaki getInstance(){
        return instance;
    }
    
    // Métodos privados
    private void initPlayers(ArrayList<String> names){
        for(int i = 0; i < names.size(); i++)
            players.add(new Player(names.get(i)));
    }
    
    private Player nextPlayer(){
        if (indexCurrentPlayer == -1){
                Random aleatorio = new Random();
                indexCurrentPlayer = aleatorio.nextInt(players.size());
        } else
                indexCurrentPlayer = (indexCurrentPlayer+1)%players.size();
        
        return players.get(indexCurrentPlayer);
    }
    
    private boolean nextTurnAllowed(){
        if (this.currentPlayer == null)
            return true;
        else
            return currentPlayer.validState();
    }
    
    // Métodos públicos
    public CombatResult developCombat(){
        CombatResult cr = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        
        if (cr == CombatResult.LoseAndConvert){
            CultistPlayer cp = new CultistPlayer(currentPlayer,dealer.nextCultist());
            currentPlayer = (CultistPlayer)cp;
            players.add(indexCurrentPlayer,currentPlayer);
        }
        
        return cr;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(int i = 0; i < treasures.size(); i++){
            Treasure treasure = treasures.get(i); // Obtenemos el tesoro
            currentPlayer.discardVisibleTreasure(treasure); // Lo borramos correctamente
            
            dealer.giveTreasureBack(treasure); //Se lo damos al dealer para que lo devuelva al mazo       
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(int i = 0; i < treasures.size(); i++){
            Treasure treasure = treasures.get(i); // Obtenemos el tesoro
            currentPlayer.discardHiddenTreasure(treasure); // Lo borramos correctamente
            
            dealer.giveTreasureBack(treasure); //Se lo damos al dealer para que lo devuelva al mazo       
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for (int i = 0; i < treasures.size(); i++)
            currentPlayer.makeTreasureVisible(treasures.get(i));
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        return currentPlayer.buyLevels(visible, hidden);
    }
    
    public void initGame(ArrayList<String> players){
        this.initPlayers(players);
        dealer = CardDealer.getInstance();
        dealer.initCards();
        this.nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK = this.nextTurnAllowed();
        boolean dead;
        
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = this.nextPlayer();
            dead = currentPlayer.isDead();
            
            if (dead)
                currentPlayer.initTreasures();

        }
 
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return (result == CombatResult.WinAndWinGame);
    }
    
    
}
