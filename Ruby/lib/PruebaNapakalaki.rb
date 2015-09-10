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

require_relative 'monster'
require_relative 'prize'
require_relative 'bad_consequence'
require_relative 'treasure_kind'
require_relative 'card_dealer'
require_relative 'combat_result'
require_relative 'dice'
require_relative 'napakalaki'
require_relative 'player'
require_relative 'treasure'

# -- PRÁCTICA 1 --
=begin
puts "Prueba prize:"
price = Prize.new(4,4)
puts price.to_s()

puts "\nPrueba bad_consequence:"
bc = BadConsequence.newLevelNumberOfTreasures("asd", 4, 5, 6)
puts bc.to_s()

puts "\nPrueba bad_consequence 2:"
prueba = Array.new(3, "as")
bc = BadConsequence.newLevelSpecificTreasures("asd", 4, prueba, prueba)
puts bc.to_s()

puts "\nPrueba monster:"
monster3 = Monster.new("Monster 3", 20, price ,bc)
puts monster3.to_s()

puts "\n\n<-- TODO PROBADO CON ÉXITO -->\n\n"
=end


# -- PRÁCTICA 1 --
=begin
# Monstrar monstruos con los requisitos que se piden
puts "Vamos a mostrar los monstruos que se piden:"

puts "\n\nNivel de combate superior 10: \n"

@j = 0
@i = 0
while @i < monsters.size 
  if monsters[@i].combatLevel > 10
    @j = @j + 1
    puts  "\n#{@j}º:\n" + monsters[@i].to_s + "\n"
  end
  
  @i = @i + 1
end

puts "\n\nMal rollo implica sólo pérdida de niveles: \n"

@i = 0
@j = 0
while @i < monsters.size 
  if (monsters[@i].bc.nVisibleTreasures == nil || monsters[@i].bc.nVisibleTreasures == 0) &&
      (monsters[@i].bc.nHidden == nil || monsters[@i].bc.nHidden == 0) &&
      (monsters[@i].bc.specificHiddenTreasures == nil || monsters[@i].bc.specificHiddenTreasures == 0) &&
      (monsters[@i].bc.specificVisibleTreasures == nil || monsters[@i].bc.specificVisibleTreasures == 0) &&
      (monsters[@i].bc.death == nil)
    @j = @j + 1
    puts  "\n\n#{@j}º:\n" + monsters[@i].to_s + "\n"
  end

  @i = @i + 1
end

  puts "\n\nBuen rollo que otorgue más de un nivel: \n"
  
@i = 0
@j = 0
while @i < monsters.size 
  if (monsters[@i].pri.level > 1)
    @j = @j + 1
    puts  "\n#{@j}º:\n" + monsters[@i].to_s + "\n"
  end

  @i = @i + 1
end

  puts "\n\nMal rollo implica la perdida de un determinado tipo de tesoros: \n"
  
@i = 0
@j = 0
while @i < monsters.size 
  if (monsters[@i].bc.specificHiddenTreasures != nil || monsters[@i].bc.specificVisibleTreasures != nil)
    @j = @j + 1
    puts  "\n#{@j}º:\n" + monsters[@i].to_s + "\n"
  end

  @i = @i + 1
end
=end


