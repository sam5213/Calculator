public class ArabicOperation extends Operation{

    public ArabicOperation(Number number1, Number number2) {
        super(number1, number2);
    }

    public static boolean isArabic(String member) {
        try {
            RimNumbers.valueOf(member);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }
}