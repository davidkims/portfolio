package effectivejava.chapter10.item74;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModifiedIndexOutOfBoundsExceptionTest {

    @Test
    void testConstructorAndGetters() {
        int lowerBound = 0;
        int upperBound = 10;
        int index = 15;

        ModifiedIndexOutOfBoundsException exception = new ModifiedIndexOutOfBoundsException(lowerBound, upperBound, index);

        assertEquals(lowerBound, exception.getLowerBound());
        assertEquals(upperBound, exception.getUpperBound());
        assertEquals(index, exception.getIndex());
    }

    @Test
    void testMessage() {
        int lowerBound = 0;
        int upperBound = 10;
        int index = 15;

        ModifiedIndexOutOfBoundsException exception = new ModifiedIndexOutOfBoundsException(lowerBound, upperBound, index);

        String expectedMessage = "Index: 15, Lower bound: 0, Upper bound: 10";
        assertEquals(expectedMessage, exception.getMessage());
    }
}