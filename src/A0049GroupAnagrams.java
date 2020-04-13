import java.util.*;

public class A0049GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Character,Integer>[] maps = new Map[strs.length];
        for (int i = 0; i < strs.length; i++) {
            maps[i]=new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++) {
                maps[i].put(strs[i].charAt(j),maps[i].getOrDefault(strs[i].charAt(j),0)+1);
            }
        }
        List<List<String>> r = new ArrayList<>();
        Map<Character,Integer> tmp;
        for (int i = 0; i < maps.length; i++) {
            if(maps[i]==null){
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            tmp=maps[i];
            maps[i]=null;
            for (int j = i+1; j < maps.length; j++) {
                if(tmp.equals(maps[j])){
                    list.add(strs[j]);
                    maps[j]=null;
                }
            }
            r.add(list);
        }
        return r;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String tmps = String.valueOf(tmp);
            List<String> list = map.getOrDefault(tmps,new ArrayList<>());
            list.add(strs[i]);
            map.put(tmps,list);
        }
//        List<List<String>> r = new ArrayList<>();
//        for (List<Integer> value : map.values()) {
//            List<String> list = new ArrayList<>();
//            for (Integer integer : value) {
//                list.add(strs[integer]);
//            }
//            r.add(list);
//        }
        return  new ArrayList(map.values());

    }


    public static void main(String[] args) {
        List<List<String>> a = new A0049GroupAnagrams().groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                System.out.printf("%s ",a.get(i).get(j));
            }
            System.out.println();
        }
    }
}
