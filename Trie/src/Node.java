import java.util.HashMap;

/**
 * Created by kulkarn1 on 1/26/2016.
 */
public class Node {
    String data;
    HashMap <String,Node>  map;


    Node(){
        this.data = new String("This is Root!");
        this.map = new HashMap<>();
    }

}
