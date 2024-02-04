
package model;

public class model_detail_pemesanan {
    private model_pemesanan mod_pemesanan_detPem;
    private model_barang mod_barang_detPem;
    private Integer jml_pesan;
    private Long subtotal_pesan;
    private String status;

    public model_pemesanan getMod_pemesanan_detPem() {
        return mod_pemesanan_detPem;
    }

    public void setMod_pemesanan_detPem(model_pemesanan mod_pemesanan_detPem) {
        this.mod_pemesanan_detPem = mod_pemesanan_detPem;
    }

    public model_barang getMod_barang_detPem() {
        return mod_barang_detPem;
    }

    public void setMod_barang_detPem(model_barang mod_barang_detPem) {
        this.mod_barang_detPem = mod_barang_detPem;
    }
    
    public Integer getJml_pesan() {
        return jml_pesan;
    }

    public void setJml_pesan(Integer jml_pesan) {
        this.jml_pesan = jml_pesan;
    }

    public Long getSubtotal_pesan() {
        return subtotal_pesan;
    }

    public void setSubtotal_pesan(Long subtotal_pesan) {
        this.subtotal_pesan = subtotal_pesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
