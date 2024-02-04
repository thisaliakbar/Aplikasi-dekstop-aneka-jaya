
package model;

public class sementara_keluar {
    private model_barang mdl_brg;
    private model_detail_barangKeluar mdl_mdbk;
    private String keterangan;

    public model_barang getMdl_brg() {
        return mdl_brg;
    }

    public void setMdl_brg(model_barang mdl_brg) {
        this.mdl_brg = mdl_brg;
    }

    public model_detail_barangKeluar getMdl_mdbk() {
        return mdl_mdbk;
    }

    public void setMdl_mdbk(model_detail_barangKeluar mdl_mdbk) {
        this.mdl_mdbk = mdl_mdbk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

   
}
