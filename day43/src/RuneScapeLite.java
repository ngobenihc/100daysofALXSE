import java.util.Scanner;

public class RuneScapeLite {

    private static Scanner scanner = new Scanner(System.in);
    private static int playerLevel = 1;
    private static int playerXP = 0;
    private static int playerHP = 10;
    private static int monsterHP = 5;
    private static int monsterXP = 10;

    public static void main(String[] args) {
        System.out.println("Welcome to RuneScape Lite!");

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Train combat");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    trainCombat();
                    break;
                case 2:
                    System.out.println("Exiting game. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void trainCombat() {
        System.out.println("\nTraining combat...");

        while (monsterHP > 0 && playerHP > 0) {
            System.out.println("\nPlayer HP: " + playerHP);
            System.out.println("Monster HP: " + monsterHP);
            System.out.println("1. Attack");
            System.out.println("2. Retreat");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    attack();
                    break;
                case 2:
                    System.out.println("You retreat from the monster.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        if (playerHP <= 0) {
            System.out.println("You were defeated by the monster. Game over!");
            System.exit(0);
        } else {
            System.out.println("You defeated the monster!");
            playerXP += monsterXP;
            playerLevelUp();
            monsterHP = 5; // Reset monster's HP for next battle
        }
    }

    private static void attack() {
        int playerDamage = (int) (Math.random() * playerLevel) + 1;
        int monsterDamage = (int) (Math.random() * 2) + 1;

        System.out.println("You deal " + playerDamage + " damage to the monster.");
        monsterHP -= playerDamage;

        if (monsterHP <= 0) {
            return;
        }

        System.out.println("The monster attacks you and deals " + monsterDamage + " damage.");
        playerHP -= monsterDamage;
    }

    private static void playerLevelUp() {
        if (playerXP >= 100) {
            playerLevel++;
            playerXP -= 100;
            playerHP += 5;
            System.out.println("Congratulations! You leveled up to level " + playerLevel + "!");
        }
    }
}
