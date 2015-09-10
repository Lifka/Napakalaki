#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# 
# **********
# Javier Izquierdo Vera 2º B
# Juan Carlos Gallardo Morales 2º B
# **********

require_relative 'treasure'
require_relative 'treasure_kind'
require_relative 'bad_consequence'


module NapakalakiGame

class BadConsequence
  
  #Hacemos privado el  new
  private_class_method :new
  
  #Variables
  attr_reader:text,:levels,:nVisibleTreasures,:nHidden,:death,:specificHiddenTreasures,:specificVisibleTreasures
  
  #Constructores
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    #Siempre
    @text = aText
    
    # Distinguir variables recibidas
    if death != nil
      @death = death
      @levels = 1
    end       
    if someSpecificVisibleTreasures != nil && someSpecificHiddenTreasures != nil
      @specificHiddenTreasures = someSpecificHiddenTreasures
      @specificVisibleTreasures = someSpecificVisibleTreasures
      @levels = someLevels
      @death = false
    end
    
    if someVisibleTreasures != nil && someHiddenTreasures != nil
      @nVisibleTreasures = someVisibleTreasures
      @nHidden = someHiddenTreasures
      @levels = someLevels
      @death = false
    end
    
  end
  
  def BadConsequence.newLevelNumberOfTreasures(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, nil, nil, nil)
  end

  
  def BadConsequence.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, nil)
  end
  
  def BadConsequence.allLessDie (aText, someLevels,nVisibles,nHiddens, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels, nVisibles , nHiddens, someSpecificVisibleTreasures, someSpecificHiddenTreasures, nil)
  end

  def BadConsequence.newDeath(aText)
      new(aText, nil, nil, nil, nil, nil, true)
  end
  # **
  
  
  # Métodos públicos
  
  def to_s
       cadena = ""
       if (text!=nil)
            cadena << "\nBAD CONSEQUENCE --> Text: #{text}"
       end
       if (levels != 0)
           cadena << " Levels: #{levels}"
       end
       if (nVisibleTreasures != 0)
           cadena << " nVisibleTraesures: #{nVisibleTreasures}"
       end
       if (nHidden != 0)
           cadena << " nHiddenTreasures: #{nHidden}"
       end
       if (specificVisibleTreasures != nil && !specificVisibleTreasures.empty?)
           cadena << " specificVisibleTreasures:   #{specificVisibleTreasures.to_s()}"
       end
       if (specificHiddenTreasures != nil && !specificHiddenTreasures.empty?)
           cadena << " specificHiddenTreasures:  #{specificHiddenTreasures.to_s()}"
       end
       
       if (death)
           cadena << " death: #{death}"
       end
       
       return cadena;
       end
    
  def isEmpty
    return ((@nVisibleTreasures == 0 || @nVisibleTreasures.nil?) && (@specificVisibleTreasures.empty? || @specificVisibleTreasures == nil) && (@nHidden==0 || @nHidden.nil?) && (@specificHiddenTreasures.empty? || @specificHiddenTreasures == nil))
  end

  def substractVisibleTreasure(treasure)
    
      if !@specificVisibleTreasures.nil? && @specificVisibleTreasures.include?(treasure.type)
        @specificVisibleTreasures.delete(treasure.type)
      end

      if (!@nVisibleTreasures.nil? && @nVisibleTreasures>0)
          @nVisibleTreasures = @nVisibleTreasures - 1
      end
  end
  
  def substractHiddenTreasure(treasure)
      if !@specificHiddenTreasures.nil? && @specificHiddenTreasures.include?(treasure.type)
            @specificHiddenTreasures.delete(treasure.type)
      end

      if (!@nHidden.nil? && @nHidden>0)
          @nHidden = @nHidden - 1
      end
  end
    
  def adjustToFitTreasureLists(v, h)
    listaVisibles = Array.new
    listaOcultos = Array.new
    
    # Si hay tesoros específicos que perder
    if (specificVisibleTreasures != nil && !specificVisibleTreasures.empty?)
      for specificVP in v
        encontrado =false
        for specificVB in specificVisibleTreasures
          if (specificVB == specificVP.type && !encontrado)
            listaVisibles.push(specificVB)
            encontrado = true
          end
        end
      end
    end 
    
    # Si hay tesoros especificos que perder
    if (specificHiddenTreasures != nil && !specificHiddenTreasures.empty?)
      for specificHP in h
        encontrado = false
        for specificHB in specificHiddenTreasures
          if (specificHB == specificHP.type && !encontrado)
            listaOcultos.push(specificHB)
            encontrado = true
          end
        end
      end
    end 
    
    newbc = BadConsequence.allLessDie("-ajustado-", 0, @nVisibleTreasures, @nHidden, listaVisibles, listaOcultos)
    return newbc
    
  end


end

end