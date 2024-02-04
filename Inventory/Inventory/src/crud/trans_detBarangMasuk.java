package crud;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import control.Control_detBarangMasuk;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.model_barang;
import model.model_barangMasuk;
import model.model_detail_barangMasuk;
import model.model_detail_pemesanan;
public class trans_detBarangMasuk implements Control_detBarangMasuk{
    private Connection conn;
    public trans_detBarangMasuk() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(List<model_detail_pemesanan> list) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_barang_masuk (no_pesan, kode_barang, jml_masuk, subtotal_masuk, status)  VALUES (?,?,?,?,?);";
        try {
            for (int i = 0; i < list.size(); i++) {
                st = conn.prepareStatement(sql);
                st.setString(1, list.get(i).getMod_pemesanan_detPem().getNo_pesan());
                st.setString(2, list.get(i).getMod_barang_detPem().getKode_barang());
                st.setString(3, list.get(i).getJml_pesan()+"");
                st.setString(4, list.get(i).getSubtotal_pesan()+"");
                st.setString(5, "Telah Sampai");
                st.executeUpdate();
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangMasuk.class.getName()).log(Level.SEVERE, null, ex) ;
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                 Logger.getLogger(trans_detBarangMasuk.class.getName()).log(Level.SEVERE, null, ex) ;
                }
            }
        }
    }

    @Override
    public void sumTotal(model_detail_barangMasuk mod_detMasuk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void hapusSementara(model_detail_barangMasuk mod_detMasuk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public model_detail_barangMasuk getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_detail_barangMasuk> getData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT detMas.no_pesan, detMas.kode_barang, brg.nama_barang, brg.harga, detMas.jml_masuk, detMas.subtotal_masuk FROM detail_barang_masuk detMas INNER JOIN barang_masuk brgMas ON brgMas.no_pesan=detMas.no_pesan INNER JOIN barang brg ON brg.kode_barang=detMas.kode_barang WHERE detMas.no_pesan='"+id+"' ORDER BY no_pesan ASC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_detail_barangMasuk mdbm = new model_detail_barangMasuk();
                model_barangMasuk mbm = new model_barangMasuk();
                model_barang mb = new model_barang();
                
                mbm.setNo_masuk(String.valueOf(rs.getString("detMas.no_pesan")));
                mdbm.setMod_barangMas_detMas(mbm);
                
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setHarga(rs.getLong("harga"));
                mdbm.setJml_masuk(rs.getInt("jml_masuk"));
                mdbm.setSubtotal_masuk(rs.getLong("subtotal_masuk"));
                
                mdbm.setMod_barang_detMas(mb);
                list.add(mdbm);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs!=null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public void hapusData(model_detail_barangMasuk mod_detMasuk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_detail_barangMasuk> pencarian(String id, String no) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT dp.no_pesan, dp.kode_barang, bg.nama_barang, bg.harga ,dp.jml_masuk, "
                + "dp.subtotal_masuk, dp.status FROM detail_barang_masuk dp INNER JOIN barang bg ON "
                + "dp.kode_barang=bg.kode_barang "
                + "WHERE dp.no_pesan='"+no+"' AND (dp.kode_barang LIKE '%"+id+"%'  OR bg.nama_barang LIKE '%"+id+"%') ";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_barang mb = new model_barang();
                model_barangMasuk mbm = new model_barangMasuk();
                model_detail_barangMasuk mdbm = new model_detail_barangMasuk();
                
                mbm.setNo_masuk(rs.getString("no_pesan"));
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setHarga(rs.getLong("harga"));
                mdbm.setJml_masuk(rs.getInt("jml_masuk"));
                mdbm.setSubtotal_masuk(rs.getLong("subtotal_masuk"));
                mdbm.setStatus(rs.getString("status"));
                
                mdbm.setMod_barangMas_detMas(mbm);
                mdbm.setMod_barang_detMas(mb);
                
                list.add(mdbm);
            }
            
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs!=null) {
                try {
                rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
    
}
