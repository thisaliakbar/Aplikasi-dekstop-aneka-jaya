package crud;
import config.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.model_jenisBarang;
import control.Control_jenisBarang;

public class Crud_JenisBarang implements Control_jenisBarang{
    private Connection conn;
    public Crud_JenisBarang() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_jenisBarang mod_jenBar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO jenis_barang (kode_jenis, nama_jenis) VALUES ('"+mod_jenBar.getKode_jenis()+"', '"+mod_jenBar.getNama_jenis()+"')";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate(sql);
        } catch(SQLException ex) {
            Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        if(st != null) {
        try {
            st.close();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    }

    @Override
    public void perbaruiData(model_jenisBarang mod_jenBar) {
        PreparedStatement st = null;
        String sql = "UPDATE jenis_barang SET nama_jenis=? WHERE kode_jenis=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, mod_jenBar.getNama_jenis());
            st.setString(2, mod_jenBar.getKode_jenis());
            st.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui data gagal");
            Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void hapusData(model_jenisBarang mod_jenBar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM jenis_barang WHERE kode_jenis='"+mod_jenBar.getKode_jenis()+"'";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public model_jenisBarang getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_jenisBarang> pencarian(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM jenis_barang WHERE kode_jenis LIKE '%"+id+"%' OR nama_jenis LIKE '%"+id+"%'";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_jenisBarang mjb = new model_jenisBarang();
                mjb.setKode_jenis(rs.getString("kode_jenis"));
                mjb.setNama_jenis(rs.getString("nama_jenis"));
                
                list.add(mjb);
            }  
        } catch(SQLException ex) {
            Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "SELECT RIGHT(kode_jenis,3) AS Nomor FROM jenis_barang ORDER BY Nomor DESC LIMIT 1";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "JB" + String.format("%03d", nomor);
            } else {
                urutan = "JB001";
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean validasiNamaJenisBarang(model_jenisBarang mod_jenBar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT nama_jenis FROM jenis_barang WHERE kode_jenis!='"+mod_jenBar.getKode_jenis()+"' AND nama_jenis LIKE BINARY '"+mod_jenBar.getNama_jenis()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Nama Jenis sudah tersedia", "Peringatan",JOptionPane.WARNING_MESSAGE);
            } else {
                valid = true;
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public List<model_jenisBarang> getData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM jenis_barang";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_jenisBarang jenisBarang = new model_jenisBarang();
                jenisBarang.setKode_jenis(rs.getString("kode_jenis"));
                jenisBarang.setNama_jenis(rs.getString("nama_jenis"));
                
                list.add(jenisBarang);
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public boolean validasiHapus(model_jenisBarang mod_jenBarang) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT bg.kode_barang, bg.kode_jenis, jb.nama_jenis, bg.nama_barang, bg.satuan, bg.harga, bg.stok FROM barang bg INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis WHERE jb.kode_jenis='"+mod_jenBarang.getKode_jenis()+"' AND nama_jenis LIKE BINARY '"+mod_jenBarang.getNama_jenis()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Jenis Barang ini sedang di gunakan", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                valid = true;
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return valid;
    }
    
}
