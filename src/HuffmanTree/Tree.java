package HuffmanTree;

import java.util.*;

public class Tree {
    public Tree() {
    }

    // Fila de Folhas
    public PriorityQueue<Node> FilaDeFolhas(Map<Character, Integer> mapaDeFrequencia) {
        PriorityQueue<Node> fdf = new PriorityQueue<>();
        // Preenche a fila de folhas
        for (Map.Entry<Character, Integer> freq : mapaDeFrequencia.entrySet()) {
            char charzinho = freq.getKey();
            Integer valor = freq.getValue();
            fdf.add(new Leaf(charzinho, valor));
        }
        return fdf;
    }

    public Node criarArvore(Map<Character, Integer> mp) {
        PriorityQueue<Node> fdf = FilaDeFolhas(mp);
        while (fdf.size() > 1) {
            Node n0 = fdf.poll();
            Node n1 = fdf.poll();
            assert n1 != null;
            Node parent = new Node(n0, n1);
            fdf.add(parent);
        }
        // Retornar a arvore
        return fdf.poll();
    }

    // Codigo Binario da lista de palavras não repetidas.
    public HashMap<Character, String> mapaBinario(Node current, String codigo, HashMap<Character, String> mapa) {
        if (current.getEsquerda() != null) {
            current.getEsquerda().mapaBinario(current.getEsquerda(), codigo + 0, mapa);
        }
        if (current.getDireita() != null) {
            current.getDireita().mapaBinario(current.getDireita(), codigo + 1, mapa);
        }
        if (current.getEsquerda() == null && current.getDireita() == null) {
            mapa.put(current.getCaractere(), codigo);
        }
        return mapa;
    }

    // Codigo binario completo texto compactado
    public String mapaBinarioCompleto(HashMap<Character, String> encodeMap) {
        StringBuilder listString = new StringBuilder();
        for (Map.Entry<Character, String> entry : encodeMap.entrySet()) {
            String valor = entry.getValue();
            listString.append(valor);
        }
        return listString.toString();
    }

    // Codigo binario das lista de palavras repetidas.
    public ArrayList<String> fraseOriginalBinario(Node current, String codigo, ArrayList<String> ArrayBinario,
            char[] fraseOriginal, int i, Map<Character, Integer> raiz) {
        if (current.getEsquerda() != null) {
            current.getEsquerda().fraseOriginalBinario(current.getEsquerda(), codigo + 0, ArrayBinario, fraseOriginal,
                    i, raiz);
        }
        if (current.getDireita() != null) {
            current.getDireita().fraseOriginalBinario(current.getDireita(), codigo + 1, ArrayBinario, fraseOriginal, i,
                    raiz);
        }
        if (current.getCaractere() == fraseOriginal[i]) {
            ArrayBinario.add(codigo);
            i = i + 1;
            Node newCurrent = criarArvore(raiz);
            if (i != fraseOriginal.length) {
                fraseOriginalBinario(newCurrent, "", ArrayBinario, fraseOriginal, i, raiz);
            } else {
                return ArrayBinario;
            }
        }

        return ArrayBinario;
    }

