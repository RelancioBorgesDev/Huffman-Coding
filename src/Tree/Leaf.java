package Tree;

public class Leaf extends Node {
    protected final Object caractere;

    public Object getCaractere() {
        return caractere;
    }

    public Leaf(Object caractere, int frequencia) {
        super(frequencia);
        this.caractere = caractere;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "Char: " + caractere + "" +
                "Freq: " + getFrequencia() + "" +
                '}';
    }
}
