/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import view.view_login;
import crud.Crud_Pengguna;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author usER
 */
public class reset_password extends javax.swing.JFrame {
    int xx, xy;
    Crud_Pengguna service = new Crud_Pengguna();
    public reset_password() {
        initComponents();
        btnBack.setBackground(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        t_newPass = new javax.swing.JTextField();
        t_confirmPass = new javax.swing.JTextField();
        t_username = new javax.swing.JTextField();
        btnPerbarui = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 11, 109));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        t_newPass.setBackground(new java.awt.Color(255, 255, 255));
        t_newPass.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        t_newPass.setForeground(new java.awt.Color(102, 102, 102));
        t_newPass.setText("Masukkan Password Baru");
        t_newPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_newPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_newPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_newPassFocusLost(evt);
            }
        });
        t_newPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_newPassKeyPressed(evt);
            }
        });

        t_confirmPass.setBackground(new java.awt.Color(255, 255, 255));
        t_confirmPass.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        t_confirmPass.setForeground(new java.awt.Color(102, 102, 102));
        t_confirmPass.setText("Konfirmasi Password Baru");
        t_confirmPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_confirmPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_confirmPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_confirmPassFocusLost(evt);
            }
        });
        t_confirmPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_confirmPassKeyPressed(evt);
            }
        });

        t_username.setBackground(new java.awt.Color(255, 255, 255));
        t_username.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        t_username.setForeground(new java.awt.Color(102, 102, 102));
        t_username.setText("Masukkan Username");
        t_username.setToolTipText("Masukkan Username");
        t_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_usernameFocusLost(evt);
            }
        });
        t_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_usernameKeyPressed(evt);
            }
        });

        btnPerbarui.setBackground(new java.awt.Color(0, 11, 109));
        btnPerbarui.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnPerbarui.setForeground(new java.awt.Color(255, 255, 255));
        btnPerbarui.setText("Perbarui");
        btnPerbarui.setPreferredSize(new java.awt.Dimension(100, 50));
        btnPerbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerbaruiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_newPass)
                    .addComponent(t_confirmPass, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                    .addComponent(t_username))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPerbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(t_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_newPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_confirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPerbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RESET PASSWORD");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/keyhole.png"))); // NOI18N

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow.png"))); // NOI18N
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBack.setOpaque(true);
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 357, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(333, 333, 333))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252)
                .addComponent(jLabel1)
                .addContainerGap(279, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(818, 465));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        view_login vl = new view_login();
        vl.setVisible(true);
        vl.repaint();
        vl.revalidate();
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setBackground(null);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setBackground(Color.RED);
    }//GEN-LAST:event_btnBackMouseEntered

    private void t_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameFocusGained
        if(t_username.getText().equals("Masukkan Username")) {
            t_username.setText("");
            t_username.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_t_usernameFocusGained

    private void t_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameFocusLost
        if(t_username.getText().equals("") || t_username.equals("Masukkan Username")) {
            t_username.setText("Masukkan Username");
            t_username.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_t_usernameFocusLost

    private void t_newPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_newPassFocusGained
        if(t_newPass.getText().equals("Masukkan Password Baru")) {
            t_newPass.setText("");
            t_newPass.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_t_newPassFocusGained

    private void t_newPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_newPassFocusLost
        if(t_newPass.getText().equals("") || t_newPass.equals("Masukkan Password Baru")) {
            t_newPass.setText("Masukkan Password Baru");
            t_newPass.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_t_newPassFocusLost

    private void t_confirmPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_confirmPassFocusGained
        if(t_confirmPass.getText().equals("Konfirmasi Password Baru")) {
            t_confirmPass.setText("");
            t_confirmPass.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_t_confirmPassFocusGained

    private void t_confirmPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_confirmPassFocusLost
        if(t_confirmPass.getText().equals("") || t_confirmPass.equals("Konfirmasi Password Baru")) {
            t_confirmPass.setText("Konfirmasi Password Baru");
            t_confirmPass.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_t_confirmPassFocusLost

    private void btnPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerbaruiActionPerformed
        String username = t_username.getText();
        String newPass = t_newPass.getText();
        
        if(!service.validasiIdUser_username(username)) {
            JOptionPane.showMessageDialog(null, "Username tidak valid");
            return;
        }
        if(t_confirmPass.getText().equals(t_newPass.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Konfirmasi password baru tidak sesuai");
            return;
        }
        if(service.changePassword(username, newPass)) {
            JOptionPane.showMessageDialog(null, "Password berhasil diubah");
        } else {
            JOptionPane.showMessageDialog(null, "Password gagal diubah");
        }
        
        t_username.setText("");
        t_newPass.setText("");
        t_confirmPass.setText("");
        view_login vl = new view_login();
        vl.setVisible(true);
        vl.repaint();
        vl.revalidate();
        dispose();
    }//GEN-LAST:event_btnPerbaruiActionPerformed

    private void t_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_usernameKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER) {
            t_newPass.requestFocus();
        }
    }//GEN-LAST:event_t_usernameKeyPressed

    private void t_newPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_newPassKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            t_confirmPass.requestFocus();
        }
    }//GEN-LAST:event_t_newPassKeyPressed

    private void t_confirmPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_confirmPassKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnPerbaruiActionPerformed(new ActionEvent(evt.getSource(), evt.getID(), ""));
        }
    }//GEN-LAST:event_t_confirmPassKeyPressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(reset_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reset_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reset_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reset_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reset_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPerbarui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField t_confirmPass;
    private javax.swing.JTextField t_newPass;
    private javax.swing.JTextField t_username;
    // End of variables declaration//GEN-END:variables
}