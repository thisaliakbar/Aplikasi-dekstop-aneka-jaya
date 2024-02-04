package crud;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import control.Control_semKeluar;
import model.model_barang;
import model.model_detail_barangKeluar;
import model.sementara_keluar;

public class trans_semKeluar implements Control_semKeluar {

    private Connection conn;
    public trans_semKeluar() {
        conn = koneksi.getConnection();
    }
    

    @Override
    public void tambahData(sementara_keluar semKeluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO sementara_keluar (kode_barang, nama_barang, satuan, harga, jml_keluar, subtotal_keluar, keterangan) VALUES (?,?,?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, semKeluar.getMdl_brg().getKode_barang());
            st.setString(2, semKeluar.getMdl_brg().getNama_barang());
            st.setString(3, semKeluar.getMdl_brg().getSatuan());
            st.setLong(4, semKeluar.getMdl_brg().getHarga());
            st.setInt(5, semKeluar.getMdl_mdbk().getJml_keluar());
            st.setLong(6, semKeluar.getMdl_mdbk().getSubtotal_keluar());
            st.setString(7, semKeluar.getMdl_mdbk().getKeterangan());
            
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_semKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void perbaruiData(sementara_keluar semKeluar, sementara_keluar semKel) {
        PreparedStatement st = null;
        String sql = "UPDATE sementara_keluar SET nama_barang='"+semKeluar.getMdl_brg().getNama_barang()+"', satuan='"+semKeluar.getMdl_brg().getSatuan()+"', harga='"+semKeluar.getMdl_brg().getHarga()+"', jml_keluar='"+semKeluar.getMdl_mdbk().getJml_keluar()+"', subtotal_keluar='"+semKeluar.getMdl_mdbk().getSubtotal_keluar()+"', keterangan='"+semKeluar.getKeterangan()+"' "
                + "WHERE kode_barang='"+semKel.getMdl_brg().getKode_barang()+"' AND nama_barang='"+semKel.getMdl_brg().getNama_barang()+"' AND satuan='"+semKel.getMdl_brg().getSatuan()+"' AND harga='"+semKel.getMdl_brg().getHarga()+"' AND jml_keluar='"+semKel.getMdl_mdbk().getJml_keluar()+"' AND subtotal_keluar='"+semKel.getMdl_mdbk().getSubtotal_keluar()+"' AND keterangan='"+semKel.getKeterangan()+"'";
        
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
           Logger.getLogger(trans_semKeluar.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
        if(st != null) {
        try {
            st.close();
        } catch(SQLException ex) {
            Logger.getLogger(trans_semKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    }

    @Override
    public void hapusData(sementara_keluar semKeluar) {
         PreparedStatement st = null;
        String sql = "DELETE FROM sementara_keluar WHERE kode_barang='"+semKeluar.getMdl_brg().getKode_barang()+"' AND nama_barang='"+semKeluar.getMdl_brg().getNama_barang()+"' "
                + "AND satuan='"+semKeluar.getMdl_brg().getSatuan()+"' AND harga='"+semKeluar.getMdl_brg().getHarga()+"' AND jml_keluar='"+semKeluar.getMdl_mdbk().getJml_keluar()+"' "
                + "AND subtotal_keluar='"+semKeluar.getMdl_mdbk().getSubtotal_keluar()+"' AND keterangan='"+semKeluar.getKeterangan()+"'";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_semKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!= null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semKeluar.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
    }

    @Override
    public sementara_keluar getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<sementara_keluar> getData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM sementara_keluar";
        List list = new ArrayList();
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                sementara_keluar semKel = new sementara_keluar();
                model_barang mb = new model_barang();
                model_detail_barangKeluar mdbk = new model_detail_barangKeluar();
                
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setSatuan(rs.getString("satuan"));
                mb.setHarga(rs.getLong("harga"));
                mdbk.setJml_keluar(rs.getInt("jml_keluar"));
                mdbk.setSubtotal_keluar(rs.getLong("subtotal_keluar"));
                semKel.setKeterangan(rs.getString("keterangan"));
                
                
                semKel.setMdl_brg(mb);
                semKel.setMdl_mdbk(mdbk);
                
                list.add(semKel);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_semKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_semKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
    
}
