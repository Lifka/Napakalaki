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

import NapakalakiGame.Treasure;
import javax.swing.ImageIcon;

public class TreasureInfo extends javax.swing.JFrame {

    private Treasure treasureModel;

    public TreasureInfo() {
        initComponents();
    }
    
    public void setTreasure (Treasure t) {
        treasureModel = t;
        
        String varname = treasureModel.getName();
        name.setText(varname);
        setImage(varname);
        
        tipo.setText(treasureModel.getType().toString());
                
        bonmin.setText(Integer.toString(treasureModel.getMinBonus()));
        bonmax.setText(Integer.toString(treasureModel.getMaxBonus()));
        coins.setText(Integer.toString(treasureModel.getGoldCoins()));
        setTitle(varname);
        repaint();
    }

    private void setImage (String name){
        // Establecemos la imagen por defecto para reducir el acoplamiento (solo se establece una imagen distinta si está definida):
        ImageIcon icon;
        icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/default.png"));

        // Si existe una imagen definida para ese tesoro en concreto, la establecemos:
        if (name == "¡Sí mi amo!"){   
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/0.png"));
            
        } else if (name == "Botas de investigación"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/1.png"));
            
        } else if (name == "Capucha de Cthulhu"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/2.png"));
            
        } else if (name == "A prueba de babas"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/3.png"));
            
        } else if (name == "Botas de llubia ácida"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/4.png"));
            
        } else if (name == "Casco minero"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/5.png"));
            
        } else if (name == "Ametralladora"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/6.png"));
            
        } else if (name == "Camiseta de la UGR"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/7.png"));
            
        } else if (name == "Clavo de rail ferroviario"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/8.png"));
            
        } else if (name == "Cuchillo de sushi arcano"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/9.png"));
            
        } else if (name == "Fez alópodo"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/10.png"));
            
        } else if (name == "Hacha prehistórica"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/11.png"));
            
        } else if (name == "El aparato del Pr. Tesla"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/12.png"));
            
        } else if (name == "Gaita"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/13.png"));
            
        } else if (name == "Insecticida"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/14.png"));
            
        } else if (name == "Escopeta de 3 cañones"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/15.png"));
            
        } else if (name == "Garabato místico"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/16.png"));
            
        } else if (name == "La fuerza de Mr. T"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/17.png"));
            
        } else if (name == "La rebeca metálica"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/18.png"));
            
        } else if (name == "Mazo de los antiguos"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/19.png"));
            
        } else if (name == "Necroplayboycón"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/20.png"));
            
        } else if (name == "Lanzallamas"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/21.png"));
            
        } else if (name == "Necrocomicón"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/22.png"));
            
        } else if (name == "Necronomicón"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/23.png"));
            
        } else if (name == "Linterna a 2 manos"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/24.png"));
            
        } else if (name == "Necrognomicón"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/25.png"));
            
        } else if (name == "Necrotelecom"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/26.png"));
            
        } else if (name == "Porra preternatural"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/27.png"));
            
        } else if (name == "Tentáculo de pega"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/28.png"));
            
        } else if (name == "Zapato deja-amigos"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/29.png"));
            
        } else if (name == "Shogulador"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/30.png"));
            
        } else if (name == "Varita de atizamiento"){
            icon = new ImageIcon(getClass().getResource("/GUI/img/treasures/31.png"));
          
        }
        
       img.setIcon(icon);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coins = new javax.swing.JLabel();
        info2 = new javax.swing.JLabel();
        info3 = new javax.swing.JLabel();
        bonmax = new javax.swing.JLabel();
        bonmin = new javax.swing.JLabel();
        info1 = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        coins.setText("jLabel1");

        info2.setText("Coins:");

        info3.setText("Bonus max:");

        bonmax.setText("jLabel1");

        bonmin.setText("jLabel1");

        info1.setText("Bonus min:");

        tipo.setText("tipo");

        name.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        name.setText("jLabel1");

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/treasures/default.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(info1))
                                    .addComponent(info2)
                                    .addComponent(info3))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bonmax)
                                    .addComponent(bonmin)
                                    .addComponent(coins)))
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipo)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info1)
                    .addComponent(bonmin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info3)
                    .addComponent(bonmax))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info2)
                    .addComponent(coins))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(img))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        setVisible(false);
    }//GEN-LAST:event_formWindowLostFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bonmax;
    private javax.swing.JLabel bonmin;
    private javax.swing.JLabel coins;
    private javax.swing.JLabel img;
    private javax.swing.JLabel info1;
    private javax.swing.JLabel info2;
    private javax.swing.JLabel info3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel tipo;
    // End of variables declaration//GEN-END:variables
}
