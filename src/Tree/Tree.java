package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Tree {


    private Node raiz;
    private Node esquerda, direita;

    public Tree (){
    }
    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public Node criarArvore(Map<Character, Integer> mp){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Leaf xx = null;

           for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
               char key = entry.getKey();
               Integer tab = entry.getValue();
               System.out.println(key + "" + tab);
               pq.add(xx = new Leaf(key,tab));
            /*   System.out.println(xx);*/
           }

           while(pq.size() > 1){
               Node n0 = pq.poll();
               Node n1 = pq.poll();
               Node parent = new Node();
               parent.setEsquerda(n1);
               parent.setDireita(n0);
               parent.setFrequencia(n0.getFrequencia() + n1.getFrequencia());
               pq.add(parent);

           }
           Node x = pq.poll();

       return x;

    }

    public String encode (Node arvore, String codigo){
        Map<Character, String> mapEncoded = new HashMap<>();
        ArrayList<Integer>arr  = new ArrayList<>();

        if(arvore.getEsquerda() != null) return arvore.encode(arvore.getEsquerda(), codigo +=0);
        if(arvore.getDireita() != null) return arvore.encode(arvore.getDireita(), codigo +=1);

        if(arvore.getEsquerda() == null && arvore.getDireita() == null) return codigo;
        return codigo;
    }


}
