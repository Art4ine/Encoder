import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class EncryptedDecrypted {
    public void encryptedDecrypted(boolean flag) throws IOException {
        ConsoleHelper.writeMessage(flag ? "Введите путь к файлу для разшифровки":"Введите путь к файлу для зашифровки");
        String src = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(src, flag ? "_encrypt":"_decrypt");

        ConsoleHelper.writeMessage("Введите ключ");
        int key =  ConsoleHelper.readInt();

        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
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
