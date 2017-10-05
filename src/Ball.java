import java.awt.*;

public class Ball {

    private Game game;
    private int x, y, width, height;
    private int xVel, yVel;
    private int xStart, yStart;

    public Ball(Game game) {
        width = 10;
        height = 10;
        x = 400 - width/2;
        y = 300 - height/2;
        xStart = x;
        yStart = y;
        this.game = game;
        xVel = -5;
        yVel = -1;
    }

    public void tick() {
        this.checkYBorder();
        this.checkPaddleCollision(game.getHuman(), game.getAI());

        x += xVel;
        y += yVel;

    }
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x,y,width,height);
    }

    public void checkYBorder() {
        if (y > 600 || (y + height) < 0) {
            yVel = -yVel;
        }
    }
    public void checkPaddleCollision(HumanPaddle Human, AIPaddle AI) {
        if (x == 30) {
            if((y + width) >= Human.getY() && y <= (Human.getY() + Human.getpHeight())) {
                xVel = -xVel;
            }
        }
        if ((x + width) == 770) {
            if((y + width) >= AI.getY() && y <= (AI.getY() + AI.getpHeight())) {
                xVel = -xVel;
            }
        }
    }

//    public void checkPoint() {
//        if (x < 1) {
//            AI.setScore(AI.getScore() + 1);
//        }
//        if ((x + width) > 599) {
//            Human.setScore(Human.getScore() + 1);
//        }
//    }


}
