package 实验性测试;

import org.junit.Test;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/5/2 20:02
 */
public class MayTest {
    @Test
    public void test1() {
        int[][] nums = new int[10][10];
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }

    @Test
    public void test2() {
        int p = 1;
        p <<= 1;
        System.out.println(p);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        System.out.println(map.firstKey() + " " + map.lastKey());
    }

    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    @Test
    public void test3() {
        ArrayList<Character> list=new ArrayList<>();
        list.add(null);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(0).equals(list.get(1)));
    }
    @Test
    public void test4(){
        char a='1';
        System.out.println(Integer.valueOf(a));
    }
}
