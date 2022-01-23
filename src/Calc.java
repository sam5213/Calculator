import java.util.Scanner;

public class Calc {
    public static final int OPERAND_COUNT = 3;
    public static Operation operations;

    public static Number getValidNumber(String number) throws Exception {
        if (RimOperation.isNumeric(number)) {
            int arabicNumber = Integer.parseInt(number);
            return new Number(arabicNumber, Notation.ARABIC);
        } else if (ArabicOperation.isArabic(number)) {
            int rimNumber = RimOperation.parseRimNumber(number);
            return new Number(rimNumber, Notation.ROMAN);
        } else throw new Exception("Калькулятор принимает на вход арабские и римские числа");
    }

    public static boolean isExpressionLengthValid(int length) throws Exception {
        if (length < OPERAND_COUNT) {
            throw new Exception("строка не является математической операцией");
        }

        if (length > OPERAND_COUNT) {
            throw new Exception("формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *) ");
        }

        return length == OPERAND_COUNT;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String[] membersExpression = expression.split("\\s+");

        try {
            Number number1 = getValidNumber(membersExpression[0]);
            Number number2 = getValidNumber(membersExpression[2]);

            if (isExpressionLengthValid(membersExpression.length)) {
                if (number1.getNotationValue() == Notation.ARABIC && number2.getNotationValue() == Notation.ARABIC) {
                    operations = new ArabicOperation(number1, number2);

                } else if (number1.getNotationValue() == Notation.ROMAN && number2.getNotationValue() == Notation.ROMAN) {
                    operations = new RimOperation(number1, number2);
                } else {
                    throw new Exception("используются одновременно разные системы счисления");
                }

                String result = operations.calculate(membersExpression[1]);
                System.out.println(result);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
