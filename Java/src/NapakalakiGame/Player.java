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
import java.util.ArrayList;

public class Player {
    private boolean dead = true;
    private String name;
    private int level;
    
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private BadConsequence pendingBadConsequence;// = new BadConsequence("Nada pendiente", 0, 0, 0);
    
    // Constructor
    public Player(String name){
        this.name = name;
        this.level = 1;
        this.pendingBadConsequence = null;
    }
    
    public Player(Player p){
        this.name = p.name;
        this.level = p.level;
        this.pendingBadConsequence = p.pendingBadConsequence;
        this.hiddenTreasures = p.hiddenTreasures;
        this.visibleTreasures = p.visibleTreasures;
        this.dead = p.dead;
    }
    
    // Métodos privados
    private void bringToLife(){
        dead = false;
    }
    
    protected int getCombatLevel(){
        boolean collar_puesto = false;
        int correct_level = level;
               

        for(int i = 0; i < visibleTreasures.size() && !collar_puesto; i++)
            collar_puesto = (visibleTreasures.get(i).getType() == TreasureKind.necklace);
        
        if (collar_puesto)
            for(int i = 0; i < visibleTreasures.size(); i++)
                correct_level += visibleTreasures.get(i).getMaxBonus();
        else        
            for(int i = 0; i < visibleTreasures.size(); i++)
                correct_level += visibleTreasures.get(i).getMinBonus();
       
       return correct_level;
    }
    
    private void incrementLevels(int l){
        level += l;
    }

    private void decrementLevels(int l){
        level -= l;
        if (level < 1)
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    private void dieIfNoTreasures(){
        dead = ((visibleTreasures.isEmpty() || visibleTreasures==null) && (hiddenTreasures.isEmpty() || hiddenTreasures==null));
        if (dead)
            pendingBadConsequence = null;
    }
    
    private void discardNecklaceIfVisible(){
        boolean collar_puesto = false;
         
        int i = 0;
        while(i < visibleTreasures.size() && !collar_puesto) {
            collar_puesto = (visibleTreasures.get(i).getType() == TreasureKind.necklace);
            i++;
        }
        
        if (collar_puesto) {
            CardDealer.getInstance().giveTreasureBack(visibleTreasures.get(i));
            visibleTreasures.remove(i);
        }
    }
    
    private void die(){
        level = 1; // Nivel a 1
        CardDealer dealer = CardDealer.getInstance();
        
        // Devuelve los tesoros al mazo
        for(int i = 0; i < visibleTreasures.size(); i++)
            dealer.giveTreasureBack(visibleTreasures.get(i));
        
        for(int i = 0; i < hiddenTreasures.size(); i++)
            dealer.giveTreasureBack(hiddenTreasures.get(i));
        
        // Borra los tesoros del jugador
        visibleTreasures.clear();
        hiddenTreasures.clear();
        
        //Muere
        this.dieIfNoTreasures();
    }
    
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        int gold = 0;
        float niveles = 0;
        for(int i = 0; i < t.size(); i++)
            gold += t.get(i).getGoldCoins();
        niveles = (float) (gold / 1000.0);
                    
        return niveles;
    }
    
    private boolean canIBuyLevels(int l){
        return ((level + l) < 10);
    }
    
    private void applyPrize(Monster currentMonster){
        int nLevels = currentMonster.getLevelsgained(); // Cantidad de niveles
        this.incrementLevels(nLevels); // Incrementamos los niveles logrados
        int nTreasures = currentMonster.getTreasuresGained(); // Cantidad de tesoros
        
        if (nTreasures > 0){
             CardDealer dealer = CardDealer.getInstance();
             
             // Vamos añadiendo los tesoros ganados a los ocultos
             for (int i = 0; i < nTreasures; i++){
                 Treasure treasure = dealer.nextTreasure();
                 hiddenTreasures.add(treasure);
             }
        }
            
    }
    
    private void applyBadConsequence(BadConsequence bad){
        int nLevels = bad.getLevels();
        this.decrementLevels(nLevels);
        BadConsequence pendingBad = bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        this.setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean puede = true;
        int tesoros_una_mano = 0;
        
        // Si lo que vamos a equipar es de una mano:
        if (t.getType() == TreasureKind.oneHand){
            //Buscamos los tesoros de una mano equipados
            for (int i = 0; i < visibleTreasures.size() && puede; i++){
                // Si tiene uno de dos manos no puede
                puede = (visibleTreasures.get(i).getType() != TreasureKind.bothHand);
                
                // Si ya tiene de una mano lo contamos
                if (visibleTreasures.get(i).getType() == TreasureKind.oneHand && puede){
                    tesoros_una_mano++;
                    puede = (tesoros_una_mano < 2); // Sólo puede si tiene equipados 1 o ninguno de una mano
                }
            }
                    
        // Si es de dos manos no debería tener ninguno de una mano
        } else if (t.getType() == TreasureKind.bothHand) {
                //Buscamos los tesoros de una mano equipados ni de dos
                for (int i = 0; i < visibleTreasures.size() && puede; i++)
                    puede = (visibleTreasures.get(i).getType() != TreasureKind.oneHand) && 
                            (visibleTreasures.get(i).getType() != TreasureKind.bothHand);
        } else {
            //Comprobamos que no haya ningún tipo repetido
             for (int i = 0; i < visibleTreasures.size() && puede; i++)
                 puede = (t.getType() != visibleTreasures.get(i).getType());
       }
        
       
        
        return puede;
    }
    
