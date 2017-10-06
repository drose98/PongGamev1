import java.awt.*;

public class Ball {

    private Game game;
    private int x, y, width, height;
    private int xVel, yVel;
    private boolean stationary = true;

    public Ball(Game game) {
        width = 10;
        height = 10;
        x = 400 - width/2;
        y = 300 - height/2;
        this.game = game;
        xVel = 0;
        yVel = 0;
    }

    //MAIN TICK METHOD
    public void tick() {

            this.startinput();
            this.checkYBorder();
            this.checkPaddleCollision(game.getHuman(), game.getAI());
            this.checkPoints();

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
        if ((y + height) > 600 || y < 0) {
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
            this.reset();

        }
        if ((x + width) > 799) {
            game.getHuman().setScore(game.getHuman().getScore() + 1);
            this.reset();
        }

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
        stationary = true;
    }
    public void startinput() {
        if(stationary && game.getKeyManager().enter) {
            xVel = -5;
            yVel = 0;
            stationary = false;
        }
    }



}
