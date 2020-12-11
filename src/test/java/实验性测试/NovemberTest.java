package 实验性测试;

import org.junit.Test;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/11/19 9:26
 */
public class NovemberTest {
    class UF{
        int[] parent;
        //int[] rank;
        public UF(int total){
            parent=new int[total+1];
            for(int i=1;i<=total;i++){
                parent[i]=i;
            }
            //rank=new int[total+1];
        }
        public int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public void union(int a,int b){
            int ap=find(a);
            int bp=find(b);
            parent[ap]=bp;
        }
    }
    @Test
    public void test1(){
        int[] arr={2,3,5,4,89,67,86,44,22,3};
        quickSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public void quickSort(int[] arr,int left,int right){
        if(left<right){
            int pos=position(arr,left,right);
            quickSort(arr,left,pos-1);
            quickSort(arr,pos+1,right);
        }
    }
    public int position(int[] arr,int left,int right){
        int temp=arr[left];
        while(left<right){
            while(left<right&&arr[right]>=temp) right--;
            arr[left]=arr[right];
            while(left<right&&arr[left]<=temp) left++;
            arr[right]=arr[left];
        }
        arr[left]=temp;
        return left;
    }
    @Test
    public void test2(){
        long m = Maximumcandies(2, 10);
        System.out.println(m);
    }
    public long Maximumcandies (long n, long k) {
        // write code here
        long left=0,right=k;
        long ans=1;
        while(left<=right){
            long mid=left+(right-left)/2;
            if(check(mid,k,n)){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
    public boolean check(long x,long k,long n){
        if(k-(x+1)*n>=x){
            return true;
        }else return false;
    }
    public long tree2 (int k, int[] a) {
        // write code here
        long sum=0;
        for(int i=0;i<a.length;i++){
            for(int x=1;x<=k;x++){
                int s=i*k+x;
                if(s>=a.length){
                    break;
                }else{
                    sum+=(a[i]^a[s]);
                }
            }
        }
        //System.out.print(sum);
        return sum;
    }
    @Test
    public void test3(){
        Map<Character,Integer> map=new HashMap<>();
        for(int i=1;i<=26;i++){
            map.put((char)('a'+i-1),i);
        }
        System.out.println((char)('a'+1-1));
        int[][] arr=new int[2][2];
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
    }
    @Test
    public void test4(){
        long a = cal1(9);
        long b = cal2(9);
        System.out.println(a);
        System.out.println(b);
        System.out.println(Math.pow(3,9));
        System.out.println(Math.pow(5,9));
        System.out.println((2*a*7*b)%1000000007);
    }
    private long cal1(long n){
        if(n==0) return 1l;
        long x=cal1(n/2);
        if((n%2)==0)
            return x*x;
        else return x*x*3;
    }
    private long cal2(long n){
        if(n==0) return 1l;
        long x=cal2(n/2);
        if((n%2)==0)
            return x*x;
        else return x*x*5;
    }
    @Test
    public void test5(){
        int a=123456;
        long start = System.currentTimeMillis();
        for(int i=0;i<1000000000;i++){
            a=a>>1;
            a=a<<1;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        long start2=System.currentTimeMillis();
        for(int i=0;i<1000000000;i++){
            a=a/2;
            a=a*2;
        }
        long end2=System.currentTimeMillis();
        System.out.println(end2-start2);
    }
    class Interval{
        int start;
        int end;
        public Interval(int i,int j){
            start=i;
            end=j;
        }
    }
    @Test
    public void test6(){
        Interval[] intervals= new Interval[3];
        intervals[0]=new Interval(0,2);
        intervals[1]=new Interval(4,7);
        intervals[2]=new Interval(9,9);
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        System.out.println(check(2,intervals,5));
    }
    private boolean check(int mid,Interval[]ivs,int n){
        boolean flag=false;
        int pre=0;
        for(Interval i:ivs){
            if(n<=0) return true;
            if(!flag){
                n--;
                pre=i.start;
                flag=true;
                int x=pre+mid;
                while(x<=i.end){
                    pre=x;
                    n--;
                    x+=mid;
                }
            }else{
                int x=pre+mid;
                if(x>=i.start&&x<=i.end){
                    pre=x;
                    n--;
                }else if(x<i.start){
                    x=i.start;
                    n--;
                }else{
                    continue;
                }
                x+=mid;
                while(x<=i.end){
                    pre=x;
                    x+=mid;
                    n--;
                }
            }
            System.out.println(n);
        }
        if(n<=0) return true;
        return false;
    }

    @Test
    public void test7(){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.add(3);
        System.out.println(deque.peek());
        System.out.println(deque.getLast());
        System.out.println(deque.pollLast());
        List<Integer> list=new LinkedList<>();
        list.add(2,1);
        Integer remove = list.remove(2);
        Integer[] nums=new Integer[2];
        Arrays.sort(nums,(a,b)->(nums[a]==nums[b]?a-b:nums[a]-nums[b]));
        Arrays.copyOfRange(nums,0,1);
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1]-nums[o2];
            }
        });
        int[] arr=new int[3];
        TreeMap<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());
    }
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans=new int[k];
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(nums[o1]==nums[o2]){
                    return o1-o2;
                }else
                    return nums[o1]-nums[o2];
            }
        });
        for(int i=0;i<nums.length;i++){
            queue.add(i);
        }
        int s=k;
        int index=0;
        int n=nums.length;
        int pre=-1;
        for(int i=0;i<s;i++){
            boolean flag=true;
            List<Integer> list=new ArrayList<>();
            while(flag){
                if(!queue.isEmpty()&&queue.peek()<=n-k&&queue.peek()>pre){
                    int cur=queue.poll();
                    pre=cur;
                    ans[index++]=nums[cur];
                    flag=false;
                    k--;
                }else{
                    list.add(queue.poll());
                }
            }
            for(int x:list){
                queue.add(x);
            }
        }
        return ans;
    }
    @Test
    public void test9(){
        Integer a=1000;
        System.out.println(a==1000);
        Integer b=1000;
        System.out.println(a==b);
        Integer c=100;
        Integer d=100;
        System.out.println(c==d);
    }
    @Test
    public void test10(){

        int i = Integer.numberOfTrailingZeros(4);
        System.out.println(i);
        int b=Integer.bitCount(8);
        System.out.println(b);
        System.out.println((int)Math.pow(3,16));
    }

}
