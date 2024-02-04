package control;
import java.util.ArrayList;
import model.model_barang;
import java.util.List;

public interface Control_barang {
    void tambahData(model_barang mod_bar);
    void perbaruiData(model_barang mod_bar);
    void hapusData(model_barang mod_bar);
    
    model_barang getById(String id);
    
    List<model_barang> getDataByID();
    List<model_barang> getData();
    
    List<model_barang> pencarianData(String id);
    List<model_barang> pencarianData2(String id);
    
    
    String nomor();
    String nomor2();
    
    boolean validasiHapus(model_barang mod_bar);
    boolean validasiStokKosong(model_barang mod_bar);
    boolean validasiQtyStok(model_barang mod_bar, int qty);
}
