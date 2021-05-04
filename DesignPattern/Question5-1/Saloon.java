//AbstractCar를 구현한 Saloon구상클래스
//두가지 생성자에 대해서 오버로딩하였고, getPrice()추상메소드에 대한 구체적은 구현을 하였다.
public class Saloon extends AbstractCar {
    public Saloon(Engine engine) {
        super(engine);
    }
    public Saloon(Engine engine, Colour colour) {
        super(engine, colour);
    }
    @Override
    public int getPrice(){
        return 6000;
    }
}
