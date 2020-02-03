package Lab1;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
사용자로 부터 돈의 액수(integer)를 입력받아, 오만 원권, 만 원권, 오천 원 권, 천원, 500원, 100원, 50원, 10원, 1원짜리
 동전 각 몇 개로 변환되는 지 출력하라. 예를 들어, 65537이 입력되면 오만 원권 1매, 만 원권 1매, 오천 원권 1매, 100원짜리 동전 3개, 50원짜리 동전 1개, 10원짜리 동전 2개를 출 력한다.
 각 단위의 돈을 출력할 때에는 줄을 바꿔서 출력한다.
 */

public class Lab1_4 {
    Scanner sc=new Scanner(System.in);

    int input(){
        int cash;
        System.out.print("돈의 액수를 입력하시오(정수)>>");

        try {
            cash = sc.nextInt();
        }
        catch(InputMismatchException e){
            return -1;
        }

        return cash;
    }
    void check(int n){
        if(n<0){
            System.out.println("잘못된 형식의 입력입니다!!"+'\n'+"실수를 입력하셨거나, 돈의 액수가 0보다 작습니다.");
            return;
        }
        else
            printmoney(n);
    }

    void printmoney(int money){
        if(money>=50000){
            System.out.println("오만원: "+money/50000);
            money=money%50000;
        }
        if(money>=10000){
            System.out.println("만원: "+money/10000);
            money=money%10000;
        }
        if(money>=5000){
            System.out.println("오천원: "+money/5000);
            money=money%5000;
        }
        if(money>=1000){
            System.out.println("천원: "+money/1000);
            money=money%1000;
        }
        if(money>=500){
            System.out.println("오백원: "+money/500);
            money=money%500;
        }
        if(money>=100){
            System.out.println("백원: "+money/100);
            money=money%100;
        }
        if(money>=50){
            System.out.println("오십원: "+money/50);
            money=money%50;
        }
        if(money>=10){
            System.out.println("십원: "+money/10);
            money=money%10;
        }
        if(money>=1){
            System.out.println("원: "+money/1);
        }
    }


    void run(){
        check(input());
    }

    public static void main(String[] args) {
        Lab1_4 lab=new Lab1_4();
        lab.run();
    }
}
