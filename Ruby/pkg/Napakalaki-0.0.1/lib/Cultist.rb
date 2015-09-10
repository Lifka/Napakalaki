# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

  require_relative 'card'
  
  class Cultist
    include Card
    
    def initialize(name, gainedlv)
      @name = name
      @gainedLevels = gainedlv
    end
    
    
    def getBasicValue
      @gainedLevels
    end
  
    def getSpecialValue
      getBasicValue*CultistPlayer.totalCultistPlayers
    end
    
  end
  
  
end