    private int howManyVisibleTreasures(TreasureKind tkind){
        int cantidad = 0;
        for(int i = 0; i < visibleTreasures.size(); i++)
            if (visibleTreasures.get(i).getType() == tkind)
                cantidad++;
        return cantidad;
            
    }
    
    // Métodos públicos
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
   public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
   }
   
   public CombatResult combat(Monster m){
       int myLevel = this.getCombatLevel();
       int monsterLevel = this.getOponentLevel(m);
       CombatResult cr = null;
       
       if (myLevel > monsterLevel) { // Ganamos
           this.applyPrize(m);
         
           if (this.level >= 10)
               cr = CombatResult.WinAndWinGame;
           else
               cr = CombatResult.Win;

       } else { // Perdemos
           Dice dice = Dice.getInstance();
           int escape = dice.nextNumber("No tienes nivel suficiente, intentas escapar...", "Necesitas un 5 o un 6");
           
           if (escape < 5){ // Perdemos y no espacapamos
               boolean amIDead = m.kills(); // bc = muerte
               
               if (amIDead){
                   this.die(); // morimos
                   cr = CombatResult.LoseAndDie;
               } else { // No morimos pero...
                   if (shouldConvert()) // Si tenemos suerte nos volvemos sectario
                        cr = CombatResult.LoseAndConvert;
                   else { 
                        BadConsequence bad = m.getBadConsequence();
                        this.applyBadConsequence(bad);  
                        cr = CombatResult.Lose;
                   }
               }
               
           } else // Perdemos pero escapamos
               cr = CombatResult.LoseAndEscape;
       }
       
       this.discardNecklaceIfVisible();
       
       return cr;
   }
   
   public void makeTreasureVisible(Treasure t){
       if (this.canMakeTreasureVisible(t)){
           visibleTreasures.add(t);
           hiddenTreasures.remove(t);
       }
           
   }
   
   public void discardVisibleTreasure(Treasure t){
       visibleTreasures.remove(t);
       
       if ((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty())) // Si tiene un mal rollo
           pendingBadConsequence.substractVisibleTreasure(t); // Indicamos que se ha cumplido
       
       dieIfNoTreasures();
   }
   
   public void discardHiddenTreasure(Treasure t){
       hiddenTreasures.remove(t);
       
       if ((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty())) // Si tiene un mal rollo
           pendingBadConsequence.substractHiddenTreasure(t); // Indicamos que se ha cumplido
       
       dieIfNoTreasures();
   }
   
   public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
       float levelsMayBought = this.computeGoldCoinsValue(visible);
       levelsMayBought += this.computeGoldCoinsValue(hidden); // Total de oro de los tesoros pasados
       int l = (int)levelsMayBought;
       boolean canI = this.canIBuyLevels(l); 
       
       if (canI)
           this.incrementLevels(l); // Sólo incrementa si se puede
       
       // Se haya podido o no, perdemos los tesoros indicados
       visibleTreasures.removeAll(visible);
       hiddenTreasures.removeAll(hidden);
       
       CardDealer dealer = CardDealer.getInstance(); // Llamamos al dealer
       
       // Los devolvemos al mazo
       for (int i = 0; i < visible.size(); i++)
           dealer.giveTreasureBack(visible.get(i));
         
       for (int i = 0; i < hidden.size(); i++)
           dealer.giveTreasureBack(hidden.get(i));
       
       dieIfNoTreasures();
       return canI;
   }
   
   public boolean validState(){
       return ((pendingBadConsequence == null || pendingBadConsequence.isEmpty()) && (hiddenTreasures.size() <= 4 || hiddenTreasures == null));
   }
   
   /*
   Cuando un jugador está en su primer turno o se ha quedado sin tesoros ocultos o visibles,
hay que proporcionarle nuevos tesoros para que pueda seguir jugando. El número de
tesoros que se les proporciona viene dado por el valor que saque al tirar el dado:
Si (dado == 1) roba un tesoro.
Si (1 < dado< 6) roba dos tesoros.
Si (dado == 6) roba tres tesoros.
   */
   public void initTreasures(){
       CardDealer dealer = CardDealer.getInstance();
       Dice dice = Dice.getInstance();
       this.bringToLife();
       
       Treasure treasure = new Treasure("Varita de atizamiento",400,3,4,TreasureKind.oneHand);
       hiddenTreasures.add(treasure);
       
       int number = dice.nextNumber();
       
       if (number > 1){
           treasure = dealer.nextTreasure();
           hiddenTreasures.add(treasure);
       }
       
       if (number == 6){
           treasure = dealer.nextTreasure();
           hiddenTreasures.add(treasure);
       }
       
   }
   
   public boolean hasVisibleTreasures(){
       return !(visibleTreasures.isEmpty());
   }
   
   public int getLevels(){
       return level;
   }
   
   public String getName(){
       return name;
   }
   
   public String toString(){
       String cadena = "Nombre: " + this.name + " - Nivel: " + this.level;/* + "\n ->Tesoros visibles: "
               + visibleTreasures.toString() + "\n ->Tesoros ocultos: " + hiddenTreasures.toString();
       */if (pendingBadConsequence != null)
           cadena  += "\nMalrollo pendiente: " + pendingBadConsequence.toString();
       if (dead != false)
           cadena += "\nMUERTO";
       
       return cadena;
   }
   
    protected int getOponentLevel(Monster m){
        return m.getBasicValue();
    }
    
    protected boolean shouldConvert(){
           Dice dice = Dice.getInstance();
           return (dice.nextNumber("Optas a convertirte en sectario", "Lo seras si obtienes un 6") == 6);
        
    }
   
}
