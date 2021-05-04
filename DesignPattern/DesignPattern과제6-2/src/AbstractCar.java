//AbstractVehicle을 상속하는 추상클래스
//'탈 것'에 관한 내용뿐만 아니라 자동차와 관련된 속성과 기능(여기서는 기어박스에 대한 내용)을 추가해주었다.
//이를 상속하여 구현하는 클래스(Sport)에서 인스턴스를 생성할 수 있도록 하였다.
//바뀌는 부분과 바뀌지 않는 부분을 분리하고 기어박스에 대한 내용을 AbstractCar(혹은 서브클래스)에서 구현하지 않고 다른 클래스에 위임하고
//이에 대한 인터페이스 형식의 인스턴스 변수를 추가하였다. 이를 통해 기존의 코드를 변경하지 않고도 기어박스에 대한 내용을 변경할 수 있고
//새로운 기어가 추가되더라도 자동차에 관련된 AbstractCar는 영향을 받지 않는다.
public abstract class AbstractCar extends AbstractVehicle{
    //GearboxStrategy에 대한 composition이용
    private GearboxStrategy gearboxStrategy;
    public AbstractCar(Engine engine){
        super(engine);
        gearboxStrategy=new StandardGearboxStrategy();
    }
    public void setGearboxStrategy(GearboxStrategy gearboxStrategy){
        this.gearboxStrategy=gearboxStrategy;
    }
    public GearboxStrategy getGearboxStrategy(){
        return this.gearboxStrategy;
    }
    public void setSpeed(int speed){
        gearboxStrategy.ensureCorrectGear(getEngine(),speed);
    }


}
