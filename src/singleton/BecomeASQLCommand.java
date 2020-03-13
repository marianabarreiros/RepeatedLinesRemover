package singleton;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class BecomeASQLCommand {

    private List<String> list;

    private static BecomeASQLCommand becomeASQLCommand;

    private BecomeASQLCommand() throws URISyntaxException {
        FileReading fileReading = FileReading.getInstance();
        list = new ArrayList<String>(fileReading.getFilledLinesListInFile()) ;

    }

    public static BecomeASQLCommand getInstance() throws URISyntaxException {
        if (becomeASQLCommand == null) {
            becomeASQLCommand = new BecomeASQLCommand();
        }
        return becomeASQLCommand;
    }

    public void becomeASQLCommand() {
        for(int i = 0; i <=list.size(); i++){
            String str = list.get(i);
            String[] splitStr = str.split("\t");
            System.out.println("SELECT " + "'"+ splitStr[0] +"'" + " AS GLIESE_CODE," + "'"+ splitStr[1]+"'" + " AS PROGRESS_CODE," + "'"+ splitStr[2]+"'" + " AS NAME");
            System.out.println("UNION");
        }
    }
}
