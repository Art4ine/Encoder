import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parsing {

    @SneakyThrows
    public void parse() {
        ConsoleHelper.writeMessage("Введите адрес зашифрованного файла");
        String src = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Введите адрес файла для набора к статистики");
        String srcStat = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(src, "_parse");

        Map<Character, Integer> mapSrc = fillMapValues(src);
        Map<Character, Integer> mapSrcStat = fillMapValues(srcStat);

        List<Map.Entry<Character, Integer>> listScr = mapToList(mapSrc);
        List<Map.Entry<Character, Integer>> listScrStat = mapToList(mapSrcStat);

        Map<Character, Character> decrypted = new HashMap<>();
        if (listScr.size() <= listScrStat.size()) {
            for (int i = 0; i < listScr.size(); i++) {
                decrypted.put(listScr.get(i).getKey(), listScrStat.get(i).getKey());
            }

            try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(src));
                 BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
                while (bufferedReader.ready()) {
                    StringBuilder builder = new StringBuilder();

                    String line = bufferedReader.readLine();
                    for (char encryptedChar : line.toCharArray()) {
                        Character decryptedChar = decrypted.get(encryptedChar);

                        builder.append(decryptedChar);
                    }

                    bufferedWriter.write(builder.toString());
                    bufferedWriter.newLine();
                }

                ConsoleHelper.writeMessage("Содержимое файла разшифровано");
            }
        } else {
            ConsoleHelper.writeMessage("Размер файла статистики не достаточен для разшифровки");
        }
    }

    private List<Map.Entry<Character, Integer>> mapToList(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Character, Integer>> comparator = Comparator.comparingInt(Map.Entry::getValue);

        list.sort(comparator.reversed());

        return list;
    }

    @SneakyThrows
    private Map<Character, Integer> fillMapValues(String path) {
        Map<Character, Integer> map = new HashMap<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path));) {
            StringBuilder builder = new StringBuilder();

            while (bufferedReader.ready()) {
                builder.append(bufferedReader.readLine());
            }

            char[] chars = builder.toString().toCharArray();
            for (char ch: chars) {
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
        }

        return map;
    }
 }