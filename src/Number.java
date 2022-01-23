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

    public static Number getValidNumber(String number) throws ExpressionFormatException {
        if (RimOperation.isNumeric(number)) {
            int arabicNumber = Integer.parseInt(number);
            return new Number(arabicNumber, Notation.ARABIC);
        } else if (ArabicOperation.isArabic(number)) {
            int rimNumber = RimOperation.parseRimNumber(number);
            return new Number(rimNumber, Notation.ROMAN);
        } else throw new UnsupportedNumbersOfExpressionException("Калькулятор принимает на вход арабские и " +
                "римские числа");
    }
}
