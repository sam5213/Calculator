public class Operation {

    private Integer number1;
    private Integer number2;

    public Operation(int a, int b) {
        number1 = a;
        number2 = b;
    }

    private int add(Integer number1, Integer number2) {
        return number1 + number2;
    }

    private int minus(Integer number1, Integer number2) {
        return number1 - number2;
    }

    private int multiple(Integer number1, Integer number2) {
        return number1 * number2;
    }

    private int divide(Integer number1, Integer number2) {
        return number1 / number2;
    }

    public int recognizeSign(String sign) throws Exception{
        switch (sign) {
            case "+":
                return add(number1, number2);
            case "-":
                return minus(number1, number2);
            case "*":
                return multiple(number1, number2);
            case "/":
                return divide(number1, number2);
            default:
                throw new Exception("Калькулятор умеет выполнять операции +, -, * и / ");
        }
    }
}
