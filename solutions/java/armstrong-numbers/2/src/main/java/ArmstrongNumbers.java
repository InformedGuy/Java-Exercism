class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        int originalNumber = numberToCheck;
        int numberOfDigits = String.valueOf(Math.abs(numberToCheck)).length();

        int sum = 0;

        while (numberToCheck > 0) {
            int currentDigit = numberToCheck % 10;
            sum += (int) Math.pow(currentDigit, numberOfDigits);
            numberToCheck /= 10;
        }

        return sum == originalNumber;

    }

}
