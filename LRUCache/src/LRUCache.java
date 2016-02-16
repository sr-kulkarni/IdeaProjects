import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Saurabh on 2/15/16.
 */
public class LRUCache {

        public Node HEAD;
        public Node TAIL;
        public int size;

        HashMap<Integer,Node> tracker;

        LRUCache(int input){
            this.HEAD = null;
            this.TAIL = null;
            this.size = input;
        }

        private void add(int el){
            /*TBD*/


        }

        public void showStuff(){
            /*TBD*/
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
