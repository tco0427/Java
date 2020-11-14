//PizzaIngredientFactory를 구현한다.
//어느 분점이든지 도우와 소스, 치즈등의 재료는 필요할 것이다.
//다만 이에 대한 구체적인 구현은 각 분점의 원재료공장에서 도맡아 한다.
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory
{
	//뉴욕분점에 맞게끔 재료들을 만듭니다.
	public Dough createDough() {
		return new ThickCrustDough();
	}
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}
	public Clams createClam() {
		return new FrozenClams();
	}
}
