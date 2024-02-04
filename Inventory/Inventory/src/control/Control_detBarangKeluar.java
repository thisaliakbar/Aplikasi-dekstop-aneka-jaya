package control;
import java.util.List;
import model.model_detail_barangKeluar;

public interface Control_detBarangKeluar {
    void tambahData(model_detail_barangKeluar mod_detKeluar);
    void sumTotal(model_detail_barangKeluar mod_detKeluar);
    void sumTotalSemua(model_detail_barangKeluar mod_detKeluar);
    void sumTotalTerjual(model_detail_barangKeluar mod_detKeluar);
    void sumTotalRusak(model_detail_barangKeluar mod_detKeluar);
    void sumTotallBerandaTerjual(model_detail_barangKeluar mod_detKeluar);
    void sumTotallBerandaRusak(model_detail_barangKeluar mod_detKeluar);
    void hapusSementara(model_detail_barangKeluar mod_detKeluar);
    
    model_detail_barangKeluar getById(String id);
    List<model_detail_barangKeluar> getData(String id);
    List<model_detail_barangKeluar> pencarian(String id, String no_keluar);
    List<model_detail_barangKeluar> filterSemua(model_detail_barangKeluar mod_detKeluar);
    List<model_detail_barangKeluar> filterTerjual(model_detail_barangKeluar mod_detKeluar);
    List<model_detail_barangKeluar> filterRusak(model_detail_barangKeluar mod_detKeluar);
    
    boolean validasiStok(model_detail_barangKeluar mod_detKeluar);
}
