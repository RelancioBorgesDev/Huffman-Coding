package HuffmanTree;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Tree {


    public Tree (){

    }
    //Métodos
    public boolean isLeaf(Node current){
        if(current.getEsquerda() == null && current.getDireita() == null){
            return true;
        }
        return false;
    }
    //Fila de Folhas
    public PriorityQueue<Node> FilaDeFolhas (Map<Character, Integer> mapaDeFrequencia){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        //Preenche a fila de folhas
        for (Map.Entry<Character, Integer> freq : mapaDeFrequencia.entrySet()) {
            char charzinho = freq.getKey();
            Integer valor = freq.getValue();
            pq.add(new Leaf(charzinho,valor));
        }
        return pq;
    }

    public Node criarArvore(Map<Character, Integer> mp){
        PriorityQueue<Node> fdf = FilaDeFolhas(mp);
           while(fdf.size() > 1){
               Node n0 = fdf.poll();
               Node n1 = fdf.poll();
               Node parent = new Node(n0, n1);
               fdf.add(parent);
           }
        //Retornar a arvore
        Node raiz = fdf.poll();
        return raiz;
    }
    //Codigo Binario da lista de palavras não repetidas.
    public HashMap<Character, String> encodeMap (Node current, String codigo, HashMap<Character, String> hm){
        if(current.getEsquerda() != null){
            current.getEsquerda().encodeMap(current.getEsquerda(), codigo + 0,  hm);
        }
        if(current.getDireita() != null){
            current.getDireita().encodeMap(current.getDireita(), codigo + 1, hm);
        }
        if(current.getEsquerda() == null && current.getDireita() == null){
            hm.put(current.getCaractere(), codigo);
        }
        return hm;
    }
    //Codigo binario completo texto compactado
    public String fullEncodeMap (HashMap<Character, String> encodeMap ){
        StringBuilder listString = new StringBuilder();
        for (Map.Entry<Character, String> entry : encodeMap.entrySet()) {
            String valor = entry.getValue();
          listString.append(valor);
        }
        return listString.toString();
    }
    //Codigo binario das lista de palavras repetidas.
    public String[] encodeOriginalStringArray (Node current, String codigo, HashMap<Character, String> hm, String [] x , char[] fraseOriginal, int i, Map<Character, Integer> raiz ){
        if(current.getEsquerda() != null){
            current.getEsquerda().encodeOriginalStringArray(current.getEsquerda(), codigo + 0,  hm, x, fraseOriginal, i, raiz);
        }
        if(current.getDireita() != null){
            current.getDireita().encodeOriginalStringArray(current.getDireita(), codigo + 1,  hm, x, fraseOriginal, i, raiz);
        }

         if(current.getCaractere() == fraseOriginal[i]) {
             x[i] = codigo;
             i = i + 1;
             Node newCurrent = criarArvore(raiz);
             if(i != fraseOriginal.length){
                 encodeOriginalStringArray (newCurrent, "", hm, x, fraseOriginal, i, raiz);
             }else{
                 return x;
             }
         }
        return x;
    }

    //Codigo binario completo texto original
    public String fullOriginalStringEncodeMap (String[] encodeMap ){
        StringBuilder listString = new StringBuilder();
        for (String entry : encodeMap) {
            String valor = entry;
            listString.append(valor.toString());
        }
        return listString.toString();
    }

    public String decode (String [] encodeOriginalStringArray, HashMap<Character, String> mapaDeFrequencia){
        StringBuilder palavraDecodificada = new StringBuilder();

        for(String code : encodeOriginalStringArray){
            for (Map.Entry<Character, String> entry : mapaDeFrequencia.entrySet()) {
                if(Objects.equals(code, entry.getValue())){
                    palavraDecodificada.append(entry.getKey());
                }
            }
        }
        return palavraDecodificada.toString();
    }

    public void imprimeMapa(HashMap<Character, String> encodedMap ){
        Map<Character, String> encodedMapOrdenado = ordenarEncodedMapaPorValor(encodedMap);
        System.out.println();
        System.out.println();
        System.out.println("------------TABELA DE CODIFICADA-------------");
        System.out.printf("%10s %20s", "Caractere", "Codigo Binario");
        System.out.println();


        for (Map.Entry<Character, String> entry : encodedMapOrdenado.entrySet()) {
            char charzinho = entry.getKey();
            String valor = entry.getValue();
            System.out.format("%10s %20s",charzinho, valor);
            System.out.println();
        }
        System.out.println("--------------------------------------------");

    }

    public static Map<Character, String> ordenarEncodedMapaPorValor(Map<Character, String> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, String> > list =
                new LinkedList<Map.Entry<Character, String> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, String> >() {
            public int compare(Map.Entry<Character, String> o1,
                               Map.Entry<Character, String> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        Map<Character, String> temp = new LinkedHashMap<Character, String>();
        for (Map.Entry<Character, String> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }



}
