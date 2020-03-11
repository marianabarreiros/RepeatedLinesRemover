package singleton;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReading {

    private static FileReading fileReadingInstance;

    private FileReading() {
    }

    public static FileReading getInstance() {
        if (fileReadingInstance == null) {
            fileReadingInstance = new FileReading();
        }
        return fileReadingInstance;
    }

    private Path getFilePath() throws URISyntaxException {
        final String FILE = "file" + File.separator + "records.txt";
        return Paths.get(getClass().getClassLoader().getResource(FILE).toURI());
    }

    public void getFilledLinesListInFile() throws URISyntaxException {
        Path filePath = getFilePath();
        Set<String> list = new HashSet<>();

        try (Stream<String> stream = Files.lines(filePath, StandardCharsets.ISO_8859_1)) {
            list = stream
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
    }
}
