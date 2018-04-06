public class Preferences {

    public static Preferences preferences;

    private Parameter speed;
    private int model;
    private boolean isStart;

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public static void newInstance() {
        preferences = new Preferences();
    }
    public static void initParameter(Parameter speed,int model){
        preferences.setSpeed(speed);
        preferences.setModel(model);
    }

    public Parameter getSpeed() {
        return speed;
    }

    public void setSpeed(Parameter speed) {
        this.speed = speed;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }
}
