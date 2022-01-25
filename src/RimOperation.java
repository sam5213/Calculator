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

    public static int parseRimNumber(String rim) throws CountOutOfBoundsException {
        for (RimNumbers number : RimNumbers.values()) {
            if (number.name().equals(rim)) {
                return number.getNum();
            }
        }
        throw new CountOutOfBoundsException(
                "не является римским числом в диапозоне от 1 до 10 : " + rim);
    }

    public static String convertToRim(int num) throws IllegalOperandException {
        if (num <= 0) {
            throw new IllegalOperandException(
                    "не является положительным римским числом : " + num);
        }

        String result = "";
        int[] roman_value_list = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman_char_list = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < roman_value_list.length; i++) {
            while (num >= roman_value_list[i]) {
                num -= roman_value_list[i];
                result += roman_char_list[i];
            }
        }
        return result;
    }

    public String calculate(String sign) throws Exception {
        String result = super.calculate(sign);
        int num = Integer.parseInt(result);
        return convertToRim(num);
    }
}
