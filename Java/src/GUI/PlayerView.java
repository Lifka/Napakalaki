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
import NapakalakiGame.Napakalaki;
import javax.swing.ImageIcon;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import NapakalakiGame.CultistPlayer;


public class PlayerView extends javax.swing.JPanel {
    
    private Player playerModel;
    private Napakalaki napakalakiModel;
    private CultistInfo si = null;

    public PlayerView() {
        initComponents();
    }

    

    public void setNapakalaki(Napakalaki game){
        napakalakiModel = game;
    }
    
    public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua
        aPanel.removeAll();
        
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    public void setMakevisibleEnabled(boolean b){
        makevisible.setEnabled(b);
        repaint();
    }
        
    public void setBuyEnabled(boolean b){
        buylevel.setEnabled(b);
        repaint();
    }
    
    public void setPlayer (Player p) {
        playerModel = p;
        
        String varname = playerModel.getName();
        
        name.setText(varname);
        
        // Vivo o muerto
        if (playerModel.isDead())
            name.setForeground(Color.RED);
        else
            name.setForeground(Color.white);
            
        // Establecemos la imagen del nivel real
        ImageIcon levelrealimg;
        levelrealimg = new ImageIcon(getClass().getResource("/GUI/img/level/real/" + Integer.toString(playerModel.getLevels()) + ".png"));
        level.setIcon(levelrealimg);
       
        // Lo rellenamos
        fillTreasurePanel (hiddenTreasures, playerModel.getHiddenTreasures());
        fillTreasurePanel (visibleTreasures, playerModel.getVisibleTreasures());
        
        // SECTARIO
         if(playerModel.getClass() == CultistPlayer.class){
            cultistView1.setCultist(((CultistPlayer)playerModel).getCultistCard());
            cultistView1.setVisible(true);
        } else 
             cultistView1.setVisible(false);
        
        
        repaint();
    }
    
    public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
    // Se recorren los tesoros que contiene el panel,
    //almacenando en un vector aquellos que están seleccionados.
    //Finalmente se devuelve dicho vector.
    
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            
            if ( tv.isSelected() )
                output.add ( tv.getTreasure() );
        }
        
        return output;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        level = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        buylevel = new javax.swing.JButton();
        makevisible = new javax.swing.JButton();
        discard = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cultistView1 = new GUI.CultistView();

        setBackground(new java.awt.Color(1, 1, 1));
        setForeground(new java.awt.Color(1, 1, 1));

        level.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/level/real/1.png"))); // NOI18N

        name.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(254, 254, 254));
        name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name.setText("Player");

        buylevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/buy.png"))); // NOI18N
        buylevel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buylevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buylevelActionPerformed(evt);
            }
        });

        makevisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/makevisible.png"))); // NOI18N
        makevisible.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        makevisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makevisibleActionPerformed(evt);
            }
        });

        discard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/discard.png"))); // NOI18N
        discard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        discard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bag:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("jsMath-eurb10", 0, 14), java.awt.Color.white)); // NOI18N

        visibleTreasures.setAutoscrolls(true);
        visibleTreasures.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visibleTreasuresMouseClicked(evt);
            }
        });

        hiddenTreasures.setAutoscrolls(true);
        hiddenTreasures.add(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cultistView1.setBackground(new java.awt.Color(1, 1, 1));
        cultistView1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cultist:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(254, 254, 254))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(level)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(cultistView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(makevisible, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buylevel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(discard, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(level)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(discard, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buylevel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                    .addComponent(makevisible, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cultistView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void discardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures (visibleTreasures);
        
        napakalakiModel.discardHiddenTreasures(selHidden);
        napakalakiModel.discardVisibleTreasures(selVisible); 
        
        setPlayer(napakalakiModel.getCurrentPlayer());
        
    }//GEN-LAST:event_discardActionPerformed

    private void visibleTreasuresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visibleTreasuresMouseClicked

        
    }//GEN-LAST:event_visibleTreasuresMouseClicked

    private void makevisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makevisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        napakalakiModel.makeTreasuresVisible (selHidden);
        setPlayer (napakalakiModel.getCurrentPlayer());

    }//GEN-LAST:event_makevisibleActionPerformed

    private void buylevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buylevelActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures (visibleTreasures);
        
        int reply = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas vender los objetos seleccionados? Si no llegas a 1.000 lo perderás.", "¿Seguro?", JOptionPane.YES_NO_OPTION);
        
        
        if (reply == JOptionPane.YES_OPTION){
            napakalakiModel.buyLevels(selVisible,selHidden);
            setPlayer (napakalakiModel.getCurrentPlayer());   
        }
    }//GEN-LAST:event_buylevelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buylevel;
    private GUI.CultistView cultistView1;
    private javax.swing.JButton discard;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel level;
    private javax.swing.JButton makevisible;
    private javax.swing.JLabel name;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
