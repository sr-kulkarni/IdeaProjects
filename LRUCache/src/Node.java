/**
 * Created by Saurabh on 2/15/16.
 */
public class Node {

    public int data;
    Node next,prev;

    Node(int input){
        this.data = input;
        this.next = null;
        this.prev = null;
    }

    Node(int input,Node n,Node p){
        this.data = input;
        this.next = n;
        this.prev = p;
    }



}
