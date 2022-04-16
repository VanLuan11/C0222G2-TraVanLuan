package ss11_dsa_stack_queue.bai_tap;


import java.util.Map;
import java.util.TreeMap;

public class CharacterCount {
    public static void main(String[] args) {
        String str = "Taichodien";
        str = str.toLowerCase();

        Map<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!treeMap.containsKey(str.charAt(i))) {
                treeMap.put(str.charAt(i), 1);
            } else {
                treeMap.put(str.charAt(i), (treeMap.get(str.charAt(i))+1));
            }
        }

        for (Map.Entry<Character,Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
