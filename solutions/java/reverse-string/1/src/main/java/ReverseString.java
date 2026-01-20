class ReverseString {

    String reverse(String inputString) {
        StringBuilder reversedInputString = new StringBuilder(inputString);
        reversedInputString.reverse();
        return reversedInputString.toString();
    }
  
}
