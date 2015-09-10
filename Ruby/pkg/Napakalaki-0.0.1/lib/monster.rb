#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# 
# **********
# Javier Izquierdo Vera 2º B
# Juan Carlos Gallardo Morales 2º B
# **********

require_relative 'prize'
require_relative 'bad_consequence'
require_relative 'card'

module NapakalakiGame

class Monster
  include Card
  
  # Get's:
  attr_reader:name,:combatLevel,:bc, :pri, :levelChangeAgainstCultistPlayer
  
  # Constructor
  def initialize(name, combatLevel, prize2, bc2, lv)
    @name = name
    @combatLevel = combatLevel
    @pri = prize2
    @bc = bc2
    @levelChangeAgainstCultistPlayer = lv
  end
  
  # Métodos públicos
  #int
  def getLevelsgained
   @pri.levels
  end
  
  #int
  def getTreasuresGained
    @pri.treasures
  end
  
  #boolean
  def kills
    @bc.death
  end
  
  def to_s
       return "Name:  #{name} , combatLevel: #{combatLevel}  #{pri.to_s}  #{bc.to_s}"
  end
  
  def getBasicValue
    @combatLevel
  end
  
  def getSpecialValue
    @levelChangeAgainstCultistPlayer + @combatLevel
  end
  
end

end