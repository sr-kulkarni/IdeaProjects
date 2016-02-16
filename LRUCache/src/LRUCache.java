import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Saurabh on 2/15/16.
 */
public class LRUCache {

        public Node HEAD;
        public Node TAIL;
        public int size;
        private int count;
        HashMap<Integer,Node> tracker;

        LRUCache(int input){
            this.HEAD = null;
            this.TAIL = null;
            this.size = input;
            this.count = 0;
            this.tracker = new HashMap<Integer,Node>();
        }

        private boolean get(int el){
            if(this.tracker.containsKey(el) && this.tracker.get(el) != null)
                return true;
            return false;
        }

        private void set(int el){

            if(count<size){
                   Node p = new Node(el,this.HEAD,null);
                   if(count == 0){
                       this.HEAD = p;
                       this.TAIL = p;
                       this.HEAD.next = this.TAIL;
                       this.HEAD.prev = null;
                       this.TAIL.next = null;
                       this.TAIL.prev = this.HEAD;
                       this.count++;
                   }
                   else{
                       this.HEAD.prev = p;
                       this.HEAD = p;
                       this.count++;
                   }
                   this.tracker.put(el,p);
                   this.showStuff();
            }
            /*
            If we've reached the size limit already
             */
            else{
                /*
                We first remove the first element in the queue, and then insert the new one.
                 */
                System.out.println("Tail data to be removed: "+this.TAIL.data);
                this.tracker.remove(this.TAIL.data);
                Node p = this.TAIL.prev;
                p.next = null;

                this.TAIL = p;

                Node q = new Node(el,this.HEAD,null);
                this.HEAD.prev = q;
                this.HEAD = q;
                this.tracker.put(el,q);
            }

        }

        private void update(int el){
            Node p = this.tracker.get(el);
            if(p == this.HEAD){
                System.out.println(el+" is already in the HEAD position.");
                return;
            }
            Node q = p.prev;
            q.next = p.next;
            p.next = this.HEAD;
            this.HEAD.prev = p;
            this.HEAD = p;
            this.tracker.put(el,p);
            System.out.println("HEAD updated!");

        }


        private void add(int el){
            /*TBD*/

            /* First we check if the element exists already. If yes, we bring it to the front of the queue.
            If not, we create a new node and assign it to front. There are some more internal steps involved here
            at the queue side. These are described in those respective function calls.
            */

            if(this.get(el)){
                /*
                 The element exists.
                 */
                System.out.println("Cache hit!");
                this.update(el);
            }

            else{
                System.out.println("Adding a new entry to the Cache");
                this.set(el);
            }

        }

        public void showStuff(){
            Node p = this.HEAD;
            while(p != null){
                System.out.print(" "+p.data);
                p = p.next;
            }
        }

        public void addStuff(){

            boolean flag = true;

            do{
                System.out.println("Enter a number : (-99999 to Quit) ");
                Scanner input = new Scanner(System.in);

                int el = input.nextInt();
                if(el == -99999){
                    flag = false;
                }
                else{
                    this.add(el);
                }

            }while(flag);

            System.out.println("Quitting...");
        }




        public static void main(String args[]){

            System.out.println("Welcome to the LRU Cache simulator!\nPlease Enter your desired Page size (0<size<10): ");
            Scanner input = new Scanner(System.in);

            int pageSize = input.nextInt();
            LRUCache cache = new LRUCache(pageSize);

            System.out.println("Okay, lets start putting stuff into this Cache.");

            cache.addStuff();

            System.out.println("Ok. Now your cache looks something like this ->");

            cache.showStuff();



        }




}
