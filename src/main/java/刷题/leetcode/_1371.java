package 刷题.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/5/20 9:24
 */
public class _1371 {
    //0代表偶数次，1代表奇数次
    // 把字符串下的子串(下标是0~i)，元音字母出现的的奇偶性存在一个累加变量里面
    // 例如a:2 e:3 i:0 o:4 u:6
    // 则该变量为0b00010==2因为e是奇数次，而二进制是从右往左
    // 易推得：只要该变量之前出现过，则中间的单词一定是aeiou出现偶数次
    // 也就说 只要用数组存下首次出现这个变量的下标
    // 就可以在后面出现该变量相同值时，找到最早的下标，做减法更新ans即可
    public int findTheLongestSubstring(String s) {
        int n=s.length();
        int[] pos=new int[1<<5];
        Arrays.fill(pos,-1);
        int ans=0,status=0;
        //为什么一定要设置一个pos[0]？很显然字符串可以为空，空的时候的0，如果不设置
        //比如ele这种情况，pos0=1，pos1出来ans=2，pos2由于没有真正的00000可以比较，所以没法显示出3.
        //参考样例"eleetminicoworoep"
        pos[0]=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a')
                status^=(1<<0);
            else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    /**
     *map做法
     */
    public int findTheLongestSubstring2(String s) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int cur=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            int idx=map(s.charAt(i));
            if(idx!=-1){
                cur^=1<<idx;
            }
            if(map.containsKey(cur)){
                res=Math.max(res,i-map.get(cur));
            }else{
                map.put(cur,i);
            }
        }
        return res;
    }
    private int map(char ch){
        String vowel="aeiou";
        for(int i=0;i<vowel.length();i++){
            if(vowel.charAt(i)==ch) return i;
        }
        return -1;
    }
}
