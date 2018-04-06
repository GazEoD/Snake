import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitWindow extends JPanel implements ActionListener{

    private JFrame frame;
    private JButton bt_start;
    private JButton bt_option;
    private JButton bt_exit;


    public InitWindow() {

    }
    public void draw(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame = new JFrame("InitWindow.");
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

        bt_start.addActionListener(this);
        bt_option.addActionListener(this);
        bt_exit.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String bt_name = e.getActionCommand();

        if(bt_name.equals("Start")){
            Controler.closeInitWindow();
            Controler.showGamePanel();
        }else if(bt_name.equals("Option")){
            Controler.closeInitWindow();
            Controler.showOptionPanel();
        } else if(bt_name.equals("Exit")){
            Controler.exit();
        }
    }
    public void hideWindow(){
        frame.removeAll();
        frame.setVisible(false);
    }
}
