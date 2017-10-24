package Lab4;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptographer {

    /*========================================= cryptFile method =====================================================*/

    public static void cryptFile(File inputFile, File outputFile, Algorithm methodCrypter){
        try {
            Scanner fileReader = new Scanner(new FileReader(inputFile)); // class which respons for read from file
            PrintWriter printWriter = new PrintWriter(outputFile);   // class which respons for write to file
            while (fileReader.hasNextLine()) // looping through file line by line
                printWriter.println(methodCrypter.crypt(fileReader.nextLine())); // put crypt line to new file with '/n'
            printWriter.close();
            fileReader.close();     // closing both streams
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");   //exception if not valid path to file
        }

    /*======================================== deCryptFile method ====================================================*/
    // same as above but just using decrypt method
    }
    public static void deCryptFile(File inputFile, File outputFile, Algorithm methodDeCrypter){
        try {
            Scanner fileReader = new Scanner(new FileReader(inputFile));
            PrintWriter printWriter = new PrintWriter(outputFile);
            while (fileReader.hasNextLine())
                printWriter.println(methodDeCrypter.decrypt(fileReader.nextLine()));
            printWriter.close();
            fileReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found"); //exception if not valid path to file
        }
    }
}
