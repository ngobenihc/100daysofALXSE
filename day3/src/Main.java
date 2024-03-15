import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int index;
        int number;
        int sum =0;
        int ava =0;
        System.out.print("enter the number that you want the loop to loop to : ");
        index = input.nextInt();

        for (int i =1; i < index; i++){
            System.out.print("enter the number you want the sum and ava of " + i + " : ");
            number = input.nextInt();

            sum = sum + number;
            ava = sum/i;
        }

        System.out.println("the ava is!" + ava);
        System.out.println("the sum is! "+ sum);
    }
}