import java.util.NoSuchElementException;

class RimOperation extends Operation{

    public RimOperation(Number number1, Number number2) {
        super(number1, number2);
    }

    public static boolean isNumeric(String member) {
        try {
            Integer.parseInt(member);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static int parseRimNumber(String rim) {
        for (RimNumbers number : RimNumbers.values()) {
            if (number.name().equals(rim)) {
                return number.getNum();
            }
        }
        throw new NoSuchElementException(
                "не является римским числом в диапозоне от 1 до 10 : " + rim);
    }

    private static String getRimNumber(int num) {
        for (RimNumbers number : RimNumbers.values()) {
            if (number.getNum() == num) {
                return number.name();
            }
        }
        throw new NoSuchElementException(
                "не является положительным римским числом : " + num);
    }

    public static String convertToRim(int num) {
        if (num / 10 == 0) {
            return (getRimNumber(num));
        } else {
            return "X" + getRimNumber(num - 10);
        }
    }

    public String calculate(String sign) throws Exception {
        String result = super.calculate(sign);
        int num = Integer.parseInt(result);
        return convertToRim(num);
    }
}
