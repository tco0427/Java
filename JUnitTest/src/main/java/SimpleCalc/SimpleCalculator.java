package SimpleCalc;

public class SimpleCalculator {
    private int res=0;
    public void add(int x,int y){
        res=x+y;
    }
    public void sub(int x,int y){
        res=x-y;
    }
    public void inc(int d){
        res+=d;
    }
    public void dec(int d){
        res-=d;
    }
    public int getResult(){
        return res;
    }
    public void addWithPositiveArgs(int x, int y) throws IllegalArgumentException{
        if(x<0||y<0) throw new IllegalArgumentException();
        res=x+y;
    }
    public void weirdAdd(int x,int y){
        if(x==5 && y==7){
            res=100;
        }else{
            res=x+y;
        }
    }
}
