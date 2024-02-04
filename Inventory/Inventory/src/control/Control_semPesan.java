package control;
import java.util.List;
import model.sementara_pesan;

public interface Control_semPesan {
    void tambahData(sementara_pesan semPesan);
    void perbaruiData(sementara_pesan semPesan);
    void hapusData(sementara_pesan semPesan);
    
    sementara_pesan getById(String id);
    List<sementara_pesan> getData();
    
    boolean validasiNamaBarang(sementara_pesan semPesan);
    boolean validasiHarga(sementara_pesan semPesan, long hargaJual);
}
