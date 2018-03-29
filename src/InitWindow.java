import javax.swing.*;
import java.awt.*;

public class InitWindow extends JPanel{

    private JButton bt_start;
    private JButton bt_option;
    private JButton bt_exit;

    private JLabel bg;

    public InitWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame("InitWindow");
        frame.setLocation(screenSize.width/2 - 200,screenSize.height/2 - 150);
        frame.setSize(350,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);


        bt_start = new JButton("Start");
        bt_option = new JButton("Option");
        bt_exit = new JButton("Exit");
//        bt_start.setOpaque(false);
//        bt_start.setBorder(null);                 按钮透明
//        bt_start.setContentAreaFilled(false);


        setLayout(null);
        setSize(frame.getSize());


        add(bt_start);
        bt_start.setBounds(getWidth()/4,210,150,40);
        add(bt_option);
        bt_option.setBounds(getWidth()/4,260,150,40);
        add(bt_exit);
        bt_exit.setBounds(getWidth()/4,310,150,40);

        this.setVisible(true);
        frame.setContentPane(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("res/bg.png");
        Image image = icon.getImage();
        g.drawImage(image,0,0,icon.getIconWidth()-100,icon.getIconHeight()+120,icon.getImageObserver());
    }

    public static void main(String[] args){
        InitWindow window = new InitWindow();

    }

}
