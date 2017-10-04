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

//Constructor
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }



    private void init() {
        display = new Display(title, width, height);
        Human = new HumanPaddle();
        KeyListener klistener = new myKeyListener();
        addKeyListener(klistener);
    }

    public void update() {
        Human.move();
    }

    private void tick() {
        update();
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
        g.setColor(Color.CYAN);
        g.fillRect(0, Human.getY(), 30, 80);




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


}
