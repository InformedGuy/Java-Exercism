public class EliudsEggs {

    public int eggCount(int number) {
        int numberOfEggs = 0;

        while (number > 0) {
            numberOfEggs += number & 1;
            number >>= 1;
        }

        return numberOfEggs;
    }
}
