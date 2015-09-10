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

require 'singleton'

module NapakalakiGame
  
class Dice
  include Singleton
  def initialize
    
  end
  
  # int
  def nextNumber
    rand(5)+1
  end
end


end