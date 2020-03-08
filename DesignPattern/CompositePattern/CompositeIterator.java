package IteratorPattern;
import java.util.*;

public class CompositeIterator implements Iterator {
    Stack stack=new Stack();

    public CompositeIterator(Iterator iterator){
        stack.push(iterator);
    }

    public Object next(){
            Iterator iterator=(Iterator)stack.peek();
            MenuComponent component=(MenuComponent)iterator.next();
            if(component instanceof Menu){
                stack.push(((Menu) component).createIterator());
            }
            return component;
    }
    public boolean hasNext(){
        if(stack.empty()){
            return false;
        }
        else{
            Iterator itr=(Iterator)stack.peek();
            if(!itr.hasNext()){
                stack.pop();
                return hasNext();
            }
            else{
                return true;
            }
        }
    }
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
