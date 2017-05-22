package LeetCode;

import java.util.ArrayList;

/**
 * Created by zhuhao on 17-5-19.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
//        ArrayList<UndirectedGraphNode>
        return node;
    }
}

  class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
      }
  };