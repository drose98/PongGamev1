import javax.net.ssl.KeyManager;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Game implements Runnable {

    private Thread thread;
    private boolean running = false;
    private int width, height;
    private String title;
    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    HumanPaddle Human;
    AIPaddle AI;
    Ball ball;

//Constructor
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new myKeyListener();
    }
    private void itemInit() {
        Human = new HumanPaddle(this);
        AI = new AIPaddle(this);
        ball = new Ball(this);
    }

    private myKeyListener keyManager;

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        itemInit();
    }


    private void tick() {
        keyManager.tick();
        Human.tick();
        AI.tick();
        ball.tick();
    }


    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0,width,height);
        //Draw Here
        Human.render(g);
        AI.render(g);
        ball.render(g);



        //End Drawing
        bs.show();
        g.dispose();
    }

    @Override   //Loop engine
    public void run() {

        init();


        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();


        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                delta--;
            }
        }

        stop();
    }

    public myKeyListener getKeyManager() {
        return keyManager;
    }

    public synchronized void start() {
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public HumanPaddle getHuman() {
        return Human;
    }
    public AIPaddle getAI() {
        return AI;
    }


}
