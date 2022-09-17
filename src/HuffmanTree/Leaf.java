package HuffmanTree;

public class Leaf extends Node {
    protected char caractere;
    //Construtor
    public Leaf(char caractere, int frequencia) {
        super(frequencia, caractere);
        this.caractere = caractere;
    }
    //Getter e Setter
    public char getCaractere() {
        return caractere;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "Char: " + caractere + "" +
                " Freq: " + getFrequencia() + "" +
                '}';
    }
}
