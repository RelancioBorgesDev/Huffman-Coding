package HuffmanTree;

public class Node extends Tree implements Comparable<Node> {
    private final int frequencia;
    private Node esquerda, direita;
    private char caractere;

    //Construtores
    public Node(int frequencia, char caractere) {
        this.frequencia = frequencia;
        this.caractere = caractere;
    }

    public Node(Node esquerda, Node direita) {
        super();
        this.esquerda = esquerda;
        this.direita = direita;
        this.frequencia = esquerda.getFrequencia() + direita.getFrequencia();
    }

    //Getters
    public Node getEsquerda() {
        return esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public char getCaractere() {
        return caractere;
    }


    //Sobrescrita de métodos
    @Override
    public int compareTo(Node node) {
        return getFrequencia() - node.getFrequencia();
    }

    public int getFrequencia() {
        return frequencia;
    }
    @Override
    public String toString() {
        return "Esquerda: " + getEsquerda() + "\n" +
                "Direita: " + getDireita()  + "\t" +
                "Frequencia: " + getFrequencia()  + "\t";
    }
}
