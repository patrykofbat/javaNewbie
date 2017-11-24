package Lab9;

public class MainLab9 {
    public static void main(String[] args) {
        AghDateBase papior = new AghDateBase();
        papior.connect();
        papior.displayTable();
//        papior.deleteByAuthorOrIsbn("patryk");
        papior.searchByAuthorOrIsbn("patryk");
//        papior.deleteByAuthorOrIsbn("patryk");
        papior.searchByAuthorOrIsbn("Stanislaw Lem");
        papior.searchByAuthorOrIsbn("1234567891246");

    }
}
