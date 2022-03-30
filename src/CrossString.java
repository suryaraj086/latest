public class CrossString {

    public static void main(String[] args) {
        String word = "coder";
        printCrossString(word);
    }

    private static void printCrossString(String word) {
        int n = word.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) System.out.print(word.charAt(i));
                else if (i + j == n-1) System.out.print(word.charAt(n-1-i));
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}