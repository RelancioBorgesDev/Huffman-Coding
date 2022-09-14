package frequencia;

import Tree.Node;

import java.util.*;

public class FrequenciaTexto  {
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



