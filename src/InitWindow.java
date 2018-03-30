import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class InitWindow extends JPanel implements ActionListener,Runnable{

    private JFrame frame;
    private JButton bt_start;
    private JButton bt_option;
    private JButton bt_exit;
    private int Choose_Flag = -1;


    public InitWindow() {
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
        if(e.getSource() == bt_start){
            System.out.print("Start");
            Choose_Flag = 1;
            return;
        }
        if(e.getSource() == bt_option){
            Choose_Flag = 2;
        }
        if(e.getSource() == bt_exit){
            Choose_Flag = 3;
        }

    }
    @Override
    public void run() {
        while(true){
            try {
                sleep(100);
                if(Choose_Flag != -1) {
                    frame.setVisible(false);
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getChoose_Flag() {
        return Choose_Flag;
    }
}
