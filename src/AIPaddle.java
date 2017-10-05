import java.awt.*;

public class AIPaddle {

    private int pWidth, pHeight;
    private int x, y;
    private Game game;
    private int score;

    public AIPaddle(Game game) {
        pWidth = 30;
        pHeight = 100;
        x = 770;
        y = 300 - 50;
        this.game = game;
        score = 0;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, pWidth, pHeight);
    }


    public int getpWidth() {
        return pWidth;
    }

    public int getpHeight() {
        return pHeight;
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
