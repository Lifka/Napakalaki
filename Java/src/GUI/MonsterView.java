/************************************
|                                   | 
|   Javier Izquierdo Vera           |
|   Juan Carlos Gallardo Morales    |
|   2ºBII                           |
|                                   |
|   NapakalakiGame - PDOO           |
|                                   |
************************************/

package GUI;

import NapakalakiGame.Monster;
import NapakalakiGame.Prize;
import javax.swing.ImageIcon;

public class MonsterView extends javax.swing.JPanel {
    
    private Monster monsterModel;
    
    public MonsterView() {
        initComponents();

        
        
        
    }
    
    public void setVisibleMonster(boolean b){
        
        if (!b){
            ImageIcon icon;
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/default.png"));
            img1.setIcon(icon);
            
            name1.setText("Unknown");
            ImageIcon levelimg;
            levelimg = new ImageIcon(getClass().getResource("/GUI/img/level/other/1.png"));
            level1.setIcon(levelimg);
            badConsequenceView1.setVisible(false);
            prizeView1.setVisible(false);
        } else {
            String varname = monsterModel.getName();
            name1.setText(varname);
            setImage(varname);

            // Establecemos la imagen del nivel
            ImageIcon levelimg;
            levelimg = new ImageIcon(getClass().getResource("/GUI/img/level/other/" + Integer.toString(monsterModel.getCombatLevel()) + ".png"));
            level1.setIcon(levelimg);

            // Vistas contenidas
            badConsequenceView1.setVisible(true);
            badConsequenceView1.setbc(monsterModel.getBadConsequence());
            
            prizeView1.setVisible(true);
            Prize pri = new Prize(monsterModel.getLevelsgained(), monsterModel.getTreasuresGained());
            prizeView1.setPrize(pri); 
        }
        
        repaint(); 
    }

    public void setMonster (Monster m) {
        monsterModel = m;

    }
    
     private void setImage (String name){
        // Establecemos la imagen por defecto para reducir el acoplamiento (solo se establece una imagen distinta si está definida):
        ImageIcon icon;
        icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/default.png"));
        
        // Si existe una imagen definida para ese monstruo en concreto, la establecemos:
        if (name == "Bicéfalo"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/18.png"));

        } else if(name == "El lenguas"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/17.png"));
            
        } else if(name == "El espía"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/16.png"));
    
        } else if(name == "Roboggoth"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/15.png"));
    
        } else if(name == "Familia feliz"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/14.png"));
    
        } else if(name == "Yskhtihyssg-Goth"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/13.png"));
    
        } else if(name == "3 Byakhees de bonanza"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/0.png"));
    
        } else if(name == "Ángeles de la noche ibicenca"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/3.png"));
    
        } else if(name == "Bichgooth"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/1.png"));
    
        } else if(name == "Los hondos"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/9.png"));
    
        } else if(name == "Pollipolito volante"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/12.png"));
    
        } else if(name == "Chibithulhu"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/1.png"));
    
        } else if(name == "El gorrón en el umbral"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/1.png"));
    
        } else if(name == "El rey de rosa"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/7.png"));
    
        } else if(name == "Semillas Cthulhu"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/10.png"));
    
        } else if(name == "El sopor de Dunwich"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/2.png"));
    
        } else if(name == "H.P. Munchcraft"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/5.png"));
    
        } else if(name == "El gorrón en el umbral"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/4.png"));
            
        } else if(name == "Dameargo"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/monsters/11.png"));
           
    // *** SECTARIOS ***
        } else if(name == "El mal indecible impronunciable"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/mons_sect/msect01.png"));
            
        } else if(name == "Testigos oculares"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/mons_sect/monsect02.png"));
            
        } else if(name == "El gran cthulhu"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/mons_sect/msect03.png"));
         
        } else if(name == "Serpiente Político"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/mons_sect/msect04.png"));
         
        } else if(name == "Felpuggoth"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/mons_sect/msect05.png"));
            
        } else if(name == "Shoggoth"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/mons_sect/msect06.png"));
            
        } else if(name == "Lolitagooth"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/mons_sect/msect07.png"));
            
        }
            
        img1.setIcon(icon);

    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img1 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        level1 = new javax.swing.JLabel();
        prizeView1 = new GUI.PrizeView();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        badConsequenceView1 = new GUI.BadConsequenceView();

        setBackground(new java.awt.Color(177, 171, 165));
        setPreferredSize(new java.awt.Dimension(1867, 1708));

        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/treasures/default.png"))); // NOI18N
        img1.setMaximumSize(new java.awt.Dimension(222, 357));
        img1.setMinimumSize(new java.awt.Dimension(222, 357));
        img1.setPreferredSize(new java.awt.Dimension(222, 357));

        name1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        name1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name1.setText("jLabel1");

        level1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/level/other/1.png"))); // NOI18N

        prizeView1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        badConsequenceView1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(level1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(badConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prizeView1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prizeView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(level1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 255, Short.MAX_VALUE))
                    .addComponent(img1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BadConsequenceView badConsequenceView1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel level1;
    private javax.swing.JLabel name1;
    private GUI.PrizeView prizeView1;
    // End of variables declaration//GEN-END:variables
}
