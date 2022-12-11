// AV2DSprite.java - Part of AndroVoid2D.

package androvoid2d.GOCI.android_engine;

import androvoid2d.GOCI.TemplatesReader;

import androvoid2d.void2d.Sprite;

/**
 * AndroVoid2D Sprite.<br>
 * Copy of `void2d.Sprite`.
 */
public class AV2DSprite {
    protected final ObjectsBuffer objectsBuffer;

    protected final TemplatesReader templatesReader;

    protected final Controller controller;

    protected final Sprite engineSprite;

    /**
     * Initialize AV2D Sprite.
     *
     * @param _objectsBuffer Objects buffer.
     * @param _templatesReader Templates reader.
     * @param controllerJSDir Controller JS directory.
     * @param spritePath SpritePath.
     * @param spriteProperties Sprite properties.
     */
    public AV2DSprite(ObjectsBuffer _objectsBuffer, TemplatesReader _templatesReader, String controllerJSDir, String spritePath, int[] spriteProperties) {
        objectsBuffer = _objectsBuffer;
        templatesReader = _templatesReader;

        controller = new Controller(_templatesReader.templatesPath, controllerJSDir);

        engineSprite = new Sprite(
            null,

            spritePath,

            new int[] {
                spriteProperties[0],
                spriteProperties[1]
            },

            new int[] {
                spriteProperties[2],
                spriteProperties[3]
            }
        );
    }

    /**
     * Move sprite.
     *
     * @param x X.
     * @param y Y.
     * @param runtime Move sprite in runtime?
     */
    public void updateSpritePosition(int x, int y, boolean runtime) {
        if(!runtime) {
            engineSprite.updateSpritePosition(x, y);
        } else {
            controller.writeCode();
        }
    }

    /**
     * Add sprite to objects buffer.
     */
    public void registerSpriteInBuffer() {
        String spriteJSX = templatesReader.getTemplate("objects\\sprite.jsx")
            .replace("@spritePath", engineSprite.getSpritePath())
            .replace("@spriteWidth", String.valueOf(engineSprite.getSpriteSize()[0]))
            .replace("@spriteHeight", String.valueOf(engineSprite.getSpriteSize()[1]))
            .replace("@spriteX", String.valueOf(engineSprite.getSpritePosition()[0]))
            .replace("@spriteY", String.valueOf(engineSprite.getSpritePosition()[1]));

        objectsBuffer.addObject(spriteJSX);
    }
}
