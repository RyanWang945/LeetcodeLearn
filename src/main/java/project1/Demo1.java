package project1;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Ryan
 * @date 2020/9/21 18:31
 */
public class Demo1 {
    public static void main(String[] args) {

    }

    /**
     * 以下分别是字符串比较算法和计算重复率的函数
     */
    public static int lcs(String X, String Y){
        int m=X.length();
        int n=Y.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static int levenshtein(String X,String Y){
        int m=X.length();
        int n=Y.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        int temp=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<n+1;j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    temp=0;
                }else{
                    temp=1;
                }
                dp[i][j]=Math.min(Math.min(dp[i-1][j-1]+temp,dp[i][j-1]+1),dp[i-1][j]+1);
            }
        }
        return m - dp[m][n];
    }
    //字符串去除空格，返回新的字符串
    public String delSpace(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    double comStrings(String x,String y,int choice){
        x=delSpace(x);
        y=delSpace(y);
        int m=x.length(),n=y.length();
        int sameLength=0;
        if(choice==1) sameLength=lcs(x,y);
        else if(choice==2) sameLength=levenshtein(x,y);
        return (double)sameLength/m;
    }
    public double calRepeatRate(List<String> code1,List<String> code2,int choice){
        int countAll=0,countRepeat=0;
        for(int i=0;i<code1.size();i++){
            countAll+=code1.get(i).length();
            for(int j=0;j<code2.size();j++){
                int d=code1.get(i).length()-code2.get(j).length();
                if(Math.abs(d)>15) continue;
                double repeatRate=0;
                if(choice==1) repeatRate=comStrings(code1.get(i),code2.get(j),1);
                else if(choice==2) repeatRate=comStrings(code1.get(i),code2.get(j),2);
                if(repeatRate>0.8){
                    countRepeat+=code1.get(i).length();
                    code2.remove(j);
                }
            }
        }
        return (double)countRepeat/countAll;
    }

    /**
     * 读取单个文件的函数
     */
    public void readFile(TreeMap<String,List<String>> map,String studentId,String path){
        List<String> list=new ArrayList<>();
        File f=new File(path);
        Scanner sc= null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在: "+path);
            e.printStackTrace();
        }
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String finalString=processString(s);
            if(finalString.length()==0||(finalString.length()==2&&finalString.equals(");"))) continue;
            list.add(finalString);
        }
        map.put(studentId,list);
    }
    //处理字符串的方法，去掉空格和String
    public String processString(String s){
        if(s.equals("    ")||s.equals("endmodule")) return "";
        String newS=s.replaceAll(" ","");
        for(int i=0;i<newS.length()-1;i++){
            if(newS.substring(i,i+2).equals("//")){
                return newS.substring(0,i);
            }
        }
        return newS;
    }
    @Test
    public void testReadFile(){
        String path="C:\\Users\\Ryan\\Desktop\\MySQL";
        String filename="cpu.v";
        //String filename="ddd.txt";
        String x=path+"\\"+filename;
        TreeMap<String,List<String>> map=new TreeMap<>();
        String studentId="1933035";
        readFile(map,studentId,x);
        List<String> strings = map.get(studentId);
        for(String s:strings){
            System.out.println(s);
        }
    }
    @Test
    public void compareTwoFile(){
        TreeMap<String,List<String>> map=new TreeMap<>();
        String path="C:\\Users\\Ryan\\Desktop\\MySQL";
        String filename1="cpu.v";
        String filename2="cpu_copy.v";
        readFile(map,"1933035",path+"\\"+filename1);
        readFile(map,"1933036",path+"\\"+filename2);
        double v = calRepeatRate(map.get("1933035"), map.get("1933036"), 2);
        System.out.println(v);
    }

}
