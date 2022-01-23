public class ExpressionFormatException extends Exception{
    public ExpressionFormatException(String message) {
        super(message);
    }
}

class MathFormatExpression extends ExpressionFormatException {
    public MathFormatExpression(String message) {
        super(message);
    }
}

class IllegalOperationException extends MathFormatExpression {
    public IllegalOperationException(String message) {
        super(message);
    }
}

class IllegalNotationException extends ExpressionFormatException {
    public IllegalNotationException(String message) {
        super(message);
    }
}

class RimExpressionException extends ExpressionFormatException {
    public RimExpressionException(String message) {
        super(message);
    }
}

class IllegalOperandException extends RimExpressionException {
    public IllegalOperandException(String message) {
        super(message);
    }
}

class CountOutOfBoundsException extends RimExpressionException {
    public CountOutOfBoundsException(String message) {
        super(message);
    }
}

class UnsupportedNumbersOfExpressionException extends ExpressionFormatException {
    public UnsupportedNumbersOfExpressionException(String message) {
        super(message);
    }
}