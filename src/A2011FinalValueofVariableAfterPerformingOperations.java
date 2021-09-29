import java.util.HashMap;
import java.util.Map;

public class A2011FinalValueofVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("++X", 1);
        map.put("X++", 1);
        map.put("--X", -1);
        map.put("X--", -1);
        for (int i = 0; i < operations.length; i++) {
            x += map.get(operations[i]);
        }
        return x;
    }
}
