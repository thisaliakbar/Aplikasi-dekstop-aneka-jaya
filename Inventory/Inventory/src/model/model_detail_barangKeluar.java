
package model;

public class model_detail_barangKeluar {
    private model_barangKeluar mod_barangKel_detKel;
    private model_barang mod_barang_detKel;
    private Integer jml_keluar;
    private Long subtotal_keluar;
    private String keterangan;        

    public model_barangKeluar getMod_barangKel_detKel() {
        return mod_barangKel_detKel;
    }

    public void setMod_barangKel_detKel(model_barangKeluar mod_barangKel_detKel) {
        this.mod_barangKel_detKel = mod_barangKel_detKel;
    }

    public model_barang getMod_barang_detKel() {
        return mod_barang_detKel;
    }

    public void setMod_barang_detKel(model_barang mod_barang_detKel) {
        this.mod_barang_detKel = mod_barang_detKel;
    }

    public Integer getJml_keluar() {
        return jml_keluar;
    }

    public void setJml_keluar(Integer jml_keluar) {
        this.jml_keluar = jml_keluar;
    }

    public Long getSubtotal_keluar() {
        return subtotal_keluar;
    }

    public void setSubtotal_keluar(Long subtotal_keluar) {
        this.subtotal_keluar = subtotal_keluar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
