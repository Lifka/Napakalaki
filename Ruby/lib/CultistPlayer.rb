=begin
/***********************************/
|                                   | 
|   Javier Izquierdo Vera           |
|   Juan Carlos Gallardo Morales    |
|   2ºBII                           |
|                                   |
|   NapakalakiGame - PDOO           |
|                                   |
/***********************************/
=end

require_relative 'card'
require_relative 'player'
module NapakalakiGame
  class CultistPlayer < Player
    @@totalCultistPlayers = 0
     
    def initialize(card, p)
      copy(p)
      @@totalCultistPlayers = @@totalCultistPlayers + 1
      @myCultistCard = card
    end
    
    def getTotalCultistPlayers
      @@totalCultistPlayers
    end
    
    def getCombatLevel
      @level + @myCultistCard.getSpecialValue
    end
  
   def shouldConvert
     false
   end
   
   def getOponentLevel(m)
     m.getSpecialValue
   end
   
   def computeGoldCoinsValue(treasures)
     super(treasures)*2
   end
    
    
  end
 
end
