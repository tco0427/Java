package calculatortdd;

public class Calculator {
    private int value;
    public Calculator(){
        this.value=0;
    }
    public Calculator(int n){
        this.value=n;
    }
    public int getResult(){
        return this.value;
    }
    public void add(int n){
        this.value=this.value+n;
    }
    public void clear(){
        this.value=0;
    }
}
