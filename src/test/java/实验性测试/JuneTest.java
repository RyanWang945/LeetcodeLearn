package 实验性测试;


import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
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
    @Test
    public void testHashMap(){
        List<MyNode>list =new ArrayList<>();
        list.sort((node1,node2)->(node1.count-node2.count));
        String s="asb";
        s.split("a");
        String s1 = s.toLowerCase();
        char c = s.charAt(0);

    }
    class MyNode{
        int i;
        int count;
        public MyNode(int i,int count){
            this.i=0;
            this.count=count;
        }
    }
    @Test
    public void testWeekContest194(){

    }
    public String[] getFolderNames(String[] names) {
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<names.length;i++){
            if(map.containsKey(names[i])){
                int j=map.get(names[i]);
                for(;j<names.length;j++){
                    String temp=names[i]+"("+j+")";
                    if(map.containsKey(temp))
                        continue;
                    else{
                        names[i]=temp;
                        map.put(names[i],1);
                        break;
                    }
                }
            }else{
                map.put(names[i],1);
            }
        }
        return names;
    }
    @Test
    public void testAge(){
        int start=1995;
        int[] age=new int[30];
        int[] year=new int[30];
        age[0]=0;
        year[0]=1995;
        for(int i=1;i<29;i++){
            age[i]=age[i-1]+1;
            year[i]=year[i-1]+1;
        }
        for(int i=0;i<30;i++){
            System.out.print(year[i]+" ");
        }
        System.out.println();
        for(int i:age){
            System.out.print(age[i]+"    ");
        }
    }
    @Test
    public void testI(){
        double pow = Math.pow(3, 2);
        System.out.println(pow);
        Math.pow(2,3);
        BigInteger num=BigInteger.valueOf(10);
    }
    @Test
    public void testO(){
        String s="abc";
        String replace = s.replace("b", "a");
        System.out.println(replace);
    }
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    @Test
    public void test3(){
        TreeNode n1=new TreeNode(1);
        n1.left=new TreeNode(2);
        n1.right=new TreeNode(3);
        n1.left.left=new TreeNode(4);
        n1.left.right=new TreeNode(5);
        n1.right.left=new TreeNode(6);
        n1.right.right=new TreeNode(7);
        TreeNode n1left=n1.left;
        TreeNode n1right=n1.right;
        System.out.println(n1.left);
        n1left=null;
        System.out.println(n1.left.val);
        System.out.println(n1.left);
    }
}

