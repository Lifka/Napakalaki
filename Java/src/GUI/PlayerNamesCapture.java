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

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class PlayerNamesCapture extends javax.swing.JDialog {

    private ArrayList<String> names = new ArrayList();
    /**
     * Creates new form PlayerNamesCapture
     */
    public PlayerNamesCapture(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l1 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Player1 = new java.awt.TextField();
        Player5 = new java.awt.TextField();
        Player3 = new java.awt.TextField();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        cb = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        Player2 = new java.awt.TextField();
        Player6 = new java.awt.TextField();
        Player4 = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nombre de los jugadores");
        setBackground(new java.awt.Color(17, 71, 227));
        setForeground(java.awt.Color.white);
        setModal(true);
        setName("nombres"); // NOI18N
        setResizable(false);

        l1.setText("Player 1");

        l3.setText("Player 3");

        l5.setText("Player 5");
        l5.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Enter the names of the players:");

        Player1.setName("player1"); // NOI18N

        Player5.setEnabled(false);
        Player5.setName("player3"); // NOI18N

        Player3.setName("player2"); // NOI18N

        button1.setActionCommand("Play");
        button1.setBackground(new java.awt.Color(71, 240, 18));
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button1.setLabel("Play!");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setActionCommand("Cancel");
        button2.setLabel("Cancel");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6" }));
        cb.setSelectedIndex(1);
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });

        jLabel5.setText("Number of players:");

        l2.setText("Player 2");

        l4.setText("Player 4");
        l4.setEnabled(false);

        l6.setText("Player 6");
        l6.setEnabled(false);

        Player2.setName("player1"); // NOI18N

        Player6.setEnabled(false);
        Player6.setName("player3"); // NOI18N

        Player4.setEnabled(false);
        Player4.setName("player2"); // NOI18N
        Player4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player4ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(129, 129, 129))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(l5)
                                            .addComponent(l1)
                                            .addComponent(l3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Player3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Player1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Player5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(l2)
                                            .addComponent(l4)
                                            .addComponent(l6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Player2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Player6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Player4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(22, 22, 22)))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l3))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Player5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Player2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Player4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l4))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Player6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        l1.getAccessibleContext().setAccessibleName("player1label");
        l3.getAccessibleContext().setAccessibleName("Player2label");
        l5.getAccessibleContext().setAccessibleName("player3label");
        jLabel4.getAccessibleContext().setAccessibleDescription("");
        button1.getAccessibleContext().setAccessibleName("Play");
        button2.getAccessibleContext().setAccessibleName("cancel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // Dos jugadores
        names.add(Player1.getText());
        names.add(Player2.getText());

        // Tres jugadores
        if (cb.getSelectedIndex() > 0)
            names.add(Player3.getText());
            
        // Cuatro jugadores
        if (cb.getSelectedIndex() > 1)
            names.add(Player4.getText());

        // Cinco jugadores
        if (cb.getSelectedIndex() > 2)
            names.add(Player5.getText());
            
        // Séis jugadores
        if (cb.getSelectedIndex() > 3)
            names.add(Player5.getText());
        
        this.dispose();       
    }//GEN-LAST:event_button1ActionPerformed

    private void Player4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Player4ActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        Object selected = cb.getSelectedItem();
        
        // Dos jugadores
        if (selected.toString().equals("2")){
            Player2.setEnabled(true);
            l2.setEnabled(true);
            Player3.setEnabled(false);
            l3.setEnabled(false);
            Player4.setEnabled(false);
            l4.setEnabled(false);
            Player5.setEnabled(false);
            l5.setEnabled(false);
            Player6.setEnabled(false);
            l6.setEnabled(false);
            
        // Tres jugadores
        } else if (selected.toString().equals("3")){
            Player2.setEnabled(true);
            Player3.setEnabled(true);
            Player4.setEnabled(false);
            Player5.setEnabled(false);
            Player6.setEnabled(false);
            
            l2.setEnabled(true);
            l3.setEnabled(true);
            l4.setEnabled(false);
            l5.setEnabled(false);
            l6.setEnabled(false);
            
        // Cuatro jugadores
        } else if (selected.toString().equals("4")){
            Player2.setEnabled(true);
            Player3.setEnabled(true);
            Player4.setEnabled(true);
            Player5.setEnabled(false);
            Player6.setEnabled(false);
            
            l2.setEnabled(true);
            l3.setEnabled(true);
            l4.setEnabled(true);
            l5.setEnabled(false);
            l6.setEnabled(false);

        // Cinco jugadores
        } else if (selected.toString().equals("5")){
            Player2.setEnabled(true);
            Player3.setEnabled(true);
            Player4.setEnabled(true);
            Player5.setEnabled(true);
            Player6.setEnabled(false);
            
            l2.setEnabled(true);
            l3.setEnabled(true);
            l4.setEnabled(true);
            l5.setEnabled(true);
            l6.setEnabled(false);
            
        // Séis jugadores
        } else if (selected.toString().equals("6")){
            Player2.setEnabled(true);
            Player3.setEnabled(true);
            Player4.setEnabled(true);
            Player5.setEnabled(true);
            Player6.setEnabled(true);
            
            l2.setEnabled(true);
            l3.setEnabled(true);
            l4.setEnabled(true);
            l5.setEnabled(true);
            l6.setEnabled(true);
            
        }
            
    }//GEN-LAST:event_cbActionPerformed


    public ArrayList<String> getNames() {
        this.setVisible(true);
        return names;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField Player1;
    private java.awt.TextField Player2;
    private java.awt.TextField Player3;
    private java.awt.TextField Player4;
    private java.awt.TextField Player5;
    private java.awt.TextField Player6;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JComboBox cb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    // End of variables declaration//GEN-END:variables
}