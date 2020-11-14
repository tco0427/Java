import com.google.inject.AbstractModule;

public class InjectorModule extends AbstractModule{
    protected void configure(){
        bind(Movable.class).to(Plane.class);
    }
}