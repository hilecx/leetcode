import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class A0359LoggerRateLimiter {
    class Logger {
        Map<String,Integer> map = new  HashMap<>();
        int count = 0;
        /** Initialize your data structure here. */
        public Logger() {

        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if(count>50){
                cleanMap(timestamp);
            }
            if(timestamp < map.getOrDefault(message,-10) ){
                return false;
            }else {
                map.put(message, timestamp+10);
                count++;
                return true;
            }
        }

        private void cleanMap(int timestamp){
            Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,Integer> entry = iterator.next();
                if(timestamp - entry.getValue()>= 10){
                    iterator.remove();
                }
            }
        }
    }
}
