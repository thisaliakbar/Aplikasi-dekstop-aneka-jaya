package view_laporan;
import com.toedter.calendar.JCalendar;
import java.util.List;
import java.awt.Color;
import control.Control_pemesanan;
import control.Control_detPemesanan;
import crud.trans_pemesanan;
import crud.trans_detPemesanan;
import java.awt.Component;
import java.awt.Font;
import model.model_pemesanan;
import model.model_detail_pemesanan;
import tableModel.tm_pemesanan;
import tableModel.tm_detPemesanan;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class laporan_pemesanan extends javax.swing.JPanel {
    private Control_pemesanan servicePem = new trans_pemesanan();
    private Control_detPemesanan serviceDet = new trans_detPemesanan();
    
    private tm_pemesanan tblModelPem = new tm_pemesanan();
    private tm_detPemesanan tblModelDet = new tm_detPemesanan();
    List<model_pemesanan> list;
    
    public laporan_pemesanan() {
        initComponents();
        tblPemesanan.getTableHeader().setDefaultRenderer(new HeaderColor());
        tblDetail.getTableHeader().setDefaultRenderer(new HeaderColor());
        tblPemesanan.setRowHeight(50);
        tblDetail.setRowHeight(50);
        tblPemesanan.setModel(tblModelPem);
        tblDetail.setModel(tblModelDet);
        pn_detail.setVisible(false);
        jLabel11.setVisible(false);
        t_cari.setVisible(false);
 
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel3 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        dataBarang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bt_submit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPemesanan = new javax.swing.JTable();
        t_cari = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        pn_detail = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        bt_closeDet = new javax.swing.JButton();
        jDateFrom = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jDateTo = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        dataBarang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Laporan Pemesanan");

        bt_submit.setBackground(new java.awt.Color(0, 11, 109));
        bt_submit.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_submit.setForeground(new java.awt.Color(255, 255, 255));
        bt_submit.setText("Submit");
        bt_submit.setBorderPainted(false);
        bt_submit.setPreferredSize(new java.awt.Dimension(90, 30));
        bt_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_submitActionPerformed(evt);
            }
        });

        tblPemesanan.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        tblPemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPemesanan.setGridColor(new java.awt.Color(204, 204, 204));
        tblPemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPemesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPemesanan);

        t_cari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t_cari.setForeground(new java.awt.Color(153, 153, 153));
        t_cari.setText("Cari");
        t_cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_cari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_cariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_cariFocusLost(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_cariKeyReleased(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/magnifying-glass.png"))); // NOI18N

        pn_detail.setBackground(new java.awt.Color(0, 11, 109));
        pn_detail.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Detail Laporan");

        tblDetail.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetail.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane3.setViewportView(tblDetail);

        bt_closeDet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/closeMenu.png"))); // NOI18N
        bt_closeDet.setContentAreaFilled(false);
        bt_closeDet.setOpaque(true);
        bt_closeDet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_closeDetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_closeDetMouseExited(evt);
            }
        });
        bt_closeDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_closeDetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_detailLayout = new javax.swing.GroupLayout(pn_detail);
        pn_detail.setLayout(pn_detailLayout);
        pn_detailLayout.setHorizontalGroup(
            pn_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_detailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_closeDet)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pn_detailLayout.setVerticalGroup(
            pn_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_detailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(bt_closeDet))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
        );

        jDateFrom.setBackground(new java.awt.Color(255, 255, 255));
        jDateFrom.setForeground(new java.awt.Color(0, 0, 0));
        jDateFrom.setDateFormatString("yyyy-MM-dd");
        jDateFrom.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jDateFrom.setPreferredSize(new java.awt.Dimension(90, 30));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Dari : ");

        jDateTo.setBackground(new java.awt.Color(255, 255, 255));
        jDateTo.setForeground(new java.awt.Color(0, 0, 0));
        jDateTo.setDateFormatString("yyyy-MM-dd");
        jDateTo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jDateTo.setPreferredSize(new java.awt.Dimension(90, 30));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Sampai :");

        txt_total.setBackground(new java.awt.Color(255, 255, 255));
        txt_total.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txt_total.setForeground(new java.awt.Color(0, 0, 0));
        txt_total.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TOTAL : ");

        javax.swing.GroupLayout dataBarangLayout = new javax.swing.GroupLayout(dataBarang);
        dataBarang.setLayout(dataBarangLayout);
        dataBarangLayout.setHorizontalGroup(
            dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBarangLayout.createSequentialGroup()
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataBarangLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_submit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(dataBarangLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addComponent(pn_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dataBarangLayout.setVerticalGroup(
            dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_submit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_cari, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7)
                        .addComponent(jDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(dataBarang, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_submitActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String from = sdf.format(jDateFrom.getDate());
        String to = sdf.format(jDateTo.getDate());
        
        model_pemesanan mp = new model_pemesanan();
        model_pemesanan mpn = new model_pemesanan();
        Long subtotal = mp.getTotal_pesan();
        mp.setTgl_pesan(from);
        mpn.setTgl_pesan(to);
        mp.setTotal_pesan(subtotal);
        
        servicePem.sumTotalReport(mp, mpn);
        txt_total.setText("Rp " + mp.getTotal_pesan().toString());
        list = servicePem.getById(from, to);
        tblModelPem.setData(list);
        pn_detail.setVisible(false);
    }//GEN-LAST:event_bt_submitActionPerformed

    private void tblPemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPemesananMouseClicked
          int row = tblPemesanan.getSelectedRow();
          String id = tblPemesanan.getValueAt(row, 0).toString();
          pn_detail.setVisible(true);
          bt_closeDet.setBackground(null);
          List<model_detail_pemesanan> list = serviceDet.getData(id);
          tblModelDet.setData(list);
    }//GEN-LAST:event_tblPemesananMouseClicked

    private void t_cariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_cariFocusGained
        if(t_cari.getText().equalsIgnoreCase("Cari")) {
            t_cari.setText("");
            t_cari.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_t_cariFocusGained

    private void t_cariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_cariFocusLost
        if(t_cari.getText().equalsIgnoreCase("")) {
            t_cari.setText("Cari");
        }
    }//GEN-LAST:event_t_cariFocusLost

    private void t_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyReleased

    }//GEN-LAST:event_t_cariKeyReleased

    private void bt_closeDetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_closeDetMouseEntered
        bt_closeDet.setBackground(Color.red);
    }//GEN-LAST:event_bt_closeDetMouseEntered

    private void bt_closeDetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_closeDetMouseExited
        bt_closeDet.setBackground(null);
    }//GEN-LAST:event_bt_closeDetMouseExited

    private void bt_closeDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_closeDetActionPerformed
        pn_detail.setVisible(false);
    }//GEN-LAST:event_bt_closeDetActionPerformed


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_closeDet;
    private javax.swing.JButton bt_submit;
    private javax.swing.JPanel dataBarang;
    private com.toedter.calendar.JDateChooser jDateFrom;
    private com.toedter.calendar.JDateChooser jDateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pn_detail;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTable tblDetail;
    private javax.swing.JTable tblPemesanan;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
        List<model_pemesanan> list = servicePem.getData();
        tblModelPem.setData(list);
    }
    
    
    
    static public class HeaderColor extends DefaultTableCellRenderer{

        public HeaderColor() {
            setOpaque(true);
        }
        
        public Component getTableCellRendererComponent(JTable tbl_contoh, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(tbl_contoh, value, selected, focused, row, column);
            setBackground(new Color(0,139,185,255));
            setForeground(new Color(255, 255, 255));
            setFont(new Font(null, Font.BOLD, 18));
            return this;
        }
    
    }
      
}