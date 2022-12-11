// Controller.java - Part of AndroVoid2D.

package androvoid2d.GOCI.android_engine;

import androvoid2d.GOCI.BaseReactJSAppCreator;
import androvoid2d.GOCI.TemplatesReader;

import java.io.FileWriter;

import java.io.IOException;

/**
 * Controller for objects on the window.
 */
public class Controller {
    protected final TemplatesReader templatesReader;

    /**
     * Controller JS file source (directory where it's placed).
     */
    public final String controllerJSDir;

    /**
     * Initialize controller.
     *
     * @param templatesPath Templates path.
     * @param _controllerJSDir Controller JS directory.
     */
    public Controller(String templatesPath, String _controllerJSDir) {
        templatesReader = new TemplatesReader(templatesPath);

        controllerJSDir = _controllerJSDir;
    }

    /**
     * Write template to controller.
     *
     * @param templateName Template name.
     */
    public void writeTemplate(String templateName) {
        try {
            FileWriter controllerJSWriter = new FileWriter(getControllerJS(), true);

            controllerJSWriter.write(templatesReader.getTemplate(templateName));

            controllerJSWriter.close();
        } catch(IOException IOE) {
            System.out.println("IOException while writing template to 'controller.js'.");
        }
    }

    /**
     * Write JS code to controller.
     *
     * @param code JS Code.
     */
    public void writeCode(String code) {
        try {
            FileWriter controllerJSWriter = new FileWriter(getControllerJS(), true);

            controllerJSWriter.write(code);

            controllerJSWriter.close();
        } catch(IOException IOE) {
            System.out.println("IOException while writing code to 'controller.js'.");
        }
    }

    protected String getControllerJS() {
        return String.format(
            "%s%s%s",
            controllerJSDir,
            controllerJSDir.endsWith("\\") ? "" : "\\",
            BaseReactJSAppCreator.CONTROLLER_APP_PART_FILENAME
        );
    }
}
