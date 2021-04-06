import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationsTest {
    //create new instance
    Calculations calculations = new Calculations();

    @BeforeEach
    public void setUp(){
        calculations.CalculateDogSizeFoodNeeds(5, 3, 7);
        calculations.CalculateNetLbsEOM(17);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void calculateDogSizeFoodNeedsTest_ValidInputs_ReturnsTotalLbsOfDogFoodUsed() {
        //Given
        int expected = 320;

        //When
        int actual = calculations.CalculateDogSizeFoodNeeds(5, 3, 7);

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDogSizeFoodNeedsTest_InvalidInputs_ThrowsException() {
        Exception exception = assertThrows(NumberFormatException.class, () ->
                calculations.CalculateDogSizeFoodNeeds(-3,null,-9));
        assertEquals("Please provide a valid number", exception.getMessage());
    }

    @Test
    void calculateDogSizeFoodNeedsTest_ValidInputs_DoesNotReturnString() {
        //Given
        String expected = "hello";

        //When
        int actual = calculations.CalculateDogSizeFoodNeeds(5, 3, 7);

        //Then
        assertNotEquals(expected, actual);
    }

    @Test
    void calculateNetLbsEOM_ValidInputs_ReturnsNetLbsEOM() {
        //Given
        int expected = 303;

        //When
        int actual =  calculations.CalculateNetLbsEOM(17);

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void calculateNetLbsEOM_InvalidInput_ThrowsException() {
        var invalidNum = -2;
        Exception invalidNumException = assertThrows(NumberFormatException.class, () ->
                calculations.CalculateNetLbsEOM(invalidNum));
        assertEquals("Please provide a valid number", invalidNumException.getMessage());
    }

    @Test
    void calculateNetLbsEOM_NullInput_ThrowsException() {
        Exception nullException = assertThrows(NumberFormatException.class, () ->
                calculations.CalculateNetLbsEOM(null));
        assertEquals("Please provide a valid number", nullException.getMessage());
    }

    @Test
    void calculateNetLbsEOM_ValidInputs_DoesNotReturnString() {
        //Given
        String expected = "303";

        //When
        int actual =  calculations.CalculateNetLbsEOM(17);

        //Then
        assertNotEquals(expected, actual);
    }

    @Test
    void calculateNetLbsEOM_ZeroFoodRemaining_ReturnsWarningMessage() {
        TestAppender testAppender = new TestAppender();

        Logger.getRootLogger().addAppender(testAppender);
        calculations.CalculateNetLbsEOM(0);
        LoggingEvent loggingEvent = testAppender.events.get(0);
        assertEquals("You do not have any food remaining this month"
                ,loggingEvent.getMessage().toString());
    }

    @Test
    void calculateTotalAmountOfFoodToOrderTest_ValidInputs_ReturnsTotalAmountOfFoodToOrder() {
        //Given
        double expected = 363.6;

        //When
        double actual = calculations.CalculateTotalAmountOfFoodToOrder();

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountOfFoodToOrderTest_ValidInputs_DoesNotReturnString() {
        //Given
        String expected = "363.6";

        //When
        double actual = calculations.CalculateTotalAmountOfFoodToOrder();

        //Then
        assertNotEquals(expected, actual);
    }

    private static class TestAppender extends AppenderSkeleton{
        public List<LoggingEvent> events = new ArrayList<LoggingEvent>();
        public void close() {}
        public boolean requiresLayout() {return false;}
        @Override
        protected void append(LoggingEvent event) {
            events.add(event);
        }
    }
}