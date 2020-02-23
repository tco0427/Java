package MyClass;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;


//Not use hasMoreTokens()

class Example {
    public static void main(String[] args) {
        StringTokenizer st=new StringTokenizer("12 + 36 - 8 / 2 = 44","+-/=");

        while(true){
            try{
                System.out.print(st.nextToken());
            }
            catch(NoSuchElementException e){
                break;
            }
        }
    }
}

