package com.xpagesbeast.cmdline;

import joptsimple.OptionException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CmdLineRunnerTest {

    /**
     * A description of the testMainArgs function.
     *
     */
    @Test
    void testMainPrintsHelpScreen() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        String[] args = {"-h"};
        CmdLineRunner.main(args);
    }

    @Test
    void testMainWithArguments() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        String[] args = {"-e", "UAT"};
        CmdLineRunner.main(args);

        String expectedOutput = "Looking for settings-UAT.properties\nLooking for configuration-UAT.properties\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testMainThrowsUnrecognizedOptionException_with_recognized_arg() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        String[] args = {"-e","UAT","-N","NOTHING"};

        String expectedOutput = ""; // Empty string as we expect no output for invalid argument
        assertThrows(OptionException.class, () -> CmdLineRunner.main(args));
    }

    @Test
    void testMainThrowsUnrecognizedOptionException() {
        String[] args = {"-u", "UAT"}; // Using an unrecognized option "-u"
        assertThrows(OptionException.class, () -> CmdLineRunner.main(args));
    }

    @Test
    void testMainThrowsOptionMissingRequiredArgumentException_no_args_passed() {
        String[] args = {}; // Empty args, which is missing the required argument
        assertThrows(OptionException.class, () -> CmdLineRunner.main(args));
    }

    @Test
    void testMainThrowsOptionMissingRequiredArgumentException() {
        String[] args = {"-e"}; // Missing args, which is missing the required argument after -e
        assertThrows(OptionException.class, () -> CmdLineRunner.main(args));
    }
}