import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bruteforce {

    @SneakyThrows
    public void bruteforce() { // Сделать фоормотирование документа коректно собрать в хранилище строки в колекции а когда найден ключ перебрать колекцию и дешифровать каждую строку этим ключом и между строками добавить перенос строки и записать в документ
        ConsoleHelper.writeMessage("Введите адрес файла для его разшифровки");
        String src = ConsoleHelper.readString();

        Path dst = ConsoleHelper.buildFileName(src, "_brutforce");
        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(src));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            ArrayList<String> strs = new ArrayList<String>();
            StringBuilder builder = new StringBuilder();

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                strs.add(line+System.lineSeparator());
                builder.append(line+System.lineSeparator());
            }

            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String line = caesarCipher.decrypt(builder.toString(), i);

                if (isValidate(line)) {
                    for (String str: strs) {
                        bufferedWriter.write(caesarCipher.decrypt(str, i));
                        bufferedWriter.newLine();
                    }
                }
            }
        }
    }

    private boolean isValidate(String text) {
        String[] strings = text.split(" ");
        for (String str: strings) {
            if (str.length() > 28) {
                return false;
            }
        }

        boolean isvalidate = false;
       if (text.contains("? ") || text.contains("! ") || text.contains(". ") || text.contains(", ")) {
           isvalidate = true;
       }

       while (isvalidate) {
           ConsoleHelper.writeMessage(text.length() > 50 ? text.substring(0, 50): text);
           ConsoleHelper.writeMessage("Понятен ли теккст? да/нет");
           String answer = ConsoleHelper.readString();

           if (answer.equalsIgnoreCase("да")) {
               return true;
           } else if (answer.equalsIgnoreCase("нет")) {
               isvalidate = false;
           } else {
               ConsoleHelper.writeMessage("Ответ должен быть только да или нет");
           }
       }

        return false;
    }
}
