class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        String numberAsString = String.valueOf(Math.abs(numberToCheck));

        int numberOfDigits = numberAsString.length();

        int sumOfDigits = 0;

        for (int i = 0; i < numberOfDigits; i++) {
            int currentDigit = Integer.parseInt(String.valueOf(numberAsString.charAt(i)));
            sumOfDigits += (int) Math.pow(currentDigit, numberOfDigits);
        }

        return numberToCheck == sumOfDigits;

    }

}
