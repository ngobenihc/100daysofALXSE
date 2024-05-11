import java.util.Scanner;

public class Main {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        char a_string[]=a.toLowerCase().toCharArray();
        char b_string[]=b.toLowerCase().toCharArray();
        boolean returnValue;
        if(a_string !=null && b_string!=null){
            java.util.Arrays.sort(a_string);
            java.util.Arrays.sort(b_string);
            returnValue=java.util.Arrays.equals(a_string,b_string);
            return returnValue;
        }
        else{
            return returnValue=false;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
