import com.google.inject.Inject;

public class Driver{
    private Movable m;
    @Inject
    public void setMovable(Movable m){
        this.m=m;
    }
    public void drive(){
        m.engineOn();
        m.go();
        m.engineOff();
    }
}