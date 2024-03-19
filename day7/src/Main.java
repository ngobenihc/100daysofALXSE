package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int index =4;

        int [] itemNumber = new int[index];
        double perItem = 6.50;
        String [] studentName = new String[index];
        String bestName=" ";
        double bestAmount =0;


        for (int i = 1;i<index;i++){
            System.out.print("Enter the number of item sold : ");
            itemNumber[i] = input.nextInt();
            System.out.print("Enter the name of the student : ");
            input.nextLine();
            studentName[i] = input.nextLine();
        }


        for (int i = 1 ; i < index; i++){
            double  amount = itemNumber[i]*perItem;

            bestName = studentName[i];
            System.out.println("the name of the student is "+studentName[i] +" the amount made is "+ amount);

            if(amount > bestAmount ){
                bestName = studentName[i];
                bestAmount=amount;

            }
        }

        System.out.println("the name of the best seller is " + bestName +" made "+ bestAmount);
    }
}