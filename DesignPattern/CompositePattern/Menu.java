package IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents=new ArrayList<>();
    String name;
    String description;

    public Menu(String name,String description){
        this.name=name;
        this.description=description;
    }
    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }
    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }
    public MenuComponent getChile(int i){
        return menuComponents.get(i);
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public void print(){
        System.out.print('\n'+getName());
        System.out.println(", "+getDescription());
        System.out.println("---------------------");
        Iterator<MenuComponent> itr=menuComponents.iterator();
        while(itr.hasNext()){
            MenuComponent menuComponent=itr.next();
            menuComponent.print();
        }
    }

    public Iterator createIterator(){
        return new CompositeIterator(menuComponents.iterator());
    }
}
