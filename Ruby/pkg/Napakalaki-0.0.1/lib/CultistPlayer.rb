# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  
  class CultistPlayer < Player
    attr_reader :totalCultistPlayers
    @@totalCultistPlayers = 0
     
    def initialize(card)
      @@totalCultistPlayers = @@totalCultistPlayers + 1
      @myCultistCard = card
    end
    
    def self.copy(player, card)
      super(player)
      new(card)
    end
    
    def getCombatLevel
      super.getCombatLevel + @myCultistCard.getSpecialValue
    end
  
   def shouldConvert
     false
   end
   
   def getOponentLevel(m)
     m.getSpecialValue
   end
   
   def computeGoldCoinsValue
     super*2
   end
    
    
  end
 
end
