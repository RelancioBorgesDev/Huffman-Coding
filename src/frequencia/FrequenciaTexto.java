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


    public Map<Character, Integer> frequenciaTexto (String line, char[] arrayLine, int counter, StringBuilder jaEncontrados, Map<Character, Integer> tabelaFreq) {
        for (int i = 0; i < arrayLine.length; i++){
            for (int j = 0; j < arrayLine.length; j++) {
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



    public static Map<Character, Integer> ordenarPorValor(Map<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
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



