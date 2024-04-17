import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int index;

        System.out.print("Enter the index number of your array number! : ");
        index = input.nextInt();
        int [] arrayNumber = getArrayNumber(index);
        printArrayNumber(arrayNumber);
        int [] sortArrayNumber =getArrayNumberSorted(arrayNumber);
        System.out.println("number sorted!");
        printArrayNumber(sortArrayNumber);


    }

    private static int[] getArrayNumberSorted(int []array) {
        int [] sortNumber =new int[array.length];
        for (int i =0;i<sortNumber.length;i++){
            sortNumber[i] = array[i];
        }
        boolean flag =true;
        int temp;
        while (flag){
            flag =false;
            for (int i =0; i<sortNumber.length-1;i++){
                if (sortNumber[i] < sortNumber[i+1]){
                    temp = sortNumber[i];
                    sortNumber[i]=sortNumber[i+1];
                    sortNumber[i+1]=temp;
                    flag =true;

                }
            }
        }
        return sortNumber;



    }

    private static void printArrayNumber(int [] array) {
        for (int i=0; i < array.length;i++){
            System.out.println(i+ " : "+array[i]);
        }
    }

    private static int[] getArrayNumber(int index) {
        int []number = new int[index];
        for (int i =0; i< number.length;i++){
            System.out.print("Enter the number of your choice! " + i+ " : ");
            number[i] = input.nextInt();

        }
        return number;
    }
}