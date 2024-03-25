import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double basicRateOfPerMonth = 60.0;
        double additionalMonthPerMessageCharged = 0.05;
        double additionalFees = 0.10;
        double totalAdditionalFees;
        double totalMessageSent;
        double billAmount;
        int numText;
        int remainder;
        int messageSent;

        System.out.println("Enter the number of sent text per month ");
        numText = input.nextInt();

        remainder = numText % 100;
        messageSent = numText-remainder;

        totalAdditionalFees = remainder*additionalFees;
        totalMessageSent = messageSent*additionalMonthPerMessageCharged + basicRateOfPerMonth;
        billAmount = totalAdditionalFees + totalMessageSent;

        System.out.println("The monthly additional fees is  R" + totalAdditionalFees);
        System.out.println("The monthly basically month fees is  R" + totalMessageSent);
        System.out.println("The monthly bill is  R" + billAmount);

    }
}