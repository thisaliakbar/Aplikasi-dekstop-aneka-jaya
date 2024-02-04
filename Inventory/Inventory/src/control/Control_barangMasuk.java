package control;
import java.util.List;
import model.model_barangMasuk;

public interface Control_barangMasuk {
    void tambahData(model_barangMasuk modMasuk);
    void sumTotalContent(model_barangMasuk modMasuk);
    void sumTotalReport(model_barangMasuk modBarMas, model_barangMasuk modMasuk);
    void hapusData(model_barangMasuk modMasuk);
    void perbaruiStatus(String kode_barang);
    
    List<model_barangMasuk> getById(String from, String to);
    List<model_barangMasuk> getData();
    List<model_barangMasuk> getByDate(String date);
    List<model_barangMasuk> pencarian();
    String nomor();
}
