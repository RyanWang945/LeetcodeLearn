import algorithmnote.*;
import leetcode._1twosum;
import org.junit.Test;

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
}
