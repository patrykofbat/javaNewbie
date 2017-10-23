package Lab4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Polibius implements Algorithm {
    private final static char[][] POLYBIUSARRAYCODER = {{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'k'}, {'l', 'm', 'n', 'o', 'p'}
            , {'q', 'r', 's', 't', 'u'}, {'v', 'w', 'x', 'y', 'z'}};

    @Override
    public String crypt(String word) {
        String cryptedMessage = "";
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            int licznik = 0;
            while (licznik < 5) {
                for (char k : POLYBIUSARRAYCODER[licznik]) {
                    if (k == word.charAt(i)) {
                        int tmpInt = (licznik + 1) * 10 + Arrays.binarySearch(POLYBIUSARRAYCODER[licznik], word.charAt(i)) + 1;
                        cryptedMessage = cryptedMessage + Integer.toString(tmpInt);
                        break;
                    }
                    else if (word.charAt(i) == 'j') {
                        cryptedMessage = cryptedMessage + "24";
                        licznik = 5;
                        break;
                    }
                    else if (word.charAt(i) == ' ') {
                        cryptedMessage = cryptedMessage + " ";
                        licznik = 5;
                        break;
                    }

                }
                licznik++;

            }

        }

        return cryptedMessage;
    }

    @Override
    public String decrypt(String cryptedWord) {
        String decrypted = "";
        int i =0;
        while(i<=cryptedWord.length()-1){
            if(cryptedWord.charAt(i) == ' '){
                decrypted = decrypted + " ";
                i++;
            }
            else {
                int row = Character.getNumericValue(cryptedWord.charAt(i)) - 1;
                int col = Character.getNumericValue(cryptedWord.charAt(i + 1)) - 1;
                decrypted = decrypted + POLYBIUSARRAYCODER[row][col];
                i+=2;
            }
        }
        return decrypted;
    }
}
