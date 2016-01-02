import java.util.Scanner;

/**
 * Created by Saurabh on 1/2/16.
 */
public class BinTreeInherit extends Node{

    boolean rootPresent;

    BinTreeInherit(){
        rootPresent = false;
        this.data = -99999;
        this.lchild = null;
        this.rchild = null;
    }

    /*
    Need some sanitization here
     */
    public void inorderDisplay(){
        if(!rootPresent){
            System.out.println("Nothing to display.");
            return;
        }

        System.out.print("  "+this.data);
        if(this.lchild != null){
            Node ln = this.lchild;
            ln.inorder();
        }

        if(this.rchild != null){
            Node rn = this.rchild;
            rn.inorder();
        }


    }

    public void addNode(Node N_in) throws IllegalArgumentException{
        if(!N_in.isValid()) {
            throw new IllegalArgumentException("You're trying to add an empty node!");
        }

        if(!rootPresent){
            System.out.println("First addtion. Root added!");
            this.rootPresent = true;
            this.data = N_in.data;
            return;
        }
        else{
            Node n = this;
            /*
            After checking if the root exists or not, we traverse left or right depending on the value of the node/Input
            If Input < Value present, we keep going left
            If Input >= value present, we go right.
            As soon as we hit null on lchild/rchild we link the input
             */
            while(true){
                if(N_in.data < n.data){
                    if(n.lchild == null) {
                        n.lchild = new Node(N_in.data,null,null);
                        return;
                    }
                    n = n.lchild;
                }
                if(N_in.data >= n.data){
                    if(n.rchild == null) {
                        n.rchild = new Node(N_in.data,null,null);
                        return;
                    }
                    n = n.rchild;
                }

            }//while end. theoretically.


        }//else ends.

    }//addNode ends.




    public static void main(String args[]){

        BinTreeInherit tree = new BinTreeInherit();

        System.out.println("Creating a binary search tree. Java Style.");
        Scanner input = new Scanner(System.in);


        while(true){
            System.out.println("\nEnter a number, Enter -99999 to quit. : ");
            int x = input.nextInt();
            if(x == -99999)
                break;
            try{
                Node N_in = new Node(x,null,null);
                tree.addNode(N_in);
            }
            catch(IllegalArgumentException ex){
                System.out.println("Invalid parameters!");
                break;
            }
        }

        System.out.println("\nTree is constructed! In-order traversal coming below: ");

        tree.inorderDisplay();


    }

}
