package qaengineerproject;

public class Calculations {
    //declarations
    static int lbsOfSmallDogFood, lbsOfMediumDogFood, lbsOfLargeDogFood;

    static int smallDogFoodNeeds = 10;
    static int mediumDogFoodNeeds = 20;
    static int largeDogFoodNeeds = 30;

    static final double percentMoreToOrder = 0.20;

    static int netLbsEOM;

    public static void CalculateDogSizeFoodNeeds(int smallDogs, int mediumDogs, int largeDogs) {
        lbsOfSmallDogFood = smallDogs * smallDogFoodNeeds;
        lbsOfMediumDogFood = mediumDogs * mediumDogFoodNeeds;
        lbsOfLargeDogFood = largeDogs * largeDogFoodNeeds;
    }

    public static void CalculateNetLbsEOM(int lbsFoodRemainingEOM) {
        var totalLbsOfDogFoodUsed = lbsOfSmallDogFood + lbsOfMediumDogFood + lbsOfLargeDogFood;

        netLbsEOM = totalLbsOfDogFoodUsed - lbsFoodRemainingEOM;
    }

    public static double CalculateTotalAmountOfFoodToOrder() {
        var percentageOfFoodToOrder = percentMoreToOrder * netLbsEOM;

        var amountOfFoodToOrder = netLbsEOM + percentageOfFoodToOrder;

        return amountOfFoodToOrder;
    }
}
