package ss11_dsa_stack_queue.exersice.count_occurrences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountOccurrence {
    public static void main(String[] args) {
        String str = "Toi thay hom nay la mot ngay khong dep lam nhung hom nay toi cung khong vui lam";
        String[] strings = str.toLowerCase().split(" ");
        System.out.println(Arrays.toString(strings));
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String key : strings) {
            if (treeMap.containsKey(key)) {
                Integer value = treeMap.get(key);
                value++;
                treeMap.replace(key, value);
            } else {
                treeMap.put(key, 1);
            }
        }
        System.out.println(treeMap);
    }
}
