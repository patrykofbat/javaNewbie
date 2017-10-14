package Lab4;

import java.io.File;

public class MainLab4 {
    public static void main(String[] args){
        File inputFile = new File("C:\\Users\\Patryk\\Documents\\FileJava\\input.txt");
        File outputFile = new File("C:\\Users\\Patryk\\Documents\\FileJava\\output.txt");
        File newFile = new File("C:\\Users\\Patryk\\Documents\\FileJava\\decrypted.txt");
        Cryptographer.cryptFile(inputFile, outputFile, new ROT11());
        Cryptographer.deCryptFile(outputFile, newFile, new ROT11());




    }
}
