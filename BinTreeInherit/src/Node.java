/**
 * Created by Saurabh on 1/2/16.
 */


public class Node{

    int data;
    Node lchild,rchild;

    Node(){
        this.data = 99999;
        this.lchild = null;
        this.rchild = null;
    }

    Node(int data_in,Node l_in, Node r_in){
        this.data = data_in;
        this.lchild = l_in;
        this.rchild = r_in;
    }

    public boolean isValid(){
        if(this.data == 99999)
            return false;
        return true;
    }

    void inorder(){
        System.out.print("  "+this.data);
        if(this.lchild != null)
            this.lchild.inorder();
        if(this.rchild != null)
            this.rchild.inorder();
    }

}




