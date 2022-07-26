public class NYPizzaStore extends PizzaStore {
	//NYPizzaStore를 생성하면 NYPizzaFactory인스턴스를 생성하고 이를 factory인스턴스변수로 참조하게 된다.
	public NYPizzaStore(){
		factory=new NYPizzaFactory();
	}
}
