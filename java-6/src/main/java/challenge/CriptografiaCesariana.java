package challenge;

public class CriptografiaCesariana implements Criptografia {
    final int lowerCaseLowerValue = 97;
    final int lowerCaseHigherValue = 122;
    final int spacesNumber = 3;
    static StringBuilder sb = new StringBuilder();

    @Override
    public String criptografar(String texto) {
        if (texto.equals("")){
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                int letterValue = texto.toLowerCase().codePointAt(i);
                int encryptedLetterValue = letterValue + spacesNumber;
                if (encryptedLetterValue > lowerCaseHigherValue) {
                    int lowerCaseHigherLimit = encryptedLetterValue - lowerCaseHigherValue;
                    encryptedLetterValue = lowerCaseLowerValue + lowerCaseHigherLimit;
                }
                sb.append(Character.toChars(encryptedLetterValue));
            } else {
                sb.append(texto.charAt(i));
            }
        }
        return sb.toString();
    }

    @Override
    public String descriptografar(String texto) {
        if (texto.equals("")){
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                int letterValue = texto.toLowerCase().codePointAt(i);
                int decryptedLetterValue = letterValue - spacesNumber;
                if (decryptedLetterValue < lowerCaseLowerValue) {
                    int lowerCaseLimit = lowerCaseLowerValue - decryptedLetterValue;
                    decryptedLetterValue = lowerCaseHigherValue - lowerCaseLimit;
                }
                sb.append(Character.toChars(decryptedLetterValue));
            } else {
                sb.append(texto.charAt(i));
            }
        }
        return sb.toString();
    }
}
