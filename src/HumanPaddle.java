import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HumanPaddle {

    private int pWidth, pHeight;
    private int x, y, yMov;

    public HumanPaddle() {
        pWidth = 30;
        pHeight = 80;
        x = 0;
        y = 300 - 40;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        y += yMov;
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            yMov = 1;
        }
        if (key == KeyEvent.VK_DOWN) {
            yMov = -1;
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            yMov = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            yMov = 0;
        }
    }



}
