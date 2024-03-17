import java.util.Scanner;

import java.util.ArrayList;

public class FizzBuzz {
    public String checkNumber(int number) {
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;

        if (( divisibleBy3) && (divisibleBy5 )) {
            return "FizzBuzz";
        }
        else if (divisibleBy3){
            return "Fizz";
        }
        else  if (divisibleBy5){
            return "Buzz";
        }
        else {
            return String.valueOf(number);
        }
    }

    public String countTo(int number) {
        ArrayList<String> store_num = new ArrayList<>();
        for(int h =1;h<= number;h++){
            store_num.add(checkNumber(h));
        }
        return store_num.toString();
    }



    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);

        int number;
        System.out.print("enter a number: ");
        number = input.nextInt();
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.countTo(number));


    }
}
