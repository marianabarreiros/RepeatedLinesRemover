import singleton.FileReading;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        FileReading fileReading = FileReading.getInstance();
        fileReading.getFilledLinesListInFile();
    }
}
