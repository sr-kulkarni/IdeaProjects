import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Saurabh on 1/12/16.
 */
public class BinTreeBaap extends Node{

    public boolean isRootPresent;

    BinTreeBaap(){
        this.isRootPresent = false;
    }

    public void addElements(){

        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("\nEnter a number, Enter -99999 to quit. : ");
            int x = input.nextInt();
            if(x == -99999)
                break;
            try{
                this.addNode(x);
            }
            catch(IllegalArgumentException ex){
                System.out.println("Invalid parameters!");
                break;
            }
        }
    }

    private void addNode(int stuff){

        if(!isRootPresent){
            this.data = stuff;
            System.out.println("Adding Root");
            isRootPresent = true;
            return;
        }
        Node temp = this;


        while(true){
            int checker = temp.data;
            System.out.println("Checker is  "+checker);
            if(checker >= stuff){
                if(temp.lchild == null) {
                    temp.lchild = new Node(stuff);
                    System.out.println("Adding node to left child of"+temp.data);
                    return;
                }
                temp = temp.lchild;
            }
            else if(checker < stuff){
                if(temp.rchild == null) {
                    temp.rchild = new Node(stuff);
                    System.out.println("Adding node to right child of"+ temp.data);
                    return;
                }
                temp = temp.rchild;
            }

        }

    }

    public void commonAncestor(int x, int y){
        /*
           Traverse the tree until you hit the element and store the path in an array.
           Repeat for the second element.
           Check two lists and find the node until they differ.
         */
        List l1 = new ArrayList();
        List l2 = new ArrayList();
        Node temp = this;
        while(true){
            int checker = temp.data;
            if(checker == x){
                break;
            }
           // System.out.println("Checker is  "+checker);
            if(x < checker){
                if(temp.lchild == null) {
                    //temp.lchild = new Node(stuff);
                    System.out.println("Node not found! Wrong value Entered");
                    return;
                }
                l1.add(temp.data);
                temp = temp.lchild;
            }
            else if(x > checker){
                if(temp.rchild == null) {
                    //temp.rchild = new Node(stuff);
                    System.out.println("Node not found! Wrong value entered");
                    return;
                }
                l1.add(temp.data);
                temp = temp.rchild;
            }

        }

        temp = this;
        while(true){
            int checker = temp.data;
            if(checker == y){
                break;
            }
            // System.out.println("Checker is  "+checker);
            if(y < checker){
                if(temp.lchild == null) {
                    //temp.lchild = new Node(stuff);
                    System.out.println("Node not found! Wrong value Entered");
                    return;
                }
                l2.add(temp.data);
                temp = temp.lchild;
            }
            else if(y > checker){
                if(temp.rchild == null) {
                    //temp.rchild = new Node(stuff);
                    System.out.println("Node not found! Wrong value entered");
                    return;
                }
                l2.add(temp.data);
                temp = temp.rchild;
            }

        }
        int i;
        for(i=0; i<l1.size() && i<l2.size();i++){
            if(l1.get(i) != l2.get(i))
                break;

        }
        System.out.println("The Lowest Common Ancestor is "+l1.get(i-1));



    }

    public void display(){
        this.inorder();
    }

    public static void main(String args[]){

        BinTreeBaap B = new BinTreeBaap();

        System.out.println("Lets start creating a Binary tree..");
        B.addElements();
        System.out.println("Your Binary tree is : ");
        B.display();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the element #1 :");
        int x = input.nextInt();
        System.out.println("Enter the element #2 ");
        int y = input.nextInt();

        B.commonAncestor(x,y);


    }



}
