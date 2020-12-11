package 实验性测试;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author Ryan
 * @date 2020/10/16 22:44
 */
public class OctoberTest {

    @Test
    //测试TreeMap相关的方法
    public void test1(){
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(1,1);
        map.put(5,3);
        map.put(6,4);
        map.put(7,3);
        System.out.println(map.ceilingKey(2));
        System.out.println(map.floorKey(2));
    }
    @Test
    public void test2(){
//        String a="1111";
//        String b="2222";
//        System.out.println(a.compareTo(b));
//        TreeSet<String> set=new TreeSet<>();
//        set.add(b);
//        set.add(a);
//        System.out.println(set.first());
//        set.first();
//        char[] chs1={'1','2','3'};
//        char[] chs2;
//        char[] chars = Arrays.copyOf(chs1, chs1.length);
//        chs1[0]+=1;
//        System.out.println(chs1[0]);
//        set.pollFirst();
//        System.out.println(String.valueOf(chs1));
//        Integer integer = Integer.valueOf('1');
//        System.out.println(integer);
//        int x=chs1[0]-'0';
//        System.out.println("x:"+x);
        char[] chs={'5','5','2','5'};
        char[] add = add(chs, 10);
        System.out.println(String.valueOf(add));

    }

    private char[] add(char[] chs,int a){
        int[] ints=new int[chs.length];
        for(int i=0;i<ints.length;i++){
            ints[i]=chs[i]-'0';
        }
        for(int i=0;i<chs.length;i++){
            if((i&1)==1){
                ints[i]+=a;
                ints[i]%=10;
            }
        }
        for(int i=0;i<chs.length;i++){
            chs[i]=(char)(ints[i]+'0');
        }
        return chs;
    }
    @Test
    //测试int[][]排序Arrays.sort
    public void test3(){
        int[][] clips={{5,7},{1,8},{0,0},{2,3},{4,5},{0,6}};
        Arrays.sort(clips,(o1,o2)->(o1[0]-o2[0]!=0?o1[0]-o2[0]:o2[1]-o1[1]));
        for(int[] i:clips){
            System.out.println(i[0]+" "+i[1]);
        }
    }
    @Test
    public void test4(){
        PriorityQueue<String> pq1=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        PriorityQueue<String> pq2=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        StringBuilder sb=new StringBuilder();
        TreeSet<Integer> a=new TreeSet<>();
        a.ceiling(2);
        a.floor(2);
    }
    public int position(int[] nums,int left, int right){
        int temp=nums[left];
        while(left<right){
            while(left<right&&nums[right]>=temp) right--;
            nums[left]=nums[right];
            while(left<right&&nums[left]<=temp) left++;
            nums[right]=nums[left];
        }
        nums[left]=temp;
        return left;
    }
    public void quickSort(int[] nums,int left,int right){
        if(left<right){
            int pos=position(nums,left,right);
            quickSort(nums,left,pos-1);
            quickSort(nums,pos+1,right);
        }
    }
    @Test
    public void testQuickSort(){
        int[] nums={2,6,8,4,3,4,1,10,34,22};
        quickSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    @Test
    public void testGCD(){
        int a=14;
        int b=60;
        System.out.println(gcd(a,b));
    }
    @Test
    public void testTreeSet(){
        TreeSet<Integer> set=new TreeSet<>();
        set.add(3);
        set.add(2);
        set.add(4);
        set.add(10);
        set.add(7);
        for(int i:set){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(set.floor(5));
        System.out.println(set.ceiling(5));
        System.out.println(set.pollFirst());
        System.out.println(set.pollLast());
        TreeSet<Integer> reverse_set=new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        reverse_set.add(3);
        reverse_set.add(2);
        reverse_set.add(4);
        reverse_set.add(10);
        reverse_set.add(7);
        for(int i:reverse_set){
            System.out.print(i+" ");
        }
        System.out.println();
        Iterator it=set.iterator();
        while(it.hasNext()){
            it.remove();
            System.out.print(it.next()+" ");
        }

    }
    @Test
    public void testSetRemove(){
        TreeSet<Integer> set=new TreeSet<>();
        set.add(3);
        set.add(2);
        set.add(4);
        set.add(10);
        set.add(7);
        for(int i:set){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i:set){
            System.out.print(i+" ");
            set.remove(10);
        }
    }
    @Test
    public void testSetRemove2(){
        TreeSet<Integer> set=new TreeSet<>();
        set.add(3);
        set.add(2);
        set.add(4);
        set.add(10);
        set.add(7);
        for(int i:set){
            System.out.print(i+" ");
        }
        System.out.println();
        Iterator it=set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
            it.remove();
        }
        System.out.println();
        System.out.println(set.size());
        for(int i:set){
            System.out.print(i+" ");
        }
    }
    @Test
    public void test(){
        List<Integer> list=new ArrayList((Collection) Collections.reverseOrder());
        Collections.sort(list,((o1, o2) -> o2-o1));
    }
    @Test
    public void test5(){
        //n件物品，每个物品用一次，重量限制为W，第i件物品重量为w，价值为v
        int n=4,W=5;
        int[] w={2,1,3,2};
        int[] v={3,2,4,1};
        //dp(i,j)，前i件物品当重量限制为j时最大价值为多少
        //dp(i+1,j)=max(dp(i,j),dp(i,j-w(i))+v(i);
        int[][] dp=new int[n+1][W+1];
        //显然dp(0,0)=0
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                if(w[i]>j){
                    dp[i+1][j]=dp[i][j];
                }else{
                    dp[i+1][j]=Math.max(dp[i][j],dp[i][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }
    @Test
    public void test6(){
        Integer[] a={1,2,3,4,5};
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                int a=0,b=0;
                for(int i=0;i<32;i++){
                    if(((o1>>i)&1)==1){
                        a++;
                    }
                    if(((o2>>i)&1)==1){
                        b++;
                    }
                }
                return a==b?o1-o2:a>b?o1:o2;
            }
        });
    }
    @Test
    public void test7(){
        int n=4,W=5;
        int[] w={2,1,3,2};
        int[] v={3,2,4,1};
        int[][] dp=new int[n+1][W+1];
        //dp[i][j]=max(dp[i-1][j],dp[i-1][j-w[i]+v[i])
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                if(j<w[i]){
                    dp[i+1][j]=dp[i][j];
                }else{
                    dp[i+1][j]=Math.max(dp[i][j],dp[i][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }
    @Test
    public void test8(){
        class Node{
            int[] p=new int[2];
            double dist;
            public Node(int i,int j,double dist){
                this.p[0]=i;
                this.p[1]=j;
                this.dist=dist;
            }
        }
        PriorityQueue<Node> queue=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist-o2.dist>0?1:-1;
            }
        });
    }
    @Test
    public void test9() throws IOException {
        //创建文件并初始化输出流
        File f=new File("compareResult.xls");
        FileOutputStream os=null;
        try {
            os=new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建excel表对象
        HSSFWorkbook wholeFile=new HSSFWorkbook();
        //创建这个excel表内的sheet
        HSSFSheet result = wholeFile.createSheet("result");
        //获取这个sheet里的第0行的对象（实际上获取的是excel第一行）
        HSSFRow row = result.createRow(0);
        HSSFRow row1 = result.createRow(1);
        //获取excel表第0行的第0个单元格，然后在下面将这个单元格设置为100
        HSSFCell cell = row.createCell(0);
        HSSFCell cell1 = row.createCell(1);
        cell.setCellValue(3);
        cell1.setCellValue(2);
        row1.createCell(0).setCellValue(1);
        row1.createCell(1).setCellValue(0);
        try {
            wholeFile.write(os);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        os.close();
    }
    @Test
    public void test10(){
//        int[][] arr=new int[2][2];
//        List<Integer> list=new ArrayList<>();
//        int[] a={1,2};
//        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                int lo1=Math.abs(o1[0]-a[0])+Math.abs(o1[1]-a[1]);
//                int lo2=Math.abs(o2[0]-a[0])+Math.abs(o2[1]-a[1]);
//                return lo1-lo2;
//            }
//        });
        Deque<Character> stack=new ArrayDeque<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.add('d');
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        Character character = stack.pollFirst();
        System.out.println(character);

    }
    @Test
    public void test11(){
        File f=new File("generate.xls");
        FileOutputStream os=null;


        try {
            os=new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建excel表对象
        HSSFWorkbook wholeFile=new HSSFWorkbook();
        //创建这个excel表内的sheet
        HSSFSheet result = wholeFile.createSheet("result");
        List<String> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("193300"+i);
        }
        //result.createRow(0).createCell(0).setCellValue(122);
        Map<String, HSSFRow> stringIntegerMap = initXlsFile(list, f,wholeFile,result,os);
        stringIntegerMap.get("1933000").createCell(1).setCellValue(12);
        //result.getRow(2).createCell(1).setCellValue(23432);
        //result.getRow(2).createCell(3).setCellValue(12);
        //result.getRow(1).createCell(2).setCellValue(1000);
        try {
            wholeFile.write(os);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<String,HSSFRow> initXlsFile(List<String> list,File f,HSSFWorkbook wholeFile,HSSFSheet result,FileOutputStream os){
        Map<String,HSSFRow> map=new HashMap<>();

        HSSFRow row = result.createRow(0);
        for(int i=1;i<=list.size();i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(list.get(i-1));
            //map.put(list.get(i-1),i);
        }
        for(int i=1;i<=list.size();i++){
            HSSFRow row1 = result.createRow(i);
            row1.createCell(0).setCellValue(list.get(i-1));
            //row1.createCell(1).setCellValue(12312);
            map.put(list.get(i-1),row1);
        }
        return map;
    }
}
