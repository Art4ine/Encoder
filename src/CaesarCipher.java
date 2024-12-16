public class CaesarCipher {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";

    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();

        for (char ch : message.toCharArray()) {
            int index = alphabet.indexOf(ch);
            if (index >= 0) {
                int newIndex = (index + key) % alphabet.length();

                builder.append(newIndex < 0 ? alphabet.charAt(alphabet.length() + newIndex) : alphabet.charAt(newIndex));
            }
        }

        return builder.toString();
    }

    public String decrypt(String message, int key) {
        return encrypt(message, -key);
    }

    public int alphabetLength() {
        return alphabet.length();
    }
}
