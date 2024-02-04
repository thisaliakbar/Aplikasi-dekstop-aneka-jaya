
package model;

public class model_barangMasuk {
    private String no_masuk;
    private String tgl_masuk;
    private Long total_masuk;
    private model_pengguna Mod_pengguna;
    private model_supliyer Mod_supliyer;

    public String getNo_masuk() {
        return no_masuk;
    }

    public void setNo_masuk(String no_masuk) {
        this.no_masuk = no_masuk;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public Long getTotal_masuk() {
        return total_masuk;
    }

    public void setTotal_masuk(Long total_masuk) {
        this.total_masuk = total_masuk;
    }

    public model_pengguna getMod_pengguna() {
        return Mod_pengguna;
    }

    public void setMod_pengguna(model_pengguna Mod_pengguna) {
        this.Mod_pengguna = Mod_pengguna;
    }

    public model_supliyer getMod_supliyer() {
        return Mod_supliyer;
    }

    public void setMod_supliyer(model_supliyer Mod_supliyer) {
        this.Mod_supliyer = Mod_supliyer;
    }


}
