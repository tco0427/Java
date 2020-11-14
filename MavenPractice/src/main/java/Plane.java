import javax.inject.Singleton;

@Singleton
public class Plane implements Movable{
    public void go(){
        System.out.println("Plane flies...");
        System.out.println(".....");
        System.out.println(".....");
    }
    public void engineOn(){
        System.out.println("Plane engine started");
    }
    public void engineOff(){
        System.out.println("Plane engine stopped");
    }
}