    // Codigo binario completo texto original
    public String fraseOriginalBinarioCompleto(ArrayList<String> encodeMap) {
        StringBuilder listString = new StringBuilder();
        for (String entry : encodeMap) {
            listString.append(entry);
        }
        return listString.toString();
    }
    //Tabela de hexadecimal;
    public HashMap<String, String> mapaBinarioHexa(){
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("0000","0");
        mapa.put("0001","1");
        mapa.put("0010","2");
        mapa.put("0011","3");
        mapa.put("0100","4");
        mapa.put("0101","5");
        mapa.put("0110","6");
        mapa.put("0111","7");
        mapa.put("1000","8");
        mapa.put("1001","9");
        mapa.put("1010","A");
        mapa.put("1011","B");
        mapa.put("1100","C");
        mapa.put("1101","D");
        mapa.put("1110","E");
        mapa.put("1111","F");

        return mapa;
    }
    //Transformar de binario para hexadecimal
    public String binarioParaHexa(String fraseOriginalBinarioCompleto){
        HashMap<String, String> mapaBinarioHexa = mapaBinarioHexa();
        StringBuilder hexaString = new StringBuilder();

        ArrayList<String> arrayDe4Bits = new ArrayList<>();
        for (int i = 0; i < fraseOriginalBinarioCompleto.length(); i += 4) {
            arrayDe4Bits.add(fraseOriginalBinarioCompleto.substring(i, Math.min(i + 4,fraseOriginalBinarioCompleto.length())));
        }
        System.out.println(arrayDe4Bits);
        for(String string4Bits: arrayDe4Bits){
            for(Map.Entry<String, String> entry: mapaBinarioHexa.entrySet()){
                if(Objects.equals(string4Bits, entry.getKey())){
                    hexaString.append(entry.getValue());
                }
                if(string4Bits.length() < 4){
                    hexaString.append("@").append(string4Bits);
                    return hexaString.toString();
                }
            }
        }

        return hexaString.toString();
    }
    //Transformar o codigo hexadecimal para binario
    public String hexaParaBinario(String binarioParaHexa){
        System.out.println("Codigo hexadecimal: " + binarioParaHexa);
        HashMap<String, String> mapaBinarioHexa = mapaBinarioHexa();
        String [] arrayBinarioParaHexa = binarioParaHexa.split("");
        StringBuilder binarioString = new StringBuilder();

        for(int i = 0; i < arrayBinarioParaHexa.length; i++){
            for(Map.Entry<String, String> entry: mapaBinarioHexa.entrySet()){
                if(Objects.equals(entry.getValue(), arrayBinarioParaHexa[i])){
                    binarioString.append(entry.getKey());
                }

                if(Objects.equals(arrayBinarioParaHexa[i], "@")){
                    while(i < arrayBinarioParaHexa.length){
                        binarioString.append(arrayBinarioParaHexa[i]);
                        i++;
                    }
                    String [] arrayBinariosComArroba = binarioString.toString().split("");
                    List<String> arrayBinarioSemArroba = Arrays.stream(arrayBinariosComArroba).filter(p -> !Objects.equals(p, "@")).toList();
                    StringBuilder stringBinario = new StringBuilder();
                    for(String sNumBin:  arrayBinarioSemArroba){
                        stringBinario.append(sNumBin);
                    }
                    return stringBinario.toString();
                }

            }
        }
        return binarioString.toString();
    }


    //Decode de binario para String
    public String decode(HashMap<Character, String> mapa, String fraseOriginalBinarioCompleto, StringBuilder codigo, StringBuilder fraseOriginal, char[] mapaDesordenado){
        codigo.append(fraseOriginalBinarioCompleto.split("")[0]);
        for(int i = 1 ; i <= fraseOriginalBinarioCompleto.length(); i++){
            for(Map.Entry<Character, String> entry: mapa.entrySet()){
                if(Objects.equals(entry.getValue(), codigo.toString())){
                    fraseOriginal.append(entry.getKey());
                    if(fraseOriginal.length() == mapaDesordenado.length){
                        return fraseOriginal.toString();
                    }
                    codigo.delete(0, codigo.length());
                }
            }
            codigo.append(fraseOriginalBinarioCompleto.split("")[i]);
        }
        return fraseOriginal.toString();
    }


    // Imprime o mapa de frequencia com os codigos binarios
    public void imprimeMapaCodigoBinario(HashMap<Character, String> encodedMap) {
        Map<Character, String> encodedMapOrdenado = ordenarEncodedMapaPorValor(encodedMap);
        System.out.println();
        System.out.println();
        System.out.println("------------TABELA CHAR - CODIGO BINARIO-------------");
        System.out.printf("%10s %20s", "Caractere", "Codigo Binario");
        System.out.println();

        for (Map.Entry<Character, String> entry : encodedMapOrdenado.entrySet()) {
            char charzinho = entry.getKey();
            String valor = entry.getValue();
            System.out.format("%10s %20s", charzinho, valor);
            System.out.println();
        }
        System.out.println("--------------------------------------------");

    }

    public static Map<Character, String> ordenarEncodedMapaPorValor(Map<Character, String> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, String>> list = new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue());

        // put data from sorted list to hashmap
        Map<Character, String> temp = new LinkedHashMap<>();
        for (Map.Entry<Character, String> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}
