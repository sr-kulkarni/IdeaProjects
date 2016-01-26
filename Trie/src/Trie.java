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

    private void insert(Node p,String S){


        if(p.map.containsKey(""+S.charAt(0))){

            if(S.length() > 1){
                Node p2 = p.map.get(""+S.charAt(0));
                if(p2.map.get(""+S.charAt(1)) == null){
                    p2.map.put(""+S.charAt(1),new Node());
                }
                insert(p2,S.substring(1));
            }


        }
        //Match not found
        else{
            p.data= ""+S.charAt(0);
            if(S.length() > 1){
                Node p2 = p.map.get(""+S.charAt(1));
                if(p2 == null){
                    p.map.put(""+S.charAt(1),new Node());
                }
                p2 = p.map.get(""+S.charAt(1));
                insert(p2,S.substring(1));
            }
        }

    }

    public void addElements(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Enter a String  :");
            String userS = new String(input.next());
            System.out.println("Your string is "+ userS);
            this.rootNode = new Node();
            this.insert(this.rootNode,userS);
            System.out.println("End? Enter 'END' to end or anything else to keep rollin'");
            String next = input.next();
            if(next.equals("END"))
                break;
        }

    }


    public static void main(String args[]){
        Trie T = new Trie();

        System.out.println("Try putting some crap in a Trie");
        T.addElements();
        System.out.println("Now lets see if that oddity worked..");
        System.out.println("Enter a string to check :");
        Scanner input = new Scanner(System.in);
        String S = input.next();
        if(T.rootNode.exists(S))
            System.out.println("Your String exists!");
        else
            System.out.println("No go bro..");



    }



}
