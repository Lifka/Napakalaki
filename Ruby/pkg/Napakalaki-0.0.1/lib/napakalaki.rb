# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# **********
# Javier Izquierdo Vera 2º B
# Juan Carlos Gallardo Morales 2º B
# **********

require 'singleton'
require_relative 'card_dealer'
require_relative 'player'
require_relative 'monster'
require_relative 'combat_result'
require_relative 'CultistPlayer'

module NapakalakiGame

class Napakalaki
  include Singleton
  
  # Get's
  attr_reader:currentPlayer,:currentMonster
  
  def initialize
    @players = Array.new
    @dealer = CardDealer.instance
    @indexCurrentPlayer = -1
    @currentPlayer
    @currentMonster
  end
  # Métodos públicos
  # CombatResult
  def developCombat
    cr = @currentPlayer.combat(@currentMonster)
    @dealer.giveMonsterBack(@currentMonster)
    
    if cr == CombatResult::LOSEANDCONVERT
      @currentPlayer = CultistPlayer.copy(@currentPlayer, @dealer.nextCultist)
      @players[@indexCurrentPlayer] = @currentPlayer
    end
    
    return cr
  end
  
  def discardVisibleTreasures(treasures)
    for t in treasures
        @currentPlayer.discardVisibleTreasure(t)
        @dealer.giveTreasureBack(t)
    end
  end
  
  def discardHiddenTreasures(treasures)
    for t in treasures
        @currentPlayer.discardHiddenTreasure(t)
        @dealer.giveTreasureBack(t)
    end
  end
  
  def makeTreasuresVisible(treasures)
    for trea in treasures
        @currentPlayer.makeTreasureVisible(trea)
    end
  end
  
  #boolean
  def buyLevels(visible, hidden)
     @currentPlayer.buyLevels(visible, hidden)
  end
  
  def initGame(players)
      initPlayers(players)
      @dealer = CardDealer.instance
      @dealer.initCards
      nextTurn
  end
  
  #boolean
  def nextTurnAllowed
    if @currentPlayer == nil
            return true
    else
     @currentPlayer.validState
    end
  end
  
  #boolean
  def endOfGame(result)
    result == CombatResult::WINANDWINGAME
  end
  
  # boolean
  def nextTurn
      stateOK = self.nextTurnAllowed
        
        if stateOK == true
            @currentMonster = @dealer.nextMonster
            @currentPlayer = nextPlayer
            
            dead = @currentPlayer.dead
            
            if dead == true  
              @currentPlayer.initTreasures  
            end
        end
        stateOK
  end
  
  # Métodos privados
  private
  def initPlayers(names)
      for name in names
          @players.push(Player.newPlayer(name))
      end
  end
  
  # Player
  def nextPlayer
      if @indexCurrentPlayer == -1
         @indexCurrentPlayer = rand(@players.size-1)
      else
         @indexCurrentPlayer = (@indexCurrentPlayer + 1) % @players.size
      end
      
      return @players[@indexCurrentPlayer]
  end
  
  
end


end