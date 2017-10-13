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
            while (fileReader.hasNext()){
                printWriter.write(fileReader.next());
                printWriter.write(" ");
            }
            printWriter.close();


        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }


    }
    public static void deCryptFile(File inputFile, File outputFile, Algorithm methodDeCrypter){

    }


}
