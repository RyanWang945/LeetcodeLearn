package 刷题.程序员面试金典;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/5/30 21:33
 */
public class _17_17 {
    /**
     *用哈希表存储所有节点位置，超时，正常来说不应该超时的
     */
    public int[][] multiSearch(String big, String[] smalls) {
        Map<String, List<Integer>> map=new HashMap<>();
        int max=0;
        for(int i=0;i<big.length();i++){
            for(int j=i;j<big.length();j++){
                String s=big.substring(i,j+1);
                if(!map.containsKey(s))
                    map.put(s,new ArrayList<>());
                map.get(s).add(i);
                max=Math.max(max,map.get(s).size());
            }
        }
        int[][] ans=new int[smalls.length][];
        for(int i=0;i<smalls.length;i++){
            if(!map.containsKey(smalls[i])){
                ans[i]=new int[0];
            }else{
                List<Integer>list=map.get(smalls[i]);
                ans[i]=new int[list.size()];

                for(int j=0;j<list.size();j++){
                    ans[i][j]=list.get(j);
                }
            }
        }
        return ans;
    }
    public int[][] multiSearch2(String big, String[] smalls) {
        Trie tree = new Trie(smalls);
        for (int i = 0; i < smalls.length; i++) {
            tree.insert(smalls[i], i);
        }
        char[] chars = big.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            tree.update(big.substring(i, len), i);
        }

        int[][] ans = new int[smalls.length][];
        for (int i = 0; i < ans.length; i++) {
            List<Integer> list = tree.lists[i];
            ans[i] = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                ans[i][j] = list.get(j);
            }
        }
        return ans;

    }

    class Trie {
        class Node {
            int id;
            boolean flag;
            Node[] children;

            public Node() {
                id = -1;
                flag = false;
                children = new Node[26];
            }
        }

        Node root;
        List<Integer>[] lists;

        public Trie(String[] strings) {
            root = new Node();
            int len = strings.length;
            lists = new List[len];
            for (int i = 0; i < len; i++) {
                lists[i] = new ArrayList<>();
            }
        }

        public void insert(String word, int id) {
            Node p = root;
            char[] chars = word.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                int c = chars[i] - 97;
                if (p.children[c] == null) {
                    p.children[c] = new Node();
                }
                p = p.children[c];
            }
            p.flag = true;
            p.id = id;
        }

        public void update(String word, int offset) {
            Node p = root;
            char[] chars = word.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                int c = chars[i] - 97;

                if (p.children[c] == null) {
                    return;
                }
                p = p.children[c];
                if (p.flag) {
                    lists[p.id].add(offset);
                }
            }
        }
    }
}
