package control;
import java.util.List;
import model.model_pemesanan;

public interface Control_pemesanan {
    void tambahData(model_pemesanan mod_pemesanan);
    void hapusData(model_pemesanan mod_pemesanan);
    void sumTotalReport(model_pemesanan mod_pemesanan, model_pemesanan mod_pem);
    void sumTotalContent(model_pemesanan mod_pemesanan);
//    void perbaruiData(model_pemesanan mod_pemesanan);
    
//    void tambahDataSementara(model_pemesanan mod_pemesanan);
    
    List<model_pemesanan> getById(String from, String to);
    List<model_pemesanan> getData();

    List<model_pemesanan> pencarian(String id);
    
    String nomor();
}
