package Lab4;

public class ROT11 implements Algorithm {
    private static final String alfabeth = "abcdefghijklmnopqrstvwuxyz";
    private static final int rotation = 11;

    @Override
    public String crypt(String wordToCrypt) {
        char[] tmpChar = new char[wordToCrypt.length()];
        for (int i = 0; i < wordToCrypt.length(); i++) {
            int newIndex = alfabeth.indexOf(wordToCrypt.charAt(i)) + rotation;
            if (newIndex > alfabeth.length())
                newIndex -= alfabeth.length();
            tmpChar[i] = alfabeth.charAt(newIndex);
        }
        return new String(tmpChar);


    }

    @Override
    public String decrypt(String cryptedWord) {
        char[] tmpChar = new char[cryptedWord.length()];
        for (int i = 0; i < cryptedWord.length(); i++) {
            int newIndex = alfabeth.indexOf(cryptedWord.charAt(i)) - rotation;
            if (newIndex < 0)
                newIndex = alfabeth.length() + newIndex;
            tmpChar[i] = alfabeth.charAt(newIndex);
        }
        return new String(tmpChar);

    }
}
