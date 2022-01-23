import java.util.Scanner;

public class Calc {
    public static final int OPERAND_COUNT = 3;

    public static Number getValidNumber(String number) throws Exception {
        if (RimOperation.isNumeric(number)) {
            int arabicNumber = Integer.parseInt(number);
            return new Number(arabicNumber, Notation.ARABIC);
        } else if (ArabicOperation.isArabic(number)) {
            int rimNumber = RimOperation.parseRimNumber(number);
            return new Number(rimNumber, Notation.ROMAN);
        } else throw new Exception("Калькулятор принимает на вход арабские и римские числа");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        String[] membersExpression = expression.split("\\s+");
        Operation operations;

        try {
            if (membersExpression.length == OPERAND_COUNT) {

                Number number1 = getValidNumber(membersExpression[0]);
                Number number2 = getValidNumber(membersExpression[2]);

                if (number1.getNotationValue() == Notation.ARABIC && number2.getNotationValue() == Notation.ARABIC) {
                    operations = new ArabicOperation(number1, number2);

                } else if (number1.getNotationValue() == Notation.ROMAN && number2.getNotationValue() == Notation.ROMAN) {
                    operations = new RimOperation(number1, number2);
                } else {
                    throw new Exception("используются одновременно разные системы счисления");
                }

                String result = operations.calculate(membersExpression[1]);
                System.out.println(result);

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
