package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Tree {
    private Node raiz;

    public Tree (){
        raiz = null;
    }

    public Node criarArvore(Map<Object, Integer> mp){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Leaf xx = null;

           for (Map.Entry<Object, Integer> entry : mp.entrySet()) {
               Object key = entry.getKey();
               Integer tab = entry.getValue();
               System.out.println(key + "" + tab);
               pq.add(xx = new Leaf(key,tab));
            /*   System.out.println(xx);*/
           }

           while(pq.size() > 1){
               Node n0 = pq.poll();
               Node n1 = pq.poll();
               Node parent = new Node();
               parent.setEsquerda(n0);
               parent.setDireita(n1);
               parent.setFrequencia(n0.getFrequencia() + n1.getFrequencia());
               pq.add(parent);
               System.out.println(parent);
           }
           Node x = pq.poll();

       return x;

    }
}
