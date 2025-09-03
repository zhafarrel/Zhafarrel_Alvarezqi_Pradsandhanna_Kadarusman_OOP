public class Author {
    String nama;
    int tahunLahir;

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setTahun(int tahunLahir){
        this.tahunLahir = tahunLahir;
    }

    public void showDetail() {
        System.out.println("Nama Author: " + this.nama);
        System.out.println("TahunLahir: " + this.tahunLahir);
    }
}
