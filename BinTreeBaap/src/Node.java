/**
 * Created by Saurabh on 1/12/16.
 */
public class Node {

    protected int data;
    protected Node lchild,rchild;

    Node(){
        this.data = -99999;
        this.lchild = this.rchild = null;
    }

    Node(int value){
        this.data = value;
        this.lchild = this.rchild = null;
    }

    Node(Node js){
        this.data = js.data;
        this.lchild = js.lchild;
        this.rchild = js.rchild;
    }

    public void inorder(){
        System.out.print("\t"+this.data);
        if(this.lchild != null)
            this.lchild.inorder();
        if(this.rchild != null)
            this.rchild.inorder();

    }

}
