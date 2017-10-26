package Lab5;

import java.io.File;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Microdvd {


    //############################# delay method ###########################

    void delay(String pathToFileIn, String pathToFileOut, int msec, int fps)throws Exception{

        // create File class
        File in = new File(pathToFileIn);
        File out = new File(pathToFileOut);

        //Scanner - read from file, PrintWriter - write to new file
        Scanner fileReader = new Scanner(new FileReader(in));
        PrintWriter fileWriter = new PrintWriter(out);


        //looping through file line by line
        while(fileReader.hasNextLine()){
            // counter for give detail information if exception occur
            int counter = 1;

            //seperate variable for line
            String line = fileReader.nextLine();

            // getting code
            int code = ValidateMicrodvdFormat.validate(line);
            switch (code){
                // everything is right
                case 0:
                    fileWriter.println(ValidateMicrodvdFormat.shuffle(line, msec, fps));
                    break;
                // invalid format chars i brackets
                case 1:
                    // creating message string
                    String messageError = "Line: " + Integer.toString(counter)+ " " + line;
                    // first param - message, second - type of error
                    throw new FormatException(messageError, "Invalid format");
                // starting frame is bigger than ending frame
                case 2:
                    // creating message string
                    String messageError_2 = "Line: " + Integer.toString(counter)+ " " + line;
                    // first param - message, second - type of error
                    throw new FormatException(messageError_2, "Invalid dimensions of frames");

            }
            counter++;
        }

        //closing streams
        fileReader.close();
        fileWriter.close();

    }

}
