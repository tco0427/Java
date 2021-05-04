import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private Integer[] orderedList;

    Polynomial(){}
    Polynomial(String str){
        str=str.replace("x^"," ");
        str=str.replace("+"," ");
        str=str.replace("-"," -");
        String[] strings=str.trim().split(" ");

        List<Integer> bufList=new ArrayList<>();
        bufList.add(strings.length/2);
        for(int i=0;i<strings.length;i++){
            try {
                bufList.add(Integer.parseInt(strings[i]));
            }catch(NumberFormatException e){
                System.out.println("This input is malformed.");
                System.out.println("Exit the program.");
            }
        }
        this.orderedList=new Integer[bufList.size()];
        bufList.toArray(this.orderedList);
    }


    private Integer[] getOrderedList() {
        return this.orderedList;
    }

    public void setOrderedList(Integer[] orderedList) {
        this.orderedList = orderedList;
    }

    public static Polynomial add(Polynomial p1,Polynomial p2){
        List<Integer> bufList=new ArrayList<>();
        Integer[] p1Array=p1.getOrderedList();
        Integer[] p2Array=p2.getOrderedList();


        int m=p1Array[0];
        int n=p2Array[0];
        int p=2,q=2;
        int r=2;


        while((p<=(2*m)) && (q<=(2*n))){
            if(p1Array[p]==p2Array[q]){
                int sum=p1Array[p-1]+p2Array[q-1];
                if(sum!=0){
                    bufList.add(sum);
                    bufList.add(p1Array[p]);
                    r=r+2;
                }
                p=p+2;
                q=q+2;
            }else if(p1Array[p]<p2Array[q]){
                bufList.add(p2Array[q-1]);
                bufList.add(p2Array[q]);
                q=q+2;
                r=r+2;
            }else if(p1Array[p]>p2Array[q]){
                bufList.add(p1Array[p-1]);
                bufList.add(p1Array[p]);
                p=p+2;
                r=r+2;
            }
        }
        while(p<=(2*m)){
            bufList.add(p1Array[p-1]);
            bufList.add(p1Array[p]);
            p=p+2;
            r=r+2;
        }
        while(q<=(2*n)){
            bufList.add(p2Array[q-1]);
            bufList.add(p2Array[q]);
            q=q+2;
            r=r+2;
        }

        bufList.add(0,(r/2)-1);
        Integer[] integers=new Integer[bufList.size()];
        bufList.toArray(integers);
        Polynomial result=new Polynomial();
        result.setOrderedList(integers);
        return result;
    }

    public void printPolynomial(){
        System.out.print(orderedList[1]+"x^");
        System.out.print(orderedList[2]);
        for(int i=1;i<orderedList[0];i++){
            int num=i*2;
            if(orderedList[num+1]<0) {
                System.out.print(orderedList[num + 1] + "x^");
            }else{
                System.out.print("+"+orderedList[num+1]+"x^");
            }
            System.out.print(orderedList[num+2]);
        }
        System.out.println();
    }
}
