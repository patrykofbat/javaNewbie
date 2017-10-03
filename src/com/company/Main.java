package com.company;
import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {
            System.out.print("Podaj pesel: ");
            Scanner userInput = new Scanner(System.in);
            Pesel p = new Pesel(userInput.next());
        if(p.check()){
            System.out.print("Podana prawidlowy pesel");
        }
        else{
            System.out.print("Zly format pesel");
        }


    }
}
