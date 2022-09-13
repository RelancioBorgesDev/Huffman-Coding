package main;


import Tree.Tree;
import Tree.Node;
import frequencia.FrequenciaTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/**/
public class Main {
    public static void main(String[] args) {
        String path = "/media/relanciosantos/RELANCIO TR/ProjetoHuffmanEnari/src/texto.txt/";


        StringBuilder jaEncontrados = new StringBuilder();
        Map<Object,Integer> tabelaFreq = new HashMap<Object, Integer>();
        Map<Object,Integer> newTabelaFreq = new HashMap<Object, Integer>();
        FrequenciaTexto freq =  new FrequenciaTexto();

        int counter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            char [] arrayLine = new char[line.length()];
            line.getChars(0, line.length(), arrayLine, 0);

            newTabelaFreq =  freq.ordenarPorValor(freq.frequenciaTexto(line, arrayLine, counter, jaEncontrados, tabelaFreq));
            System.out.println(newTabelaFreq);
            Tree arv = new Tree();

            Node x = arv.criarArvore(newTabelaFreq);
            System.out.println(x);


        }catch (IOException e){
            System.out.println("Erro" + e.getMessage());
        }
    }
}
