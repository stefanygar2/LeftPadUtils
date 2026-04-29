package org.example;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @org.junit.jupiter.api.Test
    void testgetArea() {
        Rectangle rec = new Rectangle(2, 6); // Arrange
        double actual = rec.getArea(); // Act
        double expected = 12;
        assertEquals(expected, actual); // Assert
    }


}