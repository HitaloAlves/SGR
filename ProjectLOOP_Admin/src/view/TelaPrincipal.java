package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author leonardo
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLData = new javax.swing.JLabel();
        jLHora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPane1.setBackground(java.awt.Color.white);

        jPanel1.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(613, Short.MAX_VALUE)
                .addComponent(jLData, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLHora, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/page.png"))); // NOI18N
        jMenu1.setText("Arquivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/disconnect.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jMenu2.setText("Usuário");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_page.png"))); // NOI18N
        jMenuItem2.setText("Conta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar.png"))); // NOI18N
        jMenu3.setText("Eventos");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye.png"))); // NOI18N
        jMenuItem3.setText("Show");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book_open.png"))); // NOI18N
        jMenu4.setText("Receitas");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye.png"))); // NOI18N
        jMenuItem4.setText("Show");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jMenuItem6.setText("Adicionar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/convidados.png"))); // NOI18N
        jMenu5.setText("Convidados");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye.png"))); // NOI18N
        jMenuItem5.setText("Show");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/information.png"))); // NOI18N
        jMenu6.setText("Sobre");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N
        jMenuItem7.setText("Ajuda");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   // Eventos
    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jMenu3ActionPerformed

    // Usuário
    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
            // TODO add your handling code here:

    }//GEN-LAST:event_jMenu2ActionPerformed

    // Receitas
    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    // Convidados
    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5ActionPerformed

    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:        
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TelaUsuario telaUser = new TelaUsuario();
        jDesktopPane1.add(telaUser);
        telaUser.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:

        TelaEvento telaCadEvento = new TelaEvento();
        jDesktopPane1.add(telaCadEvento);        
        telaCadEvento.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:

        TelaReceita telaRec = new TelaReceita();
        jDesktopPane1.add(telaRec);
        telaRec.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        TelaConvidado telaConv = new TelaConvidado();
        jDesktopPane1.add(telaConv);
        telaConv.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        
        TelaCadastrarReceita telaCadRec = new TelaCadastrarReceita();
        jDesktopPane1.add(telaCadRec);
        telaCadRec.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        // Maximizar página ao entrar na página
        this.setExtendedState(MAXIMIZED_BOTH);
        
        // Data
        Date dataSistema = new Date();
        SimpleDateFormat formarto = new SimpleDateFormat("dd/MM/yyyy");
        jLData.setText(formarto.format(dataSistema));
        
        // Hora
        Timer timer = new Timer(1000, new hora());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLHora;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            Calendar now = Calendar.getInstance();
            jLHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

}