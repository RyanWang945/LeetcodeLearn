package java学习.正则表达式.爬虫;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ryan
 * @date 2020/3/21 9:29
 */
public class CrawlerDemo {
    public static void main(String[] args) {
        String rs="";
        //从rs中爬取电话号码和邮箱
        //定义爬取规则
        String regex="(\\w{1,}@\\w{2,10}(\\.\\w{2,10}){1,2})|(0\\d{2,5}-?\\d{5,15})";
        //把正则表达式编译称为匹配规则对象
        Pattern pattern=Pattern.compile(regex);
        //通过匹配规则对象获得匹配器对象
        Matcher matcher=pattern.matcher(rs);
        //通过匹配器去内容中爬取信息
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

}
