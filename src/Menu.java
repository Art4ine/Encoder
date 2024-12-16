import com.sun.source.tree.CaseTree;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Выполните действие введя его номер:\s
                    \
                     [1] - зашифровать текст в файле с помощью ключа)\s
                     [2] - разшифровать текст в файле с помощью ключа\s
                     [3] - подобрать ключ к шифровоному файлу с помощью bruterforce\s
                     [4] - разшифровать текст в файле с помощью статесчического анализа
                     [5] - выход
                    """);

            int asnwer = scanner.nextInt();
            if (asnwer == 1) {
                EncryptedDecrypted encryptedDecrypted = new EncryptedDecrypted();

                encryptedDecrypted.encryptedDecrypted(false);
            } else if (asnwer == 2) {
                EncryptedDecrypted encryptedDecrypted = new EncryptedDecrypted();

                encryptedDecrypted.encryptedDecrypted(true);
            } else if (asnwer == 3) {
                System.out.println("Section3");
            } else if (asnwer == 4) {
                System.out.println("Section4");
            } else if (asnwer == 5) {
                break;
            }
        }
    }
}