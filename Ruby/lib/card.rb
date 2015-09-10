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

module Card
    def getBasicValue
      raise NotImplementedError.new
    end
    
    def getSpecialValue
      raise NotImplementedError.new
    end
end
