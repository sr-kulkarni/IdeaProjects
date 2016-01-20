import java.util.Scanner;
import java.lang.*;
/**
 * Created by kulkarn1 on 1/20/2016.
 */
public class DiffGen {

    public String data;

    DiffGen(String S){
        this.data = new String(S);
    }

    void print(){
        System.out.println("The content is : "+ this.data);
    }

    void getLCS(DiffGen d2){

        int l1 = this.data.length();
        int l2 = d2.data.length();

        int lcs[][] = new int[l1+1][l2+1];



        for(int i = 0;i < l1+1;i++){
            for(int j =0; j< l2+1; j++){
                if(i==0 || j ==0){
                    lcs[i][j] = 0;
                    //System.out.println("0th element");
                }
                else if(this.data.charAt(i-1) == d2.data.charAt(j-1)){
                    //System.out.println("\nEqual character found!");
                    lcs[i][j] = lcs[i-1][j-1] + 1;

                }
                else{
                   // System.out.println("Not equal. Checking max");
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }

        System.out.println("The longest common sub sequence is of " + lcs[l1][l2] + " length");



    }

    public static void main(String args[]){

        DiffGen d1,d2;

        System.out.println("Enter the content for source #1 ");
        Scanner input = new Scanner(System.in);
        String S1 = input.nextLine();
        d1 = new DiffGen(S1);

        System.out.println("Enter the content for source #2");
        String S2 = input.nextLine();

        d2 = new DiffGen(S2);

        d1.getLCS(d2);
        //d1.print();
        //d2.print();



    }




}
