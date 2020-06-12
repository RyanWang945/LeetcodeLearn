package 实验性测试;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ryan
 * @date 2020/6/10 9:22
 */
public class JuneTest {
    @Test
    public void testLambda(){
        //List<Integer> list=new ArrayList<>();
        Integer[] ints=new Integer[]{1,2,3,4,5};
        int[] ints2=new int[]{2,34,5,6,7,3,1};
        //Arrays.sort(ints, Collections.reverseOrder());
//        Arrays.sort(ints, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        Comparator c=(Object a,Object b)->{
            int ai=(int)a;
            int bi=(int)b;
            return bi-ai;
        };
        Arrays.sort(ints,c);
        for(int i:ints){
            System.out.println(i);
        }
        Arrays.sort(ints,(o1, o2) -> o2-o1);
        //List<Integer> list = Arrays.stream( ints ).boxed().collect(Collectors.toList());
        //list.forEach(System.out::println);
    }
    @Test
    public void testLambda2(){

    }
    public void test(TestA testA){

    }
    private interface TestA{
        public void print(String s);
        public void printBoth(String a,String b);
    }
    @Test
    public void testLambda3() {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 3}, {4, 8}, {2, 5}};
        Arrays.sort(edges, (o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]));
        class Edge{
            int start;
            int end;
            public  Edge(int start,int end){
                this.start=start;
                this.end=end;
            }
        }
        Edge[] edges2=new Edge[edges.length];
        for(int i=0;i<5;i++){
            edges2[i]=new Edge(edges[i][0],edges[i][1]);
        }

        Arrays.sort(edges2,(e1,e2)->(e1.start==e2.start?e2.end-e1.end:e2.start-e1.start));
    }
}

