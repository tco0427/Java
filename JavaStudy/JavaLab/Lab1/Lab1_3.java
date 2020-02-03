package Lab1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
//사용자로부터 입력 받은 숫자들(array of double numbers) 중에서 가장 큰 값(max), 가장 작은 값(min), 중앙 값 (median), 평균 값(mean) 결과를 구하 는 프로그램을 작성하라.
// If n is odd, Median = value of ((n + 1)/2)
// If n is even, Median = value of [((n)/2) + ((n)/2 - 1) ]/2
public class Lab1_3 {
    Scanner sc=new Scanner(System.in);
    ArrayList<Double> list;

    String input(){
        System.out.print("실수형 값들을 입력하시오(공백으로 구분)>>");
        String str=sc.nextLine();

        return str;
    }

    void dblist(String str){
        String[] strarr=str.split(" ");
        int len=strarr.length;
        list=new ArrayList<>();

        for(int i=0;i<len;i++){
            list.add(Double.valueOf(strarr[i]));
        }
        Collections.sort(list);
    }

    void compare(){
        double max,min,median,mean;
        int len=list.size();
        int  med;

        if(len%2==0)
            med=(len+1)/2;
        else
            med=(((len)/2) + ((len)/2 - 1))/2;

        max=list.get(0);
        min=list.get(0);
        median=list.get(med);
        mean=0;
        for(double n: list){
            if(max<n)
                max=n;
            if(min>n)
                min=n;

            mean=mean+n;
        }
        mean=mean/len;

        System.out.println("max: "+max);
        System.out.println("min: "+min);
        System.out.println("median: "+median);
        System.out.println("mean: "+mean);
    }

    void run(){
        dblist(input());
        compare();
    }

    public static void main(String[] args) {
        Lab1_3 lab=new Lab1_3();

        lab.run();
    }

}
