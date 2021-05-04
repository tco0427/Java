public abstract class PizzaStore {
	//Pizza인스턴스를 만드는 일은 이제 팩토리 역할을 하는 메소드에서 맡아서 처리한다.
	abstract Pizza createPizza(String item);
	//상위클래스에 해당하는 PizzaStore의 orderPizza()메소드에서는 어떤 피자가 만들어지는지 전혀 알 수 없다.
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
