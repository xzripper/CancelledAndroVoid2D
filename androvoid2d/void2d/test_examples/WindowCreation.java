// Simple example, how to create window.

package androvoid2d.void2d.test_examples;

import androvoid2d.void2d.Window;

public class WindowCreation {
    public static void main(String[] args) {
        Window gameWindow = new Window(null, 1000, 1000, false, false);

        gameWindow.showWindow();
    }
}
