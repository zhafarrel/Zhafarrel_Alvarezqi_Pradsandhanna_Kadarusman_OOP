public class Buku {
    String judul;
    int year;
    BookGenre BookGenre;
    Author Author;

    static void getCurrentAge{
        int currentAge = year - Author.tahunLahir;
    }

    int currentAge = getCurrentAge;

    static void showDetail{
        System.out.println("Judul: " + Buku.judul);
        System.out.println("Genre: " + Buku.BookGenre);
        System.out.println("Tahun Terbit: " + Buku.year);
        System.out.println("Usia Author Saat Buku Diterbitkan: " + currentAge);
    }
}
