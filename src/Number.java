public class Number {
    private int value;
    private Notation notationValue;

    public Number(int value, Notation notationValue) {
        this.value = value;
        this.notationValue = notationValue;
    }
    public Number(int value) {
        this(value, Notation.ARABIC);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Notation getNotationValue() {
        return notationValue;
    }

    public void setNotationValue(Notation notationValue) {
        this.notationValue = notationValue;
    }
}
