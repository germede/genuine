package org.fwf;

import org.fwf.cli.HelpCommand;

public class Console {

    public static void main(String[] args) {

        if (args.length == 0) {
            new HelpCommand().execute();
        } else {

        }
    }
}
