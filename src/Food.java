import java.awt.*;
import java.util.Random;

public class Food {
    private GamePanel gameP;
    private Snake snk;
    public Point location;
    public Point size;
    private Random rand;

    public Food(GamePanel gp,Snake sk){
        gameP = gp;
        snk = sk;
        rand = new Random();
        location = new Point(Math.abs(rand.nextInt(gp.getWidth())%gameP.getWidth()),
                Math.abs(rand.nextInt(gp.getHeight())%gameP.getHeight()));
        size = new Point(sk.r,sk.r);

    }
    public void draw(Graphics g){
        g.setColor(Color.PINK);
        g.fillRect(location.x,location.y,size.x,size.y);
    }
    public void update(GamePanel gp){
        if((Math.pow(snk.x-location.x,2)+Math.pow(snk.y-location.y,2))<(snk.r*snk.r)){
            location=new Point(Math.abs(rand.nextInt(gp.getWidth())%gameP.getWidth()),Math.abs(rand.nextInt(gp.getHeight())%gameP.getHeight()));
            if(snk.length < Snake.MAXLENTH){
                snk.length++;
            }
        }
    }
}
