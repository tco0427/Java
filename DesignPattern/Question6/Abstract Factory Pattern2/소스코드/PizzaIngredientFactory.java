//피자를 만들 때 모두 도우를 사용하고, 치즈, 소스등을 사용한다.
//이렇게 피자를 생성하는데 필요한 원재료들에 대한 객체들로 이루어진 군을 생성하기 위한 인터페이스
public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}
