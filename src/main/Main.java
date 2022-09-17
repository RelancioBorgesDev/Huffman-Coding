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
        String path = "/media/relanciosantos/RELANCIO TR/ProjetoHuffmanEnari/src/texto.txt";

        StringBuilder jaEncontrados = new StringBuilder();
        Map<Character,Integer> tabelaFreq = new HashMap<Character, Integer>();
        FrequenciaTexto freq =  new FrequenciaTexto();

        int counter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            System.out.println("Texto Original: " + line);
            char[] charArray = line.toCharArray();
            Tree arvore = new Tree();
            Node arvoreDeHuffman;
            HashMap<Character, String> hm;

            arvoreDeHuffman = arvore.criarArvore(freq.mapaDeFrequenciaOrdenado(freq.frequenciaTexto(line, counter, jaEncontrados, tabelaFreq)));

            hm = arvore.encodeMap(arvoreDeHuffman, "", new HashMap<>());

            freq.imprimeMapa(freq.mapaDeFrequenciaOrdenado(freq.frequenciaTexto(line, counter, jaEncontrados, tabelaFreq)));

            arvore.imprimeMapa(hm);

            System.out.println("Codigo binario palavra compactada codificada: " + arvore.fullEncodeMap(hm));

            tabelaFreq = freq.mapaDeFrequenciaOrdenado(freq.frequenciaTexto(line, counter, jaEncontrados, tabelaFreq));

            String [] x = arvore.encodeOriginalStringArray(arvoreDeHuffman, "", new HashMap<>(), new String[line.length()], freq.mapaDesordenado(line),0, tabelaFreq);
            System.out.println("Codigo binario palavra original codificada: " + arvore.fullOriginalStringEncodeMap(x));

            String fraseDecodificada = arvore.decode(x, hm);
            System.out.println("A frase decodificada é : " + fraseDecodificada);

            if(Objects.equals(fraseDecodificada, line)){
                System.out.println("As frases são identicas.");
            }

        }catch (IOException e){
            System.out.println("Erro" + e.getMessage());
        }
    }
}
