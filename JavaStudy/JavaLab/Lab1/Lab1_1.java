package Lab1;

import java.util.Scanner;
import java.math.*;

public class Lab1_1 {
    Scanner sc=new Scanner(System.in);


    double getDouble(){
        double n;

        System.out.print("실수 하나를 입력하시오>>");
        n=sc.nextDouble();

        return n;
    }

    void showDouble(double n){
        //소수점 셋째 자리 아래 버림
        //형변환을 이용한 방법
        System.out.println("소수점 셋째 자리 아래 버림:"+((int)(n*1000))/1000.0);
        //소수점 셋째 자리에서 올림
        //Math api의 ceil함수를 이용한 방법
        System.out.println("소수점 셋째 자리에서 올림:"+Math.ceil((n*100))/100.0);
        //소수점 셋째 자리에서 반올림
        //printformat을 이용하여 반올림한 결과
        System.out.printf("%s: %.2f\n","소수점 셋째 자리에서 반올림",n);
    }
    public static void main(String[] args) {
        Lab1_1 lab=new Lab1_1();
        lab.showDouble(lab.getDouble());
    }
}
