import java.util.Scanner;
public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("index : ");
        int index = input.nextInt();

        int []arrayNumber = getInput(index);
        int minNumber = findMin(arrayNumber);
        System.out.println("min number !"+ minNumber);
    }

    private static int findMin(int[] arrayNumber) {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<arrayNumber.length;i++){
            int value = arrayNumber[i];
            if (value <min){
                min =value;
            }

        }
        return min;
    }

    private static int[] getInput(int index) {
        int [] arraynumber = new int[index];

        for(int i =0;i<arraynumber.length;i++){
            System.out.print("Enter number : "+i+" : ");
            int number = input.nextInt();
            //input.nextLine();
            arraynumber[i]=number;
            //input.nextLine();
        }
        return arraynumber;
    }
}