import java.util.Scanner;

public class Solution {

    /*
     * Recursive approach
     */
    static boolean move(int i, int leap, int[] game) {

//        System.out.println("move <<< i: " + i);

        // **** end condition ****
        if ((i < 0) || (game[i] == 1))
            return false;

        if ((i == game.length - 1) || (i + leap > game.length - 1))
            return true;

        // **** flag we are done with this entry (avoids getting stuck going forward and backwards) ****
        game[i] = 1;

        // **** ****
        return move(i - 1, leap, game) || move(i + 1, leap, game) || move(i + leap, leap, game);
    }


    /*
     * Return true if you can win the game; otherwise, return false.
     */
    public static boolean canWin(int leap, int[] game) {

//        // **** display input arguments ****
//        System.out.println("leap: " + leap);
//        System.out.print("game: ");
//        for (int v : game)
//            System.out.print(v + " ");
//        System.out.println();

        // **** start with index 0 (game[0] == 0) ****
        boolean result = move(0, leap, game);

//        // **** display final array ****
//        System.out.print("game: ");
//        for (int v : game)
//            System.out.print(v + " ");
//        System.out.println();

        // **** ****
        return result;
    }


    /*
     * Test scaffold
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }

}