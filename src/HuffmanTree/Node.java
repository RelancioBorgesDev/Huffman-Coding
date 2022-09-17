package HuffmanTree;

public class Node extends Tree implements Comparable<Node> {
    private int frequencia;
    private Node esquerda, direita;
    private char caractere;

    //Construtores
    public Node() {
    }

    public Node(int frequencia) {
        this.frequencia = frequencia;
    }

    public Node(int frequencia, char caractere) {
        this.frequencia = frequencia;
        this.caractere = caractere;
    }

    public Node(Node esquerda, Node direita, int frequencia, char ch) {
        super();
        this.esquerda = esquerda;
        this.direita = direita;
        this.frequencia = frequencia;
    }
    public Node(Node esquerda, Node direita) {
        super();
        this.esquerda = esquerda;
        this.direita = direita;
        this.frequencia = esquerda.getFrequencia() + direita.getFrequencia();
    }


    //Getters e Setters
    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public char getCaractere() {
        return caractere;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
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
