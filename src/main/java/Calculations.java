import org.apache.log4j.Logger;

public class Calculations {
    //declarations
    static int smallDogFoodNeeds = 10, mediumDogFoodNeeds = 20, largeDogFoodNeeds = 30;
    static int lbsOfSmallDogFood, lbsOfMediumDogFood, lbsOfLargeDogFood;

    static double percentMoreToOrder = 0.20;
    static int totalLbsOfDogFoodUsed;
    static int netLbsEOM;

    //create logger
    Logger logger = Logger.getLogger(Calculations.class.getName());

    //functions
    public int CalculateDogSizeFoodNeeds(Integer smallDogs, Integer mediumDogs, Integer largeDogs) {
        Integer[] dogs = { smallDogs, mediumDogs, largeDogs };
        for(Integer dog : dogs) {
            if(dog == null || dog < 0) {
                throw new NumberFormatException("Please provide a valid number");
            }
        }
        lbsOfSmallDogFood = smallDogs * smallDogFoodNeeds;
        lbsOfMediumDogFood = mediumDogs * mediumDogFoodNeeds;
        lbsOfLargeDogFood = largeDogs * largeDogFoodNeeds;

        return totalLbsOfDogFoodUsed = lbsOfSmallDogFood + lbsOfMediumDogFood + lbsOfLargeDogFood;
    }

    public int CalculateNetLbsEOM(Integer lbsFoodRemainingEOM) {
        if (lbsFoodRemainingEOM == null || lbsFoodRemainingEOM < 0) {
            throw new NumberFormatException("Please provide a valid number");
        } else if (lbsFoodRemainingEOM == 0) {
            logger.info("You do not have any food remaining this month");
        }
        return netLbsEOM = totalLbsOfDogFoodUsed - lbsFoodRemainingEOM;
    }

    public double CalculateTotalAmountOfFoodToOrder() {
        var percentageOfFoodToOrder = percentMoreToOrder * netLbsEOM;

        return netLbsEOM + percentageOfFoodToOrder;
    }
}
