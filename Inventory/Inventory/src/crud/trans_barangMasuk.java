package crud;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import control.Control_barangMasuk;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.model_barangMasuk;
import model.model_pengguna;
import model.model_supliyer;
public class trans_barangMasuk implements Control_barangMasuk{
    private Connection conn;

    public trans_barangMasuk() {
        conn = koneksi.getConnection();
    }
    

    @Override
    public void tambahData(model_barangMasuk modMasuk) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang_masuk (no_pesan, tgl_masuk, total_masuk, id_pengguna, id_distributor) VALUES (?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, modMasuk.getNo_masuk());
            st.setString(2, modMasuk.getTgl_masuk());
            st.setLong(3, modMasuk.getTotal_masuk());
            st.setString(4, modMasuk.getMod_pengguna().getId_pengguna());
            st.setString(5, modMasuk.getMod_supliyer().getId_supliyer());
            
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void perbaruiStatus(String kode_barang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_barangMasuk> getById(String from, String to) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT psn.no_pesan, psn.tgl_masuk, psn.total_masuk, psn.id_pengguna, pg.nama_pengguna, psn.id_distributor, dst.nama_distributor FROM barang_masuk psn "
                + "INNER JOIN pengguna pg ON psn.id_pengguna = pg.id_pengguna INNER JOIN distributor dst ON psn.id_distributor = dst.id_distributor "
                + "WHERE psn.tgl_masuk BETWEEN '"+from+"' AND '"+to+"'";
        List list = new ArrayList();
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_barangMasuk modBarMas = new model_barangMasuk();
                model_supliyer mod_sup = new model_supliyer();
                model_pengguna mod_pengguna = new model_pengguna();
                
                modBarMas.setNo_masuk(rs.getString("no_pesan"));
                modBarMas.setTgl_masuk(rs.getString("tgl_masuk"));
                modBarMas.setTotal_masuk(rs.getLong("total_masuk"));
                mod_pengguna.setId_pengguna(rs.getString("id_pengguna"));
                mod_pengguna.setNama_pengguna(rs.getString("nama_pengguna"));
                mod_sup.setId_supliyer(rs.getString("id_distributor"));
                mod_sup.setNama_supliyer(rs.getString("nama_distributor"));
                
                modBarMas.setMod_supliyer(mod_sup);
                modBarMas.setMod_pengguna(mod_pengguna);
                
                list.add(modBarMas);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }  
            } if(rs!=null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_barangMasuk> getData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT psn.no_pesan, psn.tgl_masuk, psn.total_masuk, psn.id_pengguna, pg.nama_pengguna, psn.id_distributor, dst.nama_distributor FROM barang_masuk psn INNER JOIN pengguna pg ON psn.id_pengguna = pg.id_pengguna INNER JOIN distributor dst ON psn.id_distributor = dst.id_distributor";
        List list = new ArrayList();
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_barangMasuk modBarMas = new model_barangMasuk();
                model_supliyer mod_sup = new model_supliyer();
                model_pengguna mod_pengguna = new model_pengguna();
                
                modBarMas.setNo_masuk(rs.getString("no_pesan"));
                modBarMas.setTgl_masuk(rs.getString("tgl_masuk"));
                modBarMas.setTotal_masuk(rs.getLong("total_masuk"));
                mod_pengguna.setId_pengguna(rs.getString("id_pengguna"));
                mod_pengguna.setNama_pengguna(rs.getString("nama_pengguna"));
                mod_sup.setId_supliyer(rs.getString("id_distributor"));
                mod_sup.setNama_supliyer(rs.getString("nama_distributor"));
                
                modBarMas.setMod_supliyer(mod_sup);
                modBarMas.setMod_pengguna(mod_pengguna);
                
                list.add(modBarMas);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }  
            } if(rs!=null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_barangMasuk> pencarian() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
         Date now = new Date();
        SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
        String no = noformat.format(now);
        String sql = "SELECT RIGHT(no_pesan, 3) AS Nomor FROM barang_masuk WHERE no_pesan LIKE 'PB"+no+"%' ORDER BY no_pesan DESC LIMIT 1";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "PB" + no + String.format("%03d", nomor);
            } else {
                urutan = "PB" + no + "001";
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st == null) {
                try {
                st.close();  
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs == null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return urutan;
        }
    }

    @Override
    public void hapusData(model_barangMasuk modMasuk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_barangMasuk> getByDate(String date) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT bm.no_pesan, bm.tgl_masuk, bm.total_masuk, bm.id_pengguna, pg.nama_pengguna, bm.id_distributor, sr.nama_distributor "
                + "FROM barang_masuk bm INNER JOIN pengguna pg ON bm.id_pengguna=pg.id_pengguna "
                + "INNER JOIN distributor sr ON bm.id_distributor=sr.id_distributor WHERE bm.tgl_masuk='"+date+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_barangMasuk modBarMas = new model_barangMasuk();
                model_supliyer mod_sup = new model_supliyer();
                model_pengguna mod_pengguna = new model_pengguna();
                
                modBarMas.setNo_masuk(rs.getString("no_pesan"));
                modBarMas.setTgl_masuk(rs.getString("tgl_masuk"));
                modBarMas.setTotal_masuk(rs.getLong("total_masuk"));
                mod_pengguna.setId_pengguna(rs.getString("id_pengguna"));
                mod_pengguna.setNama_pengguna(rs.getString("nama_pengguna"));
                mod_sup.setId_supliyer(rs.getString("id_distributor"));
                mod_sup.setNama_supliyer(rs.getString("nama_distributor"));
                
                modBarMas.setMod_supliyer(mod_sup);
                modBarMas.setMod_pengguna(mod_pengguna);
                
                list.add(modBarMas);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public void sumTotalReport(model_barangMasuk modBarMas, model_barangMasuk modMasuk) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(total_masuk) FROM barang_masuk WHERE tgl_masuk BETWEEN '"+modBarMas.getTgl_masuk()+"' AND '"+modMasuk.getTgl_masuk()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                modBarMas.setTotal_masuk(rs.getLong(1));
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void sumTotalContent(model_barangMasuk modMasuk) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(total_masuk) FROM barang_masuk WHERE tgl_masuk='"+modMasuk.getTgl_masuk()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                modMasuk.setTotal_masuk(rs.getLong(1));
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_barangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
