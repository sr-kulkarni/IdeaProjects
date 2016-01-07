
import java.io.IOException;

/**
 * Created by Saurabh kulkarn1 on 1/7/2016.
 */
public class DumbSignal {

    private static final boolean RED = false;
    private static boolean GREEN = true;
    public StringBuilder name;
    private boolean LeftSignal;
    private boolean MainSignal;

    DumbSignal(String a,boolean status){
        this.name = new StringBuilder();
        this.name.append(a);
        this.LeftSignal = !status;
        this.MainSignal = status;
    }

    public synchronized void toggleLights(){
        this.LeftSignal = !this.LeftSignal;
        this.MainSignal = !this.MainSignal;
    }

    public void startOperation(DumbSignal XSignal) throws IllegalArgumentException{

        try {
            while (System.in.available() == 0) {

                if (this.LeftSignal == this.MainSignal || XSignal.LeftSignal == XSignal.MainSignal || this.MainSignal == XSignal.MainSignal)
                    throw new IllegalArgumentException("Signal Arguments are invalid!");
                try {
                    System.out.println(this.name + " Main Signal is" + this.MainSignal + " And " + XSignal.name + " Main Signal is" + XSignal.MainSignal);
                    Thread.sleep(1000);

                    this.toggleLights();
                    XSignal.toggleLights();
                } catch (InterruptedException ex) {
                    System.out.println("Some problem experienced in the process");
                }

            }
        }//try block
        catch(IOException ex){
            System.out.println("IO Exception caught");
        }

    }


    public static void main(String args[]){



        DumbSignal Montague = new DumbSignal("Montague",GREEN);
        DumbSignal Zanker = new DumbSignal("Zanker",RED);
        try {
            Montague.startOperation(Zanker);
        }
        catch(Exception ex){
            System.out.println("Some exception occured");
        }
    }



}
