
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double lost5per = 0.05;
        int numberOfEggs;
        double eggCost;
        int totalEggsToSell;
        double totalPrice;
        double increaseProfit = 0.25;
        double profit;
        int brokeEggs;
        String output;

        System.out.print("enter the number of eggs you bought to sell : ");
        numberOfEggs =input.nextInt();

        System.out.print("Enter the selling amount of each egg : R");
        eggCost = input.nextDouble();

        brokeEggs =numberOfEggs - (int) (numberOfEggs -(numberOfEggs*lost5per)) ;
        
        totalEggsToSell = (int) (numberOfEggs -(numberOfEggs*lost5per));

        totalPrice = totalEggsToSell*eggCost;

        profit = totalPrice - (totalPrice*increaseProfit);


        output ="she bought "+numberOfEggs + " and 5% of the eggs broke "+ brokeEggs+" and she  had to sell "+totalEggsToSell+" eggs and made R"+ totalPrice +" and 25% profit R"+ profit;


        System.out.println(output);
    }
}