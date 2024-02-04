package crud;
import config.koneksi;
import control.Control_barangKeluar;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Level;
import model.model_barangKeluar;
import model.model_detail_barangKeluar;
import model.model_pengguna;
public class trans_barangKeluar implements Control_barangKeluar{

    private Connection conn;
    public trans_barangKeluar() {
        conn = koneksi.getConnection();
    }
    

    @Override
    public void tambahData(model_barangKeluar modKeluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang_keluar (no_keluar, tgl_keluar, total_keluar, id_pengguna) VALUES (?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, modKeluar.getNo_keluar());
            st.setString(2, modKeluar.getTgl_keluar());
            st.setLong(3, modKeluar.getTotal_keluar());
            st.setString(4, modKeluar.getMod_pengguna().getId_pengguna());
            
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!=null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<model_barangKeluar> cariSemua(String from, String to) {
       PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT bk.no_keluar, bk.tgl_keluar, bk.total_keluar, bk.id_pengguna, pg.nama_pengguna FROM barang_keluar bk "
                + "INNER JOIN pengguna pg ON bk.id_pengguna=pg.id_pengguna WHERE bk.tgl_keluar BETWEEN '"+from+"' AND '"+to+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_barangKeluar mbk = new model_barangKeluar();
                model_pengguna mp = new model_pengguna();
                
                mbk.setNo_keluar(rs.getString("no_keluar"));
                mbk.setTgl_keluar(rs.getString("tgl_keluar"));
                mbk.setTotal_keluar(rs.getLong("total_keluar"));
                mp.setId_pengguna(rs.getString("id_pengguna"));
                mp.setNama_pengguna(rs.getString("nama_pengguna"));
                
                mbk.setMod_pengguna(mp);
                
                list.add(mbk);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_barangKeluar> getData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            String sql = "SELECT bk.no_keluar, bk.tgl_keluar, bk.total_keluar, bk.id_pengguna, pg.nama_pengguna FROM barang_keluar bk INNER JOIN pengguna pg ON bk.id_pengguna=pg.id_pengguna";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_barangKeluar mbk = new model_barangKeluar();
                model_pengguna mp = new model_pengguna();
                
                mbk.setNo_keluar(rs.getString("no_keluar"));
                mbk.setTgl_keluar(rs.getString("tgl_keluar"));
                mbk.setTotal_keluar(rs.getLong("total_keluar"));
                mp.setId_pengguna(rs.getString("id_pengguna"));
                mp.setNama_pengguna(rs.getString("nama_pengguna"));
                
                mbk.setMod_pengguna(mp);
                
                list.add(mbk);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_barangKeluar> pencarian() {
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
        String sql = "SELECT RIGHT(no_keluar, 3) AS Nomor FROM barang_keluar WHERE no_keluar LIKE 'BK"+no+"%' ORDER BY no_keluar DESC LIMIT 1";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "BK" + no + String.format("%03d", nomor);
            } else {
                urutan = "BK" + no + "001";
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st == null) {
                try {
                st.close();  
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs == null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return urutan;
        }

    }

    @Override
    public void sumTotalContent(model_barangKeluar modKeluar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(total_keluar) FROM barang_keluar WHERE tgl_keluar='"+modKeluar.getTgl_keluar()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                modKeluar.setTotal_keluar(rs.getLong(1));
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void sumTotalReport(model_barangKeluar mk, model_barangKeluar modKeluar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(total_keluar) FROM barang_keluar WHERE tgl_keluar BETWEEN '"+mk.getTgl_keluar()+"' AND '"+modKeluar.getTgl_keluar()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                mk.setTotal_keluar(rs.getLong(1));
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_barangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
}
