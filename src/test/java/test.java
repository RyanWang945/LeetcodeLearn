import algorithmnote.*;
import leetcode._1twosum;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @author Ryan
 * @date 2019/12/28 22:43
 */
public class test {
    @Test
    public void test_1twosum(){
        int[] nums={1,2,3,4,5,6,7};
        int target= 13;
        _1twosum a=new _1twosum();
        int[] ans=a.twoSum(nums,target);
        for(int i : ans){
            System.out.println(i);
        }
    }
    @Test
    public void test_PATB1001(){
        int a=100;
        PATB1001 test=new PATB1001();
        System.out.println(test.callatz(a));
    }
    @Test
    public void test_PATB1032(){
        int a=6;

    }
    @Test
    public void test_printf(){
        int x=1000;
        System.out.printf("%,.2f",x/3.0);
    }
    @Test
    public void test_sort(){
        int[] array={2,3,4,7,5,6,8,9,1};
        InsertSort a=new InsertSort();
        int[] array1=a.sort(array);
        for(int i=0;i<array1.length;i++){
            System.out.println(array1[i]);
        }
    }
    @Test
    public void test_Bubblesort(){
        int[] array={2,9,4,7,5,6,8,9,1};
        Bobblesort b=new Bobblesort();
        int[]result=b.BubbleSort(array);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
    @Test
    public void test_Shellsort(){
        int[] array={23,11,22,56,78,97,3,6,7,55,45,9,32,28,85,13};
        ShellSort s=new ShellSort();
        int[]result=s.shellsort(array);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
    @Test
    public void test_char(){
        String a="a";
        char[] c=a.toCharArray();
    }
    @Test
    public void test(){
        System.out.println(5-2==3-0);
    }
    @Test
    public void testLinkedHashMap(){
        Map<Integer,Integer> map=new LinkedHashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(6,3);
        map.put(5,4);
        map.put(3,3);
        for(int i:map.keySet()){
            System.out.println(map.get(i));
        }
        Set<Integer> set=new HashSet<>();
        int res=1;
        for(int i=0;i<29;i++){
            res=res*2;
        }
        System.out.println(res);
    }
    @Test
    public void testList(){
        List<Integer[]> list=new ArrayList<>();
        list.add(new Integer[]{1,2});
        list.add(new Integer[]{2,3});
        list.add(new Integer[]{3,4});
        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[][] res=(int[][])list.toArray();
        String[] str=new String[]{"str","sess","sfewf"};
        Arrays.sort(str);
        BigDecimal a=new BigDecimal(100.0001111);
        double v = a.setScale(4, RoundingMode.HALF_DOWN).doubleValue();
        String s="aaa";
        String ss="sdsf";
    }
    @Test
    public void testQueue(){
        Queue<int[]> queue=new ArrayDeque<>();
        Queue<Integer[]> queue2=new ArrayDeque<>();

    }
    @Test
    public void testList1(){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        list.remove(3);
        System.out.println(list.get(9));
    }
    @Test
    public void test1(){
        Integer a=0b0001;
        Integer b=0b0011;
        System.out.println(a&b);
        List<Integer> temp=new ArrayList<>();

    }
    @Test
    public void test2(){
        ArrayList<Integer> list=new ArrayList<>();
        int[] a=new int[0];
        Arrays.copyOfRange(a,0,2);
        Properties properties = System.getProperties();
        for(Object o:properties.keySet()){
            System.out.print(o);
            System.out.print(" ：");
            System.out.println(properties.get(o));
        }
    }
}
