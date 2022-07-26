public class SimplePizzaFactory {
    //피자 객체를 생성하는 부분(변경이 빈번하게 일어날 수 있는 부분)을 캡슐화하였다.
    public Pizza createPizza(String type){
        Pizza pizza=null;
        if(type.equals("cheese")){
            pizza=new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza=new PepperoniPizza();
        }else if(type.equals("clam")){
            pizza=new ClamPizza();
        }else if(type.equals("veggie")){
            pizza=new VeggiePizza();
        }
        return pizza;
    }
}
