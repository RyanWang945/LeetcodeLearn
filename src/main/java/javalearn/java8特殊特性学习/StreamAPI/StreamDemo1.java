package javalearn.java8特殊特性学习.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ryan
 * @date 2020/6/3 10:26
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> players = Arrays.asList("kobe", "james", "curry", "cyyt");
//        for (String player : players) {
//            if(player.startsWith("L")){
//                String temp=player.toUpperCase();
//            }
//        }
//        Collections.sort(players);
        List<String> sortedPlayers = players.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedPlayers);
        /**
         * 前面写的是集合转换为流然后进行函数式编程的方式
         * 下面是数组转换成流的方式
         */
        String[] playersArray={"kobe", "james", "curry", "cyyt"};
        List<String> c = Stream.of(playersArray)
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        //文件也可以Stream化然后用StreamAPI

    }
}
