package control;
import java.util.List;
import model.model_detail_barangMasuk;
import model.model_detail_pemesanan;

public interface Control_detBarangMasuk {
  void tambahData(List<model_detail_pemesanan> list);  
  void sumTotal(model_detail_barangMasuk mod_detMasuk);  
  void hapusSementara(model_detail_barangMasuk mod_detMasuk);
  void hapusData(model_detail_barangMasuk mod_detMasuk);
    
  model_detail_barangMasuk getById(String id);
  
  List<model_detail_barangMasuk> getData(String id);
  List<model_detail_barangMasuk> pencarian(String id, String no);
}
