// ObjectsBufferWriter.java - Part of AndroVoid2D.

package androvoid2d.GOCI.android_engine;

import androvoid2d.GOCI.TemplatesReader;

import java.util.Scanner;

import java.io.FileWriter;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;


/**
 * Objects buffer writer.
 */
public class ObjectsBufferWriter {
    /**
     * Write objects buffer to app JS file.
     *
     * @param buffer Objects buffer.
     * @param appJSFile App JS source.
     */
    public static void writeBuffer(ObjectsBuffer buffer, String appJSFile) {
        String appJSFileContent;

        try {
            appJSFileContent = new Scanner(new File(appJSFile)).useDelimiter("\\Z").next();
        } catch(FileNotFoundException FNFE) {
            System.out.println("Unable to find app JS file.");

            return;
        }

        FileWriter appJsFileWriter;

        try {
            appJsFileWriter = new FileWriter(appJSFile);
        } catch(IOException IOE) {
            System.out.println("IOException while writing objects buffer to app JS file.");

            return;
        }

        String newAppCode = String.join("\n", buffer.getBuffer().toArray(new String[0]));

        try {
            appJsFileWriter.write(appJSFileContent.replace("@APPCODE", newAppCode));

            appJsFileWriter.close();
        } catch(IOException IOE) {
            System.out.println("IOException while writing app JS / closing FileWriter.");
        }
    }

    /**
     * Re-write object buffer to app JS file.
     *
     * @param buffer Objects buffer.
     * @param templatesPath Path to templates.
     * @param appJSFile App JS source.
     */
    public static void rewriteBuffer(ObjectsBuffer buffer, String templatesPath, String appJSFile) {
        TemplatesReader templatesReader = new TemplatesReader(templatesPath);

        try {
            FileWriter oldAppJSFileWriter = new FileWriter(appJSFile);

            oldAppJSFileWriter.write(templatesReader.getTemplate("index.js"));

            oldAppJSFileWriter.close();
        } catch(IOException IOE) {
            System.out.println("IOException while rewriting objects buffer to app JS file.");

            return;
        }

        writeBuffer(buffer, appJSFile);
    }
}
