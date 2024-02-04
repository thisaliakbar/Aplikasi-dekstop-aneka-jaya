
package model;

public class model_pemesanan {
    private String no_pesan;
    private String tgl_pesan;
    private Long total_pesan;
    private model_pengguna model_pengguna_pem;
    private model_supliyer model_supliyer_pem;

    public String getNo_pesan() {
        return no_pesan;
    }

    public void setNo_pesan(String no_pesan) {
        this.no_pesan = no_pesan;
    }

    public String getTgl_pesan() {
        return tgl_pesan;
    }

    public void setTgl_pesan(String tgl_pesan) {
        this.tgl_pesan = tgl_pesan;
    }

    public Long getTotal_pesan() {
        return total_pesan;
    }

    public void setTotal_pesan(Long total_pesan) {
        this.total_pesan = total_pesan;
    }

    public model_pengguna getModel_pengguna_pem() {
        return model_pengguna_pem;
    }

    public void setModel_pengguna_pem(model_pengguna model_pengguna_pem) {
        this.model_pengguna_pem = model_pengguna_pem;
    }

    public model_supliyer getModel_supliyer_pem() {
        return model_supliyer_pem;
    }

    public void setModel_supliyer_pem(model_supliyer model_supliyer_pem) {
        this.model_supliyer_pem = model_supliyer_pem;
    }


}
