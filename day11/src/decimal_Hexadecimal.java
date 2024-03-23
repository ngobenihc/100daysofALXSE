import java.util.InputMismatchException;
import java.util.Scanner;

class decimal_Hexadecimal {
    Scanner scanner;
    int decimal_Number;

    int Decimal_Num(){

        // the method which allows the user to give an input of a decimal number

        try {
            scanner = new Scanner(System.in);
            System.out.print("Enter number in Decimal from 0 to 10000: ");
            decimal_Number= scanner.nextInt();
            if (decimal_Number <=10000){
                return decimal_Number;
            }
        } catch( InputMismatchException ex1 ) {
            System.err.println("Please Input in Integer not string :");
        }

        return Decimal_Num();


    }
    int convert_Decimal_To_Haxedecimal(){

        // converting decimal numbers to hexadecimal
        String hexadecimal_Number = Integer.toHexString(decimal_Number);
        System.out.println("Decimal number of :" + decimal_Number +" is = "+ hexadecimal_Number.toUpperCase() +" in Hexadecimal");
        return decimal_Number;
    }
    int convert_Decimal_To_Binary(){
        // converting decimal numbers to binaries
        String binary_Number = Integer.toBinaryString(decimal_Number);
        System.out.println("Decimal number of :" + decimal_Number +" is = "+ binary_Number +" in Binaries");
        return Integer.parseInt((binary_Number));

    }
    void convert_Binary_To_Decimal(int decimal_Num){
        //converting binaries to decimal

        System.out.println("Binary number of :" +  decimal_Num +" is = "+ decimal_Number +" in Decimal");
    }
}