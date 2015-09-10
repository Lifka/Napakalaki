/************************************
|                                   | 
|   Javier Izquierdo Vera           |
|   Juan Carlos Gallardo Morales    |
|   2ºBII                           |
|                                   |
|   NapakalakiGame - PDOO           |
|                                   |
************************************/

package NapakalakiGame;

import java.util.ArrayList;
import java.util.Collections;

public class CardDealer {
    // singleton
    private static final CardDealer instance = new CardDealer();
    
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    
    private ArrayList<Cultist> unusedCultist = new ArrayList();
    
    //singleton
    public static CardDealer getInstance(){
        return instance;
    }
    
    //Constructor singleton
    private CardDealer(){
    }
    
    //Métodos privados
    private void initTreasureCardDeck(){
        
        Treasure tesoro1 = new Treasure("¡Sí mi amo!",0,4,7,TreasureKind.helmet);
        Treasure tesoro2 = new Treasure("Botas de investigación",600,3,4,TreasureKind.shoe);
        Treasure tesoro3 = new Treasure("Capucha de Cthulhu",500,3,5,TreasureKind.helmet);
        Treasure tesoro4 = new Treasure("A prueba de babas",400,2,5,TreasureKind.armor);
        Treasure tesoro5 = new Treasure("Botas de llubia ácida",800,1,1,TreasureKind.bothHand);
        Treasure tesoro6 = new Treasure("Casco minero",400,2,4,TreasureKind.helmet);
        Treasure tesoro7 = new Treasure("Ametralladora",600,4,8,TreasureKind.bothHand);
        Treasure tesoro8 = new Treasure("Camiseta de la UGR",100,1,7,TreasureKind.armor);
        Treasure tesoro9 = new Treasure("Clavo de rail ferroviario",400,3,6,TreasureKind.oneHand);
        Treasure tesoro10 = new Treasure("Cuchillo de sushi arcano",300,2,3,TreasureKind.oneHand);
        Treasure tesoro11 = new Treasure("Fez alópodo",700,3,5,TreasureKind.helmet);
        Treasure tesoro12 = new Treasure("Hacha prehistórica",500,2,5,TreasureKind.oneHand);
        Treasure tesoro13 = new Treasure("El aparato del Pr. Tesla",900,4,8,TreasureKind.armor);
        Treasure tesoro14 = new Treasure("Gaita",500,4,5,TreasureKind.bothHand);
        Treasure tesoro15 = new Treasure("Insecticida",300,2,3,TreasureKind.oneHand);
        Treasure tesoro16 = new Treasure("Escopeta de 3 cañones",700,4,6,TreasureKind.bothHand);
        Treasure tesoro17 = new Treasure("Garabato místico",300,2,2,TreasureKind.oneHand);
        Treasure tesoro18 = new Treasure("La fuerza de Mr. T",1000,0,0,TreasureKind.necklace);
        Treasure tesoro19 = new Treasure("La rebeca metálica",400,2,3,TreasureKind.armor);
        Treasure tesoro20 = new Treasure("Mazo de los antiguos",200,3,4,TreasureKind.oneHand);
        Treasure tesoro21 = new Treasure("Necroplayboycón",300,3,5,TreasureKind.oneHand);
        Treasure tesoro22 = new Treasure("Lanzallamas",800,4,8,TreasureKind.bothHand);
        Treasure tesoro23 = new Treasure("Necrocomicón",100,1,1,TreasureKind.oneHand);
        Treasure tesoro24 = new Treasure("Necronomicón",800,5,7,TreasureKind.bothHand);
        Treasure tesoro25 = new Treasure("Linterna a 2 manos",400,3,6,TreasureKind.bothHand);
        Treasure tesoro26 = new Treasure("Necrognomicón",200,2,4,TreasureKind.oneHand);
        Treasure tesoro27 = new Treasure("Necrotelecom",300,2,3,TreasureKind.helmet);
        Treasure tesoro28 = new Treasure("Porra preternatural",200,2,3,TreasureKind.oneHand);
        Treasure tesoro29 = new Treasure("Tentáculo de pega",200,0,1,TreasureKind.helmet);
        Treasure tesoro30 = new Treasure("Zapato deja-amigos",500,0,1,TreasureKind.shoe);
        Treasure tesoro31 = new Treasure("Shogulador",600,1,1,TreasureKind.bothHand);
        Treasure tesoro32 = new Treasure("Varita de atizamiento",400,3,4,TreasureKind.oneHand);
       
        // Los añadimos
        unusedTreasures.add(tesoro1);
        unusedTreasures.add(tesoro2);
        unusedTreasures.add(tesoro3);
        unusedTreasures.add(tesoro4);
        unusedTreasures.add(tesoro5);
        unusedTreasures.add(tesoro6);
        unusedTreasures.add(tesoro7);
        unusedTreasures.add(tesoro8);
        unusedTreasures.add(tesoro9);
        unusedTreasures.add(tesoro10);
        unusedTreasures.add(tesoro11);
        unusedTreasures.add(tesoro12);
        unusedTreasures.add(tesoro13);
        unusedTreasures.add(tesoro14);
        unusedTreasures.add(tesoro15);
        unusedTreasures.add(tesoro16);
        unusedTreasures.add(tesoro17);
        unusedTreasures.add(tesoro18);
        unusedTreasures.add(tesoro19);
        unusedTreasures.add(tesoro20);
        unusedTreasures.add(tesoro21);
        unusedTreasures.add(tesoro22);
        unusedTreasures.add(tesoro23);
        unusedTreasures.add(tesoro24);
        unusedTreasures.add(tesoro25);
        unusedTreasures.add(tesoro26);
        unusedTreasures.add(tesoro27);
        unusedTreasures.add(tesoro28);
        unusedTreasures.add(tesoro29);
        unusedTreasures.add(tesoro30);
        unusedTreasures.add(tesoro31);
        unusedTreasures.add(tesoro32);
        
        //Barajamos
        this.shuffleTreasures();
    }
    
