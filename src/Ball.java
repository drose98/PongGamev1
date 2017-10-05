import java.awt.*;

public class Ball {

    private Game game;
    private int x, y, width, height;
    private int xVel, yVel;
    private int xStart, yStart;
    private boolean stationary = false;

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

    //MAIN TICK METHOD
    public void tick() {
//        if(stationary) {
//            this.reset();
//        }
//        if (game.getKeyManager().enter) {
//            this.restart();
//            xVel = -4;
//            yVel = 1;
//            }


            this.checkYBorder();
            this.checkPaddleCollision(game.getHuman(), game.getAI());
            this.checkPoints();
            this.changeYVel();

            x += xVel;
            y += yVel;

    }
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x,y,width,height);

        if (stationary) {
            g.setColor(Color.YELLOW);
            g.drawString("Hit ENTER to Start", 350, 100);
            }
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
                this.changeYVel();
            }
        }
        if ((x + width) == 770) {
            if((y + width) >= AI.getY() && y <= (AI.getY() + AI.getpHeight())) {
                xVel = -xVel;
                this.changeYVel();
            }
        }
    }

    public void checkPoints() {
        if (x < 1) {
            game.getAI().setScore(game.getAI().getScore() + 1);
        }
        if ((x + width) > 599) {
            game.getHuman().setScore(game.getHuman().getScore() + 1);
        }
        this.reset();
    }
    public void changeYVel() {
        if (game.getKeyManager().up) {
            yVel -= 1;
        }
        if (game.getKeyManager().down) {
            yVel += 1;
        }
    }

    public void reset() {
        x = 400 - width/2;
        y = 300 - height/2;
        xVel = 0;
        yVel = 0;
    }
    public void restart() {
        stationary = false;
    }


}
