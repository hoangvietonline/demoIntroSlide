package hoangviet.ndhv.demointroslide;

public class phim_hd {
    private String hinh;
    private String tittle;
    private String gia;

    public phim_hd(String hinh, String tittle, String gia) {
        this.hinh = hinh;
        this.tittle = tittle;
        this.gia = gia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
