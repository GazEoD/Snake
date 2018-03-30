import javax.swing.*;

public class Main {

    public static void main(String[] args){
        InitWindow initWindow = new InitWindow();

        Thread t1 = new Thread(initWindow);
        t1.run();
        System.out.println(initWindow.getChoose_Flag());


        GamePanel panel = new GamePanel();
        Thread thread = new Thread(panel);
        thread.start();
    }
}
