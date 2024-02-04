package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.koneksi;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.sementara_pesan;
import model.model_barang;
import model.model_detail_pemesanan;
import control.Control_semPesan;

public class trans_semPesan implements Control_semPesan{
    private Connection conn;
    public trans_semPesan() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(sementara_pesan semPesan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO sementara_pesan (kode_barang, nama_barang, satuan, harga, jml_pesan, subtotal_pesan, status) VALUES (?,?,?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, semPesan.getMdl_brg().getKode_barang());
            st.setString(2, semPesan.getMdl_brg().getNama_barang());
            st.setString(3, semPesan.getMdl_brg().getSatuan());
            st.setLong(4, semPesan.getMdl_brg().getHarga());
            st.setInt(5, semPesan.getMdl_mdp().getJml_pesan());
            st.setLong(6, semPesan.getMdl_mdp().getSubtotal_pesan());
            st.setString(7, semPesan.getMdl_mdp().getStatus());
            
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void perbaruiData(sementara_pesan semPesan) {
        PreparedStatement st = null;
        String sql = "UPDATE sementara_pesan SET nama_barang=?, satuan=?, harga=?, jml_pesan=?, subtotal_pesan=? WHERE kode_barang='"+semPesan.getMdl_brg().getKode_barang()+"'";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, semPesan.getMdl_brg().getNama_barang());
            st.setString(2, semPesan.getMdl_brg().getSatuan());
            st.setLong(3, semPesan.getMdl_brg().getHarga());
            st.setInt(4, semPesan.getMdl_mdp().getJml_pesan());
            st.setLong(5, semPesan.getMdl_mdp().getSubtotal_pesan());

            st.executeUpdate();
        } catch(SQLException ex) {
           Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
        if(st != null) {
        try {
            st.close();
        } catch(SQLException ex) {
            Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    }


    @Override
    public sementara_pesan getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<sementara_pesan> getData(){
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM sementara_pesan";
        List list = new ArrayList();
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                sementara_pesan sp = new sementara_pesan();
                model_barang mb = new model_barang();
                model_detail_pemesanan mdp = new model_detail_pemesanan();
                
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setSatuan(rs.getString("satuan"));
                mb.setHarga(rs.getLong("harga"));
                mdp.setJml_pesan(rs.getInt("jml_pesan"));
                mdp.setSubtotal_pesan(rs.getLong("subtotal_pesan"));
                
                sp.setMdl_brg(mb);
                sp.setMdl_mdp(mdp);
                
                list.add(sp);
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                }catch(SQLException ex) {
                    Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public boolean validasiNamaBarang(sementara_pesan semPesan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT nama_barang FROM sementara_pesan WHERE kode_barang='"+semPesan.getMdl_brg().getKode_barang()+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Barang ini sudah di tambahkan", "Caution", JOptionPane.WARNING_MESSAGE);
            } else {
                valid = true;
            }
        } catch(SQLException ex) {
            Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public void hapusData(sementara_pesan semPesan) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_pesan WHERE kode_barang='"+semPesan.getMdl_brg().getKode_barang()+"'";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!= null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(trans_semPesan.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
    }

    @Override
    public boolean validasiHarga(sementara_pesan semPesan, long hargaJual) {
        boolean valid = false;
            semPesan.getMdl_brg().getHarga();
            if(semPesan.getMdl_brg().getHarga() > hargaJual) {
                JOptionPane.showMessageDialog(null, "Harga beli lebih besar dari harga jual"); 
            } else {
                valid = true;
            }   
        return valid;
        }
    }
