import singleton.BecomeASQLCommand;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        BecomeASQLCommand becomeASQLCommand = BecomeASQLCommand.getInstance();
        becomeASQLCommand.becomeASQLCommand();
    }
}
