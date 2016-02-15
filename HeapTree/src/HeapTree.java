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


    /*public Node balanceIt(){

    }*/



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

    }



    public static void main(String args[]){

        HeapTree H = new HeapTree();

        System.out.println("Let's Start putting stuff in the heap.");
        H.addStuff();

        System.out.println("Done. Your inorder expression is : ");
        H.printInorder();




    }




}
