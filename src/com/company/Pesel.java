package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pesel {
    String pesel;
    Pesel(String p){
        pesel = p;
    }

    boolean check(){
        String pattern = "[0-9]+";
        Pattern d = Pattern.compile(pattern);
        Matcher m = d.matcher(pesel);
        int liczbaKontrolna=0;
        if(pesel.length()!= 11){
            return false;
        }
        else if(!m.matches()){
            return false;
        }


        else
            for(int i=0;i<pesel.length()-1;i++) {
                int[]tab={9,7,3,1,9,7,3,1,9,7};
                Character b = pesel.charAt(i);
                String g = b.toString();
                Integer x = Integer.parseInt(g);
                liczbaKontrolna += x*tab[i];
            }
            liczbaKontrolna = liczbaKontrolna % 10;
            Character f = pesel.charAt(10);
            String h = f.toString();
            Integer o = Integer.parseInt(h);
            if(liczbaKontrolna != o)
                return false;
            else
                return true;
    }
}
