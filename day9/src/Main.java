import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("eneter a number and let us see if it's a palindrome or not ");
        Scanner sc=new Scanner(System.in);
        String A=sc.next();


        boolean palindrome = true;

        for(int i = 0; i<A.length()/2;i++)
        {
            if(!A.substring(i,i+1).equals(A.substring(A.length()-i-1,A.length()-i)))
            {
                palindrome = false;
            }
        }
        if(palindrome){System.out.println("Yes it's a  palindrome");}
        else{System.out.println("No it's not palindrome");}

    }
}