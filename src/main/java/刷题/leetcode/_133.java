package 刷题.leetcode;
import 刷题.Structure.Node;
import java.util.*;

/**
 * @author Ryan
 * @date 2020/3/31 9:03
 */

public class _133 {

    public Node cloneGraph1(Node node) {
        if(node==null) return node;
        Map<Node,Node> map=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        map.put(node,new Node(node.val,new ArrayList<>()));
        while(!queue.isEmpty()){
            Node n=queue.poll();
            for(Node i:n.neighbors){
                if(!map.containsKey(i)){
                    map.put(i,new Node(i.val,new ArrayList<>()));
                    queue.add(i);
                }
                map.get(n).neighbors.add(map.get(i));//当前克隆节点的克隆孩子需要把当前克隆节点加进去，因为queue不回头
            }
        }
        return map.get(node);
    }

    /**
     * 思路：
     *  先创建一个map用来记录
     *  先判断是否为null，null就直接返回node
     *  递归的核心终止条件就是map中是否有这个node，判断，如果有即返回这个复制好的node
     *  没有的话，就用构造方法复制一个，然后将其put进map中
     *  for循环遍历相邻节点，将相邻节点放入neighbors中，里面用cloneGraph获取复制的节点
     *  返回这个节点的复制。
     */
    Map<Node,Node> map=new HashMap<>();
    public Node cloneGraph(Node node){
        if(node==null) return node;
        if(map.containsKey(node))
            return map.get(node);
        Node cloneNode=new Node(node.val,new ArrayList<>());
        map.put(node,cloneNode);
        for(Node n:node.neighbors){
            cloneNode.neighbors.add(cloneGraph(n));
        }
        return map.get(node);
    }
}
