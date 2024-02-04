package control;
import java.util.List;
import model.model_jenisBarang;

public interface Control_jenisBarang {
    void tambahData(model_jenisBarang mod_jenBar);
    void perbaruiData(model_jenisBarang mod_jenBar);
    void hapusData(model_jenisBarang mod_jenBar);
    
    model_jenisBarang getById(String id);
    
    List<model_jenisBarang> getData();
    List<model_jenisBarang> pencarian(String id);
    
    String nomor();
    
    boolean validasiNamaJenisBarang(model_jenisBarang mod_jenBar);
    boolean validasiHapus(model_jenisBarang mod_jenBarang);
}
