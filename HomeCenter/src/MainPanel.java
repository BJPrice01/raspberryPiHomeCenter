import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * shows a basic home page
 */
public class MainPanel extends DrawingPanel{
    Image img = Toolkit.getDefaultToolkit().getImage("./main.png");
    /**
     * shows an image
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Monospaced", Font.PLAIN, 12));
        g.setColor(Color.BLACK);
        g.drawImage(img, 0, 0, null);
        g.drawString("Brennan Price", 835, 560);
    }
}
