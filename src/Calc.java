import java.util.Scanner;

public class Calc {
    public static final int OPERAND_COUNT = 3;
    public static Operation operations;

    public static boolean isExpressionLengthValid(int length) throws ExpressionFormatException {
        if (length < OPERAND_COUNT) {
            throw new MathFormatExpression("строка не является математической операцией");
        }
        if (length > OPERAND_COUNT) {
            throw new ExpressionFormatException("формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *) ");
        }
        return length == OPERAND_COUNT;
    }

    public static String[] enterExpression() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        return expression.split("\\s+");
    }

    public static void main(String[] args) {
        String[] membersExpression = enterExpression();
        try {
            Number number1 = Number.getValidNumber(membersExpression[0]);
            Number number2 = Number.getValidNumber(membersExpression[2]);

            if (isExpressionLengthValid(membersExpression.length)) {
                if (number1.getNotationValue() == Notation.ARABIC && number2.getNotationValue() == Notation.ARABIC) {
                    operations = new ArabicOperation(number1, number2);
                } else if (number1.getNotationValue() == Notation.ROMAN && number2.getNotationValue() == Notation.ROMAN) {
                    operations = new RimOperation(number1, number2);
                } else {
                    throw new IllegalNotationException("используются одновременно разные системы счисления");
                }

                String result = operations.calculate(membersExpression[1]);
                System.out.println(result);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
