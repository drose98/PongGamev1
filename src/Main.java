import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;

public class Main {

    public static void main(String[] args) {

            JFrame myFrame = new JFrame("Sample Frame");
            myFrame.setSize(600,800);
            myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            myFrame.setVisible(true);
            myFrame.setTitle("Pong");

    }
}
