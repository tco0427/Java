import java.util.Vector;

interface IStack<T>{
    T pop();
    void push(T ob);
}

class MyStack<T> implements IStack<T> {
    Vector<T> vect;
    public MyStack(){
        vect=new Vector<>();
    }
    public T pop(){
        if(vect.size()==0)
            return null;
        else
            return vect.remove(0);
    }
    public void push(T ob){
        vect.add(0,ob);
    }
}

public class Study{
    public static void main(String[] args) {
        IStack<Integer> stack=new MyStack<Integer>();
        for(int i=0;i<10;i++)
            stack.push(i);
        while(true){
            Integer n=stack.pop();
            if(n==null)
                break;
            System.out.print(n+" ");
        }
    }
}