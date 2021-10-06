import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StringTest {
    @Test
    public void stringTest(){
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(0, "a");
        stringMap.put(1, "b");
        stringMap.put(2, "c");
        String sumString = "";
        for (Integer i : stringMap.keySet()) {
            sumString += stringMap.get(i);
        }
    }
}
