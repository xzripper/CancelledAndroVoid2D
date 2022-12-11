// TemplatesReader.java - Part of AndroVoid2D.

package androvoid2d.GOCI;

import java.util.ArrayList;

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * ReactJS app templates reader.
 */
public class TemplatesReader {
    /**
     * Templates path (static).
     */
    public static final String ANDRO_VOID2D_GOCI_TEMPLATES = "androvoid2d\\GOCI\\templates\\";

    /**
     * Templates path.
     */
    public final String templatesPath;

    /**
     * Initialize template reader.
     *
     * @param _templatesPath Templates path.
     */
    public TemplatesReader(String _templatesPath) {
        templatesPath = _templatesPath;
    }

    /**
     * Read template.
     *
     * @param templateName Template name.
     */
    public String getTemplate(String templateName) {
        return readFile(
            String.format(
                "%s%s%s",
                templatesPath,
                templatesPath.endsWith("\\") ? "" : "\\",
                templateName
            )
        );
    }

    /**
     * Read template and replace template key (keys don't supported) in template.
     *
     * @param templateName Template name.
     * @param keyName Key name.
     * @param replaceOn Replace on.
     */
    public String getTemplate(String templateName, String keyName, String replaceOn) {
        return getTemplate(templateName).replace(keyName, replaceOn);
    }

    private String readFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();

        Scanner reader = null;

        try {
            reader = new Scanner(new File(filePath));
        } catch(FileNotFoundException FNFE) {
            System.out.println(String.format("Unable to read file. Invalid path '%s'", filePath));

            return null;
        }

        while(reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }

        return String.join("\n", lines.toArray(new String[0]));
    }
}
