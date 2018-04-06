import com.sun.tools.internal.xjc.addon.sync.SynchronizedMethodAddOn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable,KeyListener {
    private int x,y;
    private int dx,dy;
    private int direction;
    public static final int SOUTH = 0;
    public static final int NORTH = 1;
    public static final int EAST = 2;
    public static final int WEST = 3;
    private Snake sk;
    private Food bk;
    private JFrame frame;
    private boolean isPaused = false;
    private boolean isStoped = false;
    Image im;
    Graphics g;

    public void setStoped(boolean stoped) {
        isStoped = stoped;
    }

    ImageIcon ima = new ImageIcon("res/123.png");

    public GamePanel() {
    }
    public void draw(){
        frame = new JFrame("Snack.");
        frame.setLocation(600,100);
        frame.setSize(500,300);
        frame.add(this);
        frame.setDefaultCloseOperation(3);

        x=50;
        y=50;
        dx=10;
        dy=10;
        addKeyListener(this);
        frame.setVisible(true);

        sk = new Snake(this);
        bk = new Food(this,sk);
        this.requestFocus();

        Thread thread = new Thread(this);
        thread.start();
    }
    public synchronized void gameUpdate(){
        sk.update();
        bk.update(this);
        System.out.println("direction: " + direction);
        switch (direction){
            case SOUTH:
                y=y+dy;
                break;
            case NORTH:
                y=y-dy;
                break;
            case EAST:
                x=x+dx;
                break;
            case WEST:
                x=x-dx;
                break;
        }
    }
    public void gameRender(Image im){
        Graphics dbg = im.getGraphics();
        dbg.drawImage(ima.getImage(),0,0,this.getWidth(),this.getHeight(),null);
        sk.draw(dbg);
        bk.draw(dbg);
    }
    public void gamePaint(Image im){
        g = this.getGraphics();
        g.drawImage(im,0,0,null);
    }

    public void run(){
        Thread t1 = Thread.currentThread();
        System.out.println("GamePanel: " + t1.getName());

        while(!isStoped){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            im = new BufferedImage(this.getWidth(),this.getHeight(),
                    BufferedImage.TYPE_4BYTE_ABGR);
            if(isPaused == false) {
                gameUpdate();
            }
            System.out.println(getDirection());
            gameRender(im);
            gamePaint(im);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e){
        Thread thread = Thread.currentThread();
        System.out.println("Key Thread: " + thread.getName());
        int keycode = e.getKeyCode();
        if(keycode == KeyEvent.VK_SPACE)
            isPaused = !isPaused;
        switch (keycode){
            case KeyEvent.VK_DOWN:
                if(direction!=NORTH)
                    direction = SOUTH;
                System.out.println("KEY: DOWN");
                break;
            case KeyEvent.VK_UP:
                if(direction!=SOUTH)
                    direction = NORTH;
                System.out.println("KEY: SOUTH");

                break;
            case KeyEvent.VK_RIGHT:
                if(direction!=WEST)
                    direction = EAST;
                System.out.println("KEY: EAST");

                break;
            case KeyEvent.VK_LEFT:
                if(direction!=EAST)
                    direction = WEST;
                System.out.println("KEY: WEST");
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    public int getDirection(){
        return direction;
    }
    public void hidePanel(){
        isStoped=true;
        frame.setVisible(false);
    }

}