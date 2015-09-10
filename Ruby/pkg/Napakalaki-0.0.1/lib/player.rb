# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# **********
# Javier Izquierdo Vera 2º B
# Juan Carlos Gallardo Morales 2º B
# **********

require_relative 'bad_consequence'
require_relative 'treasure_kind'
require_relative 'card_dealer'
require_relative 'dice'
require_relative 'treasure'
require_relative 'monster'
require_relative 'combat_result'

module NapakalakiGame

class Player
  private_class_method :new
  
  #GET's
  attr_reader:hiddenTreasures, :visibleTreasures,:level, :name
  
  #SET's
  attr_accessor:pendingBadConsequence, :dead
  
  def nuevo(name, otro)
    if otro == nil && name != nil
      @hiddenTreasures = Array.new
      @visibleTreasures = Array.new
      @dead = true
      @name = name
      @level = 1
    else
      @hiddenTreasures = otro.hiddenTreasures
      @visibleTreasures = otro.visibleTreasures
      @dead = otro.dead
      @name = otro.name
      @level = otro.level
    end
    
  end
  
  
  def self.newPlayer(name)
    nuevo(name,nil)
  end
  
  def self.copy(otro)
    nuevo(nil,otro)
  end
  
  # Métodos públicos
  
  #CombatResult
  def combat(m)
    mylevel = getCombatLevel
    monsterLevel = getOponentLevel(m)
    cr = nil
       
    if mylevel > monsterLevel
           applyPrize(m)
           
           if @level >= 10
             cr = CombatResult::WINANDWINGAME
           else
             cr = CombatResult::WIN
           end
    else
           dice = Dice.instance   
           escape = dice.nextNumber
           
           if escape < 5
             amIDead = m.kills
               
              if amIDead == true
                   die
                   cr = CombatResult::LOSEANDDIE
              else
                   if (shouldConvert)
                     cr = CombatResult::LOSEANDCONVERT
                   else
                    bd = m.bc
                    cr = CombatResult::LOSE
                    applyBadConsequence(bd)
                   end
               end
               
           else
             cr = CombatResult::LOSEANDESCAPE
           end
    end
       
    discardNecklaceIfVisible
    cr
  end
   
  def makeTreasureVisible(t)
     canI = canMakeTreasureVisible(t)
     if canI == true
       @visibleTreasures.push(t)
       @hiddenTreasures.delete(t)
     end
  end
   
  def discardVisibleTreasure(t)
    dealer =CardDealer.instance
    dealer.giveTreasureBack(@visibleTreasures.delete(t))
       
    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty
      @pendingBadConsequence.substractVisibleTreasure(t)
    end
       
    dieIfNoTreasures
    
  end
   
  def discardHiddenTreasure(t)
    dealer =CardDealer.instance
    dealer.giveTreasureBack(@hiddenTreasures.delete(t))
       
    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty
       @pendingBadConsequence.substractHiddenTreasure(t)
    end
       
    dieIfNoTreasures
  end
   
  # boolean
  def buyLevels(visible, hidden)
    goldCoinsVisible = computeGoldCoinsValue(visible)
    goldCoinsHidden = computeGoldCoinsValue(hidden)
    totalCoins = goldCoinsVisible + goldCoinsHidden
    
    levels = totalCoins/1000
    canI = canlBuyLevels(levels)
       
    if (canI == true)
        incrementLevels(levels);
    end
       
    @visibleTreasures.delete(visible) #quizas MAL
    @hiddenTreasures.delete(hidden) #quizas MAL 
       
    dealer = CardDealer.instance
       
    for vis in visible 
      dealer.giveTreasureBack(vis)
    end
       
    for hid in hidden
      dealer.giveTreasureBack(hid)
    end
       
    canI
  end
   
  # boolean
  def validState
    ok = ((pendingBadConsequence == nil || pendingBadConsequence.isEmpty) && (hiddenTreasures.size <= 4 || hiddenTreasures == nil))  
    ok
  end
  
  def initTreasures
       dealer = CardDealer.instance
       dice = Dice.instance
       bringToLife
       treasure = dealer.nextTreasure
       @hiddenTreasures.push(treasure)
       number = dice.nextNumber
       
       if number > 1
           treasure2 = dealer.nextTreasure
           @hiddenTreasures.push(treasure2)
       end
       
       if (number == 6)
           treasure3 = dealer.nextTreasure
           @hiddenTreasures.push(treasure3)
       end
       
       
  end
   
  # boolean
  def hasVisibleTreasures
    !(@visibleTreasures.empty? || @visibleTreasures.nil?)
  end
  
  def  to_s
       cadena = "#{@name}"
       cadena << ", Level: #{level}"
       cadena << ", Dead: #{dead}"
       cadena << "\n#{pendingBadConsequence.to_s}" 
       cadena
  end

  # Métodos privados
  private
  
  def  dieIfNoTreasures
    @dead = ((@visibleTreasures.empty? || @visibleTreasures.nil?) && (@hiddenTreasures.empty? || @hiddenTreasures.nil?))
    if (@dead)
      @pendingBadConsequence = nil
    end
  end
    
  def bringToLife
    @dead = false
  end
    
  #int
  def getCombatLevel
    collar_puesto = false
    correct_level = @level
        
    i = 0
    while i < @visibleTreasures.size && !collar_puesto
      collar_puesto = (@visibleTreasures[i] == [TreasureKind::NECKLACE])
      i = i + 1
    end
    
    i = 0
    if(collar_puesto) 
      while i < @visibleTreasures.size
      correct_level = correct_level + @visibleTreasures[i].maxBonus
      i = i + 1
      end
      
    else
      
      while i < @visibleTreasures.size
      correct_level = correct_level + @visibleTreasures[i].minBonus
      i = i + 1
      end 
      
    end 
    
    correct_level
    
  end
    
  def incrementLevels(l)
    @level = @level + l
  end

  def decrementLevels(l)
    @level = @level - l
    if (@level < 1)
      @level = 1
    end
  end
    
    
  def discardNecklaceIfVisible
      lleva_collar = false
      
      i=0
      while i<@visibleTreasures.size && !lleva_collar
        lleva_collar = @visibleTreasures[i].type == TreasureKind::NECKLACE
        if lleva_collar
          CardDealer.instance.giveTreasureBack(@visibleTreasures[i])
          @visibleTreasures.delete_at(i)
        end
          i = i + 1
      end
      
  end
    
  def die
    level = 1;
    dealer = CardDealer.instance
        
    for trea in @visibleTreasures
      dealer.giveTreasureBack(trea)
    end
        
    @visibleTreasures.clear
        
    for trea in @hiddenTreasures
      dealer.giveTreasureBack(trea)
    end
        
    @hiddenTreasures.clear
    
    dieIfNoTreasures
    
  end
    
  #int
  def computeGoldCoinsValue(treasures)
      goldCoins = 0
     
      
    for i in 0..treasures.size
      goldCoins = goldCoins + treasures[i].goldCoins
    end
    
    goldCoins
    
  end
    
  #boolean
  def canlBuyLevels(l)
    (@level + l) < 10
  end
    
  def applyPrize(currentMonster)
    nLevels = currentMonster.getLevelsgained
    incrementLevels(nLevels)
    nTreasures = currentMonster.getTreasuresGained
        
    if nTreasures > 0
      dealer = CardDealer.instance
            
      for i in  0..nTreasures
        trea = dealer.nextTreasure
        @hiddenTreasures.push(trea)   
      end
      
    end
  end
    
  def applyBadConsequence(bad)
    nLevels = bad.levels
    decrementLevels(nLevels)
    pendingBad = bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures)
    @pendingBadConsequence = pendingBad
  end
    
  # boolean
  def canMakeTreasureVisible(t)
        can_make_visible = true
        tk_hidden = t.type
       
    if (tk_hidden == TreasureKind::BOTHHAND)
      i=0
      while i<visibleTreasures.size && can_make_visible
        tk_visible = visibleTreasures[i].type
        can_make_visible = (tk_visible != TreasureKind::BOTHHAND && tk_visible != TreasureKind::ONEHAND)
        i = i + 1
      end
    elsif (tk_hidden == TreasureKind::ONEHAND)
      total_one_hand=0
      i=0
      while i<visibleTreasures.size && can_make_visible
        tk_visible = visibleTreasures[i].type
        if (tk_visible == TreasureKind::ONEHAND)
          total_one_hand = total_one_hand +1
        end
        can_make_visible = (tk_visible != TreasureKind::BOTHHAND && total_one_hand<2)
        i = i + 1
      end
    else
      i=0
      while i<visibleTreasures.size && can_make_visible
        tk_visible = visibleTreasures[i].type
        can_make_visible = (tk_visible != tk_hidden)
        i = i + 1
      end
    end
      
    can_make_visible;
  end
    
  #int
  def howManyVisibleTreasures(tkind)
    cantidad = 0
    i = 1
    while i < @visibleTreasures.size
      if (@visibleTreasures[i].type == tkind)
        cantidad = cantidad + 1
      end
    end
    
    cantidad
  end
  
  def getOponentLevel(m)
    m.getBasicValue
  end
  
  def shouldConvert
   # (Dice.instance.nextNumber == 6) 
   true
  end
  
end


end