package Lab4;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptFile(File inputFile, File outputFile, Algorithm methodCrypter){
        try {
            Scanner fileReader = new Scanner(new FileReader(inputFile));
            PrintWriter printWriter = new PrintWriter(outputFile);
            while (fileReader.hasNextLine()){
                printWriter.println(methodCrypter.crypt(fileReader.nextLine()));

            }
            printWriter.close();
            fileReader.close();


        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }


    }
    public static void deCryptFile(File inputFile, File outputFile, Algorithm methodDeCrypter){
        try {
            Scanner fileReader = new Scanner(new FileReader(inputFile));
            PrintWriter printWriter = new PrintWriter(outputFile);
            while (fileReader.hasNextLine()){
                printWriter.println(methodDeCrypter.decrypt(fileReader.nextLine()));

            }
            printWriter.close();
            fileReader.close();


        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

    }


}
