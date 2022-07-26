package carttdd;


import java.util.HashMap;
import java.util.Iterator;

public class Cart {
    HashMap<String,Integer> map=new HashMap<>();
    PriceManager pm;

    public void put(String id){
        if(map.containsKey(id)){
            int n=(Integer)map.get(id);
            map.put(id,n+1);
        }else{
            map.put(id,1);
        }
    }
    public int getTotalNumberOfItemsInCart(String id){
        return (Integer)map.get(id);
    }
    public int totalPrice(){
        Iterator<String> itr=map.keySet().iterator();
        int total=0;
        while(itr.hasNext()){
            String id=itr.next();
            int intNum=map.get(id);
            if(pm.isOnePlusOneApplicable(id)==true){
                int Num1=intNum/2;
                intNum=Num1+(intNum%2);
            }
            total+=pm.getPrice(id)*intNum;
        }
        return total;
    }
    public void setPriceManager(PriceManager pm){
        this.pm=pm;
    }
}
