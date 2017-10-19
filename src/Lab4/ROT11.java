package Lab4;

public class ROT11 implements Algorithm {
    private static final String alfabeth = "abcdefghijklmnopqrstuvwxyz";
    private static final int rotation = 11;

    @Override
    public String crypt(String wordToCrypt) {
        wordToCrypt = wordToCrypt.toLowerCase();
        char[] tmpChar = new char[wordToCrypt.length()];
        for (int i = 0; i < wordToCrypt.length(); i++) {
            int newIndex = alfabeth.indexOf(wordToCrypt.charAt(i)) + rotation;
            while (newIndex >= alfabeth.length())
                newIndex -= alfabeth.length();
            if(!(wordToCrypt.charAt(i) == ' '))
                tmpChar[i] = alfabeth.charAt(newIndex);
            else
                tmpChar[i] = ' ';
        }
        return new String(tmpChar);


    }

    @Override
    public String decrypt(String cryptedWord) {
        char[] tmpChar = new char[cryptedWord.length()];
        for (int i = 0; i < cryptedWord.length(); i++) {
            int newIndex = alfabeth.indexOf(cryptedWord.charAt(i)) - rotation;
            while (newIndex < 0)
                newIndex = alfabeth.length() + newIndex;
            tmpChar[i] = alfabeth.charAt(newIndex);
            if(!(cryptedWord.charAt(i) == ' '))
                tmpChar[i] = alfabeth.charAt(newIndex);
            else
                tmpChar[i] = ' ';
        }
        return new String(tmpChar);

    }
}
