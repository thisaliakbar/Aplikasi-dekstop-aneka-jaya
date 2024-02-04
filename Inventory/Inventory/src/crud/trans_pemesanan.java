package crud;
import config.koneksi;
import control.Control_pemesanan;
import model.model_pemesanan;
import model.model_supliyer;
import model.model_pengguna;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Date;

public class trans_pemesanan implements Control_pemesanan{
    private Connection conn;
    public trans_pemesanan() {
        conn = koneksi.getConnection();
    }

    @Override
    public List<model_pemesanan> getById(String from, String to) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT psn.no_pesan, psn.tgl_pesan, psn.total_pesan, psn.id_pengguna, pg.nama_pengguna, psn.id_distributor, dst.nama_distributor FROM pemesanan psn "
                + "INNER JOIN pengguna pg ON psn.id_pengguna = pg.id_pengguna INNER JOIN distributor dst ON psn.id_distributor = dst.id_distributor "
                + "WHERE psn.tgl_pesan BETWEEN '"+from+"' AND '"+to+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_pemesanan mod_pem = new model_pemesanan();
                model_supliyer mod_sup = new model_supliyer();
                model_pengguna mod_pengguna = new model_pengguna();
                
                mod_pem.setNo_pesan(rs.getString("no_pesan"));
                mod_pem.setTgl_pesan(rs.getString("tgl_pesan"));
                mod_pem.setTotal_pesan(rs.getLong("total_pesan"));
                mod_pengguna.setId_pengguna(rs.getString("id_pengguna"));
                mod_pengguna.setNama_pengguna(rs.getString("nama_pengguna"));
                mod_sup.setId_supliyer(rs.getString("id_distributor"));
                mod_sup.setNama_supliyer(rs.getString("nama_distributor"));
                
                mod_pem.setModel_supliyer_pem(mod_sup);
                mod_pem.setModel_pengguna_pem(mod_pengguna);
                
                list.add(mod_pem); 
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
            
        }  finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        }
        return list;
    }

    @Override
    public List<model_pemesanan> getData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT psn.no_pesan, psn.tgl_pesan, psn.total_pesan, psn.id_pengguna, pg.nama_pengguna, psn.id_distributor, dst.nama_distributor FROM pemesanan psn INNER JOIN pengguna pg ON psn.id_pengguna = pg.id_pengguna INNER JOIN distributor dst ON psn.id_distributor = dst.id_distributor";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_pemesanan mod_pem = new model_pemesanan();
                model_supliyer mod_sup = new model_supliyer();
                model_pengguna mod_pengguna = new model_pengguna();
                
                mod_pem.setNo_pesan(rs.getString("no_pesan"));
                mod_pem.setTgl_pesan(rs.getString("tgl_pesan"));
                mod_pem.setTotal_pesan(rs.getLong("total_pesan"));
                mod_pengguna.setId_pengguna(rs.getString("id_pengguna"));
                mod_pengguna.setNama_pengguna(rs.getString("nama_pengguna"));
                mod_sup.setId_supliyer(rs.getString("id_distributor"));
                mod_sup.setNama_supliyer(rs.getString("nama_distributor"));
                
                mod_pem.setModel_supliyer_pem(mod_sup);
                mod_pem.setModel_pengguna_pem(mod_pengguna);
                
                list.add(mod_pem);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_pemesanan> pencarian(String id) {
        PreparedStatement st;
        ResultSet rs;
        List list = new ArrayList();
        String sql = "SELECT * FROM pemesanan WHERE no_pesan LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_pemesanan mod_pem = new model_pemesanan();
                model_supliyer mod_sup = new model_supliyer();
                model_pengguna mod_pengguna = new model_pengguna();
                
                mod_pem.setNo_pesan(rs.getString("no_pesan"));
                mod_pem.setTgl_pesan(rs.getString("tgl_pesan"));
                mod_pem.setTotal_pesan(rs.getLong("total_pesan"));
                mod_sup.setId_supliyer(rs.getString("id_distributor"));
                mod_pengguna.setId_pengguna(rs.getString("id_pengguna"));
                
                mod_pem.setModel_supliyer_pem(mod_sup);
                mod_pem.setModel_pengguna_pem(mod_pengguna);
                
                list.add(mod_pem);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        Date now = new Date();
        SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
        String no = noformat.format(now);
        String sql = "SELECT RIGHT(no_pesan, 3) AS Nomor FROM pemesanan WHERE no_pesan LIKE 'PB"+no+"%' ORDER BY no_pesan DESC LIMIT 1";
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
            Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st == null) {
                try {
                st.close();  
                } catch(SQLException ex) {
                    Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs == null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return urutan;
        }
        
    }

    @Override
    public void tambahData(model_pemesanan mod_pemesanan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pemesanan (no_pesan, tgl_pesan, total_pesan, id_pengguna, id_distributor) VALUES (?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_pemesanan.getNo_pesan());
            st.setString(2, mod_pemesanan.getTgl_pesan());
            st.setLong(3, mod_pemesanan.getTotal_pesan());
            st.setString(4, mod_pemesanan.getModel_pengguna_pem().getId_pengguna());
            st.setString(5, mod_pemesanan.getModel_supliyer_pem().getId_supliyer());
            
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void hapusData(model_pemesanan mod_pemesanan) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pemesanan WHERE no_pesan='"+mod_pemesanan.getNo_pesan()+"'";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void sumTotalReport(model_pemesanan mod_pemesanan, model_pemesanan mod_pem) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(total_pesan) FROM pemesanan WHERE tgl_pesan BETWEEN '"+mod_pemesanan.getTgl_pesan()+"' AND '"+mod_pem.getTgl_pesan()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_pemesanan.setTotal_pesan(rs.getLong(1));
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
    public void sumTotalContent(model_pemesanan mod_pemesanan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(total_pesan) FROM pemesanan WHERE tgl_pesan='"+mod_pemesanan.getTgl_pesan()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mod_pemesanan.setTotal_pesan(rs.getLong(1));
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
