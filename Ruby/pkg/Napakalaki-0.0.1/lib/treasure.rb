# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# **********
# Javier Izquierdo Vera 2º B
# Juan Carlos Gallardo Morales 2º B
# **********


require_relative 'card'
require_relative 'treasure_kind'

module NapakalakiGame
class Treasure
  include Card
  
  # GET's
  attr_reader:name,:goldCoins,:minBonus,:maxBonus,:type
  
  def initialize(nam, gold, min, max, tkind)
    @name = nam
    @goldCoins = gold
    @minBonus = min
    @maxBonus = max
    @type = tkind
  end
  
  def to_s
       cadena = "(Name: #{name}"
       cadena << ", GoldCoins: #{goldCoins}"
       cadena << ", MinBonus: #{minBonus}"
       cadena << ", MaxBonus: #{maxBonus})"
       cadena << ", type: #{type}"
       return cadena
  end
  
  def getBasicValue
    @minBonus
  end
  
  def getSpecialValue
    @maxBonus
  end
   
end
end