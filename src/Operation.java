public class Operation {

    private Number number1;
    private Number number2;

    public Operation(Number number1, Number number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    private Number add(Number number1, Number number2) {
        int result = number1.getValue() + number2.getValue();
        return new Number(result);
    }

    private Number minus(Number number1, Number number2) {
        int result = number1.getValue() - number2.getValue();
        return new Number(result);
    }

    private Number multiple(Number number1, Number number2) {
        int result = number1.getValue() * number2.getValue();
        return new Number(result);
    }

    private Number divide(Number number1, Number number2) {
        int result = number1.getValue() / number2.getValue();
        return new Number(result);
    }

    public String calculate(String sign) throws Exception{
        Number result;

        switch (sign) {
            case "+":
                result = add(number1, number2);
                break;
            case "-":
                result = minus(number1, number2);
                break;
            case "*":
                result = multiple(number1, number2);
                break;
            case "/":
                result = divide(number1, number2);
                break;
            default:
                throw new IllegalOperationException("Калькулятор умеет выполнять операции +, -, * и / ");
        }

        return String.valueOf(result.getValue());
    }
}
