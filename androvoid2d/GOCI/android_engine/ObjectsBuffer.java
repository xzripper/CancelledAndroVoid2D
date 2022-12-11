// ObjectsBuffer.java - Part of AndroVoid2D;

package androvoid2d.GOCI.android_engine;

import java.util.ArrayList;

/**
 * Objects buffer.<br>
 * Contains objects that created in Java and converted to ReactJS.
 */
public class ObjectsBuffer {
    /**
     * Objects buffer.
     */
    public final ArrayList<String> buffer = new ArrayList<>();

    /**
     * Add new ReactJS code to buffer.
     *
     * @param rsjc ReactJS code.
     */
    public void addObject(String rsjc) {
        buffer.add(rsjc);
    }

    /**
     * Get buffer.
     */
    public ArrayList<String> getBuffer() {
        return buffer;
    }
}
