import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;


public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        BigInteger a = new BigInteger(s.next());
        BigInteger b = new BigInteger(s.next());
        BigInteger ad=a.add(b);
        BigInteger mu=a.multiply(b);
        System.out.println(ad);
        System.out.println(mu);
    }
}