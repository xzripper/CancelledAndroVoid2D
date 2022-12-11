import androvoid2d.GOCI.BaseReactJSAppCreator;
import androvoid2d.GOCI.TemplatesReader;

import androvoid2d.GOCI.android_engine.ObjectsBuffer;
import androvoid2d.GOCI.android_engine.ObjectsBufferWriter;

import androvoid2d.GOCI.android_engine.AV2DSprite;

import androvoid2d.GOCI.android_engine.Controller;

public class Tests {
    public static void main(String[] args) {
//        BaseReactJSAppCreator.initTemplatesReader("src\\" + TemplatesReader.ANDRO_VOID2D_GOCI_TEMPLATES);
//
//        BaseReactJSAppCreator.doAll(
//            "src\\test_app\\my_app\\",
//            "src\\test_app\\my_app\\",
//            "src\\test_app\\my_app\\",
//            "src\\test_app\\",
//            "my_app"
//        );

        ObjectsBuffer gameObjectsBuffer = new ObjectsBuffer();

        TemplatesReader templatesReader = new TemplatesReader("src\\" + TemplatesReader.ANDRO_VOID2D_GOCI_TEMPLATES);

        AV2DSprite av2dSprite = new AV2DSprite(
            gameObjectsBuffer,
            templatesReader,
            "src\\test_app\\my_app\\",
            "ball.png",
            new int[] {
                5, 5,
                150, 150
            }
        );

        av2dSprite.registerSpriteInBuffer();

        AV2DSprite av2DSprite2 = new AV2DSprite(
            gameObjectsBuffer,
            templatesReader,
            "src\\test_app\\my_app\\",
            "ball.png",
            new int[] {
                50, 50,
                150, 150
            }
        );

        av2DSprite2.updateSpritePosition(250, 250, true);

        av2DSprite2.registerSpriteInBuffer();

        ObjectsBufferWriter.rewriteBuffer(
            gameObjectsBuffer,
            "src\\" + TemplatesReader.ANDRO_VOID2D_GOCI_TEMPLATES,
            "src\\test_app\\my_app\\app.js"
        );

        // TODO!!!!!!!!!!!!!!!!!: WRITE CONTENT REMOVER (FRON CONTROLLER, APP, APPINDEX ETC BY CLASS)

        Controller gameController = new Controller(templatesReader.templatesPath, "src\\test_app\\my_app\\");

//        gameController.writeCode("console.log('Hello World!')");
    }
}


// new Sprite(window, spritepath, x, y, width, height)
// ->
// <img src="spritepath" x=x y=y width=width height=height>
