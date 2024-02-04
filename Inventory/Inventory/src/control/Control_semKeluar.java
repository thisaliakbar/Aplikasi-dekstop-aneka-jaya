package control;

import java.util.List;
import model.sementara_keluar;


public interface Control_semKeluar {
    void tambahData(sementara_keluar semKeluar);
    void perbaruiData(sementara_keluar semKeluar, sementara_keluar semKel);
    void hapusData(sementara_keluar semKeluar);
    
    sementara_keluar getById(String id);
    List<sementara_keluar> getData();
}
