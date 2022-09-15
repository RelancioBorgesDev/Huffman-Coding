package HuffmanTree;

import frequencia.FrequenciaTexto;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Tree {


    public Tree (){
    }
    //Fila de Folhas
    public PriorityQueue<Node> FilaDeFolhas (Map<Character, Integer> mp){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        //Preenche a fila de folhas
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            char charzinho = entry.getKey();
            Integer valor = entry.getValue();
            pq.add(new Leaf(charzinho,valor));
        }
        return pq;
    }

    public Node criarArvore(Map<Character, Integer> mp){
        PriorityQueue<Node> fdf = FilaDeFolhas(mp);
        //Criar a arvore
           while(fdf.size() > 1){
               Node n0 = fdf.poll();
               Node n1 = fdf.poll();
               Node parent = new Node();
               parent.setEsquerda(n0);
               parent.setDireita(n1);
               parent.setFrequencia(n0.getFrequencia() + n1.getFrequencia());
               fdf.add(parent);
           }
        //Retornar a arvore
        return fdf.poll();
    }

    public HashMap<Character, Integer> encodeMap (Node current, String codigo, HashMap<Character, Integer> hm){
        if(current.getEsquerda() != null){
            current.getEsquerda().encodeMap(current.getEsquerda(), codigo + 0,  hm);
        }
        if(current.getDireita() != null){
            current.getDireita().encodeMap(current.getDireita(), codigo + 1, hm);
        }

        if(current.getEsquerda() == null && current.getDireita() == null){
            hm.put(current.getCaractere(), parseInt(codigo));
        }
        return hm;
    }

    public String fullEncodeMap (HashMap<Character, Integer> encodeMap ){
        StringBuilder listString = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : encodeMap.entrySet()) {
            Integer valor = entry.getValue();
          listString.append(valor.toString());
        }
        return listString.toString();
    }

    public void imprimeMapa(HashMap<Character, Integer> encodedMap ){
        Map<Character, Integer> encodedMapOrdenado = ordenarEncodedMapaPorValor(encodedMap);
        System.out.println();
        System.out.println();
        System.out.println("------------TABELA DE CODIFICADA-------------");
        System.out.printf("%10s %20s", "Caractere", "Código Binario");
        System.out.println();


        for (Map.Entry<Character, Integer> entry : encodedMapOrdenado.entrySet()) {
            char charzinho = entry.getKey();
            Integer valor = entry.getValue();
            System.out.format("%10s %20s",charzinho, valor);
            System.out.println();
        }
        System.out.println("--------------------------------------------");

    }

    public static Map<Character, Integer> ordenarEncodedMapaPorValor(Map<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        Map<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }



}
