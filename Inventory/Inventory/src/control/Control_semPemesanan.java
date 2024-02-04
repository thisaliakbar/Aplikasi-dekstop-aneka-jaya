package control;
import java.util.List;
import model.sementara_pemesanan;

public interface Control_semPemesanan {
    void tambahData(sementara_pemesanan semPemesanan);
    void perbaruiData(sementara_pemesanan semPemesanan);
    void hapusData(sementara_pemesanan semPemesanan);
    
    List<sementara_pemesanan> getData();
    
}
