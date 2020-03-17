import java.util.*;

public class A0811SubdomainCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] stringArray = cpdomains[i].split(" ");
            String domain = "." + stringArray[1];
            Integer times = Integer.valueOf(stringArray[0]);
            while (domain.contains(".")) {
                domain = domain.substring(domain.indexOf(".") + 1);
                map.compute(domain, (String key, Integer value) -> (value == null ? times : value + times));
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
//            list.add(entry.getValue() + " " + entry.getKey());
            //use stringbuffer
            StringBuffer sb = new StringBuffer();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            list.add(sb.toString());
        }
        return list;
    }


    public List<String> subdomainVisits2(String[] cpdomains) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] stringArray = cpdomains[i].split(" ");
            String domain = stringArray[1];
            Integer times = Integer.valueOf(stringArray[0]);
            while (true) {
                Integer indexOfDot = domain.indexOf(".");

                map.compute(domain, (String key, Integer value) -> (value == null ? times : value + times));

                domain = domain.substring(indexOfDot + 1);
                if(indexOfDot<0){
                    break;
                }

            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            StringBuffer sb = new StringBuffer();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            list.add(sb.toString());
        }
        return list;
    }
}
