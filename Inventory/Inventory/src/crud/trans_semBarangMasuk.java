package crud;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import control.Control_semMasuk;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.model_barang;
import model.model_detail_barangMasuk;
import model.sementara_masuk;
public class trans_semBarangMasuk implements Control_semMasuk{
    
    private Connection conn;
    public trans_semBarangMasuk() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(sementara_masuk semMasuk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void perbaruiData(sementara_masuk semMasuk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void hapusData(sementara_masuk semMasuk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public sementara_masuk getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<sementara_masuk> getData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM sementara_masuk";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                sementara_masuk sm = new sementara_masuk();
                model_barang mb = new model_barang();
                model_detail_barangMasuk mdbm = new model_detail_barangMasuk();
                
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setHarga(rs.getLong("harga"));
                mdbm.setJml_masuk(rs.getInt("jml_masuk"));
                mdbm.setSubtotal_masuk(rs.getLong("subtotal_masuk"));
                
                sm.setMdl_brg(mb);
                sm.setMdl_mdbm(mdbm);
                
                list.add(sm);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_semBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs!=null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public boolean validasiNamaBarang(sementara_masuk semMasuk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
