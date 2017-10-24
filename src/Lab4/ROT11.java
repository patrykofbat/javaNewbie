package Lab4;

public class ROT11 implements Algorithm {
    //private static final String alfabeth = "abcdefghijklmnopqrstuvwxyz";
    private static final String alfabeth = "abc";
    private static final int rotation = 11;


    /*============================================= crypt method =====================================================*/
    @Override // compile time check, checking if overriding have sense prevent from error
    public String crypt(String wordToCrypt) {
        wordToCrypt = wordToCrypt.toLowerCase();    // making every char lower case
        char[] tmpChar = new char[wordToCrypt.length()];
        for (int i = 0; i < wordToCrypt.length(); i++) {     // looping through word
            int newIndex = alfabeth.indexOf(wordToCrypt.charAt(i)); // searching char in alfabeth if not occur return -1
            if(newIndex != -1){             // checking if found char
                newIndex += rotation;   // add rotation
                while (newIndex >= alfabeth.length())
                    newIndex -= alfabeth.length();       // looping till newIndex is within alfabeth.length() bound
                if(!(wordToCrypt.charAt(i) == ' '))
                    tmpChar[i] = alfabeth.charAt(newIndex);  // put char to tmpChar with corresponding index
                else
                    tmpChar[i] = ' ';       // if white sign we are not rotating it just putting
            }
            else
                tmpChar[i] = '?';   // if we did not find char i alfabeth put '?'
        }
        return new String(tmpChar); // cast char tabel to string
    }
    /*============================================ decrypt method ====================================================*/
    // analogical as above but now we substract rotation
    @Override
    public String decrypt(String cryptedWord) {
        char[] tmpChar = new char[cryptedWord.length()];
        for (int i = 0; i < cryptedWord.length(); i++) {
            int newIndex = alfabeth.indexOf(cryptedWord.charAt(i)) - rotation;
            while (newIndex < 0)
                newIndex = alfabeth.length() + newIndex;
            tmpChar[i] = alfabeth.charAt(newIndex);
            if((cryptedWord.charAt(i) != ' ') && (cryptedWord.charAt(i)!='?'))
                tmpChar[i] = alfabeth.charAt(newIndex);
            else if(cryptedWord.charAt(i) == '?')
                tmpChar[i] = '?';
            else
                tmpChar[i] = ' ';
        }
        return new String(tmpChar);

    }
}
