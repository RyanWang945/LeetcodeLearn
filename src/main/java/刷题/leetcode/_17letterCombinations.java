package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/24 15:02
 */
public class _17letterCombinations {
    /**
     * 第一个dfs写的有些丑和麻烦
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0)
            return ans;
        StringBuilder sb=new StringBuilder();
        dfs(ans,digits,0,sb);
        return ans;
    }
    private void dfs(List<String> ans,String digits,int index,StringBuilder sb){
        if(index==digits.length()){
            ans.add(sb.toString());
            sb.delete(index-1,index);
            return;
        }
        else if(digits.charAt(index)=='2'){
            sb.append('a');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('b');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('c');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            return;
        }
        else if(digits.charAt(index)=='3'){
            sb.append('d');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('e');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('f');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            return;
        }
        else if(digits.charAt(index)=='4'){
            sb.append('g');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('h');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('i');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            return;
        }
        else if(digits.charAt(index)=='5'){
            sb.append('j');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('k');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('l');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            return;
        }
        else if(digits.charAt(index)=='6'){
            sb.append('m');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('n');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('o');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            return;
        }
        else if(digits.charAt(index)=='7'){
            sb.append('p');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('q');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('r');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('s');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            return;
        }
        else if(digits.charAt(index)=='8'){
            sb.append('t');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('u');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('v');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            return;
        }
        else if(digits.charAt(index)=='9'){
            sb.append('w');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('x');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('y');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            sb.append('z');
            dfs(ans,digits,index+1,sb);
            sb.delete(index,index+1);
            return;
        }
    }
    private String[] letterMap={
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    private ArrayList<String> res;
    public List<String> letterCombinations2(String digits){
        res=new ArrayList<>();
        if(digits.equals(""))
            return res;
        dfs2(digits,0,"");
        return res;
    }
    private void dfs2(String digits,int index,String s){
        if(index==digits.length()){
            res.add(s);
            return;
        }
        Character c=digits.charAt(index);
        String letters=letterMap[c-'0'];
        for(int i=0;i<letters.length();i++){
            dfs2(digits,index+1,s+letters.charAt(i));
        }
    }

}
