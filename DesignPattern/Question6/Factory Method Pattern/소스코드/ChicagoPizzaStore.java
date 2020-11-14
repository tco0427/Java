public class ChicagoPizzaStore extends PizzaStore {
    //피자가 만들어지는 로직(객체 생성 부분)을 서브클래스에서 구현한다.
	Pizza createPizza(String item) {
    if (item.equals("cheese")) {
      return new ChicagoStyleCheesePizza();
    } else if (item.equals("veggie")) {
      return new ChicagoStyleVeggiePizza();
    } else if (item.equals("clam")) {
      return new ChicagoStyleClamPizza();
    } else if (item.equals("pepperoni")) {
      return new ChicagoStylePepperoniPizza();
    } else {
      return null;
    }
	}
}
