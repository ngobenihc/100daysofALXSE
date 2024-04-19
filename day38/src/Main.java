import java.util.Scanner;



public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter index number :");
        int index = input.nextInt();

        int [] arrayNumber = getInput(index);
        System.out.println(" ");
        System.out.println("non reserved array ");
        displayArray(arrayNumber);
        System.out.println(" ");
        System.out.println("reserved array");
        int [] reverse = getReverse(arrayNumber);
        displayArray(reverse);
    }

    private static int[] getReverse(int[] arrayNumber) {
        int temp;
        int max_Index = arrayNumber.length-1;
        int middleIndex = arrayNumber.length/2;
        for (int i =0;i<middleIndex;i++){
            temp = arrayNumber[i];
            arrayNumber[i] = arrayNumber[max_Index-i];
            arrayNumber[max_Index-i]=temp;
        }
        return arrayNumber;
    }

    private static void displayArray(int[] arrayNumber) {
        //int [] num = new int[arrayNumber.length];
        for (int i =0; i< arrayNumber.length;i++){
            System.out.println(" "+i+" :" + arrayNumber[i]);
        }
    }

    private static int[] getInput(int index) {
        int [] numberArray = new int[index];
        for (int i =0; i<numberArray.length;i++){
            System.out.print("Enter number: "+i+" :");
            numberArray[i]=input.nextInt();
        }
        return numberArray;
    }


}