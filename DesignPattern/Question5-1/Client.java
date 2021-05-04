public class Client {
    public static void main(String[] args) {
        //Vehicle형 참조변수로 Saloon객체를 참조한다.
        //이 때 생성자로 StandardEngine인스턴스를 전달하였다.
        Vehicle myCar=new Saloon(new StandardEngine(1300));
        //AbstractVehicle에서 정의된 paint()인스턴스 메소드를 통해 myCar가 참조하는 인스턴스의 인스턴스 변수 colour를
        //Vehicle에서 정의한 열거형 상수 Colour의 BLUE로 해준다.
        myCar.paint(Vehicle.Colour.BLUE);
        //myCar가 참조하는 인스턴스를 인자로 전달하였고, 이는 toString()메소드의 호출로 이어진다.
        System.out.println(myCar);

        /*
        이후 myCar가 참조하는 인스턴스를 AbstractVehicleOption추상클래스를 구현하는 구상클래스들의 생성자의 인자로 전달한다.
        이를 통해 Saloon객체를 AirConditionedVehicle등의 AbstractVehicleOption을 구현하는 객체들로 감쌀 수 있고,
        getPrice()에 대해서 재귀적인 호출을 할 수 있는 등 기능을 확장할 수 있다.
        그리고 그 객체를 myCar참조변수로 다시 참조한다. 이렇게 할 수 있는 이유는 AbstractCar,AbstractVan,AbstractVehicleOption는 모두
        상위클래스로 AbstractVehicle을 가지고 Vehicle형참조변수(myCar) 참조가능하기 때문이다.
         */
        myCar=new AirConditionedVehicle(myCar);
        System.out.println(myCar);

        myCar=new AlloyWheeledVehicle(myCar);
        System.out.println(myCar);

        myCar=new LeatherSeatedVehicle(myCar);
        System.out.println(myCar);

        myCar=new MetallicPaintedVehicle(myCar);
        System.out.println(myCar);

        myCar=new SatNavVehicle(myCar);
        System.out.println(myCar);
    }
}
