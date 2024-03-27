import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Double minutesPerCall = 05.00;
        Double remainderPrice = 15.00;
        int minutesCalls;
        int remainder;
        int callsPer3Minutes;
        Double costPer3;
        Double remainderCost;
        Double totalCost;
        System.out.print("Enter the minutes per call :");
        minutesCalls = input.nextInt();


        remainder = minutesCalls % 3;
        remainderCost = remainder * remainderPrice;
        callsPer3Minutes = (minutesCalls - remainder) / 3;
        costPer3 = callsPer3Minutes * minutesPerCall;
        totalCost = costPer3 + remainderCost;

        System.out.println("The total price for call is R" + totalCost);
        System.out.println("");
    }
}