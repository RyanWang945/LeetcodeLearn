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
        //System.out.println(Integer.valueOf(a));
        StringBuffer sb=new StringBuffer("");
        System.out.println(sb.toString());
    }
    @Test
    public void testMatch(){
        String a="ab";
        String b="bb";
        System.out.println(a.compareTo(b));

    }
    @Test
    public void test(){
        Scanner sc=new Scanner(System.in);
        int len = sc.nextInt();
        String t=sc.nextLine();
        Map<String,Integer> map=new HashMap<>();
        String max="";
        int time=0;
        char[] chs=t.toCharArray();
        for(int i=0;i<=chs.length-len;i++){
            for(int j=i+len;j<=chs.length;i++){
                String temp=t.substring(i,j);
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }
        for(String s:map.keySet()){
            if(map.get(s)>time){
                time=map.get(s);
                max=s;
            }else if(map.get(s).equals(time)){
                if(max.compareTo(s)>0){
                    time=map.get(s);
                    max=s;
                }
            }
        }
        System.out.println(max+" "+time);
    }
    @Test
    public void testTreeMap(){
        List<Integer> list=new ArrayList<>();
        list.remove(list.size()-1);
    }
}
