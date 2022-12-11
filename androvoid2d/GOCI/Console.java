// Console.java - Part of AndroVoid2D.

package androvoid2d.GOCI;

import java.util.ArrayList;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.IOException;

/**
 * Evaluate command into console.
 */
public class Console {
    /**
     * Evaluate command into console.
     *
     * @param command Command.
     */
    public static String evaluate(String... command) {
        String[] startProcArgs = {"cmd.exe", "/c"};

        String[] procArgs = new String[startProcArgs.length + command.length];

        System.arraycopy(startProcArgs, 0, procArgs, 0, startProcArgs.length);
        System.arraycopy(command, 0, procArgs, startProcArgs.length, command.length);

        ProcessBuilder procBuilder = new ProcessBuilder(procArgs);

        procBuilder.redirectErrorStream(true);

        Process proc;

        try {
            proc = procBuilder.start();
        } catch(IOException IOE) {
            System.out.println("IOException while evaluating a command to console.");

            return null;
        }

        BufferedReader outputReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        // FIXME: Returns [null].
        //      Doesn't works by unknown reason.
        //          First output parsing method (expected to be faster that second, but doesn't work).

//        int outputLines = outputReader.lines().toArray(String[]::new).length;
//
//        ArrayList<String> outputArray = new ArrayList<>();
//
//        for(int line=0; line < outputLines; line++) {
//            try {
//                outputArray.add(outputReader.readLine());
//            } catch(IOException IOE) {
//                System.out.println("IOException while reading output line.");
//            }
//        }

        // NOTE: Second output parsing method.

        ArrayList<String> outputArray = new ArrayList<>();

        while(true) {
            String outputLine;

            try {
                outputLine = outputReader.readLine();
            } catch(IOException IOE) {
                System.out.println("IOException while reading output line.");

                break;
            }

            if(outputLine == null) {
                break;
            }

            outputArray.add(outputLine);
        }

        return String.join("\n", outputArray.toArray(new String[0]));
    }
}
