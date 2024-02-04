package control;
import java.util.List;
import model.model_pengguna;

public interface Control_pengguna {
    void tambahData(model_pengguna mod_pengguna);
    void perbaruiData(model_pengguna mod_pengguna);
    void hapusData(model_pengguna mod_pengguna);
    
    model_pengguna getById(String id);
    
    List<model_pengguna> getData();
    List<model_pengguna> pencarian(String id);
    
    String nomor();
    
    boolean validasiHapus(model_pengguna mod_pengguna);
    boolean validasiIdUser_username(String username);
    boolean changePassword(String username, String newPassword);
}
