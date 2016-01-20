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

    void getDiff(DiffGen d2){

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

        //System.out.println("The longest common sub sequence is of " + lcs[l1][l2] + " length");

        /*
         Now that we have the matrix ready, lets traverse it backwards to see the actual common sequence
         */
        int index = lcs[l1][l2];
        char[] seq =  new char[index+1];
        seq[index] = '\0';
        int i = l1;
        int j = l2;

        while(i   >0 && j > 0){

            if(this.data.charAt(i-1) == d2.data.charAt(j-1)){
                seq[index-1] = this.data.charAt(i-1);
                i--;
                j--;
                index--;
            }
            else if(lcs[i-1][j] > lcs[i][j-1]){
                i--;
            }
            else{
                j--;
            }

        }
        String CommonSeq = new String(seq);
        //System.out.println("\nThe longest subsequence is : "+S3);

        /*
        Now that we have the common subsequence, lets see the diff output
         */

        String Comp;
        if (l1 > l2){
            Comp = this.data;
        }
        else{
            Comp = d2.data;
        }

        System.out.println("Here's the Diff output : ");

        i = 0;
        j = 0;

        for (i = 0; i<Comp.length(); i++){
            if(Comp.charAt(i) == CommonSeq.charAt(j)){
                j++;
            }
            else{
                System.out.print(Comp.charAt(i));
            }
        }



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

        d1.getDiff(d2);
        //d1.print();
        //d2.print();



    }




}
