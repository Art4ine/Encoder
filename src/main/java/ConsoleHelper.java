import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class ConsoleHelper {
    private static final BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));


    private ConsoleHelper() {

    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    @SneakyThrows
    public static String readString() {
        return bufferReader.readLine();
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }

    public static Path buildFileName(String path, String suffix) {
        StringBuilder builder = new StringBuilder(path);

        return path.lastIndexOf(".") >= 0 ?
                Path.of(builder.insert(path.lastIndexOf("."), suffix).toString()) :
                Path.of(builder.append(suffix).toString());
    }
}
