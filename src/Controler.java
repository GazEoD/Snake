
public class Controler {

    private static InitWindow initWindow;
    private static OptionPanel optionPanel;
    private static GamePanel gamePanel;

    public static void Init(InitWindow init, OptionPanel option, GamePanel game){
        initWindow = init;
        optionPanel = option;
        gamePanel = game;
    }
    public static InitWindow getInitWindow() {
        return initWindow;
    }

    public static OptionPanel getOptionPanel() {
        return optionPanel;
    }

    public static GamePanel getGamePanel() {
        return gamePanel;
    }

    public static void showInitWindow(){
        initWindow.draw();
    }
    public static void closeInitWindow(){
        initWindow.hideWindow();
    }
    public static void showOptionPanel(){
        optionPanel.draw();
    }
    public static void closeOptionPanel(){
        optionPanel.hidePanel();
    }
    public static void showGamePanel(){
        gamePanel.draw();
    }
    public static void closeGamePanel(){
        gamePanel.hidePanel();
    }
    public static void exit(){
        System.exit(0);
    }
}
