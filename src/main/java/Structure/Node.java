package Structure;

import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/31 9:11
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

