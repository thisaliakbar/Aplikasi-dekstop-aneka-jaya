package crud;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import control.Control_pengguna;
import crud.Encrypt;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import model.model_pengguna;

public class Crud_Pengguna implements Control_pengguna{
    private Connection conn;
    public Crud_Pengguna() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_pengguna mod_pengguna) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pengguna (id_pengguna, nama_pengguna, username, password, telp_pengguna, alamat_pengguna, level) VALUES (?,?,?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_pengguna.getId_pengguna());
            st.setString(2, mod_pengguna.getNama_pengguna());
            st.setString(3, mod_pengguna.getUsername());
            st.setString(4, Encrypt.getmd5Java(mod_pengguna.getPassword()));
            st.setString(5, mod_pengguna.getTelp_pengguna());
            st.setString(6, mod_pengguna.getAlamat_pengguna());
            st.setString(7, mod_pengguna.getLevel());
            
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
            try {
                st.close();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    }

    @Override
    public void perbaruiData(model_pengguna mod_pengguna) {
        PreparedStatement st = null;
        String sql = "UPDATE pengguna SET nama_pengguna=?, username=?, telp_pengguna=?, alamat_pengguna=?, level=? WHERE id_pengguna=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, mod_pengguna.getNama_pengguna());
            st.setString(2, mod_pengguna.getUsername());
//            st.setString(4, Encrypt.getmd5Java(mod_pengguna.getPassword()));
            st.setString(3, mod_pengguna.getTelp_pengguna());
            st.setString(4, mod_pengguna.getAlamat_pengguna());
            st.setString(5, mod_pengguna.getLevel());
            st.setString(6, mod_pengguna.getId_pengguna());
            st.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui data gagal");
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
            try {
                st.close();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
        
    }

    @Override
    public void hapusData(model_pengguna mod_pengguna) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pengguna WHERE id_pengguna='"+mod_pengguna.getId_pengguna()+"'";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public model_pengguna getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_pengguna> getData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM pengguna";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_pengguna pengguna = new model_pengguna();
                pengguna.setId_pengguna(rs.getString("id_pengguna"));
                pengguna.setNama_pengguna(rs.getString("nama_pengguna"));
                pengguna.setUsername(rs.getString("username"));
//                pengguna.setPassword(Encrypt.getmd5Java(rs.getString("password")));
                pengguna.setTelp_pengguna(rs.getString("telp_pengguna"));
                pengguna.setAlamat_pengguna(rs.getString("alamat_pengguna"));
                pengguna.setLevel(rs.getString("Level"));
                
                list.add(pengguna);
            }
        }catch(SQLException ex) {
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_pengguna> pencarian(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM pengguna WHERE id_pengguna LIKE '%"+id+"%' OR nama_pengguna LIKE '%"+id+"%' OR username LIKE '%"+id+"%' ";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_pengguna pg = new model_pengguna();
                pg.setId_pengguna(rs.getString("id_pengguna"));
                pg.setNama_pengguna(rs.getString("nama_pengguna"));
                pg.setUsername(rs.getString("username"));
                pg.setTelp_pengguna(rs.getString("telp_pengguna"));
                pg.setAlamat_pengguna(rs.getString("alamat_pengguna"));
                pg.setLevel(rs.getString("level"));
                
                list.add(pg);
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         return list;   
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        String sql = "SELECT RIGHT (id_pengguna,3) AS Nomor FROM pengguna ORDER BY Nomor DESC LIMIT 1";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "USR" + String.format("%03d", nomor);
            } else {
                urutan = "USR001";
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return urutan;
    }

    @Override
    public boolean validasiIdUser_username(String username) {
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM pengguna WHERE username='"+username+"'";
        try {
            st = conn.prepareStatement(sql);
//            st.setString(1, idUser);
//            st.setString(2, username);
            rs = st.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
//        return true;
    }

    @Override
    public boolean changePassword(String username, String newPassword) {
        PreparedStatement st = null;
        String sql = "UPDATE pengguna SET password='"+newPassword+"' WHERE username='"+username+"'";
        try {
            st = conn.prepareStatement(sql);
            int hasil = st.executeUpdate();
            if(hasil == 1) {
                return true;
            } else {
                return false;
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui data gagal");
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    @Override
    public boolean validasiHapus(model_pengguna mod_pengguna) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT dp.no_pesan, dp.tgl_pesan, dp.total_pesan, dp.id_pengguna, dp.id_distributor FROM pemesanan dp INNER JOIN pengguna pg ON dp.id_pengguna=pg.id_pengguna WHERE pg.id_pengguna='"+mod_pengguna.getId_pengguna()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Pengguna ini sedang di gunakan", "Caution", JOptionPane.WARNING_MESSAGE);
            } else {
                valid = true;
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return valid;
    }

}
