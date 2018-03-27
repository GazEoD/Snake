import java.awt.*;

public class Snake {
    GamePanel gameP;
    private Point[] body;
    public static final int MAXLENTH=50;
    private int head;
    private int tail;
    private int speed;
    public int length;
    public int x,y;
    public int r;

    public Snake(GamePanel gp){
        gameP = gp;
        body= new Point[MAXLENTH];
        head = -1;
        tail = -1;
        length = 1;
        speed = 10;
        x = 50;
        y = 50;
        r = 10;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        if(length>1){
            int i=tail;
            while(i!=head){
                g.fillOval(body[i].x,body[i].y,r,r);
                i=(i+1)%body.length;
            }
        }
        g.setColor(Color.RED);
        g.fillOval(body[head].x,body[head].y,r,r);
        if(length==1){
            length++;
        }
    }
    public void update(){
        int direction = gameP.getDirection();
        switch (direction){
            case GamePanel.SOUTH:
                y+=speed;
                break;
            case GamePanel.NORTH:
                y-=speed;
                break;
            case GamePanel.EAST:
                x+=speed;
                break;
            case GamePanel.WEST:
                x-=speed;
                break;
        }
        head=(head+1)%body.length;
        tail=(head+body.length-length+1)%body.length;
        body[head]=new Point(x,y);
        if(x > gameP.getWidth() || x < 0 || y > gameP.getHeight() || y < 0) {
            gameP.setStoped(true);
            System.out.println("触碰边界");

        }
    }
}
