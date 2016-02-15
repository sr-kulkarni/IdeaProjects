/**
 * Created by Saurabh on 2/14/16.
 */
public class Node {

    public int data;
    public Node lchild;
    public Node rchild;


    Node(int input){
        this.data = input;
        this.lchild = null;
        this.rchild = null;
    }

    public void inorder(){

        if(this.lchild != null){
            this.lchild.inorder();
        }
        System.out.print(" "+this.data);
        if(this.rchild != null){
            this.rchild.inorder();
        }

    }





}
