public class CheesePizza extends Pizza {
	//원재료 공장 PizzaIngredientFactory형 참조변수
	PizzaIngredientFactory ingredientFactory;
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	//기존의 NYCheesePizza와 ChicagoCheesePizza를 보면 서로 다른 재료를 사용한다는 것을 제외하고는 모두 동일하였다.
	//원재료factory가 추가되면서 이 두 클래스를 하나로 합치고 원재료공장에 따라서 서로 다른 재료를 다룰 수 있게 되었다.
	//분점마다 피자클래스를 따로만들어줄 필요가 없어졌다.
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
