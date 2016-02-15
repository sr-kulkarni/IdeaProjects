import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Saurabh on 2/14/16.
 */
public class HeapTree {

    private Node root;
    public boolean isRoot;

    HeapTree(){
        this.root = new Node(0);
        isRoot = true;
    }


    private Node rockNRoll(ArrayList<Integer> temp,int start,int end){

        if(start > end){
            return null;
        }

        int mid = start+(end - start)/2;
        Node MidNode = new Node(temp.get(mid));

        MidNode.lchild = rockNRoll(temp,start,mid-1);
        MidNode.rchild = rockNRoll(temp,mid+1,end);

        return MidNode;

    }


    public void balanceIt(){

        //Create a Pseudo root first
        Node PSEUDO = new Node(0);
        PSEUDO.rchild = this.root;

        Node iterator1 = PSEUDO.rchild;
        Node iterator2 = PSEUDO;
        while(iterator1 != null){

            if(iterator1.lchild != null){
                Node temp = iterator1.lchild;
                iterator2.rchild = temp;
                iterator1.lchild = temp.rchild;
                temp.rchild = iterator1;
                iterator1 = temp;
            }
            else{
                iterator2 = iterator2.rchild;
                iterator1 = iterator1.rchild;
            }

        }

        System.out.println("Ok now we have a Linked List of sorts. :)");

        iterator1 = PSEUDO.rchild;
        this.root = iterator1;
        int size = 0;
        ArrayList<Integer> tempL = new ArrayList<>();
        while(iterator1 != null){
            size++;
            System.out.print(" "+iterator1.data);
            tempL.add(iterator1.data);
            iterator1 = iterator1.rchild;
        }

        System.out.println("\nNow time for some action. This is the real balancing act!");

        this.root = rockNRoll(tempL,0,size-1);

        System.out.println("Did it work? Lets check out : ");
        this.root.preorder();



    }



    private void addValue(int number){

        Node p = this.root;

        if(this.isRoot){
            p.data = number;
            this.isRoot = false;
            return;
        }

        boolean keepLooping = true;

        do {
            if (number <= p.data) {
                 if(p.lchild != null){
                   p = p.lchild;
                 }
                 else{
                     p.lchild = new Node(number);
                     keepLooping = false;
                 }
            }
            if (number > p.data) {
                if(p.rchild != null){
                    p = p.rchild;
                }
                else{
                    p.rchild = new Node(number);
                    keepLooping = false;
                }
            }

        }while(keepLooping);

    }



    public void addStuff(){

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a number : (Press -99999 to quit) ");
            int number = input.nextInt();
            if(number == -99999){
                System.out.println("Quitting..");
                break;
            }
            this.addValue(number);

        }

    }


    public void printInorder(){

        if(this.isRoot){
            System.out.println("Your tree isn't filled yet, mate");
            return;
        }
        this.root.inorder();
        System.out.println("Pre order is -");
        this.root.preorder();

    }



    public static void main(String args[]){

        HeapTree H = new HeapTree();

        System.out.println("Let's Start putting stuff in the heap.");
        H.addStuff();

        System.out.println("Done. Your inorder expression is : ");
        H.printInorder();

        System.out.println("\nNow lets try and balance it :-) ");
        H.balanceIt();



    }




}
