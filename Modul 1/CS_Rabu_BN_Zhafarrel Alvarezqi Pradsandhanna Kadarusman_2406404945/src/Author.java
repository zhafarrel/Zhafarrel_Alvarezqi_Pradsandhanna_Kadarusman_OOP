public class Author {
    String nama;
    int tahunLahir;

    Author(String nama, int tahunLahir){
        this.nama = nama;
        this.tahunLahir = tahunLahir;
    }

    public void showDetail() {
        System.out.println("Nama Author: " + this.nama);
        System.out.println("Tahun Lahir: " + this.tahunLahir);
    }
}
