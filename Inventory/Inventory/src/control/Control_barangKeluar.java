package control;
import java.util.List;
import model.model_barangKeluar;


public interface Control_barangKeluar {
    void tambahData(model_barangKeluar modKeluar);
    void sumTotalContent(model_barangKeluar modKeluar);
    void sumTotalReport(model_barangKeluar mk, model_barangKeluar modKeluar);
    
    List<model_barangKeluar> cariSemua(String from, String to);
    
    List<model_barangKeluar> getData();
    List<model_barangKeluar> pencarian();
    String nomor();
    
    
}
