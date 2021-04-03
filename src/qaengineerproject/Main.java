package qaengineerproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declarations
        int smallDogs, mediumDogs, largeDogs;

        int lbsFoodRemainingEOM;

        //create scanner
        Scanner scanner = new Scanner(System.in);

        //display prompt
        System.out.print("Please enter number of small dogs: ");
        smallDogs = scanner.nextInt();
        System.out.print("Please enter number of medium dogs: ");
        mediumDogs = scanner.nextInt();
        System.out.print("Please enter number of large dogs: ");
        largeDogs = scanner.nextInt();
        System.out.print("Please enter lbs of food remaining: ");
        lbsFoodRemainingEOM = scanner.nextInt();

        //calculations
        Calculations.CalculateDogSizeFoodNeeds(smallDogs, mediumDogs, largeDogs);
        Calculations.CalculateNetLbsEOM(lbsFoodRemainingEOM);
        var amountOfFoodToOrder = Calculations.CalculateTotalAmountOfFoodToOrder();

        //results
        System.out.println("The amount of food you need to order: " + amountOfFoodToOrder + "lbs");
    }
}
