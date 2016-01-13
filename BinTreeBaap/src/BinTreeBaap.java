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

    public void display(){
        this.inorder();
    }

    public static void main(String args[]){

        BinTreeBaap B = new BinTreeBaap();

        System.out.println("Lets start creating a Binary tree..");
        B.addElements();
        System.out.println("Your Binary tree is : ");
        B.display();

    }



}
