// BaseReactJSAppCreator.java - Part of AndroVoid2D.

package androvoid2d.GOCI;

import java.io.File;

import java.io.FileWriter;

import java.io.IOException;

/**
 * Create base react js app files.
 */
public class BaseReactJSAppCreator {
    protected static TemplatesReader templatesReader;

    /**
     * Default HTML part file name.
     */
    public static final String HTML_APP_PART_FILENAME = "appindex.html";

    /**
     * Default JS part file name.
     */
    public static final String JS_APP_PART_FILENAME = "app.js";

    /**
     * Default app controller file name.
     */
    public static final String CONTROLLER_APP_PART_FILENAME = "controller.js";

    /**
     * Templates keys.
     */
    public static final String[] TEMPLATES_KEYS = {"@APP_BACKEND_FILE", "@APP_CONTROLLER_FILE"};

    /**
     * Initialize templates reader.
     *
     * @param templatesPath Templates path.
     */
    public static void initTemplatesReader(String templatesPath) {
        templatesReader = new TemplatesReader(templatesPath);
    }

    /**
     * Initialize app root (index HTML).
     *
     * @param initializationPath Initialization path.
     */
    public static void initAppRoot(String initializationPath) {
        try {
            createFile(formatDirectory(initializationPath), HTML_APP_PART_FILENAME);

            writeFile(
                String.format(
                    "%s%s",
                    formatDirectory(initializationPath),
                    HTML_APP_PART_FILENAME
                ),

                templatesReader.getTemplate(
                    "index.html",
                    TEMPLATES_KEYS[0],
                    JS_APP_PART_FILENAME
                ).replace(TEMPLATES_KEYS[1], CONTROLLER_APP_PART_FILENAME)
            );
        } catch(IOException IOE) {
            System.out.println("IOException while initializing | writing app root.");
        }
    }

    /**
     * Initialize back-end of app (ReactJS file).
     *
     * @param initializationPath Initialization path.
     */
    public static void initAppBackend(String initializationPath) {
        try {
            createFile(formatDirectory(initializationPath), JS_APP_PART_FILENAME);

            writeFile(
                String.format(
                    "%s%s",
                    formatDirectory(initializationPath),
                    JS_APP_PART_FILENAME
                ),

                templatesReader.getTemplate(
                    "index.js"
                )
            );
        } catch(IOException IOE) {
            System.out.println("IOException while initializing | writing app backend.");
        }
    }

    /**
     * Initialize controller of the app (JS file).
     *
     * @param initializationPath Initialization path.
     */
    public static void initAppController(String initializationPath) {
        try {
            createFile(formatDirectory(initializationPath), CONTROLLER_APP_PART_FILENAME);

            writeFile(
                String.format(
                    "%s%s",
                    formatDirectory(initializationPath),
                    CONTROLLER_APP_PART_FILENAME
                ),

                templatesReader.getTemplate(
                    "controller.js"
                )
            );
        } catch(IOException IOE) {
            System.out.println("IOException while initializing | writing app controller.");
        }
    }

    /**
     * Initialize app folder.
     *
     * @param folderPath Folder path (where is going to be placed).
     * @param name App name.
     */
    public static void createAppFolder(String folderPath, String name) {
        new File(String.format("%s%s", formatDirectory(folderPath), name)).mkdirs();
    }

    /**
     * Create all that need (app folder, backend, root, etc).
     *
     * @param initPathRoot Initialization path of app root.
     * @param initPathBackEnd Initialization path of backend.
     * @param initPathController Initialization path of controller.s
     * @param folderPath Folder path (where is going to be placed).
     * @param appName App name.
     */
    public static void doAll(
        String initPathRoot,
        String initPathBackEnd,
        String initPathController,
        String folderPath,
        String appName
    ) {
        createAppFolder(folderPath, appName);

        initAppRoot(initPathRoot);
        initAppBackend(initPathBackEnd);
        initAppController(initPathController);
    }

    protected static void createFile(String dir, String name) throws IOException {
        if(dir != null) {
            File _dir = new File(dir);

            _dir.mkdirs();
        }

        File newFile = new File(
            String.format(
                "%s%s",
                dir == null ? "" : formatDirectory(dir),
                name
            )
        );

        newFile.createNewFile();
    }

    protected static void writeFile(String filePath, String contentToWrite) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);

        fileWriter.write(contentToWrite);

        fileWriter.close();
    }

    protected static String formatDirectory(String directory) {
        String absPath = new File(directory).getAbsolutePath();

        return absPath + "\\";
    }
}
