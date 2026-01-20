class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {

        try
        {
            int result = switch (operation) {
                case "+" -> operand1 + operand2;
                case "*" -> operand1 * operand2;
                case "/" -> operand1 / operand2;
                case null -> throw new IllegalArgumentException("Operation cannot be null");
                case "" -> throw new IllegalArgumentException("Operation cannot be empty");
                default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
            };

            return String.valueOf(operand1) + " " + operation + " " + String.valueOf(operand2) + " = " + String.valueOf(result);
        } catch (ArithmeticException ae) {
            throw new IllegalOperationException("Division by zero is not allowed", ae);
        }

    }
}
