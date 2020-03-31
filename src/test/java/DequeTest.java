import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

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
}
