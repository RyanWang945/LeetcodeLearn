package 刷题.周赛;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/6/7 10:29
 */
public class Solution0607 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        LinkedList<Integer> l=new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.removeLast();
        l.removeLast();
        System.out.println(l.get(0));
    }
}
//["BrowserHistory","visit","forward","forward","visit","visit","back","visit","visit","forward","back","visit","visit","visit","forward","forward","visit","visit","back","visit","forward","visit","visit","visit","back"]
//        [["jrbilt.com"],["uiza.com"],[3],[3],["fveyl.com"],["hyhqfqf.com"],[3],["cccs.com"],["bivz.com"],[6],[1],["cmbw.com"],["iywwwfn.com"],["sktbhdx.com"],[8],[10],["bskj.com"],["thw.com"],[6],["hgesj.com"],[6],["ctb.com"],["fllnc.com"],["fs.com"],[7]]
