package model;

public class sementara_pemesanan {
    private model_pemesanan mdl_pem;
    private model_detail_pemesanan mdl_mdp;

    public model_pemesanan getMdl_pem() {
        return mdl_pem;
    }

    public void setMdl_pem(model_pemesanan mdl_pem) {
        this.mdl_pem = mdl_pem;
    }

    public model_detail_pemesanan getMdl_mdp() {
        return mdl_mdp;
    }

    public void setMdl_mdp(model_detail_pemesanan mdl_mdp) {
        this.mdl_mdp = mdl_mdp;
    }
}
