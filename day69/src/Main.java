import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        List<Integer> L=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            L.add(s.nextInt());
        }
        int Q=s.nextInt();
        for(int i=0;i<Q;i++)
        {
            switch(s.next())
            {
                case "Insert":
                    L.add(s.nextInt(),s.nextInt());
                    break;
                case "Delete":
                    L.remove(s.nextInt());
            }
        }
        for(Integer e:L)
        {
            System.out.print(e+" ");
        }
    }
}