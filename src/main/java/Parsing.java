import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Parsing {

    @SneakyThrows
    public void parse() {
        ConsoleHelper.writeMessage("Введите адрес зашифрованного файла");
        String src = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Введите адрес файла для набора к статистики");
        String srcStat = ConsoleHelper.readString();

        Map<Character, Integer> mapSrc = fillMapValues(src);
        Map<Character, Integer> mapSrcStat = fillMapValues(srcStat);
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