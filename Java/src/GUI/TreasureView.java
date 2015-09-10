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

import javax.swing.ImageIcon;
import NapakalakiGame.Treasure;
import NapakalakiGame.TreasureKind;
import java.awt.Color;

public class TreasureView extends javax.swing.JPanel {

    private Treasure treasureModel;
    private boolean selected = false;
    private TreasureInfo ti = new TreasureInfo();

    public TreasureView() {
        initComponents();
    }
    
    public boolean isSelected(){
        return selected;
    }
    
    public Treasure getTreasure(){
        return treasureModel;
    }
    
    public void setTreasure (Treasure t) {
        treasureModel = t;
        ti.setTreasure(treasureModel);
        String varname = treasureModel.getName();
        setImage(treasureModel.getType());
        
        repaint();
    }

    private void setImage (TreasureKind tkind){
        ImageIcon icon = new ImageIcon();

        if (tkind == TreasureKind.shoe){   
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasuretype/shoe.png"));
            
        } else if (tkind == TreasureKind.armor){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasuretype/armor.png"));
            
        } else if (tkind == TreasureKind.bothHand){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasuretype/twohand.png"));
            
        } else if (tkind == TreasureKind.helmet){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasuretype/helmet.png"));
            
        } else if (tkind == TreasureKind.oneHand){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasuretype/onehand.png"));
            
        } else if (tkind == TreasureKind.necklace){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasuretype/necklace.png"));
            
        }
        
       img.setIcon(icon);
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(74, 60));
        setMinimumSize(new java.awt.Dimension(74, 60));
        setPreferredSize(new java.awt.Dimension(74, 60));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/treasuretype/armor.png"))); // NOI18N
        img.setMaximumSize(new java.awt.Dimension(74, 60));
        img.setMinimumSize(new java.awt.Dimension(74, 60));
        img.setPreferredSize(new java.awt.Dimension(74, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (selected){
            setBackground(Color.WHITE);
            selected = false;
        } else {
            setBackground(Color.gray);
            selected = true;
            ti.setVisible(true);
        }

        

            
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img;
    // End of variables declaration//GEN-END:variables
}
