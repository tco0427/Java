public class PizzaStore {
    //객체생성을 하는 createPizza()메소드가 있는 SimplePizzaFactory에 대한 래퍼런스
    SimplePizzaFactory factory;
    public PizzaStore(SimplePizzaFactory factory){
        this.factory=factory;
    }
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza=factory.createPizza(type);
        //new를 통한 인스턴스화가 제거, 팩토리를 사용하여 피자 객체를 만들고 이를 전달받는다. 구상클래스에 대한 직접적인 인스턴스 생성이 없다.
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
