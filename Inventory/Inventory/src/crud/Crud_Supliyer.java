package crud;
import config.koneksi;
import java.util.List;
import model.model_supliyer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import control.Control_supliyer;

public class Crud_Supliyer implements Control_supliyer{
    private Connection conn;
    public Crud_Supliyer() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_supliyer mod_sup) {
        PreparedStatement st = null;
        String sql = "INSERT INTO distributor (id_distributor, nama_distributor, telp_distributor, alamat_distributor) VALUES ('"+mod_sup.getId_supliyer()+"', "
                    + "'"+mod_sup.getNama_supliyer()+"', '"+mod_sup.getTelp_supliyer()+"', '"+mod_sup.getAlamat_supliyer()+"')";
        try {
            
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
            try {
                st.close();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    }

    @Override
    public void perbaruiData(model_supliyer mod_sup) {
        PreparedStatement st = null;
        String sql = "UPDATE distributor SET nama_distributor=?, telp_distributor=?, alamat_distributor=? WHERE id_distributor=?";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_sup.getNama_supliyer());
            st.setString(2, mod_sup.getTelp_supliyer());
            st.setString(3, mod_sup.getAlamat_supliyer());
            st.setString(4, mod_sup.getId_supliyer());
            
            st.executeUpdate();
        } catch(SQLException ex) {
        JOptionPane.showMessageDialog(null, "Perbarui data gagal");
        Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        if(st != null) {
        try {
            st.close();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

    }

    @Override
    public void hapusData(model_supliyer mod_sup) {
        PreparedStatement st = null;
        String sql = "DELETE FROM distributor WHERE id_distributor='"+mod_sup.getId_supliyer()+"'";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
            try {
            st.close();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    }

    @Override
    public model_supliyer getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_supliyer> getData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM distributor";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_supliyer supliyer = new model_supliyer();
                supliyer.setId_supliyer(rs.getString("id_distributor"));
                supliyer.setNama_supliyer(rs.getString("nama_distributor"));
                supliyer.setTelp_supliyer(rs.getString("telp_distributor"));
                supliyer.setAlamat_supliyer(rs.getString("alamat_distributor"));
                
                list.add(supliyer);
            }
        }catch(SQLException ex) {
            Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_supliyer> pencarian(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM distributor WHERE id_distributor LIKE '%"+id+"%' OR nama_distributor LIKE '%"+id+"%' OR telp_distributor LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_supliyer mod_sup = new model_supliyer();
                mod_sup.setId_supliyer(rs.getString("id_distributor"));
                mod_sup.setNama_supliyer(rs.getString("nama_distributor"));
                mod_sup.setTelp_supliyer(rs.getString("telp_distributor"));
                mod_sup.setAlamat_supliyer(rs.getString("alamat_distributor"));
                
                list.add(mod_sup);
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "SELECT RIGHT (id_distributor,3) AS Nomor FROM distributor ORDER BY Nomor DESC LIMIT 1";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "SLR" + String.format("%03d", nomor);
        } else {
                urutan = "SLR001";
            }
    } catch(SQLException ex) {
        Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return urutan;
    }

    @Override
    public boolean validasiHapus(model_supliyer mod_sup) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT dp.no_pesan, dp.tgl_pesan, dp.total_pesan, dp.id_pengguna, dp.id_distributor FROM pemesanan dp INNER JOIN distributor sr ON dp.id_distributor=sr.id_distributor WHERE sr.id_distributor='"+mod_sup.getId_supliyer()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Supplier ini sedang di gunakan", "Caution", JOptionPane.WARNING_MESSAGE);
            } else {
                valid = true;
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Supliyer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return valid;
    }
    
    }
