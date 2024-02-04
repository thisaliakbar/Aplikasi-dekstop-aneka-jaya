package crud;
import view.view_menu;
import java.sql.Connection;
import config.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.model_login;
import view.view_login;
import control.Control_login;

public class Ps_Login implements Control_login{
    private Connection conn;
    public Ps_Login(){
    
    conn = koneksi.getConnection();
    
    }
        
    @Override
    public void prosesLogin(model_login mod_login) {
//        Mengeksekusi query dari sql
        PreparedStatement st = null;
//        Menangkap apa yang di eksekusi PrepareStatement
        ResultSet rs;
        
        String id = null;
        String nama = null;
        String level = null;
//        Berisi query dalam menyeleksi database
        String sql = "SELECT * FROM pengguna WHERE(id_pengguna='" + mod_login.getId_user() + "' OR username='" + mod_login.getUser_name() + "')AND password='"+mod_login.getPass_user()+ "'";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                id = rs.getString("id_pengguna");
                nama = rs.getString("nama_pengguna");
                level = rs.getString("level");
                
                if(level.equals("Nonaktif")) {
                    JOptionPane.showMessageDialog(null, "Pengguna ini sudah tidak aktif");
                } else {
                view_menu menu = new view_menu(id,nama, level);
                menu.setVisible(true);
                menu.revalidate();
                
                view_login lg = new view_login();
                lg.close = true;
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Username & Password Salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                view_login lg = new view_login();
                lg.close = false;
                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Ps_Login.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st!= null) {
                try {
                    st.close();
                } catch(SQLException ex) {
                    Logger.getLogger(Ps_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
