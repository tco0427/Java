import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main{
    public static void main(String[] args) {
        Injector injector= Guice.createInjector(new InjectorModule());
        Driver p1=injector.getInstance(Driver.class);
        p1.drive();
    }
}