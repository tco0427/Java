import java.util.Scanner;

public class Switch {
    Scanner sc=new Scanner(System.in);
    int[][] arr=null;
    int row,column;

    void run(){
        makearr();
        input();
        programming();
        print();
    }
    void print(){
        int row=arr.length;
        int column=arr[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    int [][] change(int[][] arr,int a,int b){
        int row=arr.length;
        int column=arr[0].length;
        if(a==0){
            for(int i=0;i<column;i++){
                if(arr[b][i]==0) {
                    arr[b][i] = 1;
                }
                else if(arr[b][i]==1){
                    arr[b][i]=0;
                }
            }
        }
        else if(a==1){
            for(int i=0;i<row;i++){
                if(arr[i][b]==0){
                    arr[i][b]=1;
                }
                else if(arr[i][b]==1){
                    arr[i][b]=0;
                }
            }
        }

        return arr;
    }
    void programming(){
        int count=sc.nextInt();

        for(int i=0;i<count;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr=change(arr,a,(b-1));
        }
    }
    void input(){
        int row=arr.length;
        int column=arr[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                arr[i][j]=sc.nextInt();
            }
        }
    }
    void makearr(){
        String str=sc.nextLine();
        String[] arrs=str.split(" ");
        int a=Integer.parseInt(arrs[0]);
        int b=Integer.parseInt(arrs[1]);
        int[][] intarr=new int[a][b];
        arr=intarr;
    }
    public static void main(String[] args) {
        Switch main=new Switch();

        main.run();
    }
}
