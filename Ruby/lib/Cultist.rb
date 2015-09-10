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
