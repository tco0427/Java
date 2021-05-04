public class NYPizzaStore extends PizzaStore {
 
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		//뉴욕분점에서는 뉴욕분점에 맞게끔 원재료를 제공하여주는 factory를 참조한다.
		PizzaIngredientFactory ingredientFactory = 
			new NYPizzaIngredientFactory();
 		//각 피자를 만들 때 원재료를 제공하여주는 factory에 대한 래퍼런스도 함께 전달하여준다.
		if (item.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		} else if (item.equals("veggie")) {
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
		} else if (item.equals("clam")) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
		} else if (item.equals("pepperoni")) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
		} 
		return pizza;
	}
}
