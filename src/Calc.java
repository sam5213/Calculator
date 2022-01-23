import java.util.Scanner;

public class Calc {
    public static final int OPERAND_COUNT = 3;

    public static boolean isNumeric(String member) {
        try {
            Integer.parseInt(member);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static boolean isArabic(String member) {
        try {
            RimNumbers.valueOf(member);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        String[] membersExpression = expression.split("\\s+");
        int num1, num2;

        try {
            if (membersExpression.length == OPERAND_COUNT) {
                String numString1 = membersExpression[0];
                String numString2 = membersExpression[2];

                if (isNumeric(numString1) && isNumeric(numString2)) {

                    num1 = Integer.parseInt(numString1);
                    num2 = Integer.parseInt(numString2);

                    Operation operations = new Operation(num1, num2);
                    int result = operations.recognizeSign(membersExpression[1]);
                    System.out.println(result);

                } else if (isArabic(numString1) && isArabic(numString2)) {
                    num1 = RimOperation.parseRimNumber(numString1);
                    num2 = RimOperation.parseRimNumber(numString2);

                    Operation operations = new Operation(num1, num2);
                    int result = operations.recognizeSign(membersExpression[1]);
                    System.out.println(RimOperation.convertToRim(result));

                } else {
                    throw new Exception("используются одновременно разные системы счисления");
                }

            } else if (membersExpression.length > OPERAND_COUNT) {
                throw new Exception("формат математической операции не удовлетворяет заданию - " +
                        "два операнда и один оператор (+, -, /, *) ");
            } else {
                throw new Exception("строка не является математической операцией");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
