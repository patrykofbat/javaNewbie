package Largestproductofgrid;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class Largestproductofgrid {

    public static void main(String[] args){
        int[][] grid =new int[20][20];
        try {
            Scanner fileIn = new Scanner(new FileReader("C:\\Users\\Patryk\\Desktop\\exampleofgrid.txt"));

            while(fileIn.hasNext()){                 /*looping through file*/
                if(fileIn.hasNextInt())
                System.out.println(fileIn.nextInt());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }


    }
}

