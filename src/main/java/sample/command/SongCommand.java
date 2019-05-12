package sample.command;

import org.fluentness.command.Command;


public class SongCommand implements Command {

    @Override
    public String getName() {
        return "song:test";
    }

    @Override
    public String getDescription() {
        return "Song test command";
    }

    @Override
    public void execute(String... parameters) {
        System.out.println("Song test command execution");
    }
}
