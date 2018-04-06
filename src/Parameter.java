public enum Parameter {
    EASY(5),MIDDLE(10),HIGH(15);

    private final int value;

    private Parameter(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
