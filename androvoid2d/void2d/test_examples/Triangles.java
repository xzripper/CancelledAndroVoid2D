// Simple example how to draw rainbow triangles!

package androvoid2d.void2d.test_examples;

import androvoid2d.void2d.Window;
import androvoid2d.void2d.Figures;
import androvoid2d.void2d.Colors;

public class Triangles {
    public static void main(String[] args) {
        Window gameWindow = new Window(null, 1000, 800, true, true);

        Figures figuresFactory = new Figures(gameWindow);

        figuresFactory.triangle(
            new int[] {100, 100},

            Colors.colorRed
        );

        figuresFactory.triangle(
            new int[] {110, 110},

            Colors.colorGreen
        );

        figuresFactory.triangle(
            new int[] {120, 120},

            Colors.colorBlue
        );

        gameWindow.showWindow();
    }
}
