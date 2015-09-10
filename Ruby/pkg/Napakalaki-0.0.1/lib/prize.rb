#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.# 
# 
# **********
# Javier Izquierdo Vera 2º B
# Juan Carlos Gallardo Morales 2º B
# **********

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