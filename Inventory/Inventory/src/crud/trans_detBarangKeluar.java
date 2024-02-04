package crud;
import config.koneksi;
import control.Control_detBarangKeluar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.model_barang;
import model.model_barangKeluar;
import model.model_detail_barangKeluar;
public class trans_detBarangKeluar implements Control_detBarangKeluar {

    private Connection conn;
    public trans_detBarangKeluar() {
        conn = koneksi.getConnection();
    }
    

    @Override
    public void tambahData(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_barang_keluar (no_keluar, kode_barang, jml_keluar, subtotal_keluar, keterangan) SELECT '"+mod_detKeluar.getMod_barangKel_detKel().getNo_keluar()+"', kode_barang, jml_keluar, subtotal_keluar,keterangan FROM sementara_keluar";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex) ;
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                 Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex) ;
                }
            }
        }
    }

    @Override
    public void sumTotal(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_keluar) AS subtotal_keluar FROM sementara_keluar";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_detKeluar.setSubtotal_keluar(rs.getLong(1));
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void hapusSementara(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_keluar";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public model_detail_barangKeluar getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_detail_barangKeluar> getData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT detKel.no_keluar, detKel.kode_barang, brg.nama_barang, brg.harga, detKel.jml_keluar, detKel.subtotal_keluar, detKel.keterangan FROM detail_barang_keluar detKel "
                + "INNER JOIN barang_keluar bkl ON bkl.no_keluar=detKel.no_keluar INNER JOIN barang brg ON brg.kode_barang=detKel.kode_barang "
                + "WHERE detKel.no_keluar='"+id+"' ORDER BY no_keluar ASC";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                  model_detail_barangKeluar mdbk = new model_detail_barangKeluar();
                  model_barangKeluar mbk = new model_barangKeluar();
                  model_barang mb = new model_barang();
                  
                  mbk.setNo_keluar(String.valueOf(rs.getString("detKel.no_keluar")));
                  mdbk.setMod_barangKel_detKel(mbk);

                  mb.setKode_barang(rs.getString("kode_barang"));
                  mb.setNama_barang(rs.getString("nama_barang"));
                  mb.setHarga(rs.getLong("harga"));
                  mdbk.setJml_keluar(rs.getInt("jml_keluar"));
                  mdbk.setSubtotal_keluar(rs.getLong("subtotal_keluar"));
                  mdbk.setKeterangan(rs.getString("keterangan"));
                  
                  mdbk.setMod_barang_detKel(mb);
                  list.add(mdbk);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_detail_barangKeluar> pencarian(String id, String no) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT dp.no_keluar, dp.kode_barang, bg.nama_barang, bg.harga ,dp.jml_keluar, "
                + "dp.subtotal_keluar, dp.keterangan FROM detail_barang_keluar dp INNER JOIN barang bg ON "
                + "dp.kode_barang=bg.kode_barang "
                + "WHERE dp.no_keluar='"+no+"' AND (dp.kode_barang LIKE '%"+id+"%'  OR bg.nama_barang LIKE '%"+id+"%' OR dp.keterangan LIKE '%"+id+"%') ";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_barang mb = new model_barang();
                model_barangKeluar mbk = new model_barangKeluar();
                model_detail_barangKeluar mdbk = new model_detail_barangKeluar();

                mbk.setNo_keluar(rs.getString("no_keluar"));
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setHarga(rs.getLong("harga"));
                mdbk.setJml_keluar(rs.getInt("jml_keluar"));
                mdbk.setSubtotal_keluar(rs.getLong("subtotal_keluar"));
                mdbk.setKeterangan(rs.getString("keterangan"));
                
                mdbk.setMod_barangKel_detKel(mbk);
                mdbk.setMod_barang_detKel(mb);
                list.add(mdbk);
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
    public boolean validasiStok(model_detail_barangKeluar mod_detKeluar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_detail_barangKeluar> filterTerjual(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st;
        ResultSet rs;
        List list = new ArrayList();
        String sql = "SELECT dk.no_keluar, dk.kode_barang, bg.nama_barang, bg.harga, dk.jml_keluar, dk.subtotal_keluar, dk.keterangan FROM detail_barang_keluar dk "
                + "INNER JOIN barang_keluar bk ON dk.no_keluar=bk.no_keluar "
                + "INNER JOIN barang bg ON dk.kode_barang=bg.kode_barang WHERE dk.no_keluar='"+mod_detKeluar.getMod_barangKel_detKel().getNo_keluar()+"' AND dk.keterangan='"+mod_detKeluar.getKeterangan()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_detail_barangKeluar mdbk = new model_detail_barangKeluar();
                model_barangKeluar mbk = new model_barangKeluar();
                model_barang mb = new model_barang();
                
                mbk.setNo_keluar(String.valueOf(rs.getString("no_keluar")));
                mdbk.setMod_barangKel_detKel(mbk);
                
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setHarga(rs.getLong("harga"));
                mdbk.setMod_barang_detKel(mb);
                mdbk.setJml_keluar(rs.getInt("jml_keluar"));
                mdbk.setSubtotal_keluar(rs.getLong("subtotal_keluar"));
                mdbk.setKeterangan(rs.getString("keterangan"));
                
                list.add(mdbk);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<model_detail_barangKeluar> filterRusak(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st;
        ResultSet rs;
        List list = new ArrayList();
        String sql = "SELECT dk.no_keluar, dk.kode_barang, bg.nama_barang, bg.harga, dk.jml_keluar, dk.subtotal_keluar, dk.keterangan FROM detail_barang_keluar dk "
                + "INNER JOIN barang_keluar bk ON dk.no_keluar=bk.no_keluar "
                + "INNER JOIN barang bg ON dk.kode_barang=bg.kode_barang WHERE dk.no_keluar='"+mod_detKeluar.getMod_barangKel_detKel().getNo_keluar()+"' AND dk.keterangan='"+mod_detKeluar.getKeterangan()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_detail_barangKeluar mdbk = new model_detail_barangKeluar();
                model_barangKeluar mbk = new model_barangKeluar();
                model_barang mb = new model_barang();
                
                mbk.setNo_keluar(String.valueOf(rs.getString("no_keluar")));
                mdbk.setMod_barangKel_detKel(mbk);
                
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setHarga(rs.getLong("harga"));
                mdbk.setMod_barang_detKel(mb);
                mdbk.setJml_keluar(rs.getInt("jml_keluar"));
                mdbk.setSubtotal_keluar(rs.getLong("subtotal_keluar"));
                mdbk.setKeterangan(rs.getString("keterangan"));
                
                list.add(mdbk);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void sumTotalTerjual(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT SUM(subtotal_keluar) AS Terjual FROM detail_barang_keluar WHERE no_keluar='"+mod_detKeluar.getMod_barangKel_detKel().getNo_keluar()+"' AND keterangan='"+mod_detKeluar.getKeterangan()+"' ";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_detKeluar.setSubtotal_keluar(rs.getLong("Terjual"));

            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sumTotalRusak(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT SUM(subtotal_keluar) AS Rusak FROM detail_barang_keluar WHERE no_keluar='"+mod_detKeluar.getMod_barangKel_detKel().getNo_keluar()+"' AND keterangan='"+mod_detKeluar.getKeterangan()+"' ";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_detKeluar.setSubtotal_keluar(rs.getLong("Rusak"));

            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void sumTotalSemua(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT SUM(subtotal_keluar) AS Semua FROM detail_barang_keluar WHERE no_keluar='"+mod_detKeluar.getMod_barangKel_detKel().getNo_keluar()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_detKeluar.setSubtotal_keluar(rs.getLong("Semua"));

            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<model_detail_barangKeluar> filterSemua(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st;
        ResultSet rs;
        List list = new ArrayList();
        String sql = "SELECT dk.no_keluar, dk.kode_barang, bg.nama_barang, bg.harga, dk.jml_keluar, dk.subtotal_keluar, dk.keterangan FROM detail_barang_keluar dk "
                + "INNER JOIN barang_keluar bk ON dk.no_keluar=bk.no_keluar "
                + "INNER JOIN barang bg ON dk.kode_barang=bg.kode_barang WHERE dk.no_keluar='"+mod_detKeluar.getMod_barangKel_detKel().getNo_keluar()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_detail_barangKeluar mdbk = new model_detail_barangKeluar();
                model_barangKeluar mbk = new model_barangKeluar();
                model_barang mb = new model_barang();
                
                mbk.setNo_keluar(String.valueOf(rs.getString("no_keluar")));
                mdbk.setMod_barangKel_detKel(mbk);
                
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setHarga(rs.getLong("harga"));
                mdbk.setMod_barang_detKel(mb);
                mdbk.setJml_keluar(rs.getInt("jml_keluar"));
                mdbk.setSubtotal_keluar(rs.getLong("subtotal_keluar"));
                mdbk.setKeterangan(rs.getString("keterangan"));
                
                list.add(mdbk);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void sumTotallBerandaTerjual(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT SUM(subtotal_keluar) AS Terjual, bk.tgl_keluar, dk.keterangan FROM detail_barang_keluar dk INNER JOIN barang bg ON bg.kode_barang=dk.kode_barang JOIN barang_keluar bk ON dk.no_keluar=bk.no_keluar GROUP BY bk.tgl_keluar, dk.keterangan HAVING tgl_keluar='"+mod_detKeluar.getMod_barangKel_detKel().getTgl_keluar()+"' AND keterangan='Terjual'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_detKeluar.setSubtotal_keluar(rs.getLong("Terjual"));
            } else {
                long subtotal = 0;
                mod_detKeluar.setSubtotal_keluar(subtotal);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sumTotallBerandaRusak(model_detail_barangKeluar mod_detKeluar) {
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT SUM(subtotal_keluar) AS Rusak, bk.tgl_keluar, dk.keterangan FROM detail_barang_keluar dk INNER JOIN barang bg ON bg.kode_barang=dk.kode_barang JOIN barang_keluar bk ON dk.no_keluar=bk.no_keluar GROUP BY bk.tgl_keluar, dk.keterangan HAVING tgl_keluar='"+mod_detKeluar.getMod_barangKel_detKel().getTgl_keluar()+"' AND keterangan='Rusak'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_detKeluar.setSubtotal_keluar(rs.getLong("Rusak"));
            } else {
                long subtotal = 0;
                mod_detKeluar.setSubtotal_keluar(subtotal);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
