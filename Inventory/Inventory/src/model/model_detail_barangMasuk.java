package model;

public class model_detail_barangMasuk {
    private model_barangMasuk mod_barangMas_detMas;
    private model_barang mod_barang_detMas;
    private Integer jml_masuk;
    private Long subtotal_masuk;
    private String status;

    public model_barangMasuk getMod_barangMas_detMas() {
        return mod_barangMas_detMas;
    }

    public void setMod_barangMas_detMas(model_barangMasuk mod_barangMas_detMas) {
        this.mod_barangMas_detMas = mod_barangMas_detMas;
    }

    public model_barang getMod_barang_detMas() {
        return mod_barang_detMas;
    }

    public void setMod_barang_detMas(model_barang mod_barang_detMas) {
        this.mod_barang_detMas = mod_barang_detMas;
    }

    public Integer getJml_masuk() {
        return jml_masuk;
    }

    public void setJml_masuk(Integer jml_masuk) {
        this.jml_masuk = jml_masuk;
    }

    public Long getSubtotal_masuk() {
        return subtotal_masuk;
    }

    public void setSubtotal_masuk(Long subtotal_masuk) {
        this.subtotal_masuk = subtotal_masuk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
 
}
