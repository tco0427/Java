public enum State {
    GAS(1),
    SOLID(2),
    LIQUID(3),
    UNKOWN(4);

    private final int value;
    State(int value){
        this.value=value;
    }
    public int getValue(){
        return this.value;
    }
    public static State valueOf(int value){
        for(State state: State.values()){
            if(state.getValue()==value){
                return state;
            }
        }
        return null;
    }
    public static State nameOf(String name){
        for(State state:State.values()){
            if((String.valueOf(state.getValue()).equals(name)) || state==State.valueOf(name)){
                return state;
            }
        }
        return null;
    }
    public static String[] names(){
        String names[]=new String[State.values().length];
        for(State state: State.values()){
            names[state.ordinal()]=state.toString();
        }
        return names;
    }
}
