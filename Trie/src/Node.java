import java.util.HashMap;

/**
 * Created by kulkarn1 on 1/26/2016.
 */
public class Node {
    String data;
    HashMap <String,Node>  Map;


    Node(String S){
        this.data = new String(S);
        this.Map = new HashMap<>();
    }

}
