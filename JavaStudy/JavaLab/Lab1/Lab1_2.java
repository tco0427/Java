package Lab1;

import java.util.Scanner;
//사용자로부터 정수(int) 값 두 개와 연산자(char)를 입력 받고, 두 수의 덧셈 (+), 뺄셈(-), 곱셈(*), 나눗셈(/), 나머지(%) 연산의 결과를 구하는 프로그램을 작성하라. switch 사용 할 것
public class Lab1_2 {
    Scanner sc=new Scanner(System.in);

    String input(){
        String str;
        System.out.print("정수 두 개와 연산자를 포함한 식을 입력하시오>>");
        str=sc.nextLine();
        return str;
    }

    void exec(String str){
        int a,b,result;
        String ob;
        String[] strarr=new String[3];

        strarr=str.split(" ");
        try{
            a=Integer.parseInt(strarr[0]);
            b=Integer.parseInt(strarr[2]);
        }
        catch(NumberFormatException e){
            System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
            return;
        }
        ob=strarr[1];


        if(ob=="+" || ob=="-" || ob=="*" || ob=="/" || ob=="%") {
            result = switchs(ob, a, b);
            System.out.println(a + ob + b + ":" + result);
        }
        else
            System.out.println("잘못된 입력입니다. 연산자를 확인해주세요.");
    }

    int switchs(String ob,int a,int b){
        int result=0;

        switch(ob){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
            case "%":
                result=a%b;
                break;
        }

        return result;
    }

    void run(){
        exec(input());
    }

    public static void main(String[] args) {
        Lab1_2 lab=new Lab1_2();
        lab.run();
    }
}
