public class ChicagoPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza(String item){
        Pizza pizza = null;

        //피자를 생성하는 팩토리에서 다시 한 번 더 피자에 들어가는 원재료에 대한 팩토리를 만들어 3단계의 레벨을 갖게끔 하였다.
        PizzaIngredientFactory ingredientFactory =
                new ChicagoPizzaIngredientFactory();

        if (item.equals("cheese")) {
            //피자를 만들면서 원재료factory에 대한 래퍼런스를 전달한다.
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");

        } else if (item.equals("veggie")) {

            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("Chicago Style Veggie Pizza");

        } else if (item.equals("clam")) {

            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");

        } else if (item.equals("pepperoni")) {

            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("Chicago Style Pepperoni Pizza");

        }
        return pizza;
    }
}
