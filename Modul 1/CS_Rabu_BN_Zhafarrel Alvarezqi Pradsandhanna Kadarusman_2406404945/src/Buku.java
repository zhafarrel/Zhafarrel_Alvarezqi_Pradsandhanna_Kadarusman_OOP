public class Buku {
    String judul;
    int year;
    BookGenre genre;
    Author author;

    Buku(String judul, int year, BookGenre genre, Author author){
        this.judul = judul;
        this.year = year;
        this.genre = genre;
        this.author = author;
    }


    public int getCurrentAge(){
        int currentAge = this.year - this.author.tahunLahir;
        return currentAge;
    }


    public void showDetail(){
        System.out.println("Judul: " + this.judul);
        System.out.println("Genre: " + this.genre);
        System.out.println("Tahun Terbit: " + this.year);
        System.out.println("Nama Author: " + this.author.nama);
        System.out.println("Tahun Lahir: " + this.author.tahunLahir);
        System.out.println("Usia Author Saat Buku Diterbitkan: " + getCurrentAge());
    }
}
