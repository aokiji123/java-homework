package Cipher;

public class ACipher implements ICipher {
    @Override
    public String encode(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    result.append((char) ('a' + (c - 'a' + 1) % 26));
                } else {
                    result.append((char) ('A' + (c - 'A' + 1) % 26));
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    @Override
    public String decode(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    result.append((char) ('a' + (c - 'a' - 1 + 26) % 26));
                } else {
                    result.append((char) ('A' + (c - 'A' - 1 + 26) % 26));
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
