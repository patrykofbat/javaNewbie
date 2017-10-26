package Lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainLab5 {
    public static void main(String[] args){
        Microdvd microdvd = new Microdvd();
        String in = "C:\\Users\\Patryk\\Documents\\FileJava\\input.txt";
        String out = "C:\\Users\\Patryk\\Documents\\FileJava\\output.txt";

        try{
            microdvd.delay(in, out , 1000, 10);

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
