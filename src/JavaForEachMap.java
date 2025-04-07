import java.util.HashMap;
import java.util.Map;

public class JavaForEachMap {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<String,String>();
        map.put("A","Alex");
        map.put("B","Brian");
        map.put("C","Chris");
        map.put("D","Denver");
        map.forEach((k,v)->System.out.println("Key :"+k+" Value :"+v));
    }
}
