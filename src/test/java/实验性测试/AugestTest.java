package 实验性测试;

import org.junit.jupiter.api.Test;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.util.*;


/**
 * @author Ryan
 * @date 2020/8/1 17:59
 */
public class AugestTest {
    @Test
    public void test1(){
        String a="-100";
        System.out.println(Integer.valueOf(a)-10);
    }
    @Test
    public void test2(){
        String a="1";
        String b="66.x66.x66";
        String[] split = b.split("[0-9]");
        for(String s:split)
            System.out.println(s);
    }
    @Test
    public void test3(){
        String a="1abc";
        boolean matches = a.matches("^[0-9]+abc$");
        System.out.println(matches);
    }
    @Test
    public void test4(){
        List<String> list=new LinkedList<>();
        list.add("a");
        list.add("b");
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }
    @Test
    public void test5() throws UnknownHostException, InterruptedException {
//        InetAddress localHost = InetAddress.getLocalHost();
//        System.out.println(localHost);
//        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
//        System.out.println(loopbackAddress);
        InetAddress[] byName = InetAddress.getAllByName("www.bilibili.com");
        for(InetAddress s:byName){
            System.out.println(s);
        }
    }
    @Test
    public void test6() throws IOException {
//        URL baidu=new URL("http://www.baidu.com");
//        InputStream in =baidu.openStream();
//        in =new BufferedInputStream(in);
//        Reader r=new InputStreamReader(in);
//        int c;
//        while((c=r.read())!=-1){
//            System.out.print((char)c);
//        }
//        String s="abcdef";
//
//        System.out.println(s.substring(2));
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.offer(0);
        queue.offer(5);
        queue.offer(2);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
    @Test
    public void test7(){
        int count=0;
        for(int i=1;i<=65535;i++){
            try {
                ServerSocket s=new ServerSocket(i);
            } catch (IOException e) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);

    }
    @Test
    public void test8(){
        for(int port=1024;port<=65535;port++){
            try {
                DatagramSocket server=new DatagramSocket(port);
                server.close();
            } catch (SocketException e) {
                System.out.println("a server at port:"+port);
            }
        }
    }
    @Test
    public void test9() throws IOException, InterruptedException {
        //System.out.println((int)'!');
        System.out.println((int)'願');
        System.out.println((int)'网');
        StringBuilder sb=new StringBuilder();
        MyTask target = new MyTask(sb);
        Thread t=new Thread(target);
        t.start();
        sb.wait();
    }
    private class MyTask implements Runnable{
        StringBuilder sb;
        public MyTask(StringBuilder sb){
            this.sb=sb;
        }
        @Override
        public void run() {
            sb.append("s");
        }
    }
    @Test
    public void test10() throws UnknownHostException {
        byte[] bts=new byte[4];
        bts[0]=111;
        bts[1]=123;
        bts[2]=123;
        bts[3]=123;
        System.out.println(bts.length);
        InetAddress.getByAddress(bts);
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }
    @Test
    public void test11() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while(networkInterfaces.hasMoreElements()){
            System.out.println(networkInterfaces.nextElement());
        }
    }
    @Test
    public void test12() throws UnsupportedEncodingException {
        String a="njiveqn 92&*#^(&#$!)*";
        System.out.println(URLEncoder.encode(a,"UTF-8"));
        String b=URLEncoder.encode(a,"UTF-8");
        System.out.println(URLDecoder.decode(b,"UTF-8"));
        PriorityQueue queue=new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> list=new ArrayList<>();

    }
    @Test
    public void test13() throws IOException {
//        ServerSocket ss=new ServerSocket(11);
//        Socket s=ss.accept();
//        SocketFactory aDefault = SSLSocketFactory.getDefault();
//        SSLSocket socket = (SSLSocket) aDefault.createSocket();
//        String[] supportedCipherSuites = socket.getSupportedCipherSuites();
//        for(String sss:supportedCipherSuites)
//            System.out.println(sss);
        List<String> list=new ArrayList<>();
        list.add("aaa");
        list.add("xxx");
        list.add("eee");
        list.sort(Comparator.naturalOrder());
        for(String a:list){
            System.out.println(a);
        }
    }
    @Test
    public void test14(){
        int n=7;
        String a="1111000";
        String b="0010011";
        int x=0;
        int y=0;
        for(int i=0;i<n;i++){

        }
        int[] arr=new int[]{1,2,3,4};
        System.out.println(arr.toString());
    }
    @Test
    public void test15(){
        String s="_122232124_";
        String[] split = s.split("2");
        for(String ss:split)
            System.out.println(ss);
        System.out.println(split.length);
        StringBuilder sb=new StringBuilder();
        System.out.println(s.contains("222"));
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        List<Integer> l=new ArrayList<>(set);
    }
    @Test
    public void test16(){
        Integer a = new Integer(2);
        //System.out.println(a.getClass());
        Class<?> classbook=null;
        try {
            classbook=Class.forName("java.lang.Integer");
            Field[] declaredFields = classbook.getDeclaredFields();
            Field declaredField = classbook.getDeclaredField("MAX_VALUE");
            System.out.println(declaredField);

        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(classbook);
    }
    @Test
    public void test17(){
        int a=10;
        Integer.toString(a);
        String s = String.valueOf(10);
    }
}
