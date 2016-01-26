import java.util.Scanner;

/**
 * Created by kulkarn1 on 1/26/2016.
 */
public class Trie {
    boolean isRoot;
    Node rootNode;


    Trie(){
        this.isRoot = true;
        Node rootNode = null;
    }

    public void addElements(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Enter a String  :");
            String userS = new String(input.next());
            System.out.println("Your string is "+ userS);
            System.out.println("End? Enter 'END' to end");
            String next = input.next();
            if(next.equals("END"))
                break;
        }

    }


    public static void main(String args[]){
        Trie T = new Trie();

        System.out.println("Try putting some crap in a Trie");
        T.addElements();



    }



}
