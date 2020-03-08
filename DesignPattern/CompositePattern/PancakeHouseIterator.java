package IteratorPattern;

import java.util.ArrayList;
import java.util.*;

public class PancakeHouseIterator implements Iterator {
    ArrayList<MenuItem> items;
    int position=0;
    public PancakeHouseIterator(ArrayList<MenuItem> items){
        this.items=items;
    }
    public Object next(){
        MenuItem menuItem=items.get(position);
        position++;
        return menuItem;
    }
    public boolean hasNext(){
        if(position>=items.size() || items.get(position)==null){
            return false;
        }
        else return true;
    }
}
