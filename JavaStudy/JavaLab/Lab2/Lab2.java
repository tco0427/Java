package Lab2;

import java.util.Scanner;

public class Lab2{
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            System.out.print("도형의 모드(번호)를 입력하시오: ");
            calculate(UserInput.getInteger());
        }

        //enhanced for문
        String[] arr={"TRIANGLE","RECTANGLE","TRAPEZOID","TRIANGLE","CIRCLE"};

        for(String s:arr){
            calculate(s);
        }

        String check;
        do{
            System.out.print("도형의 이름을 입력하시오(종료는 q): ");
            check=UserInput.getString();
            if(check.equals("q")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            calculate(check);
        }while(true);
    }
    public static void calculate(int mode){
        printAreaSize(area(mode));
    }
    public static void calculate(String name){
        printAreaSize(area(name));

    }
    public static void printAreaSize(double area){
        if(area==-1.0){
            System.out.println("잘못된 입력입니다.");
        }
        else if(area==-1.1){
            System.out.println("길이가 0보다 작을 수 없습니다.");
        }
        else if(area<=50){
            System.out.println("면적이 50이하");
        }
        else if(area<=70){ //앞의 if(area<=50)에서 area가 50이하인 조건은 검사하였음. 따라서 다시 50보다 작은지 검사할 필요 없음
            System.out.println("면적이 51이상 70이하");
        }
        else if(area>70){
            System.out.println("면적 71이상");
        }
    }
    public static double area(int mode){
        switch(mode){
            case AreaCalculator.CIRCLE:
                System.out.print("Please input circle radius: ");
                double radius=UserInput.getDouble();
                if(radius<0)
                    return -1.1;
                return AreaCalculator.circleArea(radius);
            case AreaCalculator.RECTANGLE:
                System.out.print("Please input rectangle width:");
                double width=UserInput.getDouble();
                System.out.print("Please input rectangle height:");
                double height=UserInput.getDouble();
                if(width<0||height<0)
                    return -1.1;
                return AreaCalculator.rectArea(width,height);
            case AreaCalculator.TRIANGLE:
                System.out.print("Please input triangle width:");
                width=UserInput.getDouble();
                System.out.print("Please input triangle height:");
                height=UserInput.getDouble();
                if(width<0||height<0)
                    return -1.1;
                return AreaCalculator.triArea(width,height);
            case AreaCalculator.TRAPEZOID:
                System.out.print("Please input trapezoid width:");
                width=UserInput.getDouble();
                System.out.print("Please input trapezoid height:");
                height=UserInput.getDouble();
                if(width<0||height<0)
                    return -1.1;
                return AreaCalculator.trapArea(width,height);
            default:
                return -1.0;
        }
    }
    public static double area(String name){
        if(name.contentEquals("CIRCLE")){
            System.out.print("Please input circle radius:");
            double radius=UserInput.getDouble();
            return AreaCalculator.circleArea(radius);
        }
        else if(name.contentEquals("RECTANGLE")){
            System.out.print("Please input rectangle width:");
            double width=UserInput.getDouble();
            System.out.print("Please input rectangle height:");
            double height=UserInput.getDouble();
            return AreaCalculator.rectArea(width,height);
        }
        else if(name.contentEquals("TRIANGLE")){
            System.out.print("Please input triangle width:");
            double width=UserInput.getDouble();
            System.out.print("Please input triangle height:");
            double height=UserInput.getDouble();
            return AreaCalculator.triArea(width,height);
        }
        else if(name.contentEquals("TRAPEZOID")){
            System.out.print("Please input trapezoid width:");
            double width=UserInput.getDouble();
            System.out.print("Please input trapezoid height:");
            double height=UserInput.getDouble();
            return AreaCalculator.trapArea(width,height);
        }
        else
            return -1.0;
    }
}

class AreaCalculator{
    public static final int CIRCLE=0;
    public static final int RECTANGLE=1;
    public static final int TRIANGLE=2;
    public static final int TRAPEZOID=3;

    public static double circleArea(double radius){
        return Math.PI * radius * radius;
    }
    public static double rectArea(double a,double b){
        return a*b;
    }
    public static double triArea(double a,double b){
        return (a*b)/2;
    }
    public static double trapArea(double a,double b){
        return (a*b)/2;
    }
}

class UserInput{
    static Scanner sc=new Scanner(System.in);
    public static double getDouble(){
        return Double.parseDouble(sc.nextLine());
    }
    public static String getString(){
        return sc.nextLine();
    }
    public static int getInteger(){
        return Integer.parseInt(sc.nextLine());
    }
}
