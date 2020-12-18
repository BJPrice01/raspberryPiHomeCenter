import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class DrawingPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
    }
    public DrawingPanel(){
        setBackground(new Color(99,99,95));
    }
}
