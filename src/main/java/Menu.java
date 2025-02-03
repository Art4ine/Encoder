import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        while (true) {
            ConsoleHelper.writeMessage("""
                    Выполните действие введя его номер:\s
                    \
                     [1] - зашифровать текст в файле с помощью ключа\s
                     [2] - разшифровать текст в файле с помощью ключа\s
                     [3] - подобрать ключ к шифровоному файлу с помощью bruterforce\s
                     [4] - разшифровать текст в файле с помощью статесчического анализа
                     [5] - выход
                    """);

            int asnwer = ConsoleHelper.readInt();
            if (asnwer == 1) {
                EncryptedDecrypted encryptedDecrypted = new EncryptedDecrypted();

                encryptedDecrypted.encryptedDecrypted(false);
            } else if (asnwer == 2) {
                EncryptedDecrypted encryptedDecrypted = new EncryptedDecrypted();

                encryptedDecrypted.encryptedDecrypted(true);
            } else if (asnwer == 3) {
                Bruteforce bruteforce = new Bruteforce();

                bruteforce.bruteforce();
            } else if (asnwer == 4) {
                Parsing parsing = new Parsing();

                parsing.parse();
            } else if (asnwer == 5) {
                break;
            }
        }
    }
}