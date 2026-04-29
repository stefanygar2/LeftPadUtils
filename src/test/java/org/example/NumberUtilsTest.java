package org.example;
import org.example.number.NumberUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;


import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {
    private List<Integer> list(Integer... nums) {
        return Arrays.asList(nums);
    }
    @Tag("specification")
    @Test
    void addNormalnocarry() {
        List<Integer> a = list(1, 5);
        List<Integer> b = list(2, 3);// Arrange
        List<Integer> result = NumberUtils.add(a, b);// Act
        assertEquals(list(3, 8), result);// Assert
    }
    @Tag("specification")
    @Test
    void adddiffsizelist() {
        List<Integer> a = list(1, 2, 0);
        List<Integer> b = list(4, 5);// Arrange

        List<Integer> result = NumberUtils.add(a, b);// Act
        assertEquals(list(1, 6, 5), result);// Assert
    }
    @Tag("specification")
    @Test
    void addoneemptylist() {
        List<Integer> a = list();
        List<Integer> b = list(1, 5);// Arrange

        List<Integer> result = NumberUtils.add(a, b);// Act
        assertEquals(list(1, 5), result);// Assert
    }
    @Tag("specification")
    @Test
    void addtwoemptylist() {
        List<Integer> a = list();
        List<Integer> b = list();// Arrange

        List<Integer> result = NumberUtils.add(a, b);// Act

        assertEquals(list(0), result);// Assert
    }
    @Tag("specification")
    @Test
    void addandcarrylength() {
        List<Integer> a = list(9, 9);
        List<Integer> b = list(1);// Arrange

        List<Integer> result = NumberUtils.add(a, b);// Act
        assertEquals(list(1, 0, 0), result);// Assert
    }
    @Tag("specification")
    @Test
    void add_invalid() {
        List<Integer> a = list(10);
        List<Integer> b = list(1);// Arrange
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.add(a, b);
        });

    }
    @Tag("specification")
    @Test
    void add_nullFirstList() {
        List<Integer> a = null;
        List<Integer> b = list(1,2);// Arrange
        List<Integer> result = NumberUtils.add(a, b);
        assertNull(result);
    }
    @Tag("structural")
    @Test
    void add_nullSecondList() {
        List<Integer> a = list(1, 2);
        List<Integer> b = null;
        assertNull(NumberUtils.add(a, b));
    }
    void add_bothNull() {

        List<Integer> a = null;
        List<Integer> b = null;//Arrange

        List<Integer> result = NumberUtils.add(a, b);

        assertNull(result);
    }
    @Tag("structural")
    @Test
    void add_invalidSecondList() {
        List<Integer> a = list(1, 2);
        List<Integer> b = list(10);

        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.add(a, b);
        });
    }
    @Tag("structural")
    @Test
    void add_carryPropagation() {
        List<Integer> a = list(9);
        List<Integer> b = list(9);

        assertEquals(list(1, 8), NumberUtils.add(a, b));
    }
    @Tag("structural")
    @Test
    void add_unequalLengthWithCarry() {
        List<Integer> a = list(9, 9, 9);
        List<Integer> b = list(1);

        assertEquals(list(1, 0, 0, 0), NumberUtils.add(a, b));
    }
    @Tag("structural")
    @Test
    void add_removesLeadingZeros() {
        List<Integer> a = list(0, 0, 1);
        List<Integer> b = list(0, 0, 2);

        assertEquals(list(3), NumberUtils.add(a, b));
    }
    @Tag("structural")
    @Test
    void add_invalidNegativeDigitLeft() {
        List<Integer> a = list(-1);
        List<Integer> b = list(1);

        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.add(a, b);
        });
    }
    @Tag("structural")
    @Test
    void add_invalidNegativeDigitRight() {
        List<Integer> a = list(1);
        List<Integer> b = list(-1);

        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.add(a, b);
        });
    }
}