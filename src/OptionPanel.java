import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPanel extends JPanel implements ActionListener{

    private JLabel lb_level;
    private JLabel lb_1;
    private JLabel lb_2;
    private JLabel lb_3;

    private ButtonGroup group;
    private JRadioButton rb_easy;
    private JRadioButton rb_middle;
    private JRadioButton rb_high;

    private JButton bt_Ok;
    private JFrame frame;

    Parameter level;


    public OptionPanel(){

    }
    public void draw(){
        frame = new JFrame("Snack.");
        frame.setLocation(600,100);
        frame.setSize(300,500);
        frame.add(this);

        lb_level = new JLabel("Level: ");
        lb_1 = new JLabel("E");
        lb_2 = new JLabel("M");
        lb_3 = new JLabel("D");

        group = new ButtonGroup();

        rb_easy = new JRadioButton();
        rb_middle = new JRadioButton();
        rb_high = new JRadioButton();

        bt_Ok = new JButton("OK");
        bt_Ok.addActionListener(this);

        rb_easy.setActionCommand("easy");
        rb_middle.setActionCommand("middle");
        rb_high.setActionCommand("high");

        group.add(rb_easy);
        group.add(rb_middle);
        group.add(rb_high);

        setLayout(null);
        add(lb_level);
        lb_level.setBounds(10,200,50,40);
        add(lb_1);
        lb_1.setBounds(80,220,50,40);
        add(lb_2);
        lb_2.setBounds(150,220,50,40);
        add(lb_3);
        lb_3.setBounds(220,220,50,40);


        add(rb_easy);
        rb_easy.setBounds(70,250,35,35);
        add(rb_middle);
        rb_middle.setBounds(145,250,35,35);
        add(rb_high);
        rb_high.setBounds(215,250,35,35);

        add(bt_Ok);
        bt_Ok.setBounds(110,300,80,35);

        rb_easy.addActionListener(this);
        rb_middle.addActionListener(this);
        rb_high.addActionListener(this);


        frame.add(this);
        frame.setVisible(true);
    }
    public void hidePanel(){
        frame.setVisible(false);
    }
    public void showPanel(){
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "easy":
                level = Parameter.EASY;
                break;
            case "middle":
                level = Parameter.MIDDLE;
                break;
            case "high":
                level = Parameter.HIGH;
                break;
            case "OK":
                Preferences.preferences.setSpeed(level);
                Controler.closeOptionPanel();
                Controler.showInitWindow();
                break;
            default:
                break;
        }
    }
}
