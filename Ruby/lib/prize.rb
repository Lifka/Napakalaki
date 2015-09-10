#encoding: utf-8
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
class Prize
  #Variables
  attr_reader:treasures, :levels
  
  #Constructor
  def initialize(treasures,level)
    @treasures = treasures # Tesoros que se ganan
    @levels = level # Nivel que se gana
  end
  
  def to_s
        return "\nPRIZE--> Treasures:  #{treasures} , Levels: #{levels}"
  end
  
end
end