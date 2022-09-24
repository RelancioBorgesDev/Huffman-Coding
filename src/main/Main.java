package main;


import HuffmanTree.Tree;
import HuffmanTree.Node;
import frequencia.FrequenciaTexto;

import java.io.*;
import java.util.*;

/**/
public class Main {
    public static void main(String[] args) {
        String path = "/media/relanciosantos/RELANCIO TR/ProjetoHuffmanEnari/src/texto.txt";
        StringBuilder jaEncontrados = new StringBuilder();
        Map<Character,Integer> tabelaFreq = new HashMap<>();
        FrequenciaTexto freq =  new FrequenciaTexto();
        int counter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            System.out.println("Texto Original: " + line);
            Tree arvore = new Tree();
            Node arvoreDeHuffman;
            HashMap<Character, String> hm;

            arvoreDeHuffman = arvore.criarArvore(freq.mapaDeFrequenciaOrdenado(freq.frequenciaTexto(line,counter, jaEncontrados, tabelaFreq)));
            hm = arvore.mapaBinario(arvoreDeHuffman, "", new HashMap<>());
            freq.imprimeMapa(freq.mapaDeFrequenciaOrdenado(freq.frequenciaTexto(line,counter, jaEncontrados, tabelaFreq )));
            arvore.imprimeMapaCodigoBinario(hm);

            System.out.println("Codigo binario palavra compactada codificada: " + arvore.mapaBinarioCompleto(hm));
            tabelaFreq = freq.mapaDeFrequenciaOrdenado(freq.frequenciaTexto(line,  counter, jaEncontrados, tabelaFreq));
            
            ArrayList <String> arrayBinarioFraseOriginal = arvore.fraseOriginalBinario(arvoreDeHuffman, "", new ArrayList<>(), freq.mapaDesordenado(line),0, tabelaFreq);
            System.out.println("Codigo binario palavra original codificada: " + arvore.fraseOriginalBinarioCompleto(arrayBinarioFraseOriginal));

           String hexaDecimal = arvore.binarioParaHexa(arvore.fraseOriginalBinarioCompleto(arrayBinarioFraseOriginal));
           criarArquivo(hexaDecimal);
           String codigoBinario = arvore.hexaParaBinario(descompactarArquivoTxt());
           String stringDecodificada = arvore.decode(hm, codigoBinario, new StringBuilder(), new StringBuilder(), line);
           System.out.println("Palavra decodificada: " +  stringDecodificada);

           if(Objects.equals(stringDecodificada, line)){
               System.out.println("As String são iguais");
           }


        }catch (IOException e){
            System.out.println("Erro" + e.getMessage());
        }
    }
    //Metodo que cria arquivo compactado
    public static void criarArquivo(String hexaDecimal){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("ArquivoCompactado.txt"));
            for(String hexa : hexaDecimal.split("")){
                writer.write(hexa);
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    //Metodo que lê o codigo binario do arquivo compactado e retorna a string binaria
    public static String descompactarArquivoTxt(){
        StringBuilder novaString = new StringBuilder();
        String path = "/media/relanciosantos/RELANCIO TR/ProjetoHuffmanEnari/ArquivoCompactado.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                novaString.append(line);
                line = reader.readLine();
            }
            reader.close();
            return novaString.toString();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return novaString.toString();
    }

}
