#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# **********
# Javier Izquierdo Vera 2º B
# Juan Carlos Gallardo Morales 2º B
# **********

require 'singleton'
require_relative 'monster'
require_relative 'prize'
require_relative 'bad_consequence'
require_relative 'treasure_kind'
require_relative 'treasure'
require_relative 'Cultist'

module NapakalakiGame

class CardDealer
  include Singleton
  
  def initialize
    @unusedMonsters = Array.new
    @usedMonsters = Array.new
    @unusedTreasures = Array.new
    @usedTreasures = Array.new
    @unusedCultist = Array.new
  end
    
  # Métodos públicos
  
  # Treasure
  def nextTreasure
    if @unusedTreasures.empty?
      for i in 0 .. @unusedTreasures.size
        @unusedTreasures.push(@usedTreasures.delete_at(i)) #delte_at devuelve el tesoro eliminado
      end
      @unusedTreasures.shuffle
    end
    
    @usedTreasures.push(@unusedTreasures.pop) #eliminamos el último no usado y lo insertamos en los usados
    @usedTreasures.last #devolvemos el último tesoro usado
    
  end
  
  def nextCultist
    
  end
  
  #Monster 
  def nextMonster
      if @unusedMonsters.empty?
        for i in 0 .. @unusedMonsters.size
          @unusedMonsters.push(@usedMonsters.delete_at(i)) #delte_at devuelve el tesoro eliminado
        end
        @unusedMonsters.shuffle
      end
    
    @usedMonsters.push(@unusedMonsters.pop) #eliminamos el último no usado y lo insertamos en los usados
    @usedMonsters.last #devolvemos el último tesoro usado
  end
    
  def giveTreasureBack(treasure)
    @usedTreasures.push(treasure)
  end
  
    
  def giveMonsterBack(monster)
    @usedMonsters.push(monster)
  end
    
  def initCards
    initTreasureCardDeck
    initMonsterCardDeck
    initCultistCardDeck
  end
  
  # Métodos privados
  private
  def initTreasureCardDeck
    tesoro1 = Treasure.new("¡Sí mi amo!",0,4,7,TreasureKind::HELMET)
    tesoro2 = Treasure.new("Botas de investigación",600,3,4,TreasureKind::SHOE)
    tesoro3 = Treasure.new("Capucha de Cthulhu",500,3,5,TreasureKind::HELMET)
    tesoro4 = Treasure.new("A prueba de babas",400,2,5,TreasureKind::ARMOR)
    tesoro5 = Treasure.new("Botas de llubia ácida",800,1,1,TreasureKind::BOTHHAND)
    tesoro6 = Treasure.new("Casco minero",400,2,4,TreasureKind::HELMET)
    tesoro7 = Treasure.new("Ametralladora",600,4,8,TreasureKind::BOTHHAND)
    tesoro8 = Treasure.new("Camiseta de la UGR",100,1,7,TreasureKind::ARMOR)
    tesoro9 = Treasure.new("Clavo de rail ferroviario",400,3,6,TreasureKind::ONEHAND)
    tesoro10 = Treasure.new("Cuchillo de sushi arcano",300,2,3,TreasureKind::ONEHAND)
    tesoro11 = Treasure.new("Fez alópodo",700,3,5,TreasureKind::HELMET)
    tesoro12 = Treasure.new("Hacha prehistórica",500,2,5,TreasureKind::ONEHAND)
    tesoro13 = Treasure.new("El aparato del Pr. Tesla",900,4,8,TreasureKind::ARMOR)
    tesoro14 = Treasure.new("Gaita",500,4,5,TreasureKind::BOTHHAND)
    tesoro15 = Treasure.new("Insecticida",300,2,3,TreasureKind::ONEHAND)
    tesoro16 = Treasure.new("Escopeta de 3 cañones",700,4,6,TreasureKind::BOTHHAND)
    tesoro17 = Treasure.new("Garabato místico",300,2,2,TreasureKind::ONEHAND)
    tesoro18 = Treasure.new("La fuerza de Mr. T",1000,0,0,TreasureKind::NECKLACE)
    tesoro19 = Treasure.new("La rebeca metálica",400,2,3,TreasureKind::ARMOR)
    tesoro20 = Treasure.new("Mazo de los antiguos",200,3,4,TreasureKind::ONEHAND)
    tesoro21 = Treasure.new("Necroplayboycón",300,3,5,TreasureKind::ONEHAND)
    tesoro22 = Treasure.new("Lanzallamas",800,4,8,TreasureKind::BOTHHAND)
    tesoro23 = Treasure.new("Necrocomicón",100,1,1,TreasureKind::ONEHAND)
    tesoro24 = Treasure.new("Necronomicón",800,5,7,TreasureKind::BOTHHAND)
    tesoro25 = Treasure.new("Linterna a 2 manos",400,3,6,TreasureKind::BOTHHAND)
    tesoro26 = Treasure.new("Necrognomicón",200,2,4,TreasureKind::ONEHAND)
    tesoro27 = Treasure.new("Necrotelecom",300,2,3,TreasureKind::HELMET)
    tesoro28 = Treasure.new("Porra preternatural",200,2,3,TreasureKind::ONEHAND)
    tesoro29 = Treasure.new("Tentáculo de pega",200,0,1,TreasureKind::HELMET)
    tesoro30 = Treasure.new("Zapato deja-amigos",500,0,1,TreasureKind::SHOE)
    tesoro31 = Treasure.new("Shogulador",600,1,1,TreasureKind::BOTHHAND)
    tesoro32 = Treasure.new("Varita de atizamiento",400,3,4,TreasureKind::ONEHAND)
    
    @unusedTreasures << tesoro1
    @unusedTreasures << tesoro2
    @unusedTreasures << tesoro3
    @unusedTreasures << tesoro4
    @unusedTreasures << tesoro5
    @unusedTreasures << tesoro6
    @unusedTreasures << tesoro7
    @unusedTreasures << tesoro8
    @unusedTreasures << tesoro9
    @unusedTreasures << tesoro10
    @unusedTreasures << tesoro11
    @unusedTreasures << tesoro12
    @unusedTreasures << tesoro13
    @unusedTreasures << tesoro14
    @unusedTreasures << tesoro15
    @unusedTreasures << tesoro16
    @unusedTreasures << tesoro17
    @unusedTreasures << tesoro18
    @unusedTreasures << tesoro19
    @unusedTreasures << tesoro20
    @unusedTreasures << tesoro21
    @unusedTreasures << tesoro22
    @unusedTreasures << tesoro23
    @unusedTreasures << tesoro24
    @unusedTreasures << tesoro25
    @unusedTreasures << tesoro26
    @unusedTreasures << tesoro27
    @unusedTreasures << tesoro28
    @unusedTreasures << tesoro29
    @unusedTreasures << tesoro30
    @unusedTreasures << tesoro31
    @unusedTreasures << tesoro32
    
    @unusedTreasures = @unusedTreasures.shuffle
  end
  
  def initMonsterCardDeck
    #Botín
    pri21 = Prize.new(2,1)
    pri41 = Prize.new(4,1)
    pri11 = Prize.new(1,1)
    pri31 = Prize.new(3,1)
    pri42 = Prize.new(4,2)
    pri25 = Prize.new(2,5)

    #3 Byakhees de bonanza
    bc1 = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta", 1, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
    monster1 = Monster.new("3 Byakhees de bonanza", 8, pri21,bc1,0)

    #Ángeles de la noche ibicenca
    bc2 = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 1, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
    monster2 =  Monster.new("Ángeles de la noche ibicenca", 14, pri41, bc2,0)

    #Bickgooth
    bc3 = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible.",1,[TreasureKind::ARMOR],[])
    monster3 = Monster.new("Bickgooth", 2, pri11, bc3,0)

    #Los hondos
    bc4 = BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.")
    monster4 = Monster.new("Los hondos", 8, pri21, bc4,0)

    #Pollipólipo volante
    bc5 = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
    monster5 = Monster.new("Pollipólipo volante", 3, pri11, bc5,0)

    #Roboggoth
    bc6 = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, [TreasureKind::BOTHHAND],[])
    monster6 = Monster.new("Roboggoth", 8, pri21, bc6,0)

    #Bicéfalo
    bc7 = BadConsequence.newLevelNumberOfTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, 10, 0)
    monster7 = Monster.new("Bicéfalo", 20, pri11, bc7,0)

    #Chibithulhu
    bc8 = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible.", 1, [TreasureKind::HELMET], [])
    monster8 = Monster.new("Chibithulhu",2,pri11 ,bc8,0)

    #El gorrón en el umbral
    bc9 = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles", 1, 10, 0)
    monster9 = Monster.new("El gorrón en el umbral",10,pri31,bc9,0)

    #El rey de rosa
    bc10 = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0)
    monster10 = Monster.new("El rey rosa", 13, pri42, bc10,0)

    #Semillas Cthulhu
    bc11 = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2)
    monster11 = Monster.new("Semillas Cthulhu", 4, pri21, bc11,0)

    #Yskhtihyssg-Goth
    bc12 = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto")
    monster12 = Monster.new("Yskhtihyssg-Goth", 12, pri31, bc12,0)

    #El espía
    bc13 = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible.", 1, [TreasureKind::HELMET], [])
    monster13 = Monster.new("El espía", 5, pri11, bc13,0)

    #El sopor de Dunwich
    bc14 = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible.", 1, [TreasureKind::SHOE], [])
    monster14 = Monster.new("El sopor de Dunwich", 2, pri11, bc14,0)

    #H.P. Munchcraft
    bc15 = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 1, [TreasureKind::HELMET], [])
    monster15 = Monster.new("H.P. Munchcraft", 6, pri21, bc15,0)

    #La que redacta en las tinieblas
    bc16 = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0)
    monster16 = Monster.new("La que redacta en las tinieblas", 2, pri11, bc16,0)

    #Dameargo
    bc17 = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible.", 1, [TreasureKind::ONEHAND], [])
    monster17 = Monster.new("Dameargo", 1, pri21, bc17,0)

    #Familia feliz
    bc18 = BadConsequence.newDeath("La familia te atrapa. Estás muerto.")
    monster18 = Monster.new("Famialia feliz", 1, pri41, bc18,0)

    #El Lenguas
    bc19 = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0)
    monster19 = Monster.new("El Lenguas", 20, pri11, bc19,0)
    
    
    # MONSTRUOS CON CULTIST**********************
    
    #El mal indecible impronunciable
    bc20 = BadConsequence.newLevelSpecificTreasures("Pierdes una mano visible.", 1, [TreasureKind::ONEHAND], [])
    monster20 = Monster.new("El mal indecible impronunciable", 10, pri31, bc20, -2)
    
    #Testigos oculares
    bc21 = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles. Jajaja.", 1, 10, 0)
    monster21 = Monster.new("Testigos oculares", 6, pri21, bc21, 2)
    
    #El gran cthulhu
    bc22 = BadConsequence.newDeath("Hoy no es tu día de suerte. Mueres.")
    monster22 = Monster.new("El gran cthulhu", 20, pri25, bc22, 4)
    
    #Serpiente Político
    bc23 = BadConsequence.newLevelNumberOfTreasures("Serpiente Político", 2, 0, 0)
    monster23 = Monster.new("Serpiente Político", 8, pri21, bc23, -2)
    
    #Felpuggoth
    bc24 = BadConsequence.newLevelSpecificTreasures("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 1, [TreasureKind::ARMOR,TreasureKind::HELMET], [TreasureKind::ONEHAND,TreasureKind::ONEHAND,TreasureKind::BOTHHAND])
    monster24 = Monster.new("Felpuggoth", 2, pri11, bc24, 5)
    
    #Shoggoth
    bc25 = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles.", 2, 0, 0)
    monster25 = Monster.new("Shoggoth", 16, pri11, bc25, -4)
    
    #Lolitagooth
    bc26 = BadConsequence.newLevelNumberOfTreasures("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0)
    monster26 = Monster.new("Lolitagooth", 2, pri11, bc20, 3)
    
    #Metemos los monstruos en el array
    @unusedMonsters << monster1
    @unusedMonsters << monster2
    @unusedMonsters << monster3
    @unusedMonsters << monster4
    @unusedMonsters << monster5
    @unusedMonsters << monster6
    @unusedMonsters << monster7
    @unusedMonsters << monster8
    @unusedMonsters << monster9
    @unusedMonsters << monster10
    @unusedMonsters << monster11
    @unusedMonsters << monster12
    @unusedMonsters << monster13
    @unusedMonsters << monster14
    @unusedMonsters << monster15
    @unusedMonsters << monster16
    @unusedMonsters << monster17
    @unusedMonsters << monster18
    @unusedMonsters << monster19
    @unusedMonsters << monster20
    @unusedMonsters << monster21
    @unusedMonsters << monster22
    @unusedMonsters << monster23
    @unusedMonsters << monster24
    @unusedMonsters << monster25
    @unusedMonsters << monster26
    
    @unusedMonsters = @unusedMonsters.shuffle
  end
  
  def shuffleTreasures
    @unusedTreasures = @unusedTreasures.shuffle
  end
    
  def shuffleMonsters
    @unusedMonsters.shuffle
  end
  
  def shuffleCultists
    @unusedCultist.shuffle
  end
  
  def initCultistCardDeck
    
    cultist1 = Cultist.new("Sectario 1", 1)
    cultist2 = Cultist.new("Sectario 2", 2)
    cultist3 = Cultist.new("Sectario 3", 1)
    cultist4 = Cultist.new("Sectario 4", 2)
    cultist5 = Cultist.new("Sectario 5", 1)
    cultist6 = Cultist.new("Sectario 6", 1)
    
    @unusedCultist << cultist1
    @unusedCultist << cultist2
    @unusedCultist << cultist3
    @unusedCultist << cultist4
    @unusedCultist << cultist5
    @unusedCultist << cultist6
    
  end
   
end


end