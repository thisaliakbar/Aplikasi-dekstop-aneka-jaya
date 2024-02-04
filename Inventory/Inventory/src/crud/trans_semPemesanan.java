package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.koneksi;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import control.Control_semPemesanan;
import java.util.List;
import model.sementara_pesan;
import model.model_barang;
import model.model_detail_pemesanan;
import model.sementara_pemesanan;
public class trans_semPemesanan implements Control_semPemesanan{

    private Connection conn;
    public trans_semPemesanan() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(sementara_pemesanan semPemesanan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO sementara_pemesanan (no_pesan, tgl_pesan, total_pesan, id_pengguna, id_distributor) VALUES (?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, semPemesanan.getMdl_pem().getNo_pesan());
            st.setString(2, semPemesanan.getMdl_pem().getTgl_pesan());
            st.setLong(3, semPemesanan.getMdl_pem().getTotal_pesan());
            st.setString(4, semPemesanan.getMdl_pem().getModel_pengguna_pem().getId_pengguna());
            st.setString(5, semPemesanan.getMdl_pem().getModel_supliyer_pem().getId_supliyer());

            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_semPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void perbaruiData(sementara_pemesanan semPemesanan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void hapusData(sementara_pemesanan semPemesanan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<sementara_pemesanan> getData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
