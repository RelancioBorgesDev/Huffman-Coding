package frequencia;

import Tree.Node;

import java.util.*;

public class FrequenciaTexto  {
    public Map<Object, Integer> frequenciaTexto (String line, char[] arrayLine, int counter, StringBuilder jaEncontrados, Map<Object, Integer> tabelaFreq) {
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

    public static Map<Object, Integer> ordenarPorValor(Map<Object, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Object, Integer> > list =
                new LinkedList<Map.Entry<Object, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Object, Integer> >() {
            public int compare(Map.Entry<Object, Integer> o1,
                               Map.Entry<Object, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        Map<Object, Integer> temp = new LinkedHashMap<Object, Integer>();
        for (Map.Entry<Object, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}



