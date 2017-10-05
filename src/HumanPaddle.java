import java.awt.*;

public class HumanPaddle {

    private int pWidth, pHeight;
    private int x, y;
    private Game game;
    private int score;

    public HumanPaddle(Game game) {
        pWidth = 30;
        pHeight = 100;
        x = 0;
        y = 300 - 50;
        this.game = game;
        score = 0;
    }

    public void tick() {
        if(game.getKeyManager().up) {
            y -= 7;
        }
        if(game.getKeyManager().down) {
            y += 7;
        }
        this.checkBorder();
    }

    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, pWidth, pHeight);
    }

    public void checkBorder() {
        if (y < 0) {
            y = 0;
        }
        if ((y + pHeight) > 600) {
            y = 600 - pHeight;
        }
    }
    public int getpWidth() {
        return pWidth;
    }

    public int getpHeight() {
        return pHeight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