    private void initMonsterCardDeck(){
        
        // Bicéfalo
        BadConsequence BadBicefalo = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, 10, 0); 
        Prize PrizeBicefalo = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, BadBicefalo, PrizeBicefalo));
        
        // El lenguas
        BadConsequence BadElLenguas = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        Prize PrizeELLenguas = new Prize(1, 1);
        unusedMonsters.add(new Monster("El lenguas", 20, BadElLenguas, PrizeELLenguas));
        
        //  El espía
        ArrayList<TreasureKind> ElEspiaVisibles = new ArrayList();
        ElEspiaVisibles.add(TreasureKind.helmet);
        ArrayList<TreasureKind> ElEspiaNoVisibles = new ArrayList();
        BadConsequence BadElEspia = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, ElEspiaVisibles, ElEspiaNoVisibles); 
        Prize PrizeElEspia = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espía", 5, BadElEspia, PrizeElEspia));
        
        // Roboggoth
        ArrayList<TreasureKind> BadRoboggothVisibles = new ArrayList();
        BadRoboggothVisibles.add(TreasureKind.bothHand);
        ArrayList<TreasureKind> BadRoboggothNoVisibles = new ArrayList();
        BadConsequence BadRoboggoth = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, BadRoboggothVisibles, BadRoboggothNoVisibles);
        Prize PrizeRoboggoth = new Prize(1, 2);
        unusedMonsters.add(new Monster("Roboggoth", 8, BadRoboggoth, PrizeRoboggoth));

        // Familia feliz
        BadConsequence BadFamilia = new BadConsequence("La familia te atrapa. Estás muerto.", true);
        Prize PrizeFamilia = new Prize(1, 4);
        unusedMonsters.add(new Monster("Familia feliz", 1, BadFamilia, PrizeFamilia));
        
        // Yskhtihyssg-Goth
        BadConsequence BadYskhtihyssg = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás, muerto.", true);
        Prize PrizeYskhtihyssg = new Prize(1, 3);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, BadYskhtihyssg, PrizeYskhtihyssg));
   
        //3 Byakhees de bonanza
        ArrayList<TreasureKind> visible1 = new ArrayList();
        visible1.add(TreasureKind.armor);
        ArrayList<TreasureKind> oculto1 = new ArrayList();
        oculto1.add(TreasureKind.armor);
        BadConsequence bc1 = new BadConsequence("Pierdes tu armadura visible y otra oculta.", 1, visible1,oculto1);
        Prize pri1 = new Prize(1, 2);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bc1, pri1));
        
        //Ángeles de la noche ibicenca
        ArrayList<TreasureKind> visible2 = new ArrayList();
        visible2.add(TreasureKind.oneHand);
        ArrayList<TreasureKind> oculto2 = new ArrayList();
        oculto2.add(TreasureKind.oneHand);
        BadConsequence bc2 = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 1, visible2, oculto2);
        Prize pri2 = new Prize(1,4);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, bc2, pri2));
        
        //Bichgooth
        ArrayList<TreasureKind> visible3 = new ArrayList();
        visible3.add(TreasureKind.armor);
        ArrayList<TreasureKind> oculto3 = new ArrayList();;
        BadConsequence bc3 = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 1, visible3,oculto3);
        Prize pri3 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, bc3, pri3));
              
        //Los hondos
        BadConsequence bc4 = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.", true);
        Prize pri4 = new Prize(1, 2);
        unusedMonsters.add(new Monster("Los hondos", 8, bc4, pri4));
        
        //Pollipolito volante
        BadConsequence bc5 = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        Prize pri5 = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipolito volante", 3, bc5, pri5));
        
        //Chibithulhu
        ArrayList<TreasureKind> visible6 = new ArrayList();
        visible6.add(TreasureKind.helmet);
        ArrayList<TreasureKind> oculto6 = new ArrayList();;
        BadConsequence bc6 = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 1, visible6,oculto6);
        Prize pri6 = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, bc6, pri6));
        
        //El gorrón en el umbral
        BadConsequence bc7 = new BadConsequence("Pierdes todos tus tesoros visibles.", 1, 10, 0);
        Prize pri7 = new Prize(1, 3);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, bc7, pri7));
        
        //El rey de rosa
        BadConsequence bc8 = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        Prize pri8 = new Prize(2, 4);
        unusedMonsters.add(new Monster("El rey de rosa", 13, bc8, pri8));
        
        //Semillas Cthulhu
        BadConsequence bc9 = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        Prize pri9 = new Prize(1, 2);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 14, bc9, pri9));
        
        //El sopor de Dunwich
        ArrayList<TreasureKind> visible10 = new ArrayList();
        visible10.add(TreasureKind.shoe);
        ArrayList<TreasureKind> oculto10 = new ArrayList();;
        BadConsequence bc10 = new BadConsequence("El primordial bostezocontagioso. Pierdes el calzado visible.", 1, visible10,oculto10);
        Prize pri10 = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bc10, pri10));
        
        //H.P. Munchcraft
        ArrayList<TreasureKind> visible11 = new ArrayList();
        visible11.add(TreasureKind.armor);
        ArrayList<TreasureKind> oculto11 = new ArrayList();;
        BadConsequence bc11 = new BadConsequence("Pierdes la armadura visible.", 1, visible11,oculto11);
        Prize pri11 = new Prize(1,2);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bc11, pri11));
        
        //La que redactaen las tinieblas
        BadConsequence bc12 = new BadConsequence("Toses los pulmones y pierdes 2 niveles..", 2, 0, 0);
        Prize pri12 = new Prize(1, 1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 2, bc12, pri12)); 
        
        //Dameargo
        ArrayList<TreasureKind> visible13 = new ArrayList();
        visible13.add(TreasureKind.oneHand);
        ArrayList<TreasureKind> oculto13 = new ArrayList();;
        BadConsequence bc13 = new BadConsequence("Te intentas escaquear.Pierdes una mano visible.", 1, visible13,oculto13);
        Prize pri13 = new Prize(1,2);
        unusedMonsters.add(new Monster("Dameargo", 1, bc13, pri13));
        
        // MONSTRUOS CON SECTARIOS
        //El mal indecible impronunciable
        ArrayList<TreasureKind> visible14 = new ArrayList();
        visible14.add(TreasureKind.oneHand);
        ArrayList<TreasureKind> oculto14 = new ArrayList();;
        BadConsequence bc14 = new BadConsequence("Pierdes una mano visible.", 1, visible13,oculto13);
        Prize pri14 = new Prize(1,3);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, bc14, pri14, -2));
        
        //Testigos oculares
        BadConsequence bc15 = new BadConsequence("Pierdes todos tus tesoros visibles. Jajaja.", 1, 10, 0);
        Prize pri15 = new Prize(1, 2);
        unusedMonsters.add(new Monster("Testigos oculares", 6, bc15, pri15,2));
        
        
        //El gran cthulhu
        BadConsequence Bad16 = new BadConsequence("Hoy no es tu día de suerte. Mueres.", true);
        Prize Prize16 = new Prize(5, 2);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, Bad16, Prize16, 4));
        
        
        //Serpiente Político
        BadConsequence bc17 = new BadConsequence("Tu gobierno te recorta dos niveles.", 2, 0, 0);
        Prize pri17 = new Prize(1, 2);
        unusedMonsters.add(new Monster("Serpiente Político", 8, bc17, pri17,-2));
        
        
        //Felpuggoth
        ArrayList<TreasureKind> visible18 = new ArrayList();
        visible18.add(TreasureKind.armor);
        visible18.add(TreasureKind.helmet);
        ArrayList<TreasureKind> oculto18 = new ArrayList();
        visible18.add(TreasureKind.oneHand);
        visible18.add(TreasureKind.oneHand);
        visible18.add(TreasureKind.bothHand);
        BadConsequence bc18 = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 1, visible13,oculto13);
        Prize pri18 = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, bc18, pri18, 5));
        
        
        //Shoggoth
        BadConsequence bc19 = new BadConsequence("Pierdes 2 niveles.", 2, 0, 0);
        Prize pri19 = new Prize(2,4);
        unusedMonsters.add(new Monster("Shoggoth", 16, bc19, pri19,-4));
        
        
        //Lolitagooth
        BadConsequence bc20 = new BadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0);
        Prize pri20 = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, bc20, pri20,3));
        
        //Barajamos
        this.shuffleMonsters();
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    // Métodos públicos
    public Treasure nextTreasure(){
        
       if (unusedTreasures.isEmpty()){
           // La clonamos
           unusedTreasures = (ArrayList<Treasure>) usedTreasures.clone();
           // Como ahora referencian a la mismwera, creamos otra vacía para vaciar la lista
           usedTreasures = new ArrayList();
           // Barajamos
           shuffleTreasures();
       }
      
       usedTreasures.add(unusedTreasures.remove(unusedTreasures.size()-1));
       return usedTreasures.get(usedTreasures.size()-1);
    }
    
    public Monster nextMonster(){
        
       if (unusedMonsters.isEmpty()){
           // La clonamos
           unusedMonsters = (ArrayList<Monster>) usedMonsters.clone();
           // Como ahora referencian a la mismwera, creamos otra vacía para vaciar la lista
           usedMonsters = new ArrayList();
           // Barajamos
           shuffleMonsters();
       }

       usedMonsters.add(unusedMonsters.remove(unusedMonsters.size()-1));
       return usedMonsters.get(usedMonsters.size()-1);
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistCardDeck();
    }
    
    public Cultist nextCultist(){
         return unusedCultist.remove(unusedCultist.size()-1);
    }
    
    private void suffleCultists(){
        Collections.shuffle(unusedCultist);
    }
    
    private void initCultistCardDeck(){
        //Sectarios
        unusedCultist.add(new Cultist("Sectario 1", 1)); 
        unusedCultist.add(new Cultist("Sectario 2", 2)); 
        unusedCultist.add(new Cultist("Sectario 3", 1));
        unusedCultist.add(new Cultist("Sectario 4", 2)); 
        unusedCultist.add(new Cultist("Sectario 5", 1)); 
        unusedCultist.add(new Cultist("Sectario 6", 1)); 
        
    }
    
}
