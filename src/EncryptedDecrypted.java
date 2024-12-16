import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class EncryptedDecrypted {
    public void encryptedDecrypted(boolean flag) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(flag ? "Введите путь к файлу для разшифровки":"Введите путь к файлу для зашифровки");
        Path src = Path.of(scanner.nextLine());

        System.out.println("Введите адрес куда записать результат");
        Path dst = Path.of(scanner.nextLine());

        System.out.println("Введите ключ");
        int key = scanner.nextInt();

        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedReader reader = Files.newBufferedReader(src);
             BufferedWriter writer = Files.newBufferedWriter(dst)) {

            while (reader.ready()) {
                String line = reader.readLine();

                String result = flag ? caesarCipher.decrypt(line, key): caesarCipher.encrypt(line, key);
                writer.write(result);
                writer.newLine();
            }
        }

        System.out.println("Файл успешно зашифрован!");
    }
}
