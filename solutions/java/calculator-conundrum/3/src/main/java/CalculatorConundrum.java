class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {

        int result = switch (operation) {
            case "+" -> operand1 + operand2;
            case "*" -> operand1 * operand2;
            case "/" -> divide(operand1, operand2);
            case null -> throw new IllegalArgumentException("Operation cannot be null");
            case "" -> throw new IllegalArgumentException("Operation cannot be empty");
            default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        };

        return String.format("%d %s %d = %d", operand1, operation, operand2, result);

    }

    private int divide(int operand1, int operand2) {
        try {
            return operand1 / operand2;
        } catch (ArithmeticException ae) {
            throw new IllegalOperationException("Division by zero is not allowed", ae);
        }
    }
}
