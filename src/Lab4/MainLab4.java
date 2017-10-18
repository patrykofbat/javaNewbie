package Lab4;

import java.io.File;
import java.util.Scanner;

// to set up program args go to Run -> Edit configurations

public class MainLab4 {
    public static void main(String[] args){
        File in = new File(args[0]);
        File out = new File(args[1]);
        System.out.println("1.szyfruj(ROT11)");
        System.out.println("2.szyfruj(Polibiusz)");
        System.out.println("3.deszyfruj(ROT11)");
        System.out.println("4.deszyfruj(Polibius)");
        System.out.print("Wybor: ");
        Scanner userInput = new Scanner(System.in);
        int i = userInput.nextInt();
        switch (i) {
            case 1:
                Cryptographer.cryptFile(in, out, new ROT11());
                break;
            case 2:
                Cryptographer.cryptFile(in, out, new Polibius());
                break;
            case 3:
                Cryptographer.deCryptFile(in, out, new ROT11());
                break;
            case 4:
                Cryptographer.deCryptFile(in, out, new Polibius());
                break;
        }
    }
       /* File inputFile = new File("C:\\Users\\Patryk\\Documents\\FileJava\\input.txt");
        File outputFile = new File("C:\\Users\\Patryk\\Documents\\FileJava\\output.txt");
        File newFile = new File("C:\\Users\\Patryk\\Documents\\FileJava\\decrypted.txt");
        Cryptographer.cryptFile(inputFile, outputFile, new Polibius());
        Cryptographer.deCryptFile(outputFile, newFile, new Polibius());
        */
}

