
public class Main {

    public static void main(String[] args){

        InitWindow initWindow = new InitWindow();
        OptionPanel optionPanel = new OptionPanel();
        GamePanel gamePanel = new GamePanel();

        Preferences.newInstance();
        System.out.println(Parameter.EASY.getValue());
        Preferences.initParameter(Parameter.EASY,0);

        Controler.Init(initWindow,optionPanel,gamePanel);
        Controler.showInitWindow();
    }
}
