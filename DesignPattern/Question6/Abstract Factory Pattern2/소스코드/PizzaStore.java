public abstract class PizzaStore {
	//PizzaFactory인터페이스형 참조변수 factory
	protected PizzaFactory factory;
	public PizzaStore(){
	}
 
	public Pizza orderPizza(String type) {
		//참조하는 factory의 createPizza메소드를 호출하고 있다.(이 메소드를 통해서 피자 객체 생성)
		Pizza pizza = factory.createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
