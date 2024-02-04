package control;
import java.util.List;
import model.model_supliyer;

public interface Control_supliyer {
    void tambahData(model_supliyer mod_sup);
    void perbaruiData(model_supliyer mod_sup);
    void hapusData(model_supliyer mod_sup);
    
    model_supliyer getById(String id);
    
    List<model_supliyer> getData();
    List<model_supliyer> pencarian(String id);
    
    String nomor();
    boolean validasiHapus(model_supliyer mod_sup);
}
