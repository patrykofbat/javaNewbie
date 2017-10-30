package Lab1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

public class Pesel {
    String pesel;

    Pesel(String p) {
        pesel = p;
    }

    boolean check() {
        String pattern = "[0-9]+";
        Pattern d = Pattern.compile(pattern);
        Matcher m = d.matcher(pesel);
        int liczbaKontrolna = 0;
        if (pesel.length() != 11) {
            return false;
        } else if (!m.matches()) {
            return false;
        } else
            for (int i = 0; i < pesel.length() - 1; i++) {
                int[] tab = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
                int x = Character.getNumericValue(pesel.charAt(i));
                liczbaKontrolna += x * tab[i];
            }
        liczbaKontrolna = liczbaKontrolna % 10;
        Integer o = Character.getNumericValue(pesel.charAt(10));
        if (liczbaKontrolna != o)
            return false;
        else
            return true;
    }
}
