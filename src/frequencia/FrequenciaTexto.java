package frequencia;

import java.util.*;

public class FrequenciaTexto  {
    public void imprimeMapa(Map<Character, Integer> mp ){
        Map<Character, Integer> mapaOrdenado = mapaDeFrequenciaOrdenado(mp);
        System.out.println("------------TABELA DE FREQUENCIA-------------");
        System.out.printf("%10s %20s", "Caractere", "Frequencia");
        System.out.println();

        for (Map.Entry<Character, Integer> entry : mapaOrdenado.entrySet()) {
            char charzinho = entry.getKey();
            Integer valor = entry.getValue();
            System.out.format("%10s %20s",charzinho, valor);
            System.out.println();
        }

        System.out.println("--------------------------------------------");

    }
    public Map<Character, Integer> mapaDeFrequenciaOrdenado (Map<Character, Integer> hm){
        return ordenarPorValor(hm);
    }


    public Map<Character, Integer> frequenciaTexto (String line, int counter, StringBuilder jaEncontrados, Map<Character, Integer> tabelaFreq) {
        for (int i = 0; i < line.split("").length; i++){
            for (int j = 0; j < line.split("").length; j++) {
                if(line.charAt(i) == line.charAt(j)){
                    counter++;
                }
            }
            char c = line.charAt(i);
            if (!jaEncontrados.toString().contains("" + c)) {
                jaEncontrados.append(c);
                tabelaFreq.put(c, counter);
            }
            counter = 0;
        }
        return tabelaFreq;
    }
    public char[] mapaDesordenado (String line) {
        char [] charMap = new char[line.length()];
        for (int i = 0; i < line.split("").length; i++){
             char c = line.charAt(i);
            charMap[i] = c;
        }
        System.out.println(charMap.length);
        return charMap;
    }


    public static Map<Character, Integer> ordenarPorValor(Map<Character, Integer> hm) {
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<>(hm.entrySet());

        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        Map<Character, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}



