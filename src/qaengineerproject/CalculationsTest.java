package qaengineerproject;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {

    @BeforeEach
    void setUp() {
        Calculations.CalculateDogSizeFoodNeeds(5, 3, 7);
        Calculations.CalculateNetLbsEOM(17);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateDogSizeFoodNeedsTest_CorrectInputs_WasCalled() {
    }

    @Test
    void calculateNetLbsEOM() {
    }

    @Test
    void calculateTotalAmountOfFoodToOrderTest_CorrectInputs_ResultSuccess() {
        //Given
        double expected =  363.6;

        //When
        double actual = Calculations.CalculateTotalAmountOfFoodToOrder();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountOfFoodToOrderTest_CorrectInputs_ResultNotNull() {
        //When
        double actual = Calculations.CalculateTotalAmountOfFoodToOrder();

        //Then
        Assert.assertNotNull(actual);
    }
}