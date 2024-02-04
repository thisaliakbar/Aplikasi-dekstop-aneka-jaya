package crud;
import config.koneksi;
import model.model_barang;
import model.model_jenisBarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import control.Control_barang;

public class Crud_Barang implements Control_barang{
    private Connection conn;
    public Crud_Barang() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_barang mod_bar) {
    PreparedStatement st = null;
    String sql = "INSERT INTO barang (kode_barang, kode_jenis, nama_barang, satuan, harga, stok) VALUES ('"+mod_bar.getKode_barang()+"','"+mod_bar.getMod_jnsBarang().getKode_jenis()+"','"+mod_bar.getNama_barang()+"','"+mod_bar.getSatuan()+"',"
                + "'"+mod_bar.getHarga()+"','"+mod_bar.getStok()+"')";
    try {
        st = conn.prepareStatement(sql);
        st.executeUpdate(sql);
    } catch(SQLException ex) {
        Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
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
    public void perbaruiData(model_barang mod_bar) {
    PreparedStatement st = null;

    String sql = "UPDATE barang SET kode_jenis=?, nama_barang=?, satuan=?, harga=?, stok=? WHERE kode_barang='" + mod_bar.getKode_barang() +"'";
    try {
        st = conn.prepareStatement(sql);
        
        st.setString(1, mod_bar.getMod_jnsBarang().getKode_jenis());
        st.setString(2, mod_bar.getNama_barang());
        st.setString(3, mod_bar.getSatuan());
        st.setLong(4, mod_bar.getHarga() );
        st.setInt(5, mod_bar.getStok());
        
        st.executeUpdate();
    } catch(SQLException ex) {
        JOptionPane.showMessageDialog(null, "Perbarui data gagal");
        Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
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
    public void hapusData(model_barang mod_bar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang WHERE kode_barang='"+mod_bar.getKode_barang()+"'";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
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
    public model_barang getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_barang> getDataByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }

    @Override
    public List<model_barang> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT bg.kode_barang, bg.kode_jenis, jb.nama_jenis, bg.nama_barang, bg.satuan, bg.harga, bg.stok FROM barang bg INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis WHERE kode_barang LIKE '%"+id+"%' OR nama_barang LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_barang mb = new model_barang();
                model_jenisBarang mjb = new model_jenisBarang();
                
                mb.setKode_barang(rs.getString("kode_barang"));
                mjb.setKode_jenis(rs.getString("kode_jenis"));
                mjb.setNama_jenis(rs.getString("nama_jenis"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setSatuan(rs.getString("satuan"));
                mb.setHarga(rs.getLong("harga"));
                mb.setStok(rs.getInt("stok"));           
                mb.setMod_jnsBarang(mjb);
                
                list.add(mb);
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public List<model_barang> pencarianData2(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        Date now = new Date();
//        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
//        String tgl = tanggal.format(now);
        String no = sdf.format(now);
        
        String sql ="SELECT RIGHT(kode_barang,3) AS Nomor FROM barang WHERE kode_barang LIKE 'B" + no + "%'ORDER BY kode_barang DESC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            
            if(rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "B" + no + String.format("%03d", nomor);
            } else {
                urutan = "B" + no + "001";
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st == null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
        return urutan;
    }

    @Override
    public String nomor2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_barang> getData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql ="SELECT bg.kode_barang, bg.kode_jenis, jb.nama_jenis, bg.nama_barang, bg.satuan, bg.harga, bg.stok FROM barang bg INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while(rs.next()) {
                model_barang mod_bar = new model_barang();
                model_jenisBarang jenBar = new model_jenisBarang();
                
                mod_bar.setKode_barang(rs.getString("kode_barang"));
                jenBar.setKode_jenis(rs.getString("kode_jenis"));
                jenBar.setNama_jenis(rs.getString("nama_jenis"));
                mod_bar.setNama_barang(rs.getString("nama_barang"));
                mod_bar.setSatuan(rs.getString("satuan"));
                mod_bar.setHarga(rs.getLong("harga"));
                mod_bar.setStok(rs.getInt("stok"));
                
                mod_bar.setMod_jnsBarang(jenBar);
                list.add(mod_bar);    
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public boolean validasiHapus(model_barang mod_bar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT dp.no_pesan, bg.kode_barang, bg.nama_barang, bg.harga, dp.jml_pesan , dp.subtotal_pesan, dp.status FROM detail_pemesanan dp INNER JOIN barang bg ON dp.kode_barang=bg.kode_barang WHERE bg.kode_barang='"+mod_bar.getKode_barang()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Barang ini sedang digunakan", "Caution", JOptionPane.WARNING_MESSAGE);
            } else {
                valid = true;
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return valid;
    }

    @Override
    public boolean validasiStokKosong(model_barang mod_bar) {
        PreparedStatement st;
        ResultSet rs;
        boolean valid = false;
        String sql = "SELECT * FROM barang WHERE stok="+mod_bar.getStok()+"";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
            model_barang brg = new model_barang();
            brg.setStok(rs.getInt("stok"));
            if(brg.getStok().equals(0)) {
                JOptionPane.showMessageDialog(null, "Stok barang ini kosong");  
            } else {
                valid = true;
            }
            }
        } catch(SQLException ex) {
            Logger.getLogger(Crud_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;
    }

    @Override
    public boolean validasiQtyStok(model_barang mod_bar, int qty) {
        boolean valid = false;
        if(mod_bar.getStok() < qty) {
            JOptionPane.showMessageDialog(null, "Jumlah keluar lebih besar dari stok");
        } else {
            valid = true;
        }
        return valid;
    }    
}
