package 刷题.牛客;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/8/5 9:41
 */
public class _08_05_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int curSize = 0;
        LinkedHashMap<String, Long> map = new LinkedHashMap<>();
        while (in.hasNext()) {
            String curInput = in.nextLine();
            String[] stringArray = curInput.split(" ");
            String curKey = stringArray[0];
            long curValue = Long.parseLong(stringArray[1]);
            if (map.containsKey(curKey)) {
                if (map.get(curKey) < curValue) {
                    map.remove(curKey);
                    map.put(curKey, curValue);
                }
            } else {
                if (curSize < n) {
                    curSize++;
                } else {
                    for (String s : map.keySet()) {
                        System.out.println(s + " " + map.get(s));
                        map.remove(s);
                        break;
                    }
                }
                map.put(curKey, curValue);
            }
        }
    }
}
