package control;
import java.util.List;
import model.model_detail_pemesanan;

public interface Control_detPemesanan {
    void tambahData(model_detail_pemesanan mod_detPemesanan);
    void sumTotal(model_detail_pemesanan mod_detPemesanan);
    void sumTotalDetail(model_detail_pemesanan mod_detPemesanan);
    void hapusSementara(model_detail_pemesanan mod_detPemesanan);
    void hapusData(model_detail_pemesanan mod_pemesanan);
    
    model_detail_pemesanan getById(String id);
    
    List<model_detail_pemesanan> getData(String id);
    List<model_detail_pemesanan> pencarian(String id, String no);
}
