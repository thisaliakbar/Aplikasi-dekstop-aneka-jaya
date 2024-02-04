package crud;
import control.Control_detPemesanan;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.koneksi;
import java.sql.SQLException;
import model.model_barang;
import model.model_detail_pemesanan;
import model.model_pemesanan;

public class trans_detPemesanan implements Control_detPemesanan{
    private Connection conn;
    public trans_detPemesanan() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_detail_pemesanan mod_detPemesanan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_pemesanan (no_pesan, kode_barang, jml_pesan, subtotal_pesan, status) SELECT '"+mod_detPemesanan.getMod_pemesanan_detPem().getNo_pesan()+"', kode_barang, jml_pesan, subtotal_pesan,status FROM sementara_pesan";
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
    public void sumTotal(model_detail_pemesanan mod_detPemesanan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_pesan) AS subtotal_pesan FROM sementara_pesan";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_detPemesanan.setSubtotal_pesan(rs.getLong(1));
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void hapusSementara(model_detail_pemesanan mod_detPemesanan) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_pesan";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public model_detail_pemesanan getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_detail_pemesanan> getData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT detPsn.no_pesan, detPsn.kode_barang, brg.nama_barang, brg.harga, detPsn.jml_pesan, detPsn.subtotal_pesan, detPsn.status FROM detail_pemesanan detPsn "
                + "INNER JOIN pemesanan psn ON psn.no_pesan=detPsn.no_pesan INNER JOIN barang brg ON brg.kode_barang=detPsn.kode_barang "
                + "WHERE detPsn.no_pesan='"+id+"' ORDER BY no_pesan ASC";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                  model_detail_pemesanan mdp = new model_detail_pemesanan();
                  model_pemesanan mp = new model_pemesanan();
                  model_barang mb = new model_barang();
                  
                  mp.setNo_pesan(String.valueOf(rs.getString("detPsn.no_pesan")));
                  mdp.setMod_pemesanan_detPem(mp);

                  mb.setKode_barang(rs.getString("kode_barang"));
                  mb.setNama_barang(rs.getString("nama_barang"));
                  mb.setHarga(rs.getLong("harga"));
                  mdp.setJml_pesan(rs.getInt("jml_pesan"));
                  mdp.setSubtotal_pesan(rs.getLong("subtotal_pesan"));
                  mdp.setStatus(rs.getString("status"));
                  
                  mdp.setMod_barang_detPem(mb);
                  list.add(mdp);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_detail_pemesanan> pencarian(String id, String no) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT dp.no_pesan, dp.kode_barang, bg.nama_barang, bg.harga ,dp.jml_pesan, "
                + "dp.subtotal_pesan, dp.status FROM detail_pemesanan dp INNER JOIN barang bg ON "
                + "dp.kode_barang=bg.kode_barang "
                + "WHERE dp.no_pesan='"+no+"' AND (dp.kode_barang LIKE '%"+id+"%'  OR bg.nama_barang LIKE '%"+id+"%') ";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_barang mb = new model_barang();
                model_pemesanan mp = new model_pemesanan();
                model_detail_pemesanan mdp = new model_detail_pemesanan();
                
                mp.setNo_pesan(rs.getString("no_pesan"));
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setHarga(rs.getLong("harga"));
                mdp.setJml_pesan(rs.getInt("jml_pesan"));
                mdp.setSubtotal_pesan(rs.getLong("subtotal_pesan"));
                mdp.setStatus(rs.getString("status"));
                
                mdp.setMod_pemesanan_detPem(mp);
                mdp.setMod_barang_detPem(mb);
                
                list.add(mdp);
            }
            
        } catch(SQLException ex) {
            Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs!=null) {
                try {
                rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public void hapusData(model_detail_pemesanan mod_detPemesanan) {
        PreparedStatement st = null;
        String sql = "DELETE FROM detail_pemesanan WHERE kode_barang='"+mod_detPemesanan.getMod_barang_detPem().getKode_barang()+"'";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void sumTotalDetail(model_detail_pemesanan mod_detPemesanan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_pesan) AS subtotal_pesan FROM detail_pemesanan WHERE no_pesan='"+mod_detPemesanan.getMod_pemesanan_detPem().getNo_pesan()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_detPemesanan.setSubtotal_pesan(rs.getLong(1));
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_detPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
