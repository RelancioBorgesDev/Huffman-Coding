package Tree;

public class Leaf extends Node {
    protected final char caractere;

    public char getCaractere() {
        return caractere;
    }

    public Leaf(char caractere, int frequencia) {
        super(frequencia);
        this.caractere = caractere;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "Char: " + caractere + "" +
                " Freq: " + getFrequencia() + "" +
                '}';
    }
}
