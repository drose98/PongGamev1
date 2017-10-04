import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class myKeyListener implements KeyListener {

    private boolean isUp = false, isDown = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP {
            isUp = true;
        }
        if(key == KeyEvent.VK_DOWN) {
            isDown = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP {
            isUp = false;
        }
        if(key == KeyEvent.VK_DOWN) {
            isDown = false;
        }
    }

    public boolean getUp() {
        return isUp;
    }
    public boolean getDown() {
        return isDown;
    }
}
