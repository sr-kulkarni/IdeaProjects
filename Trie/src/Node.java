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

    public boolean exists(String S){
        if(this.data.equals(""+S.charAt(0))){
            //System.out.println("Equals" + S.charAt(0));
            if(S.length() == 1)
                return true;
            else{
                if(this.map.get(""+S.charAt(1)) != null){
                    Node p = this.map.get(""+S.charAt(1));
                    //System.out.println("Checking for substring");
                    return p.exists(S.substring(1));
                }
                return false;
            }

        }
        else{
            return false;
        }

    }

}
