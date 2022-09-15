package main;


import HuffmanTree.Tree;
import HuffmanTree.Node;
import frequencia.FrequenciaTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**/
public class Main {
    public static void main(String[] args) {
        String path = "/media/relanciosantos/RELANCIO TR/ProjetoHuffmanEnari/src/texto.txt/";
        StringBuilder jaEncontrados = new StringBuilder();
        Map<Character,Integer> tabelaFreq = new HashMap<Character, Integer>();
        FrequenciaTexto freq =  new FrequenciaTexto();
        int counter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            char [] arrayLine = new char[line.length()];

            Tree arvore = new Tree();
            Node arvoreDeHuffman;
            HashMap<Character, Integer> hm;

            arvoreDeHuffman = arvore.criarArvore(freq.mapaDeFrequenciaOrdenado(freq.frequenciaTexto(line, arrayLine, counter, jaEncontrados, tabelaFreq)));
            hm = arvore.encodeMap(arvoreDeHuffman, "", new HashMap<>());

            freq.imprimeMapa(freq.mapaDeFrequenciaOrdenado(freq.frequenciaTexto(line, arrayLine, counter, jaEncontrados, tabelaFreq)));
            arvore.imprimeMapa(hm);
            System.out.println(arvore.fullEncodeMap(hm));


        }catch (IOException e){
            System.out.println("Erro" + e.getMessage());
        }
    }
}
