package Cipher;

public class BCipher implements ICipher {
    @Override
    public String encode(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    result.append((char) ('a' + ('z' - c)));
                } else {
                    result.append((char) ('A' + ('Z' - c)));
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    @Override
    public String decode(String input) {
        return encode(input);
    }
}