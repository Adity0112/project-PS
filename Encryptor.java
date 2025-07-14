public class Encryptor {
    public static String encrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            sb.append((char)(ch + 2));
        }
        return sb.toString();
    }

    public static String decrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            sb.append((char)(ch - 2));
        }
        return sb.toString();
    }
}

