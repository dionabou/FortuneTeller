import javax.swing.*;
import java.awt.*;
public class FortuneTellerViewer
{
    public static void main(String[] args)
    {
        // Create and show the JFrame
        FortuneTellerFrame frame = new FortuneTellerFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}