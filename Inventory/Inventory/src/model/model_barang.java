
package model;

public class model_barang {
    private String kode_barang;
    private String nama_barang;
    private String satuan;
    private Long harga;
    private Integer stok;
    private model_jenisBarang mod_jnsBarang;

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }
    
    public model_jenisBarang getMod_jnsBarang() {
        return mod_jnsBarang;
    }

    public void setMod_jnsBarang(model_jenisBarang mod_jnsBarang) {
        this.mod_jnsBarang = mod_jnsBarang;
    }
 
}
