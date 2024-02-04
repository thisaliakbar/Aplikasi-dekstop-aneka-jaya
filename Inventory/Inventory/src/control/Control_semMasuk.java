package control;
import java.util.List;
import model.sementara_masuk;

public interface Control_semMasuk {
    void tambahData(sementara_masuk semMasuk);
    void perbaruiData(sementara_masuk semMasuk);
    void hapusData(sementara_masuk semMasuk);
    
    sementara_masuk getById(String id);
    
    List<sementara_masuk> getData();
    
    boolean validasiNamaBarang(sementara_masuk semMasuk);
}
