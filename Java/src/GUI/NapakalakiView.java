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


import NapakalakiGame.CombatResult;
import NapakalakiGame.Napakalaki;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;



public class NapakalakiView extends javax.swing.JFrame {

    private Napakalaki napakalakiModel;
    
    public NapakalakiView() {
        initComponents();
        this.getContentPane().setBackground(Color.black);
        meet.setText("Meet the monster!");
        combat.setText("Combat!");
        
        // FACULTAD PC 1280,1024
       /* Dimension d = new Dimension(1000,500);
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        this.setMinimumSize(d);*/
    }
    
    public void setNapakalaki(Napakalaki game){
        napakalakiModel = game;
        playerView1.setNapakalaki(napakalakiModel);
        iniciar();
        
    }
    
    public void showView() {
        this.setVisible(true);
    }
    
    private void iniciar(){
        playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
        monsterView1.setVisibleMonster(false);
        combat.setEnabled(false);
        combatResult.setVisible(false);
        
        
        next.setEnabled(false);
                
        meet.setEnabled(true);
        
        playerView1.setMakevisibleEnabled(true);
        playerView1.setBuyEnabled(true);

        repaint();
    }
    
    private void meet(){
        monsterView1.setMonster(napakalakiModel.getCurrentMonster());
        monsterView1.setVisibleMonster(true);
        
        combat.setEnabled(true);
        combatResult.setText("");
        combatResult.setVisible(true);
        
        combat.setEnabled(true);
        
        meet.setEnabled(false);
        
        playerView1.setMakevisibleEnabled(false);
        playerView1.setBuyEnabled(false);
        
        repaint();
    }
    
    private void combat(){
        
        playerView1.setMakevisibleEnabled(true);
        playerView1.setBuyEnabled(true);
        combat.setEnabled(false);
        
        next.setEnabled(true);
        
        repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combat = new javax.swing.JButton();
        meet = new javax.swing.JButton();
        combatResult = new java.awt.Label();
        next = new javax.swing.JButton();
        playerView1 = new GUI.PlayerView();
        jLabel1 = new javax.swing.JLabel();
        monsterView1 = new GUI.MonsterView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Napakalaki Game");
        setBackground(new java.awt.Color(1, 1, 1));
        setForeground(new java.awt.Color(1, 1, 1));
        setMaximumSize(new java.awt.Dimension(1300, 768));
        setMinimumSize(new java.awt.Dimension(1000, 700));

        combat.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        combat.setText("¡Combat!");
        combat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatActionPerformed(evt);
            }
        });

        meet.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        meet.setText("¡Meet the Monster!");
        meet.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        meet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetActionPerformed(evt);
            }
        });

        combatResult.setAlignment(java.awt.Label.CENTER);
        combatResult.setBackground(new java.awt.Color(1, 1, 1));
        combatResult.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        combatResult.setForeground(new java.awt.Color(254, 254, 254));

        next.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        next.setText("Next turn ->");
        next.setActionCommand("next");
        next.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        playerView1.setBorder(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/logo.png"))); // NOI18N

        monsterView1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 254, 254), 3), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED))));
        monsterView1.setMinimumSize(new java.awt.Dimension(1067, 1008));
        monsterView1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(combatResult, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(combat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(meet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(playerView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(meet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combat)
                        .addGap(123, 123, 123)
                        .addComponent(combatResult, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(next))
                    .addComponent(monsterView1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetActionPerformed
        meet();
    }//GEN-LAST:event_meetActionPerformed

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        CombatResult result = napakalakiModel.developCombat();

        switch (result) {
            case Win:
            combatResult.setText("¡Has derrotado a " + napakalakiModel.getCurrentMonster().getName() + "!");
            combatResult.setForeground(Color.green);
            break;

            case WinAndWinGame:
            combatResult.setText("¡Has ganado el combate y el juego! ¡Enhorabuena!");
            combatResult.setForeground(Color.green);
            break;

            case Lose:
            combatResult.setText("Has perdido el combate");
            combatResult.setForeground(Color.red);
            break;

            case LoseAndDie:
            combatResult.setText("Has perdido el combate y has muerto");
            combatResult.setForeground(Color.red);
            break;

            case LoseAndEscape:
            combatResult.setText("Has logrado escapar del combate...");
            combatResult.setForeground(Color.gray);
            break;
                
            case LoseAndConvert:
            combatResult.setText("Has perdido pero... Ahora eres SECTARIO");
            combatResult.setForeground(Color.gray);
            break;

            default:
            combatResult.setText("Error en el combate.");
            combatResult.setForeground(Color.red);
            break;        // TODO add your handling code here:
        }
        
        playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
        
        if (result == CombatResult.WinAndWinGame){
            JOptionPane.showMessageDialog(null, "¡¡Enhorabuena!! El jugador " + napakalakiModel.getCurrentPlayer().getName() + " ha ganado la partida.","¡¡Ganador!!", JOptionPane.INFORMATION_MESSAGE);
        } else
            combat();
        
 
    }//GEN-LAST:event_combatActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if (napakalakiModel.nextTurn())
            iniciar();
        else
            JOptionPane.showMessageDialog(null, "No cumples las condiciones para pasar de turno. Revisa el mal rollo y recuerda que no puedes tener más de 4 tesoros ocultos.", "¡No puedas pasar de turno!",JOptionPane.ERROR_MESSAGE); 
        
    }//GEN-LAST:event_nextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combat;
    private java.awt.Label combatResult;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton meet;
    private GUI.MonsterView monsterView1;
    private javax.swing.JButton next;
    private GUI.PlayerView playerView1;
    // End of variables declaration//GEN-END:variables
}
