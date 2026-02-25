public class EliudsEggs {

    /**
     * The goal is to count the number of 1 bits (number of eggs) in the binary representation of a number
     * This algorithm does this in the following steps:
     * 1. If the least significant bit (last binary digit) of the number is 1, increment number of eggs
     * 2. Shift the number to the right by one step
     * 3. Continue with steps 1 and 2 until the decimal representation of the number is zero
     */

    public int eggCount(int number) {
        int numberOfEggs = 0;

        while (number > 0) {
            if ((number & 1) == 1) {
                numberOfEggs++;
            }

            number = number >> 1;
        }

        return numberOfEggs;
    }
}
