package com.xpagesbeast.cmdline;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.IOException;
import java.util.Arrays;

public class CmdLineRunner {
    /**
     * Example main() driver.
     * Notice -e is a required argument.
     *
     * @param args
     */
    public static void main(String[] args){

        OptionParser parser = new OptionParser();
        parser.acceptsAll(Arrays.asList(new String[] { "help", "?", "h" }), "shows this help").forHelp();
        parser.acceptsAll(
                Arrays.asList(new String[] { "env", "e" }),
                        "which environment? -e or -env.  appends environment to configuration files. Example: settings-{env}.properties")
                .withRequiredArg()
                .required();

            OptionSet options = parser.parse(args);


        if (options.has("help")) {
            printHelper(parser);
        }else{
            System.out.println("Looking for settings-"+options.valueOf("e")+".properties");
            System.out.println("Looking for configuration-"+options.valueOf("e")+".properties");
        }

    }

    /**
     * Prints the Help screen into the terminal window.
     *
     * Example Output:
     * HELP Command Line Options
     * Usage: java -jar target/cmd-options-2.0-SNAPSHOT.jar -e UAT
     *
     * Option (* = required)  Description
     * ---------------------  -----------
     * -?, -h, --help         shows this help
     * * -e, --env <String>   which environment? -e or -env.  appends environment to
     *                          configuration files. Example: settings-{env}.properties
     *
     * @param parser
     */
    private static void printHelper(OptionParser parser) {
        try {
            System.out.println("HELP ALEKS Command Line Options");
            System.out.println("Usage: java -jar target/cmd-options-2.0-SNAPSHOT.jar -e UAT");
            System.out.println("");
            parser.printHelpOn(System.out);
        } catch (IOException ignored) {

        }
    }

}
