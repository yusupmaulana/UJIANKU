package ujianku.com.model;

/*
 * Nim : 10116093
 * Nama : Yusup Maulanadireja
 * Kelas : IF-3/AKB-3
 * Tanggal Pengerjaan : 19 Mei 2019
 * */

public class FriendsModel {
    private  String nim;
    private  String nama;
    private  String kelas;
    private  String telephone;
    private  String email;
    private  String sosmed;

    public FriendsModel(String nim, String nama, String kelas, String telephone, String email, String sosmed) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.telephone = telephone;
        this.email = email;
        this.sosmed = sosmed;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSosmed() {
        return sosmed;
    }

    public void setSosmed(String sosmed) {
        this.sosmed = sosmed;
    }
}
