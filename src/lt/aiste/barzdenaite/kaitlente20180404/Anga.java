package lt.aiste.barzdenaite.kaitlente20180404;

public class Anga {

    private int padala;
    public final static int MAKSIMALI_PADETIS = 10;
    public final static int NULINE_PADETIS = 0;

    public Anga(int padala) {
        this.padala = padala;
    }

    public int getPadala() {
        return padala;
    }

    public void setPadala(int padala) {
        this.padala = padala;
    }

    @Override
    public String toString() {
        return "Anga{" +
                "padala = " + padala +
                '}';
    }
}
