# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# **********
# Javier Izquierdo Vera 2º B
# Juan Carlos Gallardo Morales 2º B
# **********
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