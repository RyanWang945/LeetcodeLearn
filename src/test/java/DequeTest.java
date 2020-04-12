import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Ryan
 * @date 2020/3/31 10:37
 */
public class DequeTest {
    @Test
    public void testDeque(){
        Deque<Integer> queue=new ArrayDeque<>();
        queue.getLast();
    }
    @Test
    public void test1() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个整数");
        String str1=bufferedReader.readLine();
        Integer number=Integer.valueOf(str1);
    }
    @Test
    public void test2(){
        int[] arr={1,2,3,4,5};
        alter(arr);
        System.out.println(arr[0]);
    }
    private void alter(int[] arr){
        arr[0]=10;
        System.out.println(arr[0]);
    }
    @Test
    public void test3(){
        String a="aello";
        String b="hell";
        System.out.println(a.compareTo(b));

    }
    @Test
    public void test4(){
        String s="1000";
        char[] chs=s.toCharArray();
        int len=s.length()-1;
        List<Character> list=new ArrayList<>();
        for(int i=len;i>=0;i--){
            list.add(chs[i]);
        }
        for(Character i:list){
            System.out.println(i);
        }
        System.out.println(list.get(0)=='1');
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> a=new Stack<>();
        int n= (int) 1e+7;
        Stack<Integer> stack=new Stack<>();
        stack.peek();
    }
    @Test
    public void test5(){
        boolean flag=false;
        for(int i=0;i<1000;i++){
            int a=(int) (Math.random() * 3);
            if(a==3)
                flag=true;
        }
        System.out.println(flag);
    }
}
