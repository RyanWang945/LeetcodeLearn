package 实验性测试;

import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author Ryan
 * @date 2020/9/16 9:06
 */
public class SeptemberTest {
    int[] nums = {4, 0, -1};
    int[] colors;
    List<List<Integer>> graph;

    public static void unZipFile(String zipPath, String destDirPath) throws IOException {
        long start = System.currentTimeMillis();
        File srcFile = new File(zipPath);

        // 判断源文件是否存在
        if (!srcFile.exists()) {
            throw new RuntimeException(srcFile.getPath() + "所指文件不存在");
        }

        // 开始解压
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(srcFile);
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                System.out.println("解压" + entry.getName());
                // 如果是文件夹，就创建个文件夹
                if (entry.isDirectory()) {
                    String dirPath = destDirPath + "/" + entry.getName();
                    File dir = new File(dirPath);
                    dir.mkdirs();
                } else {
                    // 如果是文件，就先创建一个文件，然后用io流把内容copy过去
                    File targetFile = new File(destDirPath + "/" + entry.getName());
                    // 保证文件的父文件夹必须要存在
                    if (!targetFile.getParentFile().exists()) {
                        targetFile.getParentFile().mkdirs();
                    }
                    targetFile.createNewFile();
                    // 将压缩文件内容写入到这个文件中
                    InputStream is = zipFile.getInputStream(entry);
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    int len;
                    byte[] buf = new byte[1024];
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    // 关流顺序，先打开的后关闭
                    fos.close();
                    is.close();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("解压完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("unzip error from ZipUtils", e);
        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test1() {
        String s = "abcdedf";
        System.out.println(s.startsWith("abc"));
    }

    @Test
    public void test2() {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dfs(list, 0, set);
        System.out.println(set.size());
//        for(int i:set)
//            System.out.println(i);
    }

    private void dfs(List<Integer> list, int index, Set<Integer> set) {
        if (index == 10) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += list.get(i);
            }
            set.add(sum);
            return;
        }
        for (int i = 0; i < 3; i++) {
            list.add(nums[i]);
            dfs(new ArrayList<>(list), index + 1, set);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test3() {
//        String s="  this   is  a sentence ";
//        String[] s1 = s.split(" ");
//        for(String i:s1){
//            System.out.println(i);
//        }
//        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer[]> queue2 = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        int[] a = {1, 2};
        //Integer[] a1 = (Integer[]) a;
    }

    @Test
    public void test4() {
        System.out.println(File.separator);
        List<String> code = new ArrayList<>();
        File f = new File("C:\\Users\\Ryan\\Desktop\\MySQL\\");
        try {
            //FileReader fr = new FileReader(f);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                code.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String s : code) {
            System.out.println(s);
        }
    }

    @Test
    public void test5() throws IOException {
        unZipFile("C:\\Users\\Ryan\\Desktop\\MySQL\\MySQL.zip", "C:\\Users\\Ryan\\Desktop\\MySQL");
    }

    @Test
    public void test6() {
//        int a;
//        a=10;
//        System.out.println(a);
//        Map<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());
//        List<Integer> list=new ArrayList<>();
//        list.add(1);
        //int[] ts = list.toArray(new int[1]);
        //Arrays.copyOfRange
        System.out.println((int) (Math.pow(3, 40) % 1000000007));
        long res = 1;
        for (int i = 0; i < 40; i++) {
            res = (res * 3) % 1000000007;
        }
        System.out.println((int) (res % 1000000007));
    }

    public int position(int[] nums, int start, int end) {
        int temp = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= temp) end--;
            nums[start] = nums[end];
            while (start < end && nums[start] < temp) start++;
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pos = position(nums, start, end);
            quickSort(nums, start, pos - 1);
            quickSort(nums, pos + 1, end);
        }
    }

    //5
    @Test
    public void test7() {
        int n = 14;
        int[] dp = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; (int) Math.pow(2, i) <= n; i++) {
            list.add((int) Math.pow(2, i));
        }
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (Integer integer : list) {
                if (i - integer >= 0) {
                    dp[i] = dp[i] + dp[i - integer];
                } else {
                    break;
                }
            }
        }
        System.out.println(dp[n - 1]);

    }

    @Test
    public void test8() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2};
        a = b;
        System.out.println(a.length);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void test9() {
        int n = 5;
        colors = new int[n];//专门用来记录节点i的颜色值
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, 1)) {
                    System.out.println("no");
                }
            }
        }
        System.out.println("yes");
    }

    private boolean dfs(int v, int c) {
        colors[v] = c;
        for (int i = 0; i < graph.get(v).size(); i++) {
            if (colors[graph.get(v).get(i)] == c) return false;
            if (colors[graph.get(v).get(i)] == 0 && !dfs(graph.get(v).get(i), -c)) return false;
        }
        return true;
    }

    public int bf(int[][] times, int n, int k) {
        int[] dis = new int[n + 1];
        int inf = (int) 1e8 + 7;
        Arrays.fill(dis, inf);
        dis[k] = 0;
        for (int i = 0; i <= n; i++) {
            for (int[] time : times) {
                int start = time[0];
                int end = time[1];
                int cost = time[2];
                if (dis[start] != inf) {
                    if (dis[end] == inf) {
                        dis[end] = dis[start] + cost;
                    } else {
                        dis[end] = Math.min(dis[start] + cost, dis[end]);
                    }
                }
            }
        }
        return 0;
    }

    public int dijkstra(int[][] times, int n, int k) {
        int[][] g = new int[n + 1][n + 1];
        for (int[] row : g) {
            Arrays.fill(row, -1);
        }
        for (int[] time : times) {
            g[time[0]][time[1]] = time[2];
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        for (int i = 1; i <= n; i++) {
            dis[i] = g[k][i];
        }
        dis[k] = 0;
        boolean[] visited = new boolean[n + 1];
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            //int minDis=Integer.MIN_VALUE;
            int minIndex = 1;
            for (int j = 0; j <= n; i++) {
                if (!visited[j] && dis[j] != -1 && dis[j] < dis[minIndex]) {
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            for (int j = 1; j <= n; j++) {
                if (g[minIndex][j] != -1) {
                    if (dis[j] == -1) {
                        dis[j] = dis[minIndex] + g[minIndex][j];
                    } else {
                        dis[j] = Math.min(dis[j], dis[minIndex] + g[minIndex][j]);
                    }
                }
            }
        }
        return -1;
    }

    public int floyd(int[][] times, int n, int k) {
        int[][] g = new int[n + 1][n + 1];
        for (int[] row : g) {
            Arrays.fill(row, -1);
        }
        for (int[] time : times) {
            g[time[0]][time[1]] = time[2];
        }
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        g[i][j] = 0;

                    }
                    if (g[i][k] != -1 && g[k][j] != -1) {
                        g[i][j] = g[i][k] + g[k][j];
                    } else {
                        if (g[i][k] != -1 && g[k][j] != -1 && g[i][k] + g[k][j] < g[i][j])
                            g[i][j] = g[i][k] + g[k][j];
                    }

                }
            }
        }
        return 0;
    }




    @Test
    public void test11() {
//        String s="00";
//        int a= Integer.valueOf(s);
//        System.out.println(a);
        double v = Math.atan2(1, -1);
        System.out.println(v / Math.PI * 180);
//        int a=12;
//        System.out.println(12&(-12));
    }

    @Test
    public void test12() {
//        Struct s1=new Struct(1);
//        Struct s2=s1;
//        System.out.println(s1==s2);
        String a = "a good   example";
        String[] s = a.split(" ");
        System.out.println(s.length);
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0;
                int n = o1.length();
                int m = o2.length();
                while (i < Math.max(n, m)) {
                    if (o1.charAt(i % n) > o2.charAt(i % m))
                        return 1;
                    else if (o1.charAt(i % n) > o2.charAt(i % m))
                        return -1;
                    else i++;
                }
                return 0;
            }
        });
    }

    @Test
    public void test13() {
        StringBuilder sb = new StringBuilder();
        //StringBuilder ap=new StringBuilder(a.substring(0,i));
        //StringBuilder as=new StringBuilder(a.substring(i,n));
        //ap.append(as);
        List<Integer>[] edge = new ArrayList[1];
        Stack<Integer> st = new Stack<>();
    }
}